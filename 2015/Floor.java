import java.io.*;



public  class  Floor{
    public  static  void  main(String[]  args){
        
        try(BufferedReader reader = new BufferedReader(new FileReader("floor.txt"))){
            int floor =0;
            int character;
            while((character =reader.read()) != -1){
                char token = (char)character;
                
                System.out.println((char)(character));
                if(token =='('){
                    floor++;
                }
                else if(token == ')'){
                    floor--;
                }
                
            }
            System.out.println("The floor number is: " + floor);
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
           
        
    }
}