package mancala.model;

public class Mancala {
    private Player player1;
    private Player player2;
    private int holes = 6;
    private int stones = 6;
    private boolean lastMove = false;

    public Mancala(String player1Name, String player2Name, int holes, int stones) {
        this.holes = holes;
        this.stones = stones;
        this.player1 = new Player(player1Name, this.holes, this.stones);
        this.player2 = new Player(player2Name, this.holes, this.stones);
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public int getHoles() {
        return this.holes;
    }

    public int getStones() {
        return this.stones;
    }

    public boolean isLastMove() {
        return this.lastMove;
    }

    public void setLastMove(boolean lastMove) {
        this.lastMove = lastMove;
    }
}