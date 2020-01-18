import java.util.Optional;
public class Burger  {
	private final String bun;
	private final Optional<String> patty;
	private final Optional<String> vege;
	
	private Burger(String bun, Optional<String> patty , Optional<String> vege){
		this.bun = bun;
		this.patty = patty;
		this.vege = vege;
	}
	
	public static Burger create(String bun){
		
		return new Burger(bun,Optional.empty(),Optional.empty());
	}
	
	public Burger patty (String patty){
		return new Burger(this.bun,Optional.of(patty),this.vege);
	}
	
	public Burger vegetable (String vege){
		return new Burger(this.bun,this.patty,Optional.of(vege));
	}
	
	public String toString(){
		
		return this.patty.orElse("no patty") + ", " + this.vege.orElse("no Vege") + " on a  " + this.bun +" bun";
	}



}