package win.und.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import win.und.demo.oauth.support.BootLoginFailureHandler;
import win.und.demo.oauth.support.BootSecurityProperties;
import win.und.demo.oauth.support.BootUserDetailService;

/**
 * @author yuit
 * @date 2018/10/10  11:48
 **/
@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId("order1").stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    // Since we want the protected resources to be accessible in the UI as well we need
                    // session creation to be allowed (it's disabled by default in 2.0.6)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
                    .antMatchers("/order1/**").authenticated();//配置order访问控制，必须认证过后才可以访问
            // @formatter:on
        }
    }
    private BootUserDetailService userDetailService;


    private BootSecurityProperties properties;


    private BootLoginFailureHandler handler;


    public SecurityConfig(BootUserDetailService userDetailService, BootSecurityProperties properties, BootLoginFailureHandler handler) {
        this.userDetailService = userDetailService;
        this.properties = properties;
        this.handler = handler;
    }

    /**
     * 让Security 忽略这些url，不做拦截处理
     *
     * @param
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers
                ("/swagger-ui.html/**", "/webjars/**",
                        "/swagger-resources/**", "/v2/api-docs/**",
                        "/swagger-resources/configuration/ui/**", "/swagger-resources/configuration/security/**",
                        "/images/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // http security 要拦截的url，这里这拦截，oauth2相关和登录登录相关的url，其他的交给资源服务处理
                .requestMatchers()
                .antMatchers( "/oauth/**",properties.getLoginPage(),properties.getLoginProcessUrl())
                .and()
                .authorizeRequests()
                // 自定义页面或处理url是，如果不配置全局允许，浏览器会提示服务器将页面转发多次
                .antMatchers("/auth/login", properties.getLoginProcessUrl())
                .permitAll()
                .anyRequest()
                .authenticated();

        // 表单登录
        http.formLogin()
                .failureHandler(handler)
                // 页面
                .loginPage(properties.getLoginPage())
                // 登录处理url
                .loginProcessingUrl(properties.getLoginProcessUrl());

        http.httpBasic().disable();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
