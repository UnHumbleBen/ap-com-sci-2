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

    /** Sorts array
     *  Uses insertion sort.
     */
    public void insertionSort() {
        for (int i = 1; i <= array.length; i++) {
            int j = i;
            while (--j > 0) {
                if (array[j] >= array[j-1]) break;
                swap(j,j-1);
            }
        }
    }

    /** Sorts array
     *  Uses merge sort.
     */
    public void mergeSort() {

    }

    /** Prints whether the array is sorted or not */
    public void printIsSorted() {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                System.out.println("Array is not sorted");
                return;
            }
        }
        System.out.println("Array is sorted");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do  {
            System.out.println("Insertion sort");
            Sort c = new Sort(10);
            c.printArray();
            c.printIsSorted();
            c.insertionSort();
            c.printArray();
            c.printIsSorted();
            System.out.println("Press 1 to run again, any other key to stop");
            if (in.nextInt() != 1) break;
        } while (true);
    }
}
