package esp.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
    String hello(String s);
}