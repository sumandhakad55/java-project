import java.util.Scanner;
class TextAnalyzer {

    
    public void analyze(String str) {

        int uppercase = 0;
        int lowercase = 0;
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int whitespaces = 0;
        int specialSymbols = 0;

        
        StringBuilder transformed = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (Character.isUpperCase(ch)) {
                uppercase++;
                ch = Character.toLowerCase(ch);

                
                if (isVowel(ch)) {
                    vowels++;
                    transformed.append('*');
                } else {
                    consonants++;
                    transformed.append(ch);
                }

            } else if (Character.isLowerCase(ch)) {
                lowercase++;
                ch = Character.toUpperCase(ch);

                
                if (isVowel(Character.toLowerCase(str.charAt(i)))) {
                    vowels++;
                    transformed.append('*');
                } else {
                    consonants++;
                    transformed.append(ch);
                }

            } else if (Character.isDigit(ch)) {
                digits++;
                transformed.append(ch);

            } else if (Character.isWhitespace(ch)) {
                whitespaces++;
                transformed.append(ch);

            } else {
                specialSymbols++;
                transformed.append(ch);
            }
        }

        
        System.out.println("\n--- Character Classification Report ---");
        System.out.println("Uppercase Letters : " + uppercase);
        System.out.println("Lowercase Letters : " + lowercase);
        System.out.println("Vowels            : " + vowels);
        System.out.println("Consonants        : " + consonants);
        System.out.println("Digits            : " + digits);
        System.out.println("Whitespaces       : " + whitespaces);
        System.out.println("Special Symbols   : " + specialSymbols);
        System.out.println("Total Characters  : " + str.length());
        System.out.println("Transformed String: " + transformed);
    }

   
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
}

public class TextAnalyzerDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a paragraph: ");
        String str = sc.nextLine();

        System.out.println("Original String: " + str);

        TextAnalyzer analyzer = new TextAnalyzer();
        analyzer.analyze(str);

        sc.close();
    }
}