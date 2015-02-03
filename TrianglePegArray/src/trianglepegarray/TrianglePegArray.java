
public class TrianglePegArray {

    //Declares an 2D array
    private Node[][] Triangle = new Node[5][];

    /*create nodes from the Node class to store in the indexes
     *
     */
    public TrianglePegArray() {

        //Creates node number per index
        Triangle[0] = new Node[1];
        Triangle[1] = new Node[2];
        Triangle[2] = new Node[3];
        Triangle[3] = new Node[4];
        Triangle[4] = new Node[5];

        int num = 1; //counter

        //loop to create the nodes with a number
        for (int i = 0; i < Triangle.length; i++) {
            for (int j = 0; j < Triangle[i].length; j++) {
                Triangle[i][j] = new Node(num);
                num++;
            }

        }

        //Calls method
        createNeighbors();
    }

    /*
     * Creates neighbors
     */
    private void createNeighbors() {

        //loop to create sw neighbors with index i
        for (int i = 0; i < Triangle.length; i++) {

            for (int j = 0; j < Triangle[i].length; j++) {

                if (i + 1 <= 4) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("sw", Triangle[i + 1][j]);

                }

            }
        }

        //loop to create ne neighbors
        for (int i = Triangle.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                //sets the neighbor
                Triangle[i][j].setNeighbor("ne", Triangle[i - 1][j]);

            }

        }

        //loop to create nw neighbors
        for (int i = Triangle.length - 1; i > 0; i--) {

            for (int j = 0; j <= i; j++) {

                if (j >= 1) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("nw", Triangle[i - 1][j - 1]);

                }

            }

        }

        //loop to create se seighbors same as nw but flipping indexes
        for (int i = Triangle.length - 1; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                if (i < 4) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("se", Triangle[i + 1][j + 1]);

                }

            }

        }

        //loop to create e neighbors
        for (int i = 0; i < Triangle.length; i++) {

            for (int j = 0; j < Triangle[i].length; j++) {

                //if the length -1 is not 0, then add the neighbor
                if (Triangle[j].length - 1 > 0) {

                    //sets the neighbor
                    Triangle[i][j - 1].setNeighbor("e", Triangle[i][j]);
                }
            }

        }

        //loop to create w neighbors
        for (int i = 0; i < Triangle.length; i++) {

            for (int j = 0; j < Triangle[i].length; j++) {

                //if the length -1 is not 0, then add the neighbor
                if (Triangle[j].length - 1 > 0) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("w", Triangle[i][j - 1]);
                }
            }

        }
    }


};
