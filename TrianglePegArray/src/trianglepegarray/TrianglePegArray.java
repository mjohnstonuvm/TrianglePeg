
package trianglepegarray;
public class TrianglePegArray {

    //Declares an 2D array 
    public static Node[][] Triangle = new Node[5][];

    /*create nodes from the Node class to store in the indexes
     *
     */
    public TrianglePegArray() { 
 
        Triangle[0] = new Node[1];
        Triangle[1] = new Node[2];
        Triangle[2] = new Node[3];
        Triangle[3] = new Node[4];
        Triangle[4] = new Node[5];
        
        int num = 1;
        
        for (int i = 0; i < Triangle.length; i++) {
            for (int j = 0; j < Triangle[i].length; j++) {
                Triangle[i][j] = new Node(num);
                num++;

            }

        }
        
        createNeighbors();
    }
    /*
    * Creates neighbors
    */
    public void createNeighbors(){
        
            //loop to create sw and se neighbors with columns
            for (int i = 0; i < Triangle[i].length; i++) {
                
                if(i + 1 < Triangle[i].length){
                    
                    Triangle[i].setNeighbor("sw",Triangle[i]+1);
                    Triangle[i+1].setNeighbor("ne",Triangle[i]);
                    
                }

            }
            
            //loop to create se and sw neighbors with rows
            for (int j = 0; j < Triangle.length; j++) {
                
                if(!(Triangle[j]+1 > Triangle[1].length)){
                    
                    Triangle[j].setNeighbor("se",Triangle[j]+1);
                    Triangle[j-1].setNeighbor("nw",Triangle[j]);
                
                }
            }
            for (int i = 0; i < Triangle.length; i++) {
                for (int j = 0; j < Triangle.length; j++) {
                    
                
            }
        }
  
        }
    
    /*
     * Returns given peg at the current index
     */
 /*   public int getNode(int i, int j) {
        return Triangle[i][j];
    }*/

    /*
     * Changes the index (needs to be changed)
     */
/*    public void changeNode(int i, int j) {
        if (Triangle[i][j] == 'x') {
            Triangle[i][j] = 'o';
        } else {
            Triangle[i][j] = 'x';
        }
        print();
    }
*/
    /*
     * Prints out the array 
     */
    public void print() {
        for (int i = 0; i < Triangle.length; i++) {
            for (int j = 0; j < Triangle[i].length; j++) {
                System.out.print(Triangle[i][j].getLabel() + " ");
            }
            System.out.println();
        }
    }
    
};
