//(Sam)
public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		TrianglePegArray triangle = new TrianglePegArray();

		displayCross(board);
		displayTriangle(triangle);

	}
	
	public static void displayTriangle(TrianglePegArray Triangle) {
		
		System.out.println("Key:");
		
		int ct = 0;	//counter for position in key triangle
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<((12-3*i)); j++) {	//puts appropriate spaces before each line
				System.out.print(" ");
			}
			
			for (int k=0; k<(i+1); k++) {
				System.out.print(ct);	//print hole position
				System.out.print("    ");
				if (ct<10) {
					System.out.print(" ");	//2-digit positions don't need this extra space
				}
				ct++;
			}
			System.out.print("\n\n");
			
		}
			
		System.out.println("Board");	//if we want a title for the non-key triangle, print it here
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<((12-3*i)); j++) {	//puts appropriate spaces before each line
				System.out.print(" ");
			}
			
			for (int k=0; k<(i+1); k++) {
				if (Triangle.Triangle[i][k].getPeg()) {
					System.out.print("x");	//if the node has a peg
				}
				else {
					System.out.print("o");	//if the node has no peg
				}	
				System.out.print("     ");	
			}
			System.out.print("\n\n");
			
		}			
	}
	
	public static void displayCross(Board Cross) {
	
	 	System.out.println("Key:");
		
		int ctCross = 0; //counter for position in key cross
		
		for (int i=0; i<7; i++) {

			if (i<2||i>4) {
				System.out.print("          ");
				for (int j=0; j<3; j++) {
					System.out.print(ctCross+"   ");
					if (ctCross<10) {
						System.out.print(" "); //2-digit positions don't need this extra space
					}
					ctCross++;
				}
			}
			
			else {
				for (int k=0; k<7; k++) {
					System.out.print(ctCross+"   ");
					if (ctCross<10) {
						System.out.print(" "); //2-digit positions don't need this extra space
					}
					ctCross++;
				}
				
			}
			System.out.print("\n\n");
			
		}
		
		System.out.println("Board:");
		
		for (int i=1; i<8; i++) {
			if (i<3||i>5) {
				System.out.print("          ");
				for (int j=3; j<6; j++) {
					if (Cross.Board[j][i].getPeg()) {	//I had this as [i][j] but then say you did i=col j=row, switched mine for now
						System.out.print("x");	//if the node has a peg
					}
					else {
						System.out.print("o");	//if the node has no peg
					}
					System.out.print("    ");
				}
			}
			else {
				for (int k=1; k<8; k++) {
					if (Cross.Board[k][i].getPeg()) {	//I had this as [i][k] but then say you did i=col j=row, switched mine for now
						System.out.print("x");	//if the node has a peg
					}
					else {
						System.out.print("o");	//if the node has no peg
					}
					System.out.print("    ");
				}
			}
			System.out.print("\n\n");
		}
	}

}