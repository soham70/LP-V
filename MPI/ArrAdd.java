import mpi.*;
public class ArrAdd {
    public static void main(String[] args) {
        MPI.Init(args);

        int size = MPI.COMM_WORLD.Size();
        int rank = MPI.COMM_WORLD.Rank();

        int unisize = 5;

        int root = 0;

        int sender_buffer[] = new int[unisize*size];
        int receiver_buffer[] = new int[unisize];
        int new_receive_buffer[] = new int[size];

        if(root==rank){
            int total_elements = unisize*size;
            System.out.println("total elements : "+total_elements);
            for(int i=0;i<total_elements;i++){
                System.out.println("element"+i+"  =  "+i);
                sender_buffer[i] =i;
            }
        }
        
        MPI.COMM_WORLD.Scatter(
            sender_buffer,
            0,
            unisize,
            MPI.INT,
            receiver_buffer,
            0,
            unisize,
            MPI.INT,
            root
        );

        for(int i=1;i<unisize;i++){
            receiver_buffer[0] += receiver_buffer[i];
        }

        System.out.println("Intermediate process :"+rank+"sum is"+receiver_buffer[0]);

        MPI.COMM_WORLD.Gather(
            receiver_buffer,
            0,
            1,
            MPI.INT,
            new_receive_buffer,
            0,
            1,
            MPI.INT,
            root
        );

        if(root==rank){
            int total_sum = 0;
            for(int i=0;i<size;i++){
                total_sum += new_receive_buffer[i];
            }
            System.out.println("total sum: "+total_sum);
        }

        MPI.Finalize();
    }
}
