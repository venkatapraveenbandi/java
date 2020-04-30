public class Board {
    private int cells[];
    private int active;

    Board(int i) {
        this.cells = new int[15];
        for(int j=0; j<15; j++)
            cells[j] = 1;
        cells[i] = 0;
        this.active = 14;
    }

    private Board copy() {
        Board board = new Board(0);
        board.cells = this.cells.clone();
        board.active = this.active;
        return board;
    }

    public int getActive() {
        return active;
    }

    public Board makeMove(Move fot) {
        if(cells[fot.from] == 1 && cells[fot.over] == 1 && cells[fot.to] == 0) {
            Board board = this.copy();
            board.cells[fot.from] = 0; // moved away
            board.cells[fot.over] = 0; // remove jumped over
            board.cells[fot.to]   = 1; // landing here after jump
            board.active--;
            return board;
        }
        return null;
    }

    public void show() {
        int a=4, b=1, cnt=0;
        while(a >= 0) {
            for(int i=0; i<a; i++)
                System.out.print(" ");
            for(int i=0; i<b; i++)
                System.out.print(((cells[cnt++] == 1) ? 'X' : '.') + " ");
            System.out.println();
            a--;
            b++;
        }
    }
}