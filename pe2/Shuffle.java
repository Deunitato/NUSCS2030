public class Shuffle{

  //  private static String str;



    Shuffle(){
    
    
    
    }

    static String plsShuffle(String str){
        if(str.length() <= 0 || str.length()-2 < 0 ){
         return str;
             }
        String first =""+ str.charAt(0);
        String last = ""+str.charAt(str.length()-1);
        String temp = "";
        
        
        
        for(int i = 1; i< str.length()- 1 ; i++){
        
            temp =  str.charAt(i) + temp ;
            
        
        }

    return first + temp + last;
    }


}
