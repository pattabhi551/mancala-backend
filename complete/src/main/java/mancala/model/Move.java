package mancala.model;

public class Move {

    private String player;
    private int index;

    public Move(){
        this.player = "p1";
        this.index = 0;
    }

    public Move(String player, int index) {
        this.player = player;
        this.index = index;
    }

    public String getPlayer() {
        return player;
    }

    public int getIndex() {
        return index;
    }
}