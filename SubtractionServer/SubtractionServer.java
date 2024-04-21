import java.rmi.*;

public class SubtractionServer{
    public static void main(String[] args)
    {
        try {
            SubtractionImpl subtractionImpl = new SubtractionImpl();

            Naming.rebind("SubtractServer", subtractionImpl);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception e: " + e);
        }
    }
}