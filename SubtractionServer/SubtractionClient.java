import java.rmi.*;

public class SubtractionClient {
    public static void main(String[] args) {
        try {
            String sub = "rmi://" + args[0] + "/SubtractServer";

            SubtractionIntf subtractionIntf =(SubtractionIntf) Naming.lookup(sub);
            System.out.println("First Number is " + args[1]);
            double d1 = Double.parseDouble(args[1]);
            System.out.println("Second Number: " + args[2]);
            double d2 = Double.parseDouble(args[2]);
            System.out.println("Subtraction is: " + subtractionIntf.sub(d1, d2));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }    
}
