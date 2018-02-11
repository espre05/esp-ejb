package esp.ejb.openejb;

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
  env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
  env.put(Context.PROVIDER_URL, "ejbd://localhost:4201");
  ctx = new InitialContext(env);
 }
 @AfterClass
 public static void tearDown() throws NamingException {
  ctx.close();
 }
 @Test
 public void sayHelloRemoteEJBTest() throws NamingException {
  HelloRemote greeter = (HelloRemote) ctx.lookup("global/esp-ejb/HelloBean!esp.ejb.HelloRemote");
  String inputStr = "Hey, Don't scream in upper case!";
  String result = greeter.hello(inputStr);
  String expected = "Hello EJB World. upper="+inputStr.toUpperCase();
  Assert.assertEquals(expected, result);
 }
}