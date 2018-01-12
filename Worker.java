// Benjamin Lee Period 5 1/11/2018
public class Worker {
    private String name;
    private double rate;
    public Worker(String newName, double newRate) {
        name = newName;
        rate = newRate;
    }

    public double computePay(int hours) {
        double pay = hours * rate;
        if (hours > 40) pay += 0.5 * rate * (hours-40);
        return pay;
    }
}
class HourlyWorker extends Worker {
    public HourlyWorker(String newName, double newRate) {
        super(newName,newRate);
    }

    public double computePay(int hours) {
        return super.computePay(hours);
    }
}
class SalariedWorker extends Worker {
    public SalariedWorker(String newName, double newRate) {
        super(newName,newRate);
    }

    public double computePay(int hours) {
        return super.computePay(40);
    }
}
