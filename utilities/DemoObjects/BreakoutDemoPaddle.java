package utilities.DemoObjects;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class BreakoutDemoPaddle extends Rectangle{
    private BreakoutDemoBall ball;
    private static int width = 30;
    private static int height = 3;

    public BreakoutDemoPaddle(int winX, int winY, int winW, int winH, BreakoutDemoBall ball) {
        super(winX+winW/2-15, winY+3/4*winH, width, height);
        this.ball = ball;
    }

    public void draw(Graphics2D pb){
        pb.drawRect((int)this.getX(), (int)this.getY(), width, height);
    }
    
    public void move(){
        this.setLocation((int)ball.getX(), (int)this.getY());
    }
}

