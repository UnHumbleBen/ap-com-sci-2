import java.util.*;
public class DigitsTester
{
    public static void main(String[] args) {
        Digits a = new Digits(443135678);
        Digits b = new Digits(13457);
        Digits c = new Digits(346475);
        System.out.println(a.getModeDigit());
        System.out.println(b.getModeDigit());
        System.out.println(c.getModeDigit());
        while (true) {
            Scanner in = new Scanner(System.in);
            int n = (int) (Math.random() * 100000);
            System.out.println(n);
            Digits n1 = new Digits(n);
            System.out.println(n1.getModeDigit());
            
            if (in.nextLine().equals("q")) break;
        }

    }
}
