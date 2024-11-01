
import java.io.*;
public class Wrapping {
    public static void main(String[] args) {
        

        try (BufferedReader dimensions = new BufferedReader(new FileReader("Wrapping.txt"))){
            int total =0;
            String line;
            
            while((line = dimensions.readLine()) != null){
                String[] dimensionsStr = line.split("x");
                int length = Integer.parseInt(dimensionsStr[0]);
                int width = Integer.parseInt(dimensionsStr[1]);
                int height = Integer.parseInt(dimensionsStr[2]);
                
                int side1 = length * width;
                int side2 = width * height;
                int side3 = height * length;
                
                int extra = Math.min(side1, Math.min(side2, side3));
                
                int sf =  (2*side1) + (2*side2) + (2*side3);

                total +=  sf +extra;
                
            }
            System.out.println("Total: " + total);
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
