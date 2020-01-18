import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
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

    public MyIntStream limit(int maxSize){
    
        

        if(maxSize > list.size()){
        
            return new MyIntStreamImpl(this.list);
        
        }
		ArrayList<Integer> newlist = new ArrayList<>();
        for(int i = 0; i<maxSize; i ++){
        
            newlist.add(list.get(i));
        
        
        }

        return new MyIntStreamImpl(newlist);
    
    
    }

    public MyIntStream distinct(){
    
        ArrayList<Integer> mylist = new ArrayList<>();
        HashSet<Integer> hashing = new HashSet<Integer>();
        for(int i :list){
            if(!hashing.contains(i)){
                mylist.add(i);
                hashing.add(i);
            
            }    
        
        }
    
    return new MyIntStreamImpl(mylist);
    }



    public void forEach(IntConsumer action){
        for(int i : list){
            action.accept(i);
        }
    }

	public MyIntStream filter(IntPredicate predicate){

		ArrayList<Integer> myList = new ArrayList <> ();
		for(int num : list){
			if(predicate.test(num)){
				myList.add(num);
			}
		}
		
		return new MyIntStreamImpl(myList);
		
		
	}
	
	public MyIntStream map(IntUnaryOperator mapper){
		
		ArrayList<Integer> myList = new ArrayList <> ();
		for(int num: list){
			myList.add(mapper.applyAsInt(num));
		}
		
		return new MyIntStreamImpl(myList);
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
