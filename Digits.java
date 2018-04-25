import java.util.ArrayList;
public class Digits
{
    /** The list of digits from the number used to construct this object
     *  The digits appear in the list in the same order in which they appear in the original number.
     */
    private ArrayList<Integer> digitList = new ArrayList<>();

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
    
    public int getModeDigit()
    {
        int mode = 0;
        int modeIndex = 0;
        for (int i = 0; i < digitList.size(); i++)
        {
            int digit = digitList.get(i);
            if (count(digit) > mode)
            {
                mode = count(digit);
                modeIndex = i;
            }
        }
        int modeDigit = digitList.get(modeIndex);
        for (Integer digit: digitList)
        {
            if (count(digit) == mode && digit != modeDigit)
            {
                return -1; 
            }
        }
        return modeDigit;
    }

    public int count(int num)
    {
        int count = 0;
        for (Integer digit: digitList)
        {
            if (digit == num) count++; 
        }
        return count;
    }
}
