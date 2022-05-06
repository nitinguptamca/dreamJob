package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an integer array, return all equilibrium index in it. For an array `A[0..n-1]`,
 * index `i` is an equilibrium index if the sum of elements of subarray `A[0…i-1]`
 * is equal to the sum of elements of subarray `A[i+1…n-1]`.
 * <p>
 * Input : [0, -3, 5, -4, -2, 3, 1, 0]
 * Output: {0, 3, 7}
 * Explanation: For each index `i` in the output, A[0] + A[1] + … + A[i-1] = A[i+1] + A[i+2] + … + A[n-1]
 * <p>
 * Input : [-7, 3, 7, -3, 1]
 * Output: {4}
 * Explanation: `n-1` is an equilibrium index if A[0] + A[1] + … + A[n-2] sums to 0.
 * <p>
 * Input : [1, 2, -4, 2]
 * Output: {0}
 * Explanation: 0 is an equilibrium index if A[1] + A[2] + … + A[n-1] sums to 0.
 */
public class EquilibriumIndex {

    public static Set<Integer> findEquilibriumIndex(List<Integer> nums) {
        Set<Integer> indices = new HashSet<>();
        int n = nums.size();
        int[] leftArray = new int[nums.size()];
        int[] rightArray = new int[nums.size()];

        leftArray[0] = 0;
        // traverse the array from left to right
        for (int i = 1; i < n; i++) {
            leftArray[i] = leftArray[i - 1] + nums.get(i - 1);
        }

        int right = 0;
        // traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            /* If the sum of elements of subarray `A[0…i-1]` is equal to
               the sum of elements of the subarray `A[i+1…n)` i.e.
               (A[0] + … + A[i-1]) = (A[i+1] + A[i+2] + … + A[n-1]) */
            if (leftArray[i] == right) {
                indices.add(i);
            }

            // new right is `A[i] + (A[i+1] + A[i+2] + … + A[n-1])`
            right += nums.get(i);
        }

        return indices;
    }

    public static void main(String[] args) {
        //int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };
        int[] A = {-7, 3, 7, -3, 1};

        System.out.println(findEquilibriumIndex(Arrays.stream(A).boxed().collect(Collectors.toList())));
    }
}
