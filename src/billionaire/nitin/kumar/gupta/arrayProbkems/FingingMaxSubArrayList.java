package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;

/**
 * Given an integer array, find the maximum sum among all its subarrays.
 * <p>
 * Input : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Output: 6
 * Explanation: The maximum sum subarray is [4, -1, 2, 1]
 * <p>
 * Input : [-7, -3, -2, -4]
 * Output: -2
 * Explanation: The maximum sum subarray is [-2]
 * <p>
 * Input : [-2, 2, -1, 2, 1, 6, -10, 6, 4, -8]
 * Output: 10
 * Explanation: The maximum sum subarray is [2, -1, 2, 1, 6] or [6, 4] or [2, -1, 2, 1, 6, -10, 6, 4]
 * <p>
 * int[] A = {-2, 3, -1, 2, -7, -1};
 * 3 ,-1,2  =4
 */
public class FingingMaxSubArrayList {
    // Function to print contiguous subarray with the largest sum
    // in a given set of integers
    public static int[] kadane(int[] nums) {
        // base case
        if (nums.length == 0) {
            return nums;
        }

        // stores the maximum sum subarray found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores the maximum sum of subarray ending at the current position
        int maxEndingHere = 0;

        // stores endpoints of maximum sum subarray found so far
        int start = 0, end = 0;

        // stores starting index of a positive-sum sequence
        int beg = 0;

        // traverse the given array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (nums[i] >= maxEndingHere) {
                    maxEndingHere = nums[i];
                    start = i;
                    end = i;
                } else {
                    maxEndingHere = maxEndingHere + nums[i];
                    if (maxEndingHere < nums[i]) {
                        maxEndingHere = nums[i];
                        beg = i;
                    }
                }


            } else {
                maxEndingHere = maxEndingHere + nums[i];
                if (maxEndingHere < nums[i]) {
                    maxEndingHere = nums[i];
                    beg = i;
                } else if (maxSoFar <= maxEndingHere) {
                    maxSoFar = maxEndingHere;
                    start = beg;
                    end = i;
                }
            }
        }
        System.out.println("maxEndingHere " + maxEndingHere);
        int[] maxsum = Arrays.copyOfRange(nums, start, end + 1);
        int ss = Arrays.stream(maxsum).sum();
        return Arrays.copyOfRange(nums, start, end + 1);
    }

    public static void main(String[] args) {
        int[] A = {-2, 3, -1, 2, -7, -1 ,3 ,7,-9};

        int slice[] = kadane(A);
        System.out.print("The contiguous subarray with the largest sum is " +
                Arrays.toString(slice));
    }
}
