import java.util.*;
// Benjamin Lee Period 5 1/9/2018
public class Employee {
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