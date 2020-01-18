import java.util.ArrayList;
public  class Bank{


    private double monthlyrate;
    private String name;
    public static  Bank[]  BANKS;
    Bank(){};
    Bank(String name ,double d ){
    
        this.name =name;
        this.monthlyrate = d/12;
    
    }

    public double getRate(){
    
    return this.monthlyrate;
    }

    public String getName(){
    
        return this.name;
    
    }

    public static Bank getBankByName(String s){
    
        for(Bank b: BANKS){
        
            if(s.equals(b.getName())){
            
                return b;
            }
        
        }
            
        return new Bank();
    
    }

  

}
