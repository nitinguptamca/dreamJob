package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch05BitManipulation.Q5_06_Conversion;

import billionaire.nitin.kumar.gupta.CtCI6thEdition1.CtCILibrary.AssortedMethods;

public class QuestionA {
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        int c = a ^ b;
        while (c != 0) {
            count += c & 1; // Increment count if c ends with a 1
            c >>>= 1; // Shift right by 1
        }
        return count;
    }

    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
        System.out.println("Required number of bits: " + bitSwapRequired(a, b));
    }
}
