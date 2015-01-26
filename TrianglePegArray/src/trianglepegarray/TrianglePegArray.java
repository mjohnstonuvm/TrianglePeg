
//package trianglepegarray;

public class TrianglePegArray {

    private final char[][] Triangle = {{'x'}, {'x', 'x'}, {'o', 'x', 'x'}, {'x', 'x', 'x', 'x'}, {'x', 'x', 'x', 'x', 'x'}};
    
    public void createNodes(int x, int y){
    
        for (int i = 0; i < Triangle.length; i++) {
            for (int j = 0; j < Triangle.length; j++) {
                Triangle[i][j] = new Node(x,y);
            }
    }
    }
    public int getIndex(int i, int j) { return Triangle[i][j]; }

    public void changeIndex(int i, int j){
        if(Triangle[i][j] == 'x'){
            Triangle[i][j] = 'o';
        }else{
            Triangle[i][j] = 'x';
        }
        print();
    }

    public void print(){
           for (char[] Triangle1 : Triangle) {
            for (int j = 0; j < Triangle1.length; j++) {
                System.out.print(Triangle1[j] + " ");
            }
            System.out.println();
        }
    }
};
