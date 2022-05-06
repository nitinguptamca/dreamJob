package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;

/**
 * Given a binary array, in-place sort it in linear time and constant space. The output should contain all zeroes, followed by all ones.
 * <p>
 * Input : [1, 0, 1, 0, 1, 0, 0, 1]
 * Output: [0, 0, 0, 0, 1, 1, 1, 1]
 * <p>
 * Input : [1, 0, 1, 0]
 * Output: [0, 0, 1, 1]
 * <p>
 * Input : [1, 1]
 * Output: [1, 1]
 * <p>
 * Input : [0, 0]
 * Output: [0, 0]
 */
public class SortBinaryArray {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 0, 1, 0, 0, 1};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortArray(int[] nums) {
        int k = nums.length - 1;
        int i = 0;
        while (i <= k) {
            if (nums[i] > 0 && nums[k] != 1) {
                swap(i, k, nums);
                i++;
                k--;
            } else if (nums[i] > 0 && nums[k] == 1) {
                k--;
            } else
                i++;
        }
    }


    public static void swap(int k, int j, int[] nums) {
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = temp;
    }

}
