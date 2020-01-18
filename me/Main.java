import java.util.Scanner;
public class Main{

    public static void main(String[] args) { 
	int[][][] grid = new int[6][3][3];
		Scanner sc = new Scanner(System.in);
		
		for (int k = 0; k < 6; k++){
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < 3; j++){
					grid[k][i][j] = sc.nextInt();
				}
			}
		}
		Rubik cube = new Rubik(grid);
		
		//take in commands
		while(sc.hasNext()){
			
			cube = cube.commands(sc.next());
			//nextline = sc.next();
		}
		
		System.out.println(cube);
		
		
        


    }

}
