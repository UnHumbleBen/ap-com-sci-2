import java.util.*;
public class Sort
{
    private int[] array;
    
    /** Constructs a BubbleSort object. 
     *  Creates an array of length  size  with random numbers
     *  from 1 to 100 (non repeating).
     */
    public Sort(int size)
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
    
    /** Swaps the elements in the  array  at index  a  and index  b  .*/
    public void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    /** Sorts array in order from least to greatest
     *  Uses bubble sort.
     */
    public void bubbleSort() {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    swap(j,j+1);
                }
            }
        }
    }
    
    /** Sorts array
     *  Uses selection sort.
     */
    public void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i; j < array.length ; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Bubble sort");
        Sort b = new Sort(10);
        b.printArray();
        b.bubbleSort();
        b.printArray();
        
        System.out.println("Selection sort");
        Sort c = new Sort(10);
        c.printArray();
        c.selectionSort();
        c.printArray();
    }
}
