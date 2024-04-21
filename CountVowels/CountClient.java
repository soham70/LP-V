import java.rmi.Naming;

public class CountClient {
    
    public static void main(String[] args) {
        try {
            String cntvowel = "rmi://" +args[0] + "/countServer";
            CountIntf countIntf = (CountIntf) Naming.lookup(cntvowel);
            String s = args[1];

            System.out.println("Count of Vowels is  " + countIntf.count(s));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
