import java.rmi.*;

class AddClient{
    public static void main(String[] args)
    {
        try {
            String serverUrl = "rmi://" + args[0] + "/AddServer";

            AddServerIntf addserverIntf =(AddServerIntf) Naming.lookup(serverUrl);
            
            System.out.println("The First Number is: " + args[1]);

            double d1 =Double.parseDouble(args[1]);
            
            System.out.println("The Second Number is: " + args[2]);

            double d2 =Double.parseDouble(args[2]);

            System.out.println("Total Sum= " + addserverIntf.add(d1,d2));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }



    }
}