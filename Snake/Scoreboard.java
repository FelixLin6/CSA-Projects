package Snake;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;

public class Scoreboard {
    private static int score = 0;
    private int size;

    Scoreboard(int size) {
        this.size = size;
    }

    public static void update(){
        score+=1;
    }

    public void setSize(int s){
        this.size = s;
    }

    public static void addFive(){
        score+=5;
    }

    public static int getScore(){
        return score;
    }
    
    public void resetScore() {
    	score=0;
    }

    public String getScoreStr(){
        return Integer.toString(score);
    }

    public void draw(Graphics2D pb){
        pb.setFont(new Font("Courier", Font.PLAIN, this.size));
        pb.setColor(Color.white);
        pb.drawString(getScoreStr(), (int)(Game.getMaxWindowX()/2-(this.size*1/2)+25), (int)(Game.getMaxWindowY()/2));
    }
}
