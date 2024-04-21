import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class SubtractionImpl extends UnicastRemoteObject implements SubtractionIntf {

    public SubtractionImpl() throws RemoteException{}
    
    public double sub(double d1,double d2) throws RemoteException{
        return d1-d2;
    }
}
