
import java.rmi.Naming;

public class MultServer {
    public static void main(String[] args) {

        try {
            MultServerImpl multServerImpl = new MultServerImpl();
            Naming.rebind("MultServer", multServerImpl);
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
    }
}
