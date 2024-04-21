
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MultServerIntf extends Remote{
    double mult(double num1,double num2) throws RemoteException;
} 