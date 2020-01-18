package cs2030.mystream;
import java.util.function.Supplier;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.function.Consumer;
public interface InfiniteList<T>{

    public static <T>InfiniteList<T> generate (Supplier <T> supplier){
    
        return new InfiniteListImpl<T>(){
        
             protected Optional< T> get(){
            
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

            protected Optional<T> get(){
            
                ele = fun.apply(ele);
                return Optional.of(ele);
            
            }

        
        
        };
    
    
    }

    public <R> InfiniteList <R> map(Function<T,R> mapper);
    public  InfiniteList <T> limit(long maxSize);
    public  InfiniteList <T> filter(Predicate<T> predicate);
    public  InfiniteList<T> takeWhile(Predicate<T> predicate);
    public long count();
    public void forEach(Consumer<T> action);
	public Optional<T> reduce(BiFunction<T,T,T> accumulator);
    public T reduce(T identity, BiFunction<T,T,T> accumulator);
	public Object[] toArray();

}
