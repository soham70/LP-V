import ReverseModule.ReversePOA;

import java.lang.*;

class ReverseImpl extends ReversePOA{

    ReverseImpl()
    {
        super();
        System.out.println("Reverse Object created");
    }

    public String rev_string(String name)
    {
        StringBuffer stb = new StringBuffer(name);
        stb.reverse();
        return (("Server send " +stb));
    }

}