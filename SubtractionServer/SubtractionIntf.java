import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubtractionIntf extends Remote {
    double sub(double d1,double d2) throws RemoteException;
}
