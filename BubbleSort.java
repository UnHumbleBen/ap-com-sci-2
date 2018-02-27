import java.util.*;
public class BubbleSort
{
    private int[] array;
    
    /** Constructs a BubbleSort object. 
     *  Initalizes an array with random numbers from 1 to 100 (non repeating).
     */
    public BubbleSort(int size)
    {
        array = new int[size];
        Random gen = new Random();
        for (int i = 0; i < size; i++) {
            int n = gen.nextInt(100) + 1;
            for (int j = 0; j < i; j++) {
                if (array[j] == n) {
                    n = gen.nextInt(100) + 1;
                    j = -1;
                }
            }
            array[i] = n;
        }
    }
    
    /** Prints each element in the array. */
    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /** Sorts array in order from least to greatest
     *  Uses bubble sort.
     */
    public void bubbleSort() {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        BubbleSort b = new BubbleSort(10);
        b.printArray();
        b.bubbleSort();
        b.printArray();
    }
}
