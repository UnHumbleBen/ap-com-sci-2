
/**
 * Write a description of class BubbleSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class BubbleSort
{
    private int[] array;

    public BubbleSort(int size)
    {
        array = new int[size];
        Random gen = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = gen.nextInt(size) + 1;
        }
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
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
        BubbleSort b = new BubbleSort(50);
        b.printArray();
        b.bubbleSort();
        b.printArray();
    }
}
