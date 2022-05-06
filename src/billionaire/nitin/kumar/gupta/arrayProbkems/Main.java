package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Input:  { 4, 2, -3, -1, 0, 4 }
 * <p>
 * Subarrays with zero-sum are
 * <p>
 * { -3, -1, 0, 4 }
 * { 0 }
 * <p>
 * <p>
 * Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 * <p>
 * Subarrays with zero-sum are
 * <p>
 * { 3, 4, -7 }
 * { 4, -7, 3 }
 * { -7, 3, 1, 3 }
 * { 3, 1, -4 }
 * { 3, 1, 3, 1, -4, -2, -2 }
 * { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 */

class Main {
    public static Set<List<Integer>> getAllZeroSumSubarrays(List<Integer> nums) {
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
                if (sum == 0) {
                    List<Integer> tempArray = new ArrayList();
                    for (int k = z; k <= j; k++) {
                        tempArray.add(nums.get(k));
                    }
                    subarrays.add(tempArray);
                    z = j + 1;
                }
                j++;
                if (temp == 0) {
                    List<Integer> tempArray = new ArrayList();
                    for (int k = i; k <= j - 1; k++) {
                        tempArray.add(nums.get(k));
                    }
                    subarrays.add(tempArray);
                }
            }


        }

        return subarrays;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<Integer> sss = new ArrayList<>();
        sss = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<List<Integer>> vsdft = getAllZeroSumSubarrays(sss);
        for (List<Integer> list : vsdft) {
            list.forEach(e -> {
                System.out.print("  " + e);
            });
            System.out.println();
        }
    }
}
