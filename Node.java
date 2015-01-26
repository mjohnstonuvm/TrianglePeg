import java.util.*;

/*
   Each node represents a hole on the game board. There are eight
   possible positions that a neighboring node could be. A node's 
   label determine where on the game board it is located.
   The peg variable represents whether a node(hole) has a peg in it.
*/

public class Node 
{
   /*
      Variable Declarations.
   */
   private boolean peg = true;
   
   private int label;
         
   private HashMap neighbors = new HashMap();
   
   /*
      Node constructor must accept label in integer form.
   */
   public Node(int label) 
   {
      this.label = label;
      
      neighbors = startHashMap();
   } 
    
   /*
      Setter and getter for "peg" variable.
   */ 
   public void setPeg(boolean peg) 
   {
      this.peg = peg;
   } 

   public boolean getPeg() 
   {
      return peg;
   } 
   
   /*
      Setter and getter for label variable.
   */
   public void setLabel(int label) 
   {
      this.label = label;
   } 

   public int getLabel() 
   {
      return label;
   }
      
   /*
      startHashMap initializes all 8 possible neighbors of a node(hole) to be null.
      This should only be called when Node is first constructed.
   */
   
   private HashMap startHashMap()
   {
      neighbors.put("n", null);
      neighbors.put("ne", null);
      neighbors.put("e", null);
      neighbors.put("se", null);
      neighbors.put("s", null);
      neighbors.put("sw", null);
      neighbors.put("w", null);
      neighbors.put("nw", null);
 
      return neighbors;
   } 
}