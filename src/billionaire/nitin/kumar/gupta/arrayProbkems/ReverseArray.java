package billionaire.nitin.kumar.gupta.arrayProbkems;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 5, 3, 8, 4, 9, 5, 8};
        int[] reverseArray = new int[intArray.length];
        int count = 0;
        for (int i = intArray.length - 1; i >= 0; i--) {
            reverseArray[count] = intArray[i];
            count++;
        }
        System.out.println(Arrays.toString(reverseArray));
        Arrays.stream(reverseArray).forEach(System.out::println);
        Arrays.stream(reverseArray).forEach(ss -> {
            System.out.println(ss);
        });
    }
}
