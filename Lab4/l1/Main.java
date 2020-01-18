import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main{

     public static void main(String[] args) { 

         try{
         BufferedReader scroll = new BufferedReader(new FileReader(args[0]));
         String line;

         while((line = scroll.readLine())!=null){
         
             System.out.println(line);
         
         }
         
         }
         catch (IOException e){
         
             e.printStackTrace();
         
         }

     }


}
