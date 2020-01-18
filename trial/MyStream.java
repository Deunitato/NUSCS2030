import java.util.stream.*;
public class MyStream{


public static <T> long myCount(Stream<T> stream){
 long count = 0;
 count = stream.map(x -> {return 1;} ).reduce(0,(x,y)->x+y);
 return count;

}

public static long countRepeat(String str){
return str.length() - IntStream.range(0,str.length()).filter(x-> {

    char c = str.charAt(x);
    if(str.length()!= (x+1)){
    
        if(c==str.charAt(x+1)){
        return false;
        }
        else{
        return true;
        }
    }
    else{
    return true;
    }

}).count();


}




}
