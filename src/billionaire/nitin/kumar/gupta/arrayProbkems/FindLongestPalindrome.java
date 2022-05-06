package billionaire.nitin.kumar.gupta.arrayProbkems;

public class FindLongestPalindrome {
    static String str = "asdfsfaafsfsdfadfsadfsadfasfafa";

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {

        }
    }

    public static void main1(String[] args) {

        //String str = "nitin";
        GetLargestPalindromeInStringChallenge palindrome = new GetLargestPalindromeInStringChallenge();
        String maxPalindromeString = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length() - 1; j++) {
                boolean flag = isPalindrome(i, j);
                if (flag) {
                    String currentPalindrome = str.substring(i, j + 1);
                    if (currentPalindrome.length() > maxPalindromeString.length())
                        maxPalindromeString = currentPalindrome;
                }
            }
        }
        System.out.println("maxPalindromeString   " + maxPalindromeString);
    }

    public static boolean isPalindrome(int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
