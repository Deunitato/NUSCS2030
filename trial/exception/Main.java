class Main{


    public static void main(String[] args) throws Exception {
        try{
        
           // throw new Exception("heheh");

            test();
            System.out.println("weeeeeee");
        
        }
        catch(Exception e){
       
           // throw new Exception("seocn");
            System.out.println("its been caught"+ e);
        }
       // System.out.println("hue");
    }


   static void test() throws Exception{
    
        int i = 9/0;
    
    
    }
}
