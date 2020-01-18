public abstract class SalaryAdjust{

    private double raise;
    SalaryAdjust(){}
    SalaryAdjust(double raise){
    this.raise = raise;
    
    }
    public abstract void adjust();

    public double getRaise(){
    
        return this.raise;
    
    }
    public void setRaise(double raise){
    this.raise = raise;
    
    }


}
