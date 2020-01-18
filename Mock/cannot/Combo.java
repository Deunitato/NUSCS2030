import java.util.PriorityQueue;
import java.util.ArrayList;

public class Combo extends Menuitem{
    private PriorityQueue<Menuitem> pq = new PriorityQueue<Menuitem>();
	private ArrayList<Menuitem> list = new ArrayList<>();
    private int id; 
   
   Combo(int id){
    super(id);
	
    }

    public void addItem(Menuitem i){
		//System.out.println(i.getCost());
        pq.add(i);
        super.addCost(i.getCost());
    }

    public Menuitem getItem(){
    
    return pq.poll();
    }

	public void store(){
		for(Menuitem m: this.pq){
			list.add(m);
		}
		
	}
	
	
    
/*
	@Override 
	public int compareTo(Menuitem i){
		if(super.getType().equals("combo")){
			return 1;
		}
		else if (i.getType().equals("Combo")){
			return 1;
		}
		else{
			return Integer.compare(this.id,i.getID());
		}
		
	}*/
	
	
    @Override 
    public String toString(){
	
        String s = "#"+ super.getID() + " Combo (" + (super.getCost()-50) +")\n";
        for(int i=0;i<list.size();i++){
        s = s+ "   "+ list.get(i) +"\n";
        }
    
    return s;
    }





}
