package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;

public class ArraySort {
    public static void rearrange(int[] nums) {
        int n = nums.length - 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (nums[j] == 0) {
                    swap(j, j + 1, nums);
                } else {
                    if (nums[j] == 0 && nums[j + 1] != 0) {
                        swap(j, j + 1, nums);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // int[] binaryArray = {0, 0, 0, 1, 1, 1};
        int[] binaryArray = {6, 0, 8, 2, 3, 0, 4, 0, 1};
        rearrange(binaryArray);
        System.out.println(Arrays.toString(binaryArray));
    }
}
