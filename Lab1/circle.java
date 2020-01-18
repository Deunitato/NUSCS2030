class Circle{
	private Point center;
	
	
	
	public Circle(){	
		
	}
	
	
	public Circle(Point center){
		
		this.center = center;
		
	}
	
	public void setCenter(Point c){
		center = c;
	}
	
	
	public Point getCenter(Point x, Point y){
		Point midpt = x.midPoint(y);
		double mq = x.getDistance(y)/2; //from m to q
		double a = x.angleTo(y)+Math.PI/2; //give me direction
		//unit circle is 1, pq is 1
		double mc = Math.sqrt(1-mq*mq);//use pytheroem
		return midpt.getMovemidpt(a,mc);
		
		
	}
	public boolean isInside(Point x){
		return center.getDistance(x) <=1;
		
	}
	
	
}