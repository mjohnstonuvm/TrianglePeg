/*
   Each node represents a hole on the game board. There are eight
   possible positions that a neighboring node could be. A node's 
   coordinates determine where on the game board it is located.
   The peg variable represents whether a node(hole) has a peg in it.
*/
public class Node 
{
   /*
      Variable Declarations.
   */
   private boolean peg = true;
   
   private int xCoordinate;
   private int yCoordinate;
  
   //Variable names correspond to cardinal directions
   private Node nNeighbor = null;
   private Node nENeighbor = null;
   private Node eNeighbor = null;
   private Node sENeighbor = null;
   private Node sNeighbor = null;
   private Node sWNeighbor = null;
   private Node wNeighbor = null;
   private Node nWNeighbor = null;
   
   /*
      Node constructor must accept X and Y coordinates in integer form.
   */
   public Node(int xCoordinate, int yCoordinate) {
      this.xCoordinate = xCoordinate;
      this.yCoordinate = yCoordinate;
   } 
    
   /*
      Setter and getter for "peg" variable.
   */ 
   public void setPeg(boolean peg) {
      this.peg = peg;
   } 

   public boolean getPeg() {
      return peg;
   } 
   
   /*
      Setters and getters for "coordinate" variables. (Try not to use the setters.)
   */
   public void setXCoordinate(int xCoordinate) {
      this.xCoordinate = xCoordinate;
   } 

   public int getXCoordinate() {
      return xCoordinate;
   }
   
   public void setYCoordinate(int yCoordinate) {
      this.yCoordinate = yCoordinate;
   } 

   public int getYCoordinate() {
      return yCoordinate;
   }


   /*
      Setters and getters for "neighbor" variables.
   */
   //north
   public void setNNeighbor(Node nNeighbor) {
      this.nNeighbor = nNeighbor;
   } 

   public Node getNNeighbor() {
      return nNeighbor;
   }
   //northeast
   public void setNENeighbor(Node nENeighbor) {
      this.nENeighbor = nENeighbor;
   } 

   public Node getNENeighbor() {
      return nENeighbor;
   }
   //east
   public void setENeighbor(Node eNeighbor) {
      this.eNeighbor = eNeighbor;
   } 

   public Node getENeighbor() {
      return eNeighbor;
   }
   //southeast
   public void setSENeighbor(Node sENeighbor) {
      this.sENeighbor = sENeighbor;
   } 

   public Node getSENeighbor() {
      return sENeighbor;
   }
   //south
   public void setSNeighbor(Node SNeighbor) {
      this.sNeighbor = sNeighbor;
   } 
   public Node getSNeighbor() {
      return sNeighbor;
   }
   //southwest
   public void setSWNeighbor(Node sWNeighbor) {
      this.sWNeighbor = sWNeighbor;
   } 
   public Node getSWNeighbor() {
      return sWNeighbor;
   }
   //west
   public void setWNeighbor(Node wNeighbor) {
      this.wNeighbor = wNeighbor;
   } 
   public Node getWNeighbor() {
      return wNeighbor;
   }
   //northwest
   public void setNWNeighbor(Node nWNeighbor) {
      this.nWNeighbor = nWNeighbor;
   } 

   public Node getNWNeighbor() {
      return nWNeighbor;
   }

} 
