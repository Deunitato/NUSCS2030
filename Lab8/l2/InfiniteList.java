import java.util.function.Supplier;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
public interface InfiniteList<T>{

	
    public static <T>InfiniteList<T> generate (Supplier <T> supplier){
    
        return new InfiniteListImpl<T>(){
        
            public Optional< T> get(){
            
                return Optional.of(supplier.get());
            }
        
        };
    
    
    }

    public static <T> InfiniteList <T> iterate (T seed, Function<T,T> next){
    
        return new InfiniteListImpl<T>(){
        
            T ele = seed;
            Function <T,T> fun = x-> {
            
                fun = next;
                return ele;
            };

            public Optional<T> get(){
            
                ele = fun.apply(ele);
                return Optional.of(ele);
            
            }

        
        
        };
    
    
    }

    public Optional<T> get();

    public <R> InfiniteList <R> map(Function<T,R> mapper);
    public  InfiniteList <T> limit(int maxSize);
    public  InfiniteList <T> filter(Predicate<T> predicate);
    public  InfiniteList<T> takeWhile(Predicate<T> predicate);

}
