
public class Face{

    int [][] grid;
    Face(){}

    Face(int[][] grid){
    
        this.grid = grid;

    
    }

    public Face rotateRight(){
    
        int row =0;
        int co = 2;
        int[][] newface = new int[3][3];
        for(int[] col :grid){
        
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
    
        return this.grid;
    
    }

    public String toString(){
    
    
    String s = "";

    for(int[] col : grid){
    
        for (int num : col){
        
            s= s+ String.format("%02d",num);
        
        }
        s = s+"\n";
    
    
    }


    return s;
    
    }
    



}
