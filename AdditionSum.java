
import java.util.Scanner;

import mpi.MPI.*;

public class AdditionSum {
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size =MPI.COMM_WORLD.Size();

        int unisize=5;
        int root=0;

        int sender_buff[]= new int[unisize*size];
        int receiver_buff[]= new int [unisize];
        int new_receiver_buff[]= new int [size];

        if(root==rank)
        {
            int total_elements = unisize*size;
            for (int i=0;i<total_elements;i++)
            {
                System.out.println("Element: "+ i+ "\t=" +i);
                sender_buff[i]=i;
            }
        }

        MPI.COMM_WORLD.Scatter(
            sender_buff,
            0,
            unisize,
            MPI.INT,
            receiver_buff,
            0,
            unisize,
            MPI.INT,
            root
        );

        for(int i=1;i<unisize;i++)
        {
            receiver_buff[0] +=receiver_buff[i];
        }

        System.out.println("Intermediate Process " + rank + " sum is " + receiver_buff[0]);

        MPI.COMM_WORLD.Gather
        (    receiver_buff,
            0,
            1,
            MPI.INT,
            new_receiver_buff,
            0,
            1,
            MPI.INT,
            root
        );

        if(rank==root)
        {
            int sum=0;
            for(int i=0;i<size;i++)
            {
                sum+=new_receiver_buff[i];
            }
            System.out.println("Total Sum is " + sum);
        }
        MPI.Finalize();

    }
}
