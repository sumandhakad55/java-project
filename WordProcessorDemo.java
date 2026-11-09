import java.util.*;

public class WordProcessorDemo {

    public static void processSentence(String sentence) {

        
        String[] words = sentence.split("\\s+");

        StringBuilder reversedSentence = new StringBuilder();
        ArrayList<String> palindromes = new ArrayList<>();
        ArrayList<Integer> positions = new ArrayList<>();

        
        
        for (int i = 0; i < words.length; i++) {

            String originalWord = words[i];

           
           
            String reversedWord =
                    new StringBuilder(originalWord).reverse().toString();

            reversedSentence.append(reversedWord);

            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }

            String cleanWord = originalWord
                    .replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            
            
            String lowerWord = cleanWord.toLowerCase();

            String reverseCleanWord =
                    new StringBuilder(lowerWord).reverse().toString();

            if (!cleanWord.isEmpty() &&
                    lowerWord.equals(reverseCleanWord)) {

                palindromes.add(originalWord);
                positions.add(i + 1);
            }
        }

        
        System.out.println("Original Sentence: " + sentence);
        System.out.println("--- Word-by-Word Reversal ---");
        System.out.println("Reversed Sentence: " + reversedSentence);

        System.out.println("--- Palindrome Analysis ---");
        System.out.println("Total Words Evaluated: " + words.length);
        System.out.println("Palindromic Words Found: " + palindromes.size());

        for (int i = 0; i < palindromes.size(); i++) {
            System.out.println("• Word #" + positions.get(i)
                    + ": \"" + palindromes.get(i) + "\"");
        }
    }

    public static void main(String[] args) {

        String sentence =
                "Madam Arora teaches advanced Java on racecar tracks";

        processSentence(sentence);
    }
}