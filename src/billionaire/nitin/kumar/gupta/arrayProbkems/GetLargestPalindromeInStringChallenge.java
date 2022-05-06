package billionaire.nitin.kumar.gupta.arrayProbkems;


public class GetLargestPalindromeInStringChallenge {

    public static void main(String[] args) {
        String str = "asdfsfaafsfsdfadfsadfsadfasfafannnitinnitinnn";
        //String str = "nitin";
        GetLargestPalindromeInStringChallenge palindrome = new GetLargestPalindromeInStringChallenge();
        String maxPalindromeString = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String currentPalindrome = palindrome.isPalindromeString(i, j, str, maxPalindromeString.length());
                if (maxPalindromeString.length() < currentPalindrome.length()) {
                    System.out.println("currentPalindrome-->> " + currentPalindrome + "  length " + currentPalindrome.length());
                    maxPalindromeString = currentPalindrome;
                }
            }
        }
        System.out.println();
        System.out.println(maxPalindromeString);
    }

    public String isPalindromeString(int start, int end, String str, int maxPalindromeLength) {
        if (maxPalindromeLength < (end - start)) {
            String subString = getSubString(start, end, str);
            String reverseStr = getReverseSubString(start, end, str);
            if (subString.equals(reverseStr)) return reverseStr;
        }
        return "";
    }

    private String getReverseSubString(int start, int end, String str) {
        String temp = "";
        for (int i = start; i <= end; i++) {
            temp = str.charAt(i) + temp;
        }
        return temp;
    }

    public String getSubString(int start, int end, String str) {
        String temp = "";
        for (int i = start; i <= end; i++) {
            temp += str.charAt(i);
        }
        return temp;
    }
}
