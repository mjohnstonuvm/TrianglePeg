

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

            for (int j = i; j < Triangle[i].length; j++) {

                if (i + 1 < Triangle.length) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("sw", Triangle[i + 1][j]);

                }

            }
        }

        int colsNorthEast = 0; //counter or cols
        int rowsNorthEast = 0; //counter for rows

        //loop to create ne neighbors
        for (int i = Triangle.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                //sets the neighbor
                Triangle[j + 1][j].setNeighbor("ne", Triangle[rowsNorthEast][colsNorthEast]);

                //incrememnts
                rowsNorthEast++;

                if (j == i - 1) {
                    colsNorthEast++;
                    rowsNorthEast = colsNorthEast;
                }

            }

        }

        int colsNorthWest = 0; //counter for cols for the neighbor
        int rowsNorthWest = 0; //counter for rows for the neighbor
        int colsNeighbor = 1; //counter for cols for the current index
        int rowsNeighbor = 1; //counter for rows for the current index
        int count = 0; //counter

        //loop to create nw neighbors
        for (int i = Triangle.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                //sets the neighbor
                Triangle[rowsNeighbor][colsNeighbor].setNeighbor("nw", Triangle[rowsNorthWest][colsNorthWest]);

                //increments
                rowsNeighbor++;
                rowsNorthWest++;
                colsNeighbor++;
                colsNorthWest++;

                if (j == i - 1) {

                    count++;
                    rowsNeighbor = 1;
                    colsNorthWest = 0;
                    colsNeighbor = 1;
                    rowsNorthWest = 1;

                    if (count == 2) {

                        rowsNorthWest = 2;

                    }
                    if (count == 3) {

                        rowsNorthWest = 3;
                    }

                }

            }

        }

        int colsSouthEast = 0; //counter for south east cols
        int rowsSouthEast = 0; //counter for south east rows
        int colsNeighborSE = 1; //counter for south east neighbor cols
        int rowsNeighborSE = 1; //counter for south east neighbor rows
        int countSE = 0;

        //loop to create se seighbors same as nw but flipping indexes
        for (int i = Triangle.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                //sets the neighbor
                Triangle[rowsSouthEast][colsSouthEast].setNeighbor("se", Triangle[rowsNeighborSE][colsNeighborSE]);

                //increments
                rowsNeighborSE++;
                rowsSouthEast++;
                colsNeighborSE++;
                colsSouthEast++;

                if (j == i - 1) {

                    countSE++;
                    rowsNeighborSE = 1;
                    colsSouthEast = 0;
                    colsNeighborSE = 1;
                    rowsSouthEast = 1;

                    if (countSE == 2) {

                        rowsSouthEast = 2;

                    }
                    if (countSE == 3) {

                        rowsSouthEast = 3;
                    }

                }

            }

        }

        //loop to create e neighbors
        for (int i = 0; i < Triangle.length; i++) {

            for (int j = 0; j < Triangle[i].length; j++) {

                //if the length -2 is not 0, then add the neighbor
                if (Triangle[j].length - 2 > 0) {

                    //sets the neighbor
                    Triangle[i][j - 2].setNeighbor("e", Triangle[i][j]);
                }
            }

        }

        //loop to create w neighbors
        for (int i = 0; i < Triangle.length; i++) {

            for (int j = 0; j < Triangle[i].length; j++) {

                //if the length -2 is not 0, then add the neighbor
                if (Triangle[j].length - 2 > 0) {

                    //sets the neighbor
                    Triangle[i][j].setNeighbor("w", Triangle[i][j - 2]);
                }
            }

        }

    }

};
