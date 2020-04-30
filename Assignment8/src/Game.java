import java.util.List;

public class Game {

    public Game() {}

    public List<Move> puzzle(int i) {
        Board board = new Board(i);
        Solver solver = new Solver(board);
        Solution solution = solver.next_solution();
        return solution.moves;
    }

    public void replay(List<Move> solution, int i) {
        Board board = new Board(i);
        board.show();
        for(Move m: solution)
        {
            board = board.makeMove(m);
            board.show();
            System.out.println();
        }
    }

    public void go() {
        for(int i=0; i<5; i++) {
            System.out.println("=== " + i + " ===");
            List<Move> solution = puzzle(i);
            replay(solution, i);
            System.out.println();
        }
    }
}