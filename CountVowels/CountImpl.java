import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CountImpl extends UnicastRemoteObject implements CountIntf {

    public CountImpl() throws RemoteException{}

    public int count(String s)
    {
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)== 'a' || s.charAt(i)== 'e' || s.charAt(i)== 'i'|| s.charAt(i)== 'o'|| s.charAt(i)== 'u' ){
                cnt++;
            }
        }
        return cnt;
    }
    
}
