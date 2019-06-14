package win.und.demo.authentication.sms;

import win.und.demo.exception.VerificationCodeFailureException;
import win.und.demo.oauth.support.BootSecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2018/10/19 15:33
 */
public class SmsCodeCheckFilter extends OncePerRequestFilter {


    private AuthenticationFailureHandler authenticationFailureHandler;


    private BootSecurityProperties properties;

    private boolean isDebug = false;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public SmsCodeCheckFilter() {

        if(properties.getLogging().getLevel().toUpperCase().equals("DEBUG")){
            isDebug = true;
        }

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(this.isDebug){
            logger.debug("--------------> request method "+ request.getMethod());
        }

        if(StringUtils.equals("/authentication/mobile",request.getRequestURI())
                && StringUtils.equalsAnyIgnoreCase(request.getMethod(),"post")){

            try {
                check(new ServletWebRequest(request));

            }catch (VerificationCodeFailureException ex){
                authenticationFailureHandler.onAuthenticationFailure(request,response,ex);
            }


        }else {

            filterChain.doFilter(request,response);
        }
    }

    private void check(ServletWebRequest request) throws VerificationCodeFailureException{



    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    public BootSecurityProperties getProperties() {
        return properties;
    }

    public void setProperties(BootSecurityProperties properties) {
        this.properties = properties;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
