package billionaire.nitin.kumar.gupta.arrayProbkems;


/**
 * Given an integer array, find a pair with the maximum product in it.
 * <p>
 * Each input can have multiple solutions. The output should match with either one of them.
 * <p>
 * Input : [-10, -3, 5, 6, -2]
 * Output: (-10, -3) or (-3, -10) or (5, 6) or (6, 5)
 * <p>
 * Input : [-4, 3, 2, 7, -5]
 * Output: (3, 7) or (7, 3)
 * <p>
 * If no pair exists, the solution should return null.
 * <p>
 * Input : [1]
 * Output: null
 */
/*
public class MaximumProduct {

    public static Pair < Integer, Integer> findPair(int[] nums) {
        int n = nums.length;
        if(nums.length<2) return new Pair(null,null);
        int a = nums[0], b = nums[1];
        int maxProduct =0;

        Pair p = Pair.of(a ,b);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (nums[i] * nums[j] > maxProduct) {
                    maxProduct =nums[i] * nums[j];
                    p = Pair.of(nums[i], nums[j]);
                }
        return p;
    }

}
}

*/

