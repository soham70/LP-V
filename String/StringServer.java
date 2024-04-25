import java.rmi.Naming;

public class StringServer {
    public static void main(String[] args) {
        try {
            StringServerImpl stringServerImpl = new StringServerImpl();

            Naming.rebind("StringServer", stringServerImpl);

        } catch (Exception e) {
            System.out.println(e);
        }
    }    
}
