import java.rmi.Naming;

public class AddClient {
    public static void main(String[] args) {
        try {
            String url = "rmi://" + args[0] + "/AddServer";

            AddServerIntf addServerIntf=(AddServerIntf) Naming.lookup(url);

            System.out.println("Enter First Number: "+ args[1]);
            double d1 = Double.parseDouble(args[1]);

            System.out.println("Enter Second Number: "+ args[2]);
            double d2 = Double.parseDouble(args[2]);

            System.out.println("Total: " + addServerIntf.multiply(d1, d2));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
    
}
