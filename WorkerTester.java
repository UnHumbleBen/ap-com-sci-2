import java.util.*;
public class WorkerTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Enter name: ");
            String name = in.nextLine();
            in.nextLine();
            System.out.println("Enter salary: ");
            double salary = in.nextDouble();
            System.out.println("[1] Hourly \n[2] Salaried");
            if(in.nextInt()==1) {
                HourlyWorker w = new HourlyWorker(name,salary);
                System.out.println("Enter number of hours worked: ");
                int hours = in.nextInt(); 
                System.out.println("Weekly Pay: " + w.computePay(hours));
            }
            else {
                SalariedWorker w = new SalariedWorker(name,salary);
                System.out.println("Enter number of hours worked: ");
                int hours = in.nextInt(); 
                System.out.println("Weekly Pay: " + w.computePay(hours));
            }
        }
    }
}