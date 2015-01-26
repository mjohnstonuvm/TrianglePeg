
//package trianglepegarray1;
public class TrianglePegArray {

    //Declares an 2D array to store x's and o's
    private final char[][] Triangle = {{'x'}, {'x', 'x'}, {'o', 'x', 'x'}, {'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x'}};

    /*create nodes from the Node class to store in the indexes
     *
     */
    public void createNodes(int x, int y) {

        for (int i = 0; i < Triangle.length; i++) {
            for (int j = 0; j < Triangle.length; j++) {
                Triangle[i][j] = new Node(x, y);
            }
        }
    }

    /*
     * Returns given peg at the current index
     */
    public int getIndex(int i, int j) {
        return Triangle[i][j];
    }

    /*
     * Changes the index (needs to be changed)
     */
    public void changeIndex(int i, int j) {
        if (Triangle[i][j] == 'x') {
            Triangle[i][j] = 'o';
        } else {
            Triangle[i][j] = 'x';
        }
        print();
    }

    /*
     * Prints out the array 
     */
    public void print() {
        for (char[] Triangle1 : Triangle) {
            for (int j = 0; j < Triangle1.length; j++) {
                System.out.print(Triangle1[j] + " ");
            }
            System.out.println();
        }
    }
};
