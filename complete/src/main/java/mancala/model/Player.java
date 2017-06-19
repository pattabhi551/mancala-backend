package mancala.model;
import java.util.ArrayList;

public class Player {

    private int[] scores;
    private String name;
    private int pitScore;

    public Player(String  name, int holes, int stones) {
        this.name = name;
        this.scores = new int[holes];
        fillHoles(holes, stones);
    }

    public int[] getScores() {
        return this.scores;
    }

    public String getName() {
        return this.name;
    }

    private void fillHoles(int holes, int stones) {
        for(int i=0; i < holes; i++) {
            scores[i] = stones;
        }
    }

    public Integer getPitScore() {
        return this.pitScore;
    }

    public void updateScore(int index) {

        if(this.scores[index] <=0)
            return;

        if(this.scores[index] >= this.scores.length - index) {
            this.pitScore++;
        }

        this.scores[index] = 0;

        for(int i=index+1; i < this.scores.length; i++) {
            this.scores[i]++;
        }


    }

    public void updateScoreOpponentsMove(int length) {
        for(int i=0; i < length; i++) {
            this.scores[i]++;
        }
    }

    public int getFullScore() {
        int totalScore=0;
        for(int i=0; i < this.scores.length; i++) {
            totalScore = totalScore + this.scores[i];
        }

        return totalScore;
    }
}