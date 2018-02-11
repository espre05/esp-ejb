package esp.ejb.ibmliberty;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import esp.ejb.HelloRemote;

public class LibertyHelloRemoteTest {
    private static Context ctx;

    @BeforeClass
    public static void setUp() throws NamingException {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.ibm.websphere.naming.WsnInitialContextFactory");
        env.put(Context.PROVIDER_URL, "corbaloc:iiop:localhost:2809");
        //env.put(Context.PROVIDER_URL,"corbaname:iiop:localhost:9810/NameServiceServerRoot");
        
        ctx = new InitialContext(env);
        ctx.addToEnvironment(InitialContext.SECURITY_PRINCIPAL, "admin");
        ctx.addToEnvironment(InitialContext.SECURITY_CREDENTIALS, "admin");
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

    private HelloRemote lookupHelloRemote() {
        HelloRemote helloRemote = null;
        try {
//            String url = "corbaloc:iiop:localhost:2809#ejb/global/prem-ejb/HelloBean!pm\\.ejb\\.HelloRemote";
//            String url = "corbaloc:iiop:localhost:2809/applications/prem-ejb/HelloBean!pm\\.ejb\\.HelloRemote";
//            String url = "java:global/prem-ejb/HelloBean!pm\\\\.ejb\\\\.HelloRemote"; // ONLY works in J2EE env.
//            String url = "corbaname:iiop:localhost:2809#applications/prem-ejb/HelloBean!pm\\.ejb\\.HelloRemote";
            String url = "corbaloc:iiop:localhost:2809/applications/com.ibm.ws.AppNameSpaces/prem-ejb/root/prem-ejb/HelloBean!esp.ejb.HelloRemote";
            Object stub = ctx.lookup(url);
            helloRemote = (HelloRemote) PortableRemoteObject.narrow((org.omg.CORBA.Object) stub, HelloRemote.class);

            // log.info(String.format("\n\n\t Narrowed class = %s:
            // \n\n",helloRemote.toUpper("Is this message full caps, screaming?")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return helloRemote;
    }
}