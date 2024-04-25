import java.rmi.Naming;

public class StringClient {
    public static void main(String[] args) {
        try {
            String url ="rmi://" + args[0] + "/StringServer";

            StringIntf stringIntf = (StringIntf) Naming.lookup(url);

            System.out.println(" First String is: " + args[1]);
            String d1=(args[1]);

            System.out.println(" Second String: " + args[2]);
            String d2=(args[2]);

            System.out.println("Greater String: " + stringIntf.compare(d1, d2));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }    
}
