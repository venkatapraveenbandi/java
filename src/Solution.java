import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(int score) {
        this.moves = new ArrayList<Move>();
        this.score = score;
    }

    public Solution() {
        this.moves = new ArrayList<Move>();
        this.score = 9999;
    }

    public List<Move> moves;
    public int score;
}