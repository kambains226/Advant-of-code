import java.io.*;



public  class  Floor2{
    public  static  void  main(String[]  args){
        
        try(BufferedReader reader = new BufferedReader(new FileReader("floor.txt"))){
            int floor =0;
            int character;
            int basement = 0;
            while((character =reader.read()) != -1){
                char token = (char)character;
                
               
                if(token =='('){
                    floor++;
                    basement++;
                }
                else if(token == ')'){
                    floor--;
                    basement++;
                }
                
                if(floor == -1)
                {
                    break;
                }
                
            }
            System.out.println("the basement took" + basement + "tries");
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
           
        
    }
}