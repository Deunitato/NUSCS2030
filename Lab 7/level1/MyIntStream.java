import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public interface  MyIntStream{

    public static MyIntStream of(int...values){
    ArrayList<Integer> list = new ArrayList<>();
    for(int i : values){
    
        list.add(i);
    }
    return new MyIntStreamImpl(list);
    }


    public static MyIntStream range(int start, int end){ 
     ArrayList<Integer> list = new ArrayList<>();
     
     for(int i = start ; i<end ; i++){
     
         list.add(i);
     }
     return new MyIntStreamImpl(list);
    }
    public static MyIntStream rangeClosed(int start , int end){
   
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = start; i<=end ; i++){
        
            list.add(i);
        
        }

        return new MyIntStreamImpl(list);
    
    }




}
