import java.util.Scanner;

class Tring{
    public static void main(String[] args) {
        int token=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Nodes: ");
        int nodes =sc.nextInt();

        for (int i=0;i<nodes;i++)
        {
            System.out.print(i + " ");
        }
        System.out.println(0);

        try {
            while (true) {
                System.out.println("Enter sender: ");
                int s = sc.nextInt();

                System.out.println("Enter Receiver: ");
                int r =sc.nextInt();

                System.out.println("Enter Data: ");
                String d = sc.next();

                System.out.println("Token Passing: ");

                for ( int j=token;(j%nodes)!=s;j=(j+1)%nodes)
                {
                    System.out.print(" " + j + "->");
                }
                System.out.print(" " +s);

                System.out.println("Sender " +s + " sending data " + d);

                for (int i=(s+1)%nodes;i!=r;i=(i+1)%nodes)
                {
                    System.out.println("Data " +d + " forwarded by : " + i);
                }
                System.out.println("Receiver " + r +" received data " + d);
                token=s;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}