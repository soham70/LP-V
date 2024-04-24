import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

import org.omg.CORBA.portable.RemarshalException;

public interface ServerIntf extends Remote{
    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime serverTime,long diff) throws RemoteException;
}