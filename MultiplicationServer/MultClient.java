
import java.rmi.Naming;

public class MultClient {
    public static void main(String[] args) {
        try{
            String mult = "rmi://"+args[0]+"/MultServer";
            MultServerIntf multServerIntf = (MultServerIntf) Naming.lookup(mult);
            double num1 = Double.parseDouble(args[1]);
            double num2 = Double.parseDouble(args[2]);
            
            System.out.println(multServerIntf.mult(num1, num2));
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
    }
}
