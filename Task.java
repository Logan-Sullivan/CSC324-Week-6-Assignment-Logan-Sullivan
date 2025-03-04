import java.util.Scanner;

public class Task {
    static Scanner scanner = new Scanner(System.in);


    String Name;
    int intPriority;
    String strPriority;
    public Task(String Name, int intPriority){
        this.Name = Name;
        this.intPriority = intPriority;
    }
    public static int getPriority(){
        int Task_Priority = 0;
        //while the priority is out of range (1-3) continue asking for new input
        while (Task_Priority < 1 || Task_Priority > 3){
            System.out.print("What Priority is this task\n1. High\n2. Medium\n3. Low\n4. Cancel Task Creation\nEnter Choice: ");
            Task_Priority = scanner.nextInt();
            if (Task_Priority < 1 || Task_Priority > 3){
                System.out.print("given option dose not exist try again\n");
            }
            if (Task_Priority == 4){
                return 0;
            }
        }
        return Task_Priority;
    }
    public String toString(){
        //make integer option string priority for more readable output
        switch (this.intPriority){
            case 1 -> strPriority = "High";
            case 2 -> strPriority = "Med";
            case 3 -> strPriority = "Low";
        }
        return this.Name +"  Priority: " + strPriority;
    }
}
