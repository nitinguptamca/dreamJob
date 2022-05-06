package billionaire.nitin.kumar.gupta.company.optUM;

import java.util.Arrays;

public class RemoveDuplicateNotUsingAPI {
    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 2, 6, 1, 1, 7, 6, 8, 9, 9, 1, 1, 3, 4, 7, 8, 2};
        System.out.println(Arrays.toString(arr));
        //arr = removeDuplicate(arr);
        //arr = removeDuplicates(arr);
        removeDuplicateUsingBucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void removeDuplicateUsingBucketSort(int[] arr) {
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            if (Bucket[arr[i]] == 0)
                Bucket[arr[i]]++;
        System.out.println(Arrays.toString(Bucket));

        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;
        System.out.println(Arrays.toString(sorted_sequence));
    }

    public static int[] removeDuplicates(int[] arr) {

        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        arr[shiftLeft] = arr[k];
                    }
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];
        for (int i = 0; i < end; i++) {
            whitelist[i] = arr[i];
        }
        return whitelist;
    }


    public static int[] removeDuplicate(int[] arr) {
        int temp[] = new int[arr.length];
        boolean[] check = new boolean[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (check[i] != true)
                temp[index++] = arr[i];
            else
                continue;

            int var = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (var == arr[j])
                    check[j] = true;
            }
        }
        int returnArray[] = new int[index];

        for (int i = 0; i < returnArray.length; i++)
            returnArray[i] = temp[i];

        return returnArray;
    }

}
