package win.und.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SourceApplication {
    private static final Logger log = LoggerFactory.getLogger(SourceApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SourceApplication.class)
                .run(args);
    }
}

