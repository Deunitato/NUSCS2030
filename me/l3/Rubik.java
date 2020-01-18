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

/*
    @Override
    public String toString(){
		
	String s = "";
	int i=1;
	//print the face one at a time
     for(int[][] face : cube){
		for(int[]col : face){
			
			if(i==1||i==5||i==6){
			
				s= s+"......";
			 for (int num : col){ //prints out rows of nums
				s=s+ String.format("%02d",num);
			 }
			 
			 s=s+"......";
			
			}
			else{
			    for (int num : col){ //prints out rows of nums
			    s=s+ String.format("%02d",num);
			   }
			}
			s = s+"\n";
		}
		i++;
	 }
	 
	 return s;

    }
*/
	
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
