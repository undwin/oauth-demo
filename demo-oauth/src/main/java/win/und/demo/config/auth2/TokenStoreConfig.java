package win.und.demo.config.auth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import win.und.demo.oauth.support.BootSecurityProperties;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuit
 * @date  2018/10/17  16:38
 *
 * token 存储方式配置
 *
 **/
@Configuration
public class TokenStoreConfig {

    private BootSecurityProperties properties;




//    private DataSource dataSource;

    @Autowired(required = false)
    public TokenStoreConfig(BootSecurityProperties properties) {
        this.properties = properties;
//        this.dataSource = dataSource;
    }

    @Bean
    public TokenStore tokenStore() throws Exception {

        TokenStore store = null;

        switch (properties.getTokenStoreType()) {
            case jwt:
                store = new JwtTokenStore(jwtAccessTokenConverter());
                break;
            case redis:
//                if (factory == null) {
//                    throw new BeanCreationException("配置Redis存储Token需要redisConnectionFactory bean，未找到");
//                }
//                store = new RedisTokenStore(factory);
                break;
//            case jdbc:
//
//                if(dataSource==null){
//                    throw new BeanCreationException("配置jdbc存储Token需要dataSource bean，未找到");
//                }
//                store=new JdbcTokenStore(dataSource);
//                break;
            default:
                store = new InMemoryTokenStore();
        }

        return store;
    }

    @Bean
    @Primary
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//
//        converter.setSigningKey(properties.getTokenSigningKey());
//
//        return converter;
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                String userName = authentication.getUserAuthentication().getName();
                final Map<String, Object> additionalInformation = new HashMap<String, Object>();
                additionalInformation.put("user_name", userName);
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken token = super.enhance(accessToken, authentication);
                return token;
            }
        };
        //converter.setSigningKey("bcrypt");
        //keytool -genkeypair -alias mytest -keyalg RSA -keypass mypass -keystore keystore.jks -storepass mypass
        KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "mypass".toCharArray())
                .getKeyPair("mytest");
        converter.setKeyPair(keyPair);
        return converter;
    }
}
