package billionaire.nitin.kumar.gupta.arrayConcept;

public class AllSorting {
    private static final int ITEMS = 10;
    int[] unsortedArray;
    int[] tempArray = null;

    public AllSorting(int[] unsortedArray) {
        this.unsortedArray = unsortedArray;
        this.tempArray = new int[unsortedArray.length];
    }

    public void bubbleSort() {
        for (int i = 0; i < unsortedArray.length; i++) {
            for (int j = 0; j < unsortedArray.length - i - 1; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = unsortedArray[i];
        unsortedArray[i] = unsortedArray[j];
        unsortedArray[j] = temp;
    }

    public void insertionSort() {
        for (int i = 1; i < unsortedArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (unsortedArray[j] > unsortedArray[j - 1]) {
                    swap(j, j - 1);
                }
            }
        }
    }

    public void quickSort() {
        quickSort(0, unsortedArray.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low > high) return;
        int middle = partition(low, high);
        quickSort(low, middle - 1);
        quickSort(middle + 1, unsortedArray.length - 1);
    }

    private int partition(int low, int high) {
        int poivet = (high + low) / 2;
        swap(poivet, high);
        int i = low;
        for (int j = low; j < high; ++j) {
            if (unsortedArray[j] <= unsortedArray[high]) {
                swap(i, j);
                ++i;
            }
        }
        // swap back the pivot (middle item)
        swap(i, high);

        return i;
    }

    public void mergeSort() {
        mergeSort(0, unsortedArray.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) return;
        int middle = (low + high) / 2;
        mergeSort(low, middle);
        mergeSort(middle + 1, high);
        mergeSort(low, middle, high);
    }

    private void mergeSort(int low, int middle, int high) {
        // copy the items into the temporary array
        for (int i = low; i <= high; ++i)
            tempArray[i] = unsortedArray[i];

        int i = low;
        int j = middle + 1;
        int k = low;

        // we consider the temp array and copy the items into the nums
        while (i <= middle && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                unsortedArray[k] = tempArray[i];
                ++i;
            } else {
                unsortedArray[k] = tempArray[j];
                ++j;
            }

            ++k;
        }

        // we have to copy the items from the left sub-array (if there are any)
        while (i <= middle) {
            unsortedArray[k] = tempArray[i];
            ++k;
            ++i;
        }

        // we have to copy the items from the right sub-array (if there are any)
        while (j <= high) {
            unsortedArray[k] = tempArray[j];
            ++k;
            ++j;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[min]) min = j;
            }
            swap(min, i);
        }
    }

    public void countingSort() {
        // we need additional memory
        int[] output = new int[unsortedArray.length];
        int[] count = new int[ITEMS];

        // we have to consider the items in the data in O(N)
        for (int i = 0; i < unsortedArray.length; ++i)
            count[unsortedArray[i]]++;

        // transform the count array into a cumulative array O(k)
        for (int i = 1; i < count.length; ++i)
            count[i] += count[i - 1];

        // cumulative array to get the positions of the items in the original (data)
        // we have to consider the items in a reverse order O(N)
        for (int i = unsortedArray.length - 1; i >= 0; --i) {
            count[unsortedArray[i]]--;
            output[count[unsortedArray[i]]] = unsortedArray[i];
        }

        // sorted order in the output array O(N)
        for (int i = 0; i < unsortedArray.length; ++i)
            unsortedArray[i] = output[i];
    }

    public int[] bucketSort() {
        int[] bucket = new int[10];
        int[] sorted_arr = new int[unsortedArray.length];

        for (int i = 0; i < unsortedArray.length; i++)
            bucket[unsortedArray[i]]++;

        int pos = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                sorted_arr[pos++] = i;
        return sorted_arr;
    }

    public void redixSort() {
    }
}
