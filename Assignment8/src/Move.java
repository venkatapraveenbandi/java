public class Move {
    public int from, over, to;

    Move(int from, int over, int to) {
        this.from = from;
        this.over = over;
        this.to = to;
    }

    public Move reverse() {
        return new Move(this.to, this.over, this.from);
    }
}