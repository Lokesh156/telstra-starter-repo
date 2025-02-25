package au.com.telstra.simcardactivator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SimCardActivator {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SimCardActivator.class).properties("server.port=9090").run(args);

        System.out.println("Hello Software Developer Lokesh");
    }
}
