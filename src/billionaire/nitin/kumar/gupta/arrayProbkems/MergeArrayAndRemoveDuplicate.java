package billionaire.nitin.kumar.gupta.arrayProbkems;

/**
 * Given two sorted integer arrays `X[]` and `Y[]` of size `m` and `n` each where `m >= n` and `X[]` has exactly `n` vacant cells, merge elements of `Y[]` in their correct position in array `X[]`, i.e., merge `(X, Y)` by keeping the sorted order.
 * <p>
 * Input : Two arrays X[] and Y[] where vacant cells in X[] is represented by 0.
 * <p>
 * X[] = [0, 2, 0, 3, 0, 5, 6, 0, 0]
 * Y[] = [1, 8, 9, 10, 15]
 * <p>
 * Output: X[] = [1, 2, 3, 5, 6, 8, 9, 10, 15]
 */
public class MergeArrayAndRemoveDuplicate {
    public static void main(String[] args) {
        int X[] = new int[]{0, 2, 0, 3, 0, 5, 6, 0, 0};
        int Y[] = new int[]{1, 8, 9, 10, 15};
        merge(X, Y);

    }

    public static void merge(int[] X, int[] Y) {
        int mergeLength = X.length + Y.length;
        int i = 0;
        int[] mergeArray = new int[mergeLength];
        for (int j = 0; j < mergeLength; j++) {
            if (j < X.length) mergeArray[j] = X[j];
            else {
                mergeArray[j] = Y[i];
                i++;
            }
        }

        for (int k = 1; k < mergeLength; k++) {
            for (int l = k; l > 0; k--) {
                if (mergeArray[l] > mergeArray[l - 1]) {
                    swap(l, l - 1, mergeArray);
                }
            }
        }

        int length = mergeArray.length;
        length = removeDuplicateElements(mergeArray, length);
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int removeDuplicateElements(int arr[], int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n - 1];
        // Changing original array
        for (int i = 0; i < j; i++) {
            arr[i] = temp[i];
        }
        return j;
    }
}
