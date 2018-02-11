package esp.ejb.openejb.sboot;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import esp.ejb.HelloRemote;

@Configuration
// @Import(ApplicationConfiguration.class)
public class OpenEjbConfiguration {

    @Bean
    public Context context() throws NamingException {
        Context ctx;
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
        env.put(Context.PROVIDER_URL, "ejbd://localhost:4201");
        ctx = new InitialContext(env);
        return ctx;
    }

    @Bean
    public HelloRemote helloBean(Context ctx) throws NamingException {
        HelloRemote greeter = (HelloRemote) ctx.lookup("global/esp-ejb/HelloBean!esp.ejb.HelloRemote");
        return greeter;
    }

}
