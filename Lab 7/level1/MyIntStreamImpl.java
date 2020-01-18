import java.util.ArrayList;
import java.util.List;
public class MyIntStreamImpl implements MyIntStream{

    private ArrayList<Integer> list;

    MyIntStreamImpl(ArrayList<Integer> l){
    
        this.list = l;
    }

    @Override 
    public String toString(){
    
    
    String s = "[";

    for(int k = 0 ; k<list.size() ; k ++){
    
        if(k==0){
         s = s + list.get(k);
        }
        else{
         s = s + ", " + list.get(k);
        }
    }
    s = s+"]";

    return s;
    
  }
    







}
