import java.io.*;

public class Scramble {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            int nice = 0;
            String word;
            
            while ((word = br.readLine()) != null) { 
                // Ensure word is not null before processing it
                if (containsVowel(word) && doubleLetter(word) && notIn(word)) {
                    nice++;
                    // System.out.println(word); // Uncomment if you want to print each "nice" word
                }
            }
            System.out.println("Nice words: " + nice); 
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private static boolean containsVowel(String word) {
        int count = 0;        
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        
        for (char c : word.toLowerCase().toCharArray()) { 
            for (char vowel : vowels) {
                if (c == vowel) {
                    count++;
                    break; // Only count each vowel once per match
                }
            }
            if (count >= 3) { // Check if there are at least 3 vowels
                return true;
            }
        }
        return false;
    }

    private static boolean doubleLetter(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean notIn(String word) {
        String[] forbiddenWords = {"ab", "cd", "pq", "xy"};
        for (String forbidden : forbiddenWords) {
            if (word.contains(forbidden)) {
                return false;
            }
        }
        return true;
    }
}
