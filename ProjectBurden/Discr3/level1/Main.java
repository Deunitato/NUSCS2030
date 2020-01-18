import java.util.Scanner;
public class Main{

    public static void main(String[] args) {

       EventSimulator es = new EventSimulator(); 
        Scanner sc = new Scanner(System.in);
		
		int numberOfServers = sc.nextInt();
		
		for(int i =0; i<numberOfServers ; i++){
			
			es.addServer(new Server(i+1));
			
			
		}
		
		
        while(sc.hasNext()){
        
            double time = sc.nextDouble();
            es.addArrivals(new Arrival(time));
        }
       // es.tryEvent();
        es.printAll();
    }


}
