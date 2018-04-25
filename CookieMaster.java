import java.util.*;
public class CookieMaster {
    private List<Cookie> orders;
    
    public CookieMaster() {
        orders = new ArrayList<>();
        orders.add(new Cookie(0));
        orders.add(new Cookie(1));
        orders.add(new Cookie(2));
        orders.add(new Cookie(3));
        orders.add(new Cookie(4));
        System.out.println(orders.remove(2).sampleMethod());
        System.out.println(orders.remove(2).sampleMethod());
        System.out.println(orders.remove(2).sampleMethod());
    }
    
    public static void main(String[] args) {
        CookieMaster a = new CookieMaster();
    }
}