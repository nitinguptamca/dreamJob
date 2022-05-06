package revision.ArraysProblem;

import java.util.Arrays;

public class DutchFlagProblem {
    static int[] unsortedArrays = {1, 0, 2, 0, 1, 2, 0, 1, 2};

    public static void main(String[] args) {
        sortArray();
        System.out.println(Arrays.toString(unsortedArrays));
    }

    private static void sortArray() {
        int i = 0, j = 0;
        int k = unsortedArrays.length - 1;
        int middle = 1;
        while (j <= k) {
            // when item with index j = 0
            if (unsortedArrays[j] < middle) {
                swap(i, j);
                i++;
                j++;
                // item is 2
            } else if (unsortedArrays[j] > middle) {
                swap(j, k);
                k--;
                // the item is 1
            } else {
                j++;
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = unsortedArrays[i];
        unsortedArrays[i] = unsortedArrays[j];
        unsortedArrays[j] = temp;
    }
}
