package utilities.DemoObjects;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

public class BreakoutDemoPaddle extends Rectangle{
    private BreakoutDemoBall ball;

    public BreakoutDemoPaddle(int winX, int winY, int winW, int winH, BreakoutDemoBall ball) {
        super(winX+winW/2-15, winY+(winH*3/4), 30, 3);
        this.ball = ball;
    }

    public void draw(Graphics2D pb){
        pb.setColor(Color.white);
        pb.drawRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
        pb.fillRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
    }
    
    public void move(){
        this.setLocation((int)ball.getX(), (int)this.getY());
    }
}

