
import java.io.*;
import java.util.*;
public class Location {
    public static void main(String[] args) {
        

        try (BufferedReader br = new BufferedReader(new FileReader("Location.txt"))) {
            int x =0, y = 0;

            Set<String > set = new HashSet<>();
            int test [];
            int c ;
            
            while((c= br.read()) != -1) {
                char direction = (char) c;
                
                set.add(Arrays.toString(new int[]{x, y}));
                System.out.println(Arrays.toString(new int[]{x, y}));
                System.out.println(direction);
               
                
                switch (direction) {
                    case '^':y++;break;
                    case 'v':y--;break;
                    case '>':x--;break;
                    case '<':x++;break;
                }
                
                

            }
        
            
          
            System.out.println("Total: " + set.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
