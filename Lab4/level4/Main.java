import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import cs2030.catsanddogs.Farm; 
public class Main{

     public static void main(String[] args) { 

         try{
         BufferedReader scroll = new BufferedReader(new FileReader(args[0]));
         String line;


         Farm fm = new Farm();

         while((line = scroll.readLine())!=null){
         
              fm.readLine(line);
         
         }
         
         }
         catch (IOException e){
         
             e.printStackTrace();
         
         }

     }


}
