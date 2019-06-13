package win.und.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@SpringBootApplication
/**
 * 使用EnableAuthorizationServer注解开启认证服务
 * http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://baidu.com&state=123
 */
@EnableAuthorizationServer
public class Oauth2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Oauth2Application.class)
                .run(args);
    }
}


