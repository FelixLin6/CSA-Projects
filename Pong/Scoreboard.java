package Pong;

public class Scoreboard {
    private int score;

    Scoreboard(int x) {
        this.score = x;
    }

    public void update(){
        this.score+=1;
    }

    public String getScoreStr(){
        return Integer.toString(this.score);
    }
}
