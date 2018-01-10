import java.util.*;
// Benjamin Lee Period 5 1/9/2018
class Employee {
    private String name;
    private double salary;
    public Employee(String newName, double newSalary) {
        name = newName;
        salary = newSalary;
    }
    public String toString() {
        return "name: " + name + " salary: " + salary;
    }
}
class Manager extends Employee {
    private String dept = "cosmetic"; 
    public Manager(String newName, double newSalary) {
        super(newName, newSalary);
    }
    public String toString() {
        return super.toString() + " Department: " + dept;
    }
}
class Executive extends Manager {
    public Executive(String newName, double newSalary) {
        super(newName, newSalary);
    }
}
public class LucIncorporated {
    public static void main(String[] args) {
        ArrayList < Employee > people = new ArrayList < Employee > ();
        while (true) {
            System.out.println("Press [1] to add new employee.");
            System.out.println("Press [2] to add new manager.");
            System.out.println("Press [3] to add new executive.");
            System.out.println("Press [4] to display all personel and quit.");
            Scanner in = new Scanner(System.in);
            int input = in .nextInt();
            if (input == 4) {
                for (int i = 0; i < people.size(); i++) {
                    System.out.println(people.get(i));
                }
                break;
            } else {
                System.out.print("Enter name: ");
                String name = in .next();
                System.out.print("Enter salary: ");
                double salary = in .nextDouble();
                if (input == 1) {
                    Employee e = new Employee(name, salary);
                    people.add(e);
                } else if (input == 2) {
                    Manager m = new Manager(name, salary);
                    people.add(m);
                } else if (input == 3) {
                    Executive e = new Executive(name, salary);
                    people.add(e);
                }
            }
        }
    }
}