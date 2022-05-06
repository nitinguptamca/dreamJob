package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch16Moderate.Q16_02_Word_Frequencies;

import billionaire.nitin.kumar.gupta.CtCI6thEdition1.CtCILibrary.AssortedMethods;

public class QuestionA {
    public static int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();

        String[] words = {"the", "Lara", "and", "outcropping", "career", "it"};
        for (String word : words) {
            System.out.println(word + ": " + getFrequency(wordlist, word));
        }
    }

}
