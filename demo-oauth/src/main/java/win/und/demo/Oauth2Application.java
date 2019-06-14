package win.und.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Oauth2Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Oauth2Application.class)
                .run(args);
    }
}


