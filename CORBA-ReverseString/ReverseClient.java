import java.io.BufferedReader;
import java.io.InputStreamReader;
import ReverseModule.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class ReverseClient {

    public static void main(String[] args) {
        Reverse ReverseImpl=null;

        try {
            
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =NamingContextExtHelper.narrow(objRef);

            String name ="Reverse";

            ReverseImpl = ReverseHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Enter String");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = br.readLine();

            String tempStr = ReverseImpl.rev_string(str);
            
            System.out.println(tempStr);;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
