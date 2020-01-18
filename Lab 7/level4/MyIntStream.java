import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.OptionalDouble;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.IntBinaryOperator;
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

    public int sum();
    public long count();
    public OptionalDouble average();

    public OptionalInt max();
    public OptionalInt min();

    public MyIntStream limit(int maxSize);
    public MyIntStream distinct(); 
	public MyIntStream filter(IntPredicate predicate);
	public MyIntStream map(IntUnaryOperator mapper);
    public void forEach(IntConsumer action);
	public int reduce(int identity, IntBinaryOperator op);
	public OptionalInt reduce(IntBinaryOperator op);

}
