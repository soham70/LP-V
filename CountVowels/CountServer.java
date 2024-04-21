import java.rmi.Naming;

public class CountServer{
    public static void main(String[] args) {
        try {
            CountImpl countImpl = new CountImpl();

            Naming.rebind("countServer", countImpl);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    
}
