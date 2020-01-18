import java.util.ArrayList;
import java.util.function.IntConsumer;
import java.util.OptionalInt;
import java.util.List;
import java.util.OptionalDouble;
public class MyIntStreamImpl implements MyIntStream{

    private ArrayList<Integer> list;

    MyIntStreamImpl(ArrayList<Integer> l){
    
        this.list = l;
    }


   // @Override
    public long count(){
    
        long i =0;
        for(int num : list){
        
            i++;
        
        }

        return i;
    
    
    }

   // @Override
    public OptionalDouble average(){
    
        if(list.size()==0){
        return OptionalDouble.empty();
        }
        else{
        
            return OptionalDouble.of(this.sum()/list.size());
        }
    
    }
   // @Override 
    public int sum(){
    
        int sum=0;
        for(int num :list){
        
            sum = sum + num;
        
        }

        return sum;
    }


    public OptionalInt min(){
    
        if(list.size() == 0) {
        
            return OptionalInt.empty();
        
        }
        else{
         int smallest = list.get(0);
         for(int small : list){
         
             if(small<smallest){
             smallest = small;
             }
         }
        return OptionalInt.of(smallest);
        
        }

    
    }

    public OptionalInt max(){
    

        if(list.size() == 0){
        
            return OptionalInt.empty();
        
        }
        else{
        
            int biggest = list.get(0);
            for(int big : list){
            
                if(big> biggest){
                
                    biggest = big;
                
                }

            
            }
        
            return OptionalInt.of(biggest);
        }

    }


    public void forEach(IntConsumer action){
    
        for(int i : list){
       
            action.accept(i);
        
        }

    

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
