//Richard Lynch
//CS205 Jump Start
//1/28/14

import java.io.*;
import java.util.*;

//Main class
   public class PegSolitaire {
      
      //Main function welcomes the player, gets the name, asks which game the user wants to play
      public static void main(String [] args) {
         String userName;
         boolean gameType;
         boolean instructions;
         
         
         //Welcomes the player
         userName = getUserName();
         System.out.println("Welcome to Peg Solitaire " + userName); 
         
        
         //Gets game type True = Triangle False = Cross
         gameType = getGameType();
        /* if(gameType == true) {
            System.out.println("**********************************Instructions*************************************");
            System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board");
            System.out.println("You can jump in any direction parallel to the edges of the board");
            System.out.println("The goal of the game is the finish with one peg left on the board");
            
         }//if
            //playgame
         else if (gameType == false) {
            System.out.println("**********************************Instructions*************************************");
            System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board");
            System.out.println("You can jump vertically and horizontally not diagonally");
            System.out.println("The goal of the game is to finish with only one peg on the board");
            //playgame
        
         }//else if      
          */ 
          
          instructions = getInstructions();
          if(gameType == true) && (instructions = true){
            System.out.println("**********************************Instructions*************************************");
            System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board");
            System.out.println("You can jump in any direction parallel to the edges of the board");
            System.out.println("The goal of the game is the finish with one peg left on the board");
          }
          
          else if (gameType == false && (instructions = true) {
            System.out.println("**********************************Instructions*************************************");
            System.out.println("Jump one peg over another into an empty spot, removing the jumped peg from the board");
            System.out.println("You can jump vertically and horizontally not diagonally");
            System.out.println("The goal of the game is to finish with only one peg on the board");
          }
          
          else 
            /*test line*/ System.out.println("test test test");
          
          

            
           
           
     }//main
         
         
      //This function gets the user name
      public static String getUserName(){
         String inputString;
         System.out.println("Please enter your name");
         Scanner scan = new Scanner(System.in);
         inputString = scan.nextLine();
         
         return inputString;
      }//getUserName
      
      //This function gets the users first action wether it be triangle board, cross
      public static boolean getGameType() {
         String inputString;
         int inputInt;
         Scanner scan = new Scanner(System.in);
         System.out.println("Which board layout would you like to play? (1)Triangle or (2)Cross");
         inputInt = scan.nextInt();
         if (inputInt == 1)
            return true;
         else 
            return false;
      }//getGameType
      
      
      //This function finds out if the user needs instructions or not
      public static boolean getInstructions() {
         String inputString;
         int inputInt;
         Scanner scan = new Scanner(System.in);
         System.out.println("Do you need the instructions of the game you're about to play? (1) Yes or (2) No");
         inputInt = scan.nextInt();
         if (inputInt == 1)
            return true;
         else 
            return false;
      }//getInstructions
        
      
}//class         