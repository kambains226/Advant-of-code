
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String  generateHash(String data, String type) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(type);
        byte[] bytes = md.digest(data.getBytes());

        StringBuilder hexString = new StringBuilder();
        for(byte b: bytes){
            
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
       
        return hexString.toString();

    }
    public static void main(String[] args) {
        
        
        try(BufferedReader br = new BufferedReader(new FileReader("MD5.txt"))){
            int num = 0;
            String hash;
            
        
            
            while((hash= br.readLine()) != null) {
                System.out.println(hash);
                while (true) { 
                    String ans = hash+num++;

                    String MD5 =  generateHash(ans, "MD5");
                    
                    System.out.println(ans);
                    if(MD5.substring(0, 6).equals("000000")) {
                        

                       
                        break;
                    }

                }
                System.out.println(num);
            }
                
        }
        catch(IOException e) {
            System.out.println("Error: " + e);
        }
        catch(NoSuchAlgorithmException e) {
            System.out.println("Error: " + e);
        }

    }
}
