package billionaire.nitin.kumar.gupta.arrayProbkems;

/**
 * Given n non-negative integers representing an elevation map where the
 * width of each bar is 1. Compute how much water it can trap after raining!
 * <p>
 * // it has O(N) running time (with additional O(N) memory complexity)
 * // dynamic programming approach - memoization !!!
 * min(maxleft ,maxright ) -heights
 * heights :    [1,0,2,1,3,1,2,0,3]
 * maxleft:     [0,1,1,2,2,3,3,3,3]
 * maxright:     [3,3,3,3,3,3,3,3,0]
 * trap value  : [0,1,0,1,0,2,1,3,0]
 */
public class TrappedRainProblem {

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2, 1, 3, 1, 2, 0, 3};

        System.out.println(solve(array));
    }

    public static int solve(int[] heights) {

        // less than 3 bars can not trap any water
        if (heights.length < 3)
            return 0;

        // create arrays for the max left and right values
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        // calculating the left max values (from left to right)
        leftMax[0] = 0;

        for (int i = 1; i < leftMax.length; ++i)
            leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);

        // calculating the right max values (from right to left)
        rightMax[rightMax.length - 1] = 0;

        for (int i = rightMax.length - 2; i >= 0; --i)
            rightMax[i] = Math.max(rightMax[i + 1], heights[i + 1]);

        // consider all the items in O(N) running time
        int trapped = 0;
        System.out.print(" " + trapped);
        for (int i = 1; i < heights.length - 1; i++) {
            System.out.print((Math.min(leftMax[i], rightMax[i]) - heights[i]) > 0 ? " " + (Math.min(leftMax[i], rightMax[i]) - heights[i]) : " " + 0);
            if (Math.min(leftMax[i], rightMax[i]) > heights[i]) {
                trapped += Math.min(leftMax[i], rightMax[i]) - heights[i];

            }
        }
        System.out.println();
        return trapped;
    }
}
