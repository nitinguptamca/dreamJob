package billionaire.nitin.kumar.gupta.arrayConcept;

import java.util.Arrays;

public class TestingSortingArray {
    static int[] unsortedArray = {8, 4, 1, 9, 3, 7, 2, 5};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(unsortedArray));
        AllSorting allSorting = new AllSorting(unsortedArray);
        // allSorting.bubbleSort();
        // allSorting.insertionSort();
        //  allSorting.selectionSort();
        //  allSorting.quickSort();
        //   allSorting.mergeSort();
        //  allSorting.countingSort();
        int[] sortedArray = allSorting.bucketSort();
        allSorting.redixSort();
        System.out.println(Arrays.toString(sortedArray));
    }
}
