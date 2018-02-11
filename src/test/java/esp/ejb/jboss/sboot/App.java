package esp.ejb.jboss.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import esp.ejb.jboss.sboot.App;

@SpringBootApplication
public class App {

    public static void main(String args[]) {
        SpringApplication.run(App.class, args);

    }
}
