package mn.dae.pc.notifications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            log.debug("Starting, loading templates, cwd: ", System.getProperty("user.dir"));


        };
    }
}