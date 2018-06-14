class Maze {

    private char[][] m;
    private int i, j, steps, ei, ej;

    Maze(char[][] _m, int _i, int _j) {
        m = _m;
        i = _i;
        j = _j;
        steps = 0;
        ei = 0;
        ej = 0;
    }

    void display() {
        for (char[] aM : m) {
            for (int y = 0; y < m[0].length; y++) {
                System.out.print(aM[y] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
    boolean findExit(){
        return findExit(i,j);
    }

    private boolean findExit(int row, int col) {

        if (row < 0 || row == m.length || col < 0 || col == m[0].length) // out of bounds
            return false;

        if (m[row][col] != ' ' && m[row][col]!='.') //not a space
            return false;

        if (m[row][col] == ' ' && (row == 0 || row == m.length - 1 || col == 0 || col == m.length - 1)){
            ei = row;
            ej = col;			//outer rows/columns
            return true;
        }

        steps++;	// iterate steps

        m[row][col] = '.'; // mark located bit
        boolean [] donePLS = new boolean [4];
        display(); // show maze

        if (m[row+1][col]==' '){
            donePLS[0]= findExit(++row, col);			// RIGHT
        }

        if (m[row-1][col]==' ') {
            donePLS[1]= findExit(--row, col);			//LEFT
        }


        if (m[row][col-1]==' ') {
            donePLS[2]= findExit(row, --col);			//DOWN
        }

        if (m[row][col+1]==' ') {
            donePLS[3] = findExit(row, ++col);			//UP
        }

        for  (int x = 0; x<4;x++){
            if (donePLS[x]){
                return true;
            }

        }
        return false;

    }

    int getIExit() {
        return ei;
    }

    int getJExit() {
        return ej;
    }

    int getSteps() {
        return steps;
    }

}