import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Optional;
public interface InfiniteList<T>{
	
	
	public static <T> InfiniteList <T> generate(Supplier <T> supplier){
		return new InfiniteListImple<T> () {
			public Optional<T> get(){
				return Optional.of(supplier.get());
			}
			
		};
	}
	
	public static <T> InfiniteList <T> iterate(T seed , Function <T,T> next){
		
		return new InfiniteListImple<T> () {
			
			T element  = seed;
			Function<T,T> fun = x->{
				fun = next;
				return element; 
				
			};
			
			public Optional<T> get(){
				element = fun.apply(element);
				return Optional.of(element);
				
			}
			
			
		};
		
		
	}
	
	public Optional<T> get();
	public <R>InfiniteList<R> map(Function<T, R> mapper);
//	InfiniteList<T> limit(int maxSize);
	//InfiniteList<T> filter(Predicate<T> predicate);
	//InfiniteList<T> takeWhile(Predicate<T> predicate);


}