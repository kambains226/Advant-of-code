
import java.io.*;
public class Ribbon {
    public static void main(String[] args) {
        

        try (BufferedReader dimensions = new BufferedReader(new FileReader("Wrapping.txt"))){
            int total =0;
            String line;
            
            while((line = dimensions.readLine()) != null){
                String[] dimensionsStr = line.split("x");
                int[] dimensionsArr = new int[dimensionsStr.length];
                for (int i = 0; i < dimensionsStr.length; i++) {
                    dimensionsArr[i] = Integer.parseInt(dimensionsStr[i]);
                }

                int length = dimensionsArr[0];
                int width = dimensionsArr[1];
                int height = dimensionsArr[2];
                int side1 = (length *2) + (width * 2);
                int side2 = (width*2)+   (height*2);
                int side3 = (height *2)+ ( length*2);
                
                int ribbon = Math.min(side1, Math.min(side2, side3));
                int bow = length * width * height;

                total += ribbon + bow;
                

                

                
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
