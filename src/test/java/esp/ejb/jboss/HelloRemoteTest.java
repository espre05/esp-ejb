package esp.ejb.jboss;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import esp.ejb.HelloRemote;

public class HelloRemoteTest {
    private static Context ctx;

    @BeforeClass
    public static void setUp() throws NamingException {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        ctx = new InitialContext(env);
    }

    @AfterClass
    public static void tearDown() throws NamingException {
        ctx.close();
    }

    @Test
    public void sayHelloRemoteEJBTest() throws Exception {
        HelloRemote greeter = lookupHelloRemote();
        String inputStr = "Hey, Don't scream in upper case!";
        String result = greeter.hello(inputStr);
        String expected = "Hello EJB World. upper=" + inputStr.toUpperCase();
        Assert.assertEquals(expected, result);
    }

    private HelloRemote lookupHelloRemote() throws Exception {
        final String appName = "";
        final String moduleName = "prem-ejb-1.0";
        final String distinctName = "";
        final String beanName = "HelloBean";
        final String viewClassName = HelloRemote.class.getName();
        final String LOOKUP_URI = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!"
                + viewClassName;
        HelloRemote hello = (HelloRemote) ctx.lookup(LOOKUP_URI);
        return hello;

    }
}