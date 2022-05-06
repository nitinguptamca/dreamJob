package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array, find the maximum length contiguous subarray having a given sum.
 * <p>
 * Input : nums[] = [5, 6, -5, 5, 3, 5, 3, -2, 0], target = 8
 * Output: [5, 3, 3, 5]  =sum =8
 * Explanation: The subarrays with sum 8 are [[-5, 5, 3, 5], [3, 5], [5, 3]]. The longest subarray is [-5, 5, 3, 5] having length 4.
 * <p>
 * Note: Since an input can contain several maximum length subarrays with given sum, the solution should return any one of the maximum length subarray.
 */

public class FindMaxLenSubarray {
    public static List<Integer> findMaxLenSubarray(List<Integer> nums, int target) {
        Set<List<Integer>> subarrays = new HashSet<>();
        for (int i = 0; i < nums.size(); i++) {

            int j = i;
            int z = i;
            int sum = 0;
            int temp = 0;
            while (j < nums.size()) {
                // sum of elements so far
                sum += nums.get(j);
                temp += nums.get(j);

                // if the sum is seen before, we have found a subarray with zero-sum
                if (sum == target) {
                    List<Integer> tempArray = new ArrayList();
                    for (int k = z; k <= j; k++) {
                        tempArray.add(nums.get(k));
                    }
                    subarrays.add(tempArray);
                    z = j + 1;
                }
                j++;
                if (temp == target) {
                    List<Integer> tempArray = new ArrayList();
                    for (int k = i; k <= j - 1; k++) {
                        tempArray.add(nums.get(k));
                    }
                    subarrays.add(tempArray);
                }
            }


        }
        return subarrays.stream().max(Comparator.comparing(List::size))
                .orElse(new ArrayList<>());
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1 - 2, 2, -2,2 -2,3,-1};
        List<Integer> test = findMaxLenSubarray(Arrays.stream(nums).boxed().collect(Collectors.toList()), 2);
        test.forEach(s -> {
            System.out.print(" " + s);
        });
    }
}
