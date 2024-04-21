import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MultServerImpl extends UnicastRemoteObject implements MultServerIntf{
    public MultServerImpl() throws RemoteException{

    }

    // @Override
    public double mult(double num1,double num2) throws RemoteException{
        return num1*num2;
    }
}
