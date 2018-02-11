package esp.ejb.jboss.sboot;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ejb.access.SimpleRemoteStatelessSessionProxyFactoryBean;

import esp.ejb.HelloRemote;

@Configuration
// @Import(ApplicationConfiguration.class)
public class JbossEjbConfiguration {

    @Bean
    public Context context() throws NamingException {
        Context ctx;
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        ctx = new InitialContext(env);
        return ctx;
    }

    @Bean
    public HelloRemote helloBean(Context ctx) throws NamingException {
        final String appName = "";
        final String moduleName = "prem-ejb-1.0";
        final String distinctName = "";
        final String beanName = "HelloBean";
        final String viewClassName = HelloRemote.class.getName();
        final String LOOKUP_URI = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
                + viewClassName;
        HelloRemote greeter = (HelloRemote) ctx.lookup(LOOKUP_URI);
        return greeter;
    }

//    @Bean
//    public FactoryBean factory() {
//        SimpleRemoteStatelessSessionProxyFactoryBean factory = new SimpleRemoteStatelessSessionProxyFactoryBean();
//         String beanName = "HelloBean";
//         factory.setJndiName(beanName);
//         factory.setBusinessInterface(HelloRemote.class);
//        factory.setLookupHomeOnStartup(false);// binds later if ejb-server not bound.
//        Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
//        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//        factory.setJndiEnvironment(env);
//        factory.
//        return factory;
//    }


}
