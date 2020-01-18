public class Cruise{

    String id;
    int time;
    
    public Cruise(String id, int time) throws IllegalTimeException {
        if(time>2359){
        throw new IllegalTimeException("Time must be below 2359!");
        }
        else{
        this.id = id;
        this.time = time;
            }
        

    }

    @Override
    public String toString() {
        return String.format("%s@%04d", this.id, this.time);
    }

   }
