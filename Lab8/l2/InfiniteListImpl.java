import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
public abstract class InfiniteListImpl<T> implements InfiniteList<T>{

	public String toString(){
		return "fdsfd";
	}

    public <R> InfiniteList<R> map(Function<T,R> mapper){
    
        return new InfiniteListImpl<R>(){
            public Optional<R> get(){
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    
    }




    public InfiniteList <T> limit(int maxSize){
   
       return new InfiniteListImpl<T>(){
       
           int fin = maxSize;
           public Optional<T> get(){
           if(fin<=0){
           
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
       
       
           public Optional<T> get(){
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
           public Optional<T> get(){
           
             
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
   
   




































}
