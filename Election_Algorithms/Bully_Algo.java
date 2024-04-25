import java.util.Scanner;

public class Bully_Algo {

    int coordinator;
    int max_process;
    boolean processes[];

    public Bully_Algo(int max) {
        max_process=max;
        processes=new boolean[max_process];
        coordinator=max;

        System.out.println("Creating Process...");
        for (int i=0;i<max;i++)
        {
            processes[i]=true;
            System.out.println("P"+(i+1) + " is created");
        }
        System.out.println("Process P" +coordinator+" is the coordinator");
    }

    void display()
    {
        for(int i=0;i<max_process;i++)
        {
            if(processes[i])
            {
                System.out.println("Process P"+ (i+1) +" is Up");
            }
            else{
                System.out.println("Process P"+(i+1)+" is Down");
            }
        }
        System.out.println("Process P" + coordinator + " is the coordinator");
    }

    void upProcess(int process_id)
    {
        if(!processes[process_id-1])
        {
            System.out.println("Process P"+process_id+" is now Up");
        }
        else{
            System.out.println("Process P"+process_id+" is already Up");
        }
    }

    void downProcess(int process_id)
    {
        if(!processes[process_id-1])
        {
            System.out.println("Process P"+process_id + " is already down");
        }else{
            processes[process_id-1]=false;
            System.out.println("Process " + process_id+ "is down");
        }
    }

    void runElection(int process_id)
    {
        coordinator=process_id;
        boolean keepGoing=true;

        for(int i=process_id;i<max_process && keepGoing;i++)
        {
            System.out.println("election Message sent from process " + process_id + "to process" +(i+1));

            if(processes[i])
            {
                keepGoing=false;
                runElection(i+1);
            }
        }
    }




    public static void main(String[] args) {
        Bully_Algo ba =null;
        int max_processes=0,process_id=0;
        int choice =0;
        Scanner sc =new Scanner(System.in);

        while (true) {
            System.out.println("Bully Algorithm");
            System.out.println("1.Create Processes");
            System.out.println("2.Display Processes");
            System.out.println("3.Up a Preocess");
            System.out.println("4.Down a Process");
            System.out.println("5.Run election Algorithm");
            System.out.println("6.Exit");
            System.out.println("Enter Your Choice: ");
            choice=sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter Number of Processe");
                    max_processes=sc.nextInt();
                    ba= new Bully_Algo(max_processes);    
                    break;
                
                case 2:
                    ba.display();
                    break;

                case 3:
                    System.out.println("Enter Process ID to Up: ");
                    process_id=sc.nextInt();
                    ba.upProcess(process_id);
                    break;

                case 4:
                    System.out.println("Enter Process ID to Down: ");
                    process_id=sc.nextInt();
                    ba.downProcess(process_id);
                    break;

                case 5:
                    System.out.println("Enter Process Number which will perform Election: ");
                    process_id=sc.nextInt();
                    ba.runElection(process_id);
                    ba.display();
                    break;
                
                case 6:
                    System.exit(0);
                    break;
            
                default:
                    System.out.println("Error choice Selection");
                    break;
            }
        }

    }

}
