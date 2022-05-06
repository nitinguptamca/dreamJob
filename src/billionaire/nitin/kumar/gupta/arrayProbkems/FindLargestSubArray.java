package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Given a binary array containing 0’s and 1’s, find the largest contiguous
 * subarray with equal numbers of 0’s and 1’s.
 * <p>
 * Input : [0, 0, 1, 0, 1, 0, 0]
 * Output: [0, 1, 0, 1] or [1, 0, 1, 0]
 * <p>
 * Input : [0, 0, 0, 0]
 * Output: []
 * <p>
 * Note: Since an input can contain several largest subarrays with equal numbers of 0’s and 1’s,
 * the code should return any one of them.
 */
public class FindLargestSubArray {
    public static List<Integer> findLargestSubarray(List<Integer> nums) {
        Set<List<Integer>> largestSubarray = new HashSet<>();
        List<Integer> integerList = null;
        for (int i = 0; i <= nums.size() - 2; i += 2) {
            if (nums.get(i) == nums.get(i + 1)) {
                integerList = new ArrayList<>();
            } else {
                if (integerList == null) {
                    integerList = new ArrayList<>();
                }
                integerList.add(nums.get(i));
                integerList.add(nums.get(i + 1));
            }
            largestSubarray.add(integerList);
        }

        return largestSubarray.stream().max(Comparator.comparingInt(List::size)).orElse(new ArrayList<>());
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 0, 0, 1, 0, 1, 0, 1, 0};
        List<Integer> list = findLargestSubarray(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        list.forEach(e -> {
            System.out.print(" " + e);
        });
    }
}
