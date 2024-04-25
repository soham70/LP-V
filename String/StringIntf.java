import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringIntf extends Remote {

    public String compare(String a,String b) throws RemoteException;
    
}
