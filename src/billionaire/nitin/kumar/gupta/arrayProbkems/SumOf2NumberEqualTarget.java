package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.HashMap;
import java.util.Map;

public class SumOf2NumberEqualTarget {
    public static void main(String[] args) {
        int[] nums = {-4, 1, -2, 5, -8, 4, 7, 0, 3, 2, 9};
        int target = 5;
        findSumOf2Numer(nums, 5);
    }

    private static void findSumOf2Numer(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - (nums[i]);
            if (hashMap.containsValue(remainder)) {
                System.out.println("remainder " + remainder + " nums[i] " + nums[i]);
            }
            hashMap.put(i, nums[i]);
        }
    }
}
