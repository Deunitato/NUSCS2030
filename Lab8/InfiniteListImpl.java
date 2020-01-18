package cs2030.mystream;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.ArrayList;
public abstract class InfiniteListImpl<T> implements InfiniteList<T>{
	
	protected abstract Optional<T> get();

    public <R> InfiniteList<R> map(Function<T,R> mapper){
		
        return new InfiniteListImpl<R>(){
            protected Optional<R> get(){
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    
    }




    public InfiniteList <T> limit(long maxSize){
   
       return new InfiniteListImpl<T>(){
       
           long fin = maxSize;
           protected Optional<T> get(){
           if(fin==0){
           
               return Optional.empty();
           }
           else{
           
               fin = fin-1;
               return InfiniteListImpl.this.get();
           
              }
           }
       };

   }

   public InfiniteList<T> filter(Predicate<T> predicate){
   
   
       return new InfiniteListImpl<T>(){
       
       
           protected Optional<T> get(){
          Optional<T> curr;
               while(true){
				   curr  =  InfiniteListImpl.this.get();

				   if(!curr.isPresent()){
						return Optional.empty();
				   }
				   else if(predicate.test(curr.get())){
						return curr;
				   }


               }
           }
       
       };
   
   
   
   }

   public InfiniteList<T> takeWhile(Predicate<T> predicate){
   
       return new InfiniteListImpl<T>(){
			boolean continuetaking = true;
           protected Optional<T> get(){
           
             
			   if(continuetaking){
				    Optional<T> curr= InfiniteListImpl.this.get();
				   if(!curr.isPresent()){
					   return Optional.empty();
				   }
				   else{
						if(predicate.test(curr.get())){
							return curr;
						}
						else{
							continuetaking = false;
							return Optional.empty();
						}
				   }
		   
			   }
			   else{
				   return Optional.empty();
			   }
               
              }
            };
   
   }




   public long count(){
   
       long count = 0;
       Optional <T> curr = InfiniteListImpl.this.get();
       while(curr.isPresent()){
           
           count ++;
       
           curr = InfiniteListImpl.this.get();
       }
       return count;
   
   
   
   }

   public void forEach(Consumer<T> action){
   
       Optional<T> curr = get();
       while(curr.isPresent()){
       
           action.accept(curr.get());
           curr = get();

       
       }
   
   
   
   }
   
   public Optional<T> reduce(BiFunction<T,T,T> accumulator){
	 //  System.out.println("char");
	   boolean first = true;
	   Optional <T> curr = get();
	   T result = null;
	   if(!curr.isPresent()){
		   return Optional.empty();
	   }
	   else{
		   while(curr.isPresent()){
			   if(first){
				result = curr.get();
				curr = InfiniteListImpl.this.get();
			   first = false;
			   }
			   else{
				 result = accumulator.apply(result,curr.get());
				curr = InfiniteListImpl.this.get();
				   
			   }
			   
			   
			 }
	   }
	   
	   return Optional.of(result);
	   
	   
   }
   
   public T reduce(T identity, BiFunction<T,T,T> accumulator){
	   T result = identity;
	   Optional<T> curr = InfiniteListImpl.this.get();
	  
	   while(curr.isPresent()){
		   result = accumulator.apply(result,curr.get());
		    curr = InfiniteListImpl.this.get();
	   }
	   
	   return result;
	   
   }
   
   public Object[] toArray(){
	   ArrayList<T> list = new ArrayList<>();
	   Optional<T> curr = InfiniteListImpl.this.get();
	  
	   while(curr.isPresent()){
		   list.add(curr.get());
		   curr = InfiniteListImpl.this.get();
	   }
	   
	   return list.toArray();
	   
	   
   }
   
   
































}
