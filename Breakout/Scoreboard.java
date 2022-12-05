package Breakout;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class Scoreboard {
    private int score;
    private int size;

    Scoreboard(int x, int rows, int size) {
        this.score = x;
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
    
    public void resetScore() {
    	this.score=0;
    }

    public String getScoreStr(){
        return Integer.toString(this.score);
    }

    public void draw(Graphics2D pb){
        pb.setFont(new Font("TimesRoman", Font.PLAIN, size));
        pb.setColor(Color.white);
        pb.drawString(this.getScoreStr(), (int)(Breakout.getMaxWindowX()/2-(size*3/8)), (int)(Breakout.getMaxWindowY()/2));
    }
}
