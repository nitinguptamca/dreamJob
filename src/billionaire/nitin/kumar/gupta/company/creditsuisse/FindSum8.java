package billionaire.nitin.kumar.gupta.company.creditsuisse;


/**
 * problem statement We have sorted array find all possible combination of sum 8
 * like int[] sorted array ={-3,-2,-1,0,2,3,4,5,7,8,10,11} then possible
 * combination is {-3,11}{-2,10}{0,8}{3,5}
 *
 * @author nitin
 */

public class FindSum8 {

    public static void main(String[] args) {
        int[] sortedArray = {9, -7, -5, -4, -3, -2, -1, 0, 2, 3, 4, 5, 7, 8, 10, 11, 12, 13, 15, 17, 19, 21};
        String possibleCombination = "";
        // solution 1
        /*
         * for (int i = 0; i < sortedArray.length; i++) { for (int j = i + 1; j <
         * sortedArray.length; j++) { System.out.println("[i] " + i + "{[" +
         * sortedArray[i] + "[" + j + "]" + "][" + sortedArray[j] + "],"); if
         * (sortedArray[i] + sortedArray[j] == 8) { possibleCombination += "{[" +
         * sortedArray[i] + "][" + sortedArray[j] + "],"; continue; } } }
         * System.out.println(" possible -->> " + possibleCombination);
         */
        // solution2
        int begin;
        // int tmp = 0;
        int mid = 0;
        int end = sortedArray.length - 1;
        for (int i = 0; i < sortedArray.length; i++) {
            begin = i;
            mid = (begin + end) / 2;
            // tmp = sortedArray[begin] + sortedArray[mid];
            for (; (sortedArray[begin] + sortedArray[mid]) < 8; mid++)
                ;
            for (; ((mid > begin) && (sortedArray[begin] + sortedArray[mid]) > 8); mid--)
                ;
            if (sortedArray[begin] + sortedArray[mid] == 8) {
                possibleCombination += "{[" + sortedArray[begin] + "][" + sortedArray[mid] + "],";
                continue;
            }
        }

        System.out.println(" possible -->> " + possibleCombination);
    }
}
