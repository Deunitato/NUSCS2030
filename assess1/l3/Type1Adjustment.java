public class Type1Adjustment extends SalaryAdjust{


    Type1Adjustment(){}
    Type1Adjustment(double salary){
    super(salary);
    
    
    }

    @Override
    public void adjust(){
    double raise = super.getRaise();
    if(raise<0){
    super.setRaise(0);
    
    }
    else if(raise>10){
    super.setRaise(10);
    
    }
    else{
    //do nothing
    }
    
    }


}
