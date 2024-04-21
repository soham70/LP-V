import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CountIntf extends Remote{
    
    public int count(String s)throws RemoteException;
    
}
