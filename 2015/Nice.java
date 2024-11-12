import java.io.*;
import java.util.*;
public class Nice {  
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            int nice = 0;
            String word;
            
            while ((word = br.readLine()) != null) { 
                // Ensure word is not null before processing it
                
                if(doubleCombo(word)&& between(word) ) {
                    nice++;
                }
            }
            System.out.println("Nice words: " + nice); 
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    

    private static boolean doubleLetter(String word) {
        // ArrayList<String> words = new ArrayList<>(); 
        int count = 0;
        boolean  doubleCheck =false;
        for (int i = 0; i < word.length() - 2; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                if(word.charAt(i) != word.charAt(i + 2)) {


                    count++;
                }
              
            }
            
                if(count>=2){

                    // System.out.println(word+" "+count);

                    // System.out.println(word.charAt(i) + " " + word.charAt(i + 1) + count); 
                    
                    doubleCheck = true;
                    return true;
 
                }
        //     if(doubleCheck){
            
        //     if (( word.charAt(i) == word.charAt(i + 2))) {

        //         System.out.println(word);
        //         System.out.println(word.charAt(i) + " " + word.charAt(i + 1) + " " + word.charAt(i + 2));
        //         return true; // Found the xyx pattern
                
                
        //     }    
        // }
        
        }
        return false;
    }
    private static boolean  doubleCombo(String word){
         
    Set<String> track = new  LinkedHashSet<String>();
    
    for (int i = 0; i <word.length()-1; i++) {
        String combo = word.substring(i, i + 2);
        // if (track.contains(combo)) {
        //     return true;
        System.out.println(combo + " " + "test");
         if(track.contains(combo)&& same(word) ) {
            System.out.println(combo + " " + "test2");
            // System.out.println(word);
            return true;
            // System.out.println(word); 

        }
        track.add(combo);
        
    }
    System.out.println(word);
    System.out.println(track.toString());

            

    

    return false;
} 
private static boolean same(String word){
    for (int i = 0; i < word.length() -3 ; i++) {
        if (word.charAt(i) == word.charAt(i + 1)&& word.charAt(i + 2) == word.charAt(i) &&word.charAt(i+3)==word.charAt(i+2)) {
            // System.out.println(word + " " + word.charAt(i) + " " + word.charAt(i + 1) + " " + word.charAt(i + 2));
           return true;  

        }

    }

    return false;
}
    private static boolean   between(String word){

        for (int i = 0; i < word.length() - 2; i++) {
            if (word.charAt(i) == word.charAt(i + 2)) {
                // System.out.println(word + " " + word.charAt(i) + " " + word.charAt(i + 1) + " " + word.charAt(i + 2));


                return true; // Found the xyx pattern
                
                

            }

        }
    return false;    
    }
} 

