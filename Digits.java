import java.util.ArrayList;
public class Digits
{
    /** The list of digits from the number used to construct this object
     *  The digits appear in the list in the same order in which they appear in the original number.
     */
    private ArrayList<Integer> digitList = new ArrayList<>();

    /** Constructs a Digits object that represents num.
     *  Precondtiion: num >= 0
     */
    /*
    public Digits(int num)
    {
    if (num == 0) {
    digitList.add(0);
    }

    while (num > 0) {
    digitList.add(0, num % 10);
    num /= 10;
    }
    }
     */

    // in class one
    public Digits (int num)
    {
        digitList = new ArrayList<>();
        if (num == 0) 
        {
            digitList.add(0);
        }

        while (num > 0) 
        {
            digitList.add(0, num % 10);
            num /= 10;
        }
    }

    /** Returns true if the digits in this Digits are in strictly increasing order
     *          false otherwise.
     */
    public boolean isStrictlyIncreasing()
    {
        for (int i = 0; i < digitList.size()-1; i++) {
            if (digitList.get(i) >= digitList.get(i+1)) return false;
        }
        return true;
    }
}
