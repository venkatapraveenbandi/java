import java.util.Collections;

public class Solver {
    private final Board board;

    // from,over,to : describes moves
    public Move[] moves = new Move[]{
            new Move(0, 1, 3),
            new Move(0, 2, 5),
            new Move(1, 3, 6),
            new Move(1, 4, 8),
            new Move(2, 4, 7),
            new Move(2, 5, 9),
            new Move(3, 6, 10),
            new Move(3, 7, 12),
            new Move(4, 7, 11),
            new Move(4, 8, 13),
            new Move(5, 8, 12),
            new Move(5, 9, 14),
            new Move(3, 4, 5),
            new Move(6, 7, 8),
            new Move(7, 8, 9),
            new Move(10, 11, 12),
            new Move(11, 12, 13),
            new Move(12, 13, 14)
    };

    public Solver(Board board) {
        this.board = board;
    }

    public Solution next_solution() {
        Solution solution = get_solution();
        Collections.reverse(solution.moves);
        return solution;
    }

    private Solution get_solution() {
        if(board.getActive() < 2) {
            return new Solution(board.getActive()); // empty list
        }
        Solution solution = new Solution();

        for(Move move: moves) {
            Board b = board.makeMove(move);
            if(b != null) {
                Solver s = new Solver(b);
                Solution sol = s.get_solution();
                if(sol.score < solution.score)
                    solution = sol;
                sol.moves.add(move);
            }
            b = board.makeMove(move.reverse());
            if(b != null) {
                Solver s = new Solver(b);
                Solution sol = s.get_solution();
                if(sol.score < solution.score)
                    solution = sol;
                sol.moves.add(move.reverse());
            }
        }
        return solution;
    }
}