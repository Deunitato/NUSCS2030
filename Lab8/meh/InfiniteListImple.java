import java.util.Optional;
import java.util.function.Function;
public abstract class InfiniteListImple<T> implements InfiniteList<T>{

	public  <R> InfiniteList <R> map(Function<T, R> mapper){
		return new InfiniteListImple<R>(){
			
			public Optional<R> get(){
			
				return InfiniteListImple.this.get().map(mapper);
				
			} 
			
		};
		
		
		
	}
	


}