package billionaire.nitin.kumar.gupta.arrayProbkems;

/**
 * Given an integer array of size `n`, return the element which appears more than `n/2` times. Assume that the input always contain the majority element.
 * <p>
 * Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
 * Output: 2
 * <p>
 * Input : [1, 3, 1, 1]
 * Output: 1
 */
public class FindMajorityElement {

    public static int findMajorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int[] numberOccurrence = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numberOccurrence[nums[i]]++;
        }
        int majority = numberOccurrence[0];
        int i = 1;
        for (; i < nums.length; i++) {
            if (numberOccurrence[i] > majority) majority = numberOccurrence[i];
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
      ///  Arrays.stream(nums).collect(Collectors.groupingBy())
        System.out.println(findMajorityElement(nums));
    }
}
