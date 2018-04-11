import java.util.*;
public class UnitTesterTester
{
  public static printArrayList(ArrayList <Integer> a)
  {
    for (Integer n : a)
    {
      System.out.print(n + " "); 
    }
    System.out.println();
  }
  
  public ArrayList<Integer> convert(int[] array)
  {
     ArrayList<Integer> result = new ArrayList<>();
     for(int i = 0; i < array.length(); i++) {
      digitList.add(array.get(i)));
     }
    return result;
  }
  
  public static void main (String[] args) 
  {
    ArrayList <Integer> digitList = new ArrayList<>();
    for(int i = 0; i < 6; i++) {
      digitList.add((int)(Math.random()*10 + 1));
    }
    printArrayList(digitList);
    System.out.println(getModeDigit(digitList));
    
    int[] array1 = {4,4,3,1,3,5,6,7,8};
    int[] array2 = {1,3,4,5,7};
    int[] array3 = {3,4,6,4,7,5};
    
    digitList = convert(array1);
    printArrayList(digitList);
    System.out.println(getModeDigit(digitList));
    digitList = convert(array2);
    printArrayList(digitList);
    System.out.println(getModeDigit(digitList));
    digitList = convert(array3);
    printArrayList(digitList);
    System.out.println(getModeDigit(digitList));
  }
  
  public static int getModeDigit(ArrayList <Integer> digitList)
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
     int modeDigit = digitLIst.get(modeIndex)
     for (Integer digit: digitList)
     {
         if (count(digit) == mode && digit != modeDigit)
         {
            return -1; 
         }
     }
      return modeDigit;
  }
  
  public static int count(int num)
  {
    int count = 0;
    for (Integer digit: digitList)
    {
      if (digit == num) count++; 
    }
    return count;
  }
}
