package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;

/**
 * Given two sorted integer arrays, `X[]` and `Y[]` of size `m` and `n` each, in-place merge elements of `X[]` with elements of array `Y[]` by maintaining the sorted order, i.e., fill `X[]` with the first `m` smallest elements and fill `Y[]` with remaining elements.
 * <p>
 * Input :
 * <p>
 * X[] = [1, 4, 7, 8, 10]
 * Y[] = [2, 3, 9]
 * <p>
 * Output:
 * <p>
 * X[] = [1, 2, 3, 4, 7]
 * Y[] = [8, 9, 10]
 */
public class MergeArray {
    public static void main(String[] args) {
        int X[] = new int[]{1, 4, 7, 8, 10};
        int Y[] = new int[]{2, 3, 9};
        merge(X, Y);
    }

    public static void merge(int[] X, int[] Y) {
        int[] mergeArray = new int[X.length + Y.length];
        int count = 0;
        int k = 0;
        for (; count < mergeArray.length; count++) {
            if (count < X.length) mergeArray[count] = X[count];
            else {
                mergeArray[count] = Y[k];
                k++;
            }
        }
        for (int i = 1; i <= mergeArray.length - 1; i++) {
            for (int j = i; j > 0; j--) {
                if (mergeArray[j] < mergeArray[j - 1])
                    swap(j - 1, j, mergeArray);
            }
        }

        int x = 0;
        for (int z = 0; z < mergeArray.length; z++) {
            if (z < X.length) X[z] = mergeArray[z];
            else {
                Y[x] = mergeArray[z];
                x++;
            }
        }

        System.out.println(Arrays.toString(X));
        System.out.println();
        System.out.println(Arrays.toString(Y));

    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
