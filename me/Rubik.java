public class Rubik{

    int [][][] cube;
	
	
    Rubik(){}
    Rubik(int [][][] grid){
    
    
        this.cube = grid;

    
    }

    public Rubik viewRight(){
    
        int[][][] newcube = new int [6][3][3];

            int i =0;
          for(int face[][] : cube){

          
              if(i==0){
              newcube[i] = (new Face(face)).rotateRight().getGrid();

              }
              else if(i==1){
              
                  newcube[5]= (new Face(face)).rotateHalf().getGrid();

              
              }
              else if(i==2|| i ==3){
              
                  newcube[i-1] = (new Face(face)).getGrid();
              
              }
              else if( i == 4){
              
              
                  newcube[i] = (new Face(face)).rotateLeft().getGrid();
              
              }
              else if (i== 5){
              
                  newcube[3] =(new Face(face)).rotateHalf().getGrid();
              
              }

          
          
              i++;
          }

          return new Rubik(newcube);
    
    }


    public Rubik viewLeft(){

        return this.viewRight().viewRight().viewRight();
    }


    public Rubik viewUp(){
		int[][][] newcube = new int [6][3][3];

            int i =0;
          for(int face[][] : cube){

          
              if(i==0||i==2){
              newcube[i+2] = (new Face(face)).getGrid();

              }
              else if(i==1){
              
                  newcube[i]= (new Face(face)).rotateRight().getGrid();

              
              }
              else if( i == 3){
              
              
                  newcube[i] = (new Face(face)).rotateLeft().getGrid();
              
              }
			  else if( i == 4){
              
              
                  newcube[i+1] = (new Face(face)).getGrid();
              
              }
              else if (i== 5){
              
                  newcube[0] =(new Face(face)).getGrid();
              
              }

          
          
              i++;
          }

          return new Rubik(newcube);
    
	
	
    
    }


    public Rubik viewDown(){
    
    
    return this.viewUp().viewUp().viewUp();
    
    }

	
	
	//front
	public Rubik frontfaceLeft(){
		
		int[][][] newcube = new int [6][3][3];
		
            int i =0;
			for(int face[][] : cube){
				
				
				int temp[][] = new int[3][3];
				for(int l=0; l<3; l++){
					for(int k=0; k<3; k++){
						temp[l][k]=face[l][k];
					}
				}
				

				
          
              if(i==0){
				 temp[2][0] = this.cube[3][0][0];
				 temp[2][1] = this.cube[3][1][0];
				 temp[2][2] = this.cube[3][2][0];
			      
              newcube[i] = (new Face(temp)).getGrid();

              }
              else if(i==1){
				  //start building new face
				  temp[0][2] = this.cube[0][2][2];
				  temp[1][2] = this.cube[0][2][1];
				  temp[2][2] = this.cube[0][2][0];
				  
				  
				  
              
                  newcube[i]= (new Face(temp)).getGrid();

              
              }
			  else if(i==2){
              
                  newcube[i]= (new Face(face)).rotateLeft().getGrid();

              
              }
              else if( i == 3){
				  
				  temp[0][0] = this.cube[4][0][2];
				  temp[1][0] = this.cube[4][0][1];
				  temp[2][0] = this.cube[4][0][0];
              
              
                  newcube[i] = (new Face(temp)).getGrid();
              
              }
			  else if( i == 4){
				 temp[0][0] = this.cube[1][0][2];
				 temp[0][1] = this.cube[1][1][2];
				 temp[0][2] = this.cube[1][2][2];
			      
              
                  newcube[i] = (new Face(temp)).getGrid();
              
              }
              else if (i== 5){
              
                  newcube[i] =(new Face(face)).getGrid();
              
              }

          
          
              i++;
          }

          return new Rubik(newcube);
		
	}
	
	public Rubik frontfaceRight(){
		return this.frontfaceLeft().frontfaceLeft().frontfaceLeft();
	}
	
	public Rubik frontfaceHalf(){
		return this.frontfaceLeft().frontfaceLeft();
	}
	
	
	//right
	
	public Rubik rightfaceRight(){
		return this.viewRight().frontfaceRight().viewLeft();
		
	}
	public Rubik rightfaceLeft(){
		return this.viewRight().frontfaceLeft().viewLeft();
	}
	public Rubik rightfaceHalf(){
		return this.viewRight().frontfaceHalf().viewLeft();
	}
	
	//left
	public Rubik leftfaceRight(){
		return this.viewLeft().frontfaceRight().viewRight();
	}
	public Rubik leftfaceLeft(){
		return this.viewLeft().frontfaceLeft().viewRight();
	}
	public Rubik leftfaceHalf(){
		return this.viewLeft().frontfaceHalf().viewRight();
	}
	
	//up
	public Rubik upfaceRight(){
		return this.viewUp().frontfaceRight().viewDown();
	}
	public Rubik upfaceLeft(){
		return this.viewUp().frontfaceLeft().viewDown();
	}
	public Rubik upfaceHalf(){
		return this.viewUp().frontfaceHalf().viewDown();
	}
	
	//down
	public Rubik downfaceRight(){
		return this.viewDown().frontfaceRight().viewUp();
	}
	public Rubik downfaceLeft(){
		return this.viewDown().frontfaceLeft().viewUp();
	}
	public Rubik downfaceHalf(){
		return this.viewDown().frontfaceHalf().viewUp();
	}
	
	
	//extra
	
	public Rubik viewBack(){
		return this.viewUp().viewUp();
	}
	
	//back
	public Rubik backfaceRight(){
		return this.viewBack().frontfaceRight().viewBack();
	}
	public Rubik backfaceLeft(){
		return this.viewBack().frontfaceLeft().viewBack();
	}
	public Rubik backfaceHalf(){
		return this.viewBack().frontfaceHalf().viewBack();
	}
	
	public Rubik commands(String s){
		
		 switch(s) 
        { 
            case "F": 
                return this.frontfaceRight();
                 
            case "R": 
                return this.rightfaceRight();
                 
            case "U": 
                return this.upfaceRight();
                
			case "D": 
                return this.downfaceRight();
                
			case "L": 
                return this.leftfaceRight(); 
               
            case "B": 
                return this.backfaceRight();
                 
            case "F'": 
                return this.frontfaceLeft();
              
			case "R'": 
                return this.rightfaceLeft(); 
               
			case "U'": 
                return this.upfaceLeft();
                
			case "D'": 
                return this.downfaceLeft();
             
			case "L'": 
                return this.leftfaceLeft();
            
            case "B'": 
               return this.backfaceLeft();
            
			case "F2": 
                return this.frontfaceHalf();
              
            case "R2": 
                return this.rightfaceHalf();
             
            case "U2": 
                return this.upfaceHalf();
            
			case "D2": 
                return this.downfaceHalf();
               
			case "L2": 
                return this.leftfaceHalf();
              
            case "B2": 
                return this.backfaceHalf();
              
            default: 
                System.out.println("no match"); 
				return this;
				
        } 
		
		
		
	}
	
	
	
	
	

	 @Override
    public String toString(){
		
	String s = "";
	int faces=1;
	//print the face one at a time
	
	//do first face first
	
	//do special face
	//face = 1;
	
	
	
	
     for(int i = 0 ; i < 6 ; i++){
		 
		 if(faces == 1 || faces ==5 ||faces==6){
			 
			 for(int row =0;row <3 ; row++){
				  s=s+"......";
				 for(int col =0 ; col<3 ; col++){
				   s=s+ String.format("%02d",cube[i][row][col]);
				 }
				 
				  s=s+"......\n";
				 
			}
			faces++;
		 }
		 else{
			 
			for(int row = 0 ; row<3 ; row ++){
	
				for(int face = 1; face<4 ; face++){
					for(int col =0 ;col <3 ; col++){
			
					s=s+ String.format("%02d",cube[face][row][col]);
			
			
					}
				}
				s=s+"\n";
		
			} 
			 
			i = i +2;
			faces= faces+3; 
		 }
		 
		
	 
	 
	 }
		
	 
	 return s;

    }


}
