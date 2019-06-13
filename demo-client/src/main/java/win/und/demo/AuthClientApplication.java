package win.und.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AuthClientApplication {
    private static final Logger log = LoggerFactory.getLogger(AuthClientApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthClientApplication.class)
                .run(args);
    }
}


