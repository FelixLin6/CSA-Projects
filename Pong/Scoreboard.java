package Pong;

public class Scoreboard {
    private int score;

    Scoreboard(int x) {
        this.score = x;
    }

    public void update(){
        this.score+=1;
    }

    public int getScore(){
        return this.score;
    }
    
    public void resetScore() {
    	this.score=0;
    }

    public String getScoreStr(){
        return Integer.toString(this.score);
    }
}
