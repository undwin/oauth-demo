package win.und.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SourceApplication {
    private static final Logger log = LoggerFactory.getLogger(SourceApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SourceApplication.class)
                .run(args);
    }
}

