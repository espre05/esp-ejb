package esp.ejb.openejb.sboot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import esp.ejb.HelloRemote;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OpenEjbConfiguration.class)
public class OpenEjbTest {
    
    @Autowired
    HelloRemote helloRemote;
    
    @Test
    public void whenInvoked_getscreaming_caps() {
        String inputStr = "Hey, Don't scream in upper case!";
        String result = helloRemote.hello(inputStr);
        String expected = "Hello EJB World. upper="+inputStr.toUpperCase();
        Assert.assertEquals(expected, result);
    }
    

}
