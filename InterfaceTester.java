
/*
interface Operator {
    //contains only public methods. NO INSTANCE VARIABLES
    void task1();
    void task2();
    int getHours();
}
*/
interface Custodian {
    int a = 0;
    void task3();
}
abstract class Operator {
    private String name;
    private int hours;
    
    abstract public void task1();
    public int getHours() {return hours;}
}

class Worker extends Operator {
    public void task1() {
        System.out.print("");
    }
}

public class InterfaceTester {
    public static void main(String[] args) {
        
    }
}

/*
public class Employee2 implements Operato{
    public void task3() {
        
    }
    public void task1() {

    }
    public void task2() {
        
    }
    public int getHours() {
        return 0;
    }
}
*/