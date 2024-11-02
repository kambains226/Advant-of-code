
import java.io.*;
import java.util.*;
public class Location2 {
    public static void main(String[] args) {
        

        try (BufferedReader br = new BufferedReader(new FileReader("Location.txt"))) {
            int x =0, y = 0;
            int rx = 0, ry = 0;
            Set<String > santa = new HashSet<>();
            Set<String > robo = new HashSet<>();
            Set<String > combine = new HashSet<>();
           
            int odd= 0;
            int c ;
            
            while((c= br.read()) != -1) {
                
               
                odd++;
                char direction = (char) c;
                System.out.println(direction);
                System.out.println(odd);
                if(odd % 2 == 1 ) {
                    
                    switch (direction) {
                        case '^':ry++;break;
                        case 'v':ry--;break;
                        case '>':rx--;break;
                        case '<':rx++;break;
                    }
                }if (odd % 2 == 0 ){
                    
                    switch (direction) {
                        case '^':y++;break;
                        case 'v':y--;break;
                        case '>':x--;break;
                        case '<':x++;break;
                    }
                }
                
               
                robo.add(Arrays.toString(new int[]{rx, ry}));
                santa.add(Arrays.toString(new int[]{x, y}));
                
                
            }

            for (String s : santa){
                System.out.println("santa"+s);
            }
            for (String s : robo){
                System.out.println("robot"+s);
            }

            combine.addAll(santa);
            combine.addAll(robo);
            for (String element : combine){
                System.out.println((element));
            }
            
            int total = santa.size() + robo.size();
            System.out.println("Total: " +' ' +combine.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
