//(Matt)
public class Board {

    //Declares an 2D array
    public Node[][] Board = new Node[9][9];

    public Board() {

        int num = 0; //counter

        /*
        
         ********NOTE********
         *********NOTE********
        INDEX i IS ROWS 
        INDEX j IS COLS
        
        */
        
        for (int i = 1; i < 8; i++) {

            //creates the constraint on the cols, sets everyting else to null
            if (i < 3 || i > 5) {

                for (int j = 4; j < 7; j++) {

                    //gives the node a number
                    Board[i][j] = new Node(num);

                    //increments
                    num++;
                }
            } else {

                //creates constraint on the rows, everything else is null
                for (int j = 1; j < 8; j++) {

                    //gives the node a number
                    Board[i][j] = new Node(num);

                    //increments
                    num++;

                }
            }

        }

        //function call
        createNeighbors();
    }

    private void createNeighbors() {

        //This starts with the cols and only sets neighbors to non-null nodes
        for (int i = 1; i < 8; i++) {

            //this is for the rows
            for (int j = 1; j < 7; j++) {

                //gets east neighbor if not null
                if (Board[i][j + 1] != null && Board[i][j] != null) {

                    //Sets east neighbor to the node
                    Board[i][j].setNeighbor("e", Board[i][j + 1]);

                }

                //gets west neighbor if not null
                if (j - 1 > 0 && Board[i][j] != null) {

                    //Sets west neighbor to the node
                    Board[i][j].setNeighbor("w", Board[i][j - 1]);

                }

                //gets west neighbor if not null
                //Also has a constraint on the vertical axis
                if (i < 7 && Board[i][j] != null) {

                    //gets south neighbor if not null
                    if (Board[i + 1][j] != null) {

                        //Sets south neighbor 
                        Board[i][j].setNeighbor("s", Board[i + 1][j]);

                    }
                }

                //gets north neighbor if not null
                if (i - 1 > 0 && Board[i][j] != null) {

                    //Sets the north neighbors
                    Board[i][j].setNeighbor("n", Board[i - 1][j]);

                }
            }

        }

    }
}