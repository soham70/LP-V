import java.rmi.Naming;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainClock {
    public static void main(String[] args) {
        try{
             String clock1="rmi://" + "/127.0.0.1" +args[0];

            LocalTime serverTime = LocalTime.parse("03:00:00",DateTimeFormatter.ofPattern("HH:mm:ss"));

            System.out.println("Server Time" + serverTime);

            ServerIntf c1 = (ServerIntf) Naming.lookup(clock1);
            System.out.println(c1.getTime());

            String clock2 ="rmi://" + "127.0.0.1/" +args[1];
            String clock3 ="rmi://" + "127.0.0.1/" +args[2];

            System.out.println("Server Time is "+serverTime);

            ServerIntf c2 = (ServerIntf) Naming.lookup(clock2);
            System.out.println(c2.getTime());
    
            ServerIntf c3 = (ServerIntf) Naming.lookup(clock3);
            System.out.println(c3.getTime());
    
            
            long serverNano = serverTime.toNanoOfDay();
            long c1Nano = c1.getTime().toNanoOfDay()-serverNano;
            long c2Nano = c1.getTime().toNanoOfDay()-serverNano;
            long c3Nano = c1.getTime().toNanoOfDay()-serverNano;
            long avg = (c1Nano+c2Nano+c3Nano)/4;
    
            c1.adjustTime(serverTime, avg);
            c2.adjustTime(serverTime, avg);
            c3.adjustTime(serverTime, avg);
            //serverTime.plusNanos(avg);
           serverTime= LocalTime.ofNanoOfDay(serverNano+avg);

            System.out.println("updated time"+serverTime);
        }
        catch(Exception e)
        {
            System.out.println("Exception: " +e);
        }
    }   
}
