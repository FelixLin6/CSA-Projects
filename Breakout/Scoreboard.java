package Breakout;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class Scoreboard {
    private int score;
    private int size;

    Scoreboard(int x, int size) {
        this.score = x;
        this.size = size;
    }

    public void update(){
        this.score+=1;
    }

    public void setSize(int s){
        this.size = s;
    }

    public int getScore(){
        return this.score;
    }
    
    public void setScore(int s){
        this.score = s;
    }
    
    public void resetScore() {
    	this.score=0;
    }

    public String getScoreStr(){
        return Integer.toString(this.score);
    }

    public void draw(Graphics2D pb){
        pb.setFont(new Font("Courier", Font.PLAIN, this.size));
        pb.setColor(Color.white);
        pb.drawString(this.getScoreStr(), (int)(Breakout.getMaxWindowX()/2-(this.size*1/2)), (int)(Breakout.getMaxWindowY()/2));
    }
}
