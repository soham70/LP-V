import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringServerImpl extends UnicastRemoteObject implements StringIntf {

    public StringServerImpl() throws RemoteException{};

    public String compare(String a,String b){
        int compareRes=a.compareTo(b);
        if(compareRes>0)
        {
            return a;
        }
        else if(compareRes<0)
        {
            return b;
        }
    return a;
    }
    
}
