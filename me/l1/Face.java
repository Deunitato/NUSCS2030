public class Face{
	
	private final String gridstring;

    //private final int [][] grid = new int[3][3];
    //Face(){}

    Face(int[][] grid){
		
		String o = "";
		for(int row = 0; row<3 ; row++){
			
			for(int col = 0 ; col <3; col++){
				o =o + grid[row][col]+".";
				//System.out.println(o);
				//this.grid[row][col] = o;
			}
			
		}
		this.gridstring = o;
		

    
    }

    public Face rotateRight(){
    
        int row =0;
        int co = 2;
        int[][] newface = new int[3][3];
        for(int[] col :this.getGrid()){
        
            for(int num : col){
            
                newface[row][co] = num;
            
                row++;
            
            }

            row =0;
            co--;
        }

        return new Face(newface);
    }
    public Face  rotateLeft(){
    
        return this.rotateRight().rotateRight().rotateRight();
    
    
    
    }




    
    public Face  rotateHalf(){
    
        return this.rotateRight().rotateRight();
    
    }
	
	
    public int[][] getGrid(){
		
		int grid[][] = new int[3][3];
		String[] parts = this.gridstring.split("\\.");
		int i =0;
        for(int row = 0; row<3 ; row++){
			
			for(int col = 0 ; col <3; col++){
				grid[row][col] = Integer.parseInt(parts[i]) ;
				//this.grid[row][col] = o;
				i++;
			}
			
		}
		return grid;
    
    }

    public String toString(){
    
    
    String s = "";

    for(int[] col : this.getGrid()){
    
        for (int num : col){
        
            s= s+ String.format("%02d",num);
        
        }
        s = s+"\n";
    
    
    }


    return s;
    
    }
    



}
