import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Main{
    
    public static void main(String[] args) { 
       int j =0;
       Scanner sc = new Scanner(System.in);
       PriorityQueue<Menuitem> mi = new PriorityQueue<Menuitem>();
       ArrayList<Menuitem> buffer = new ArrayList<>();
       ArrayList<Integer> num = new ArrayList<>();
       ArrayList<Combo> c = new ArrayList<>();
       Object[] arr;
	   Menuitem m = new Menuitem() ;
       int cost=0;
       while(sc.next().equals("add")){
       
        String type = sc.next();
		
        if(type.equals("Combo")){
            int f = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();
			try{  
			Combo cp = new Combo(j);
            //for(int i=0;i<3;i++){
			
            Menuitem first = find(f,buffer);
            Menuitem second = find(s,buffer);
            Menuitem last = find(t,buffer);
			if(!first.getType().equals("Burger")||!second.getType().equals("Snack")||!last.getType().equals("Drink")){
				
				throw new Exception();
				
			}
	
            //c.add(cp);
			cp.addItem(first);
            cp.addItem(second);
            cp.addItem(last);
            cp.store();
            mi.add(cp);
			c.add(cp);
			}
			catch(NullPointerException e){
				System.out.println("Error: Invalid combo input "+ f +" "+s+" "+t);
				j--;
				e.printStackTrace();
			}
			catch (Exception e){
				System.out.println("Error: Invalid combo input "+ f +" "+s+" "+t);
				j--;
			}
			
            
        }
        else{
             String desc = sc.next();
             int price = sc.nextInt();
             m = new Menuitem(type,desc,price,j);
             mi.add(m);
             buffer.add(m);
			
        }

        j++;
       }
	   arr = mi.toArray();
	   //lesson one : poll the array to print the correct one or else its wrong
	   while(mi.size()!= 0){
        System.out.println(mi.poll());
       
       }
	   
       
       while(sc.hasNext()){
        num.add(sc.nextInt());
       }
	   
        System.out.println("--- Order ---");
          
		  

      for(int i : num){
		  
          for(int k=0;k<arr.length;k++){
			  Menuitem s = (Menuitem) arr[k];
          if(s.getID()==i){
            cost = cost+s.getCost(); 
             System.out.println(s);
             break;
            }
          
        }
		
		for(Combo co : c){
              if(i==co.getID())
			  {
				cost = co.getCost() +cost -50 ;
				System.out.print(co);
				break;
			
			   }
			}
      
      }

      System.out.println("Total: "+cost);
        



    }

    public static Menuitem find(int order,ArrayList<Menuitem> list){
		//System.out.println(order);
        for(Menuitem l : list){
			//System.out.println(l.getID());
            if(l.getID() == order){
            return l;
            }
        
        }
        return new Menuitem();    
    }


}
