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

    /** Prints each element in the array a. */
    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
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
        System.out.println("Bubble sort");
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
        System.out.println("Selection sort");
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
        System.out.println("Insertion sort");
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
        System.out.println("Merge sort");
        mergeSort(array);
    }

    /** Merge sorts array  A */
    public void mergeSort(int[] A) {
        int n = A.length;
        if (n < 2) return;
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid] = A[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,A);
    }
    
    /** Merges two sorted arrays to one sorted array
     *  Array on left  L  combines with array on right  R
     *  to make array  A
     */
    public void merge(int[] L , int[] R, int[] A) {
        int nL = L.length;
        int nR = R.length;
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < nL) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < nR) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
    /*
    /** Merge subarray  a  with subarray  b
     *  int  i  is the first index of  a
     *  int  k  is the last index of  b
     *  int  j  is the last index of  a
     *  j + 1  is the first index of b
     */ 
    /*
    public void merge(int i ,int j, int k) {
    int length = k-i+1;
    int[] sorted = new int[length];

    // intializes subarrays A and B with values
    int[] a = new int[j-i+1];
    int[] b = new int[k-j];
    for (int index = 0; index < a.length; index++) {
    a[index] = array[i+index];
    }
    for (int index = 0; index < b.length; index++) {
    b[index] = array[i+a.length+index];
    }
    //printArray(a);
    //printArray(b);

    int indexSorted = 0;
    int indexA = 0;
    int indexB = 0;
    while (indexA < a.length && indexB < b.length) {
    if (a[indexA] < b[indexB]) {
    sorted[indexSorted] = a[indexA];
    indexA++;
    } else {
    sorted[indexSorted] = b[indexB];
    indexB++;
    }
    indexSorted++;
    }
    while(indexA < a.length) {
    sorted[indexSorted] = a[indexA];
    indexSorted++;
    indexA++;
    }
    while(indexB < b.length) {
    sorted[indexSorted] = b[indexB];
    indexSorted++;
    indexB++;
    }
    //printArray(sorted);

    for (int index = i; index <= k; index++) {
    array[index] = sorted[index - i];
    }
    //printArray();
    }
     */
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
            Sort c = new Sort(8);
            System.out.println("Given Array");
            c.printArray();

            c.mergeSort();
            c.printArray();
            c.printIsSorted();

            System.out.println("Press 1 to run again, any other key to stop");
            if (in.nextInt() != 1) break;
        } while (true);
    }
}