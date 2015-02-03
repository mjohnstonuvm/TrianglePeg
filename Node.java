//(Colin)
import java.util.*;

/*
   Each node represents a hole on the game board. 
   
   There are eight possible positions that a neighboring node could be in relation 
   to another node. 
   
   A node's label is which position it is located on the game board. 
   
   The label is displayed when a Node is printed to the command
   line. 
   
   The peg variable represents whether a node(hole) has a peg in it.
*/

public class Node 
{
   /*
      Variable Declarations.
   */
   private boolean peg = true;
   
   private int label;
         
   private HashMap<String, Node> neighbors = new HashMap<String, Node>(8);
   
   /*
      Node constructor must accept label in integer form. It automatically
      initializes the keys in neighbors HashMap.
   */
   public Node(int label) 
   {
      this.label = label;
      
      neighbors.put("n", null);
      neighbors.put("ne", null);
      neighbors.put("e", null);
      neighbors.put("se", null);
      neighbors.put("s", null);
      neighbors.put("sw", null);
      neighbors.put("w", null);
      neighbors.put("nw", null);
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
      Setter and getter for Node neighbors. 
   */   
   public void setNeighbor(String direction, Node neighbor)
   {
      if(neighbors.containsKey(direction))//Direction should already exist in HashMap. This replaces value of preexisting direction key.
      {
         neighbors.put(direction, neighbor);
      }
   }
   
   public Node getNeighbor(String direction)
   {
      return neighbors.get(direction);
   }
   
   /*
      toString method returns string version of label variable.
   */
   public String toString()
   {
      return Integer.toString(label);
   }
}