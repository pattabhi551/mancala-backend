package mancala.service;

import mancala.model.*;

public class MancalaService {
    private Mancala mancala;
    private static MancalaService instance;

    public static MancalaService getInstance() {
        if(instance == null) {
            instance = new MancalaService();
        }

        return instance;
    }

    MancalaService() {
        this.mancala = new Mancala("Pattabhi", "Sushmitha",6,6);
    }

    public Mancala initMancala() {
        return this.mancala;
    }

    public Mancala updateMancala(Move move) {

        if(!this.mancala.isLastMove()) {
            if(move.getPlayer().equals("p1")) {

                this.mancala.getPlayer2().
                        updateScoreOpponentsMove(this.getExcessScoreLength(this.mancala.getPlayer1(),
                                move.getIndex()));

                this.mancala.getPlayer1().updateScore(move.getIndex());

            } else {

                this.mancala.getPlayer1().
                        updateScoreOpponentsMove(this.getExcessScoreLength(this.mancala.getPlayer2(), move.getIndex()));

                this.mancala.getPlayer2().updateScore(move.getIndex());
            }

            if(this.mancala.getPlayer1().getFullScore() == 0 || this.mancala.getPlayer2().getFullScore() == 0) {
                this.mancala.setLastMove(true);
            }
        }

        return this.mancala;
    }

    private int getExcessScoreLength(Player player, int index) {
        int[] scores = player.getScores();
        int excessLength = scores[index] - (scores.length - index);

        return excessLength;
    }

    public Player declareWinner() {
        if(this.mancala.getPlayer1().getPitScore() > this.mancala.getPlayer2().getPitScore()) {
            return this.mancala.getPlayer1();
        }

        return this.mancala.getPlayer2();
    }
}