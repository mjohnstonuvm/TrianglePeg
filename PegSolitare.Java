//(Richard, Sam, and Colin)

import java.io.*;
import java.util.*;

//Colin Luther, Richard Lynch, Matt Johnston, Samuel Lynch
//CS 205: Software Development
//Warm-up Project

/*
   Peg Solitaire allows users to play peg solitaire in the command line with 
   either a cross or triangle shaped board.
*/

//Main class
public class PegSolitare {
      
   //Main function welcomes the player, gets the name, asks which game the user wants to play.
   public static void main(String [] args) {
   
      //Variable Declaration.
      String userName;
      boolean gameType;
      TrianglePegArray triangle = new TrianglePegArray();
      Board board = new Board();
      int pegCount;
                  
      //Welcomes the player.
      userName = getUserName();
      System.out.println("Welcome to Peg Solitaire, " + userName + "!\n"); 
         
      //Gets game type. (true = Triangle; false = Cross)
      gameType = getGameType(); 
      
      //Initializes starting peg count based on board layout.
      if(gameType){
         pegCount = 15;
      }
      else{
         pegCount = 33;
      }
      
      //Removes peg from single hole on board based on board layout.
      triangle.Triangle[2][1].setPeg(false);
      board.Board[4][4].setPeg(false);
      //Initially print instructions to command line based on board layout.
      printInstructions(gameType);
      
      //Continue playing turns of the game until pegCount equals 1.
      while(pegCount > 1){
         pegCount = turn(pegCount, gameType, triangle, board);
      }
      
      /*
         If the while loop above is exited, it means that there is one peg left,
         and the user has beaten the game.
      */
      System.out.println("Congratulations, you have beaten peg solitaire!");
                  
   }//main
         
   //This function gets the user name
   public static String getUserName(){
      String inputString;
      System.out.println("Please enter your name:");
      Scanner scan = new Scanner(System.in);
      inputString = scan.nextLine();         
      return inputString;
   }//getUserName
      
   //This function gets the user's first action whether it be triangle board, cross
   public static boolean getGameType() {
      int gameType = getInt();          
      if (gameType == 1){
         return true;
      }
      else { 
         return false;
      }  
        
   }//getGameType 
   
   /*
      This function makes sure the user enters a valid integer.
   */
   public static int getInt(){
      int inputInt = 0;
      Scanner scan = new Scanner(System.in);    
      System.out.println("Which board layout would you like to play? (1)Triangle or (2)Cross");
      if(scan.hasNextInt()){
         inputInt = scan.nextInt();
         if(inputInt != 1 && inputInt != 2){
            System.out.println("Please enter either a (1) or (2).\n");
            inputInt = getInt();
         }
      }   
      else{
         System.out.println("Please enter an interger.\n");
         inputInt = getInt();
      } 
      return inputInt;           
   }
   
   /*
      This function computes and returns all valid moves for a given node
      in the form of a 2d Node array. The first collumn of the array is
      the node being jumped and the second is the node being jumped to.
   */
   public static Node[][] getMoves(Node node){
      String[] directions = new String[]{"n","ne","e","se","s","sw","w","nw"};
      Node[][] jumps = new Node[8][2];
      for(int i = 0; i < directions.length; i++){
         if(node.getNeighbor(directions[i]) != null && node.getNeighbor(directions[i]).getPeg()){
            if(node.getNeighbor(directions[i]).getNeighbor(directions[i]) != null && !node.getNeighbor(directions[i]).getNeighbor(directions[i]).getPeg()){
               jumps[i][0] = node.getNeighbor(directions[i]);
               jumps[i][1] = node.getNeighbor(directions[i]).getNeighbor(directions[i]);            
            }  
         }
      }
      return jumps;
   }
   
   /*Call this with your TrianglePegArray as an argument to print out a key and a representation of
    *which holes are and aren't filled
    */
   
   public static void displayTriangle(TrianglePegArray Triangle) {
		
		System.out.println("Key:");
		
		int ct = 1;	//counter for position in key triangle
		
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
			
		System.out.println("Board:");	//if we want a title for the non-key triangle, print it here
		
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
   
	/*Call this with your Board as an argument to print out a key and a representation of
    *which holes are and aren't filled
    */
	public static void displayCross(Board Cross) {
	
	 	System.out.println("Key:");
		
		int ctCross = 0; //counter for position in key cross
		
		for (int i=1; i<8; i++) {

			if (i<3||i>5) {
				System.out.print("          ");
				for (int j=3; j<6; j++) {
					System.out.print(ctCross+"   ");
					if (ctCross<10) {
						System.out.print(" "); //2-digit positions don't need this extra space
					}
					ctCross++;
				}
			}
			
			else {
				for (int k=1; k<8; k++) {
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
					if (Cross.Board[i][j].getPeg()) {	//I had this as [i][j] but then say you did i=col j=row, switched mine for now
						System.out.print("x");	//if the node has a peg
					}
					else{
						System.out.print("o");	//if the node has no peg
					}
					System.out.print("    ");
				}
			}
			else {
				for (int k=1; k<8; k++) {
					if (Cross.Board[i][k].getPeg()) {	//I had this as [i][k] but then say you did i=col j=row, switched mine for now
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
   
   /*
      printInstructions prints a set of instructions based on which gameType has
      been chosen.
   */
   public static void printInstructions(boolean gameType){
      if(gameType == true){
         System.out.println("**********************************Instructions*************************************");
         System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board.");
         System.out.println("You can jump in any direction parallel to the edges of the board.");
         System.out.println("The goal of the game is to finish with one peg left on the board.");
         System.out.println("***********************************************************************************\n");
      }
      else{
         System.out.println("**********************************Instructions*************************************");
         System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board.");
         System.out.println("You can jump vertically and horizontally, but not diagonally.");
         System.out.println("The goal of the game is to finish with only one peg on the board.");
         System.out.println("***********************************************************************************\n");
      }
   }
   
   /*
      turn is all the functionality that occurs each turn of the game. The user may enters
      the label of the peg they wish to move. Then they may enter either 'h' for a helpful
      printout of the instructions, 'r' to reset the game board, or another letter to make a
      move choice.
   */
   public static int turn(int pegCount, boolean gameType, TrianglePegArray triangle, Board board){
      //Variable Declarations
      Node[][] jumps;
      int nodeRow = -1;
      int nodeCollumn = -1;
      int nodeLabel = -1;
      Scanner scan = new Scanner(System.in);
      String choiceKeys[] = {"A","B","C","D"};
      int choiceCounter = 0;
      String moveChoice;
      Node[][] moves = new Node[4][2];
      
      //Display peg-value and peg-label representations of board.
      if(gameType){
         displayTriangle(triangle);
         System.out.println("Please choose a peg number to move. (e.g. between 1 and 15)\n");
      }
      else{
         displayCross(board);
         System.out.println("Please choose a peg number to move. (e.g. between 0 and 32)\n");
      }
      
      //Get startNode label from user and find coordinates of node with corresponding label.
      if(scan.hasNextInt()){
         nodeLabel = scan.nextInt();
      }
      else{
         System.out.print("Please input an integer.\n");
         return pegCount;
      }
      if(gameType){
         for(int i = 0; i < triangle.Triangle.length; i++){
            for(int j = 0; j < (i+1); j++){
               if(triangle.Triangle[i][j] != null && triangle.Triangle[i][j].getLabel() == nodeLabel){
                  nodeRow = i;
                  nodeCollumn = j;
               }
            }
         }
      }
      else{
         for(int i = 0; i < board.Board.length; i++){
            for(int j = 0; j < board.Board[0].length; j++){
               if(board.Board[i][j] != null && board.Board[i][j].getLabel() == nodeLabel){
                  nodeRow = i;
                  nodeCollumn = j;
               }
            }
         }
      }
      
      /*
         Compute possible moves if node was found with label.
      */
      if(nodeRow == -1){
         System.out.println("That label wasn't found on the board. \n");
         return pegCount;
      }
      else{
         if(gameType){
            jumps = getMoves(triangle.Triangle[nodeRow][nodeCollumn]);
         }
         else{
            jumps = getMoves(board.Board[nodeRow][nodeCollumn]);
         }
      }  
            
      /*
         Display all possible moves to user.
      */
      boolean noMoves = true;
      for(int i = 0; i < jumps.length; i++){
         if(jumps[i][0] != null){
            noMoves = false;
            moves[choiceCounter][0] = jumps[i][0];
            moves[choiceCounter][1] = jumps[i][1];
            System.out.println("Enter '" + choiceKeys[choiceCounter] + "' to jump over peg " + jumps[i][0] + " into empty hole " + jumps[i][1] + "!\n");       
            choiceCounter++;
         }
      }
      if(noMoves){
         System.out.println("There are no moves available to that peg. Sorry!\n");
         //reset code
      }
      
      /*
         Prompt user for a choice input.
      */
      System.out.println("Please enter a letter for the move you wish to execute.");
      System.out.println("You may also press 'h' for help or 'r' to reset the board.\n");
      moveChoice = scan.next();
      
      /*
         Execute move based on user input.
      */
      switch(moveChoice.toLowerCase()){
         case "h":
            printInstructions(gameType);
            break;
         case "a":
            if(choiceCounter > 0){
               moves[0][0].setPeg(false);
               moves[0][1].setPeg(true);
               if(gameType){
                  triangle.Triangle[nodeRow][nodeCollumn].setPeg(false);
               }
               else{
                  board.Board[nodeRow][nodeCollumn].setPeg(false);
                   
               }
               pegCount++;
            }
            break;
         case "b":
            if(choiceCounter > 1){
               moves[1][0].setPeg(false);
               moves[1][1].setPeg(true);
               if(gameType){
                  triangle.Triangle[nodeRow][nodeCollumn].setPeg(false);
               }
               else{
                  board.Board[nodeRow][nodeCollumn].setPeg(false);
               }
               pegCount++;
            }
            break;
         case "c":
            if(choiceCounter > 2){
               moves[2][0].setPeg(false);
               moves[2][1].setPeg(true);
               if(gameType){
                  triangle.Triangle[nodeRow][nodeCollumn].setPeg(false);
               }
               else{
                  board.Board[nodeRow][nodeCollumn].setPeg(false);
               }
               pegCount++;
            }
            break;
         case "d":
            if(choiceCounter > 3){
               moves[3][0].setPeg(false);
               moves[3][1].setPeg(true);
               if(gameType){
                  triangle.Triangle[nodeRow][nodeCollumn].setPeg(false);
               }
               else{
                  board.Board[nodeRow][nodeCollumn].setPeg(false);
               }
               pegCount++;
            }
            break;    
         default:
            System.out.println("That wasn't an option.\n");
            break;
      }      
      return pegCount;
   }
    
}//class
