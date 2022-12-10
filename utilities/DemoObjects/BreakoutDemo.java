package utilities.DemoObjects;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;

public class BreakoutDemo {
     //demo objects on splash/menu screen, a demo of the game will be displayed in a 360x240 window placed at (40, 350)
    private int winX = 40;
    private int winY = 350;
    private int winW = 374;
    private int winH = 254 ;   
    private Rectangle window = new Rectangle(winX, winY, winW, winH);
    private BreakoutDemoBall ball = new BreakoutDemoBall(7, winX, winY, winW, winH);
    private BreakoutDemoPaddle pad = new BreakoutDemoPaddle(winX, winY, winW, winH, ball);
    private DemoBrick[][] bricks = DemoBrick.makeBricks();

    public BreakoutDemo(){
        DemoBrick.maxX = this.winW;
        DemoBrick.maxY = this.winH;
        DemoBrick.winX = this.winX;
        DemoBrick.winY = this.winY;
    }

    public int getWinX(){
        return this.winX;
    }

    public int getWinY(){
        return this.winX;
    }

    public void draw(Graphics2D pb){
        // pb.setColor(Color.white);
        // pb.draw(window);
        // pb.draw(ball);
        // pb.draw(pad);
        // for(DemoBrick[] brrrr: bricks){
        //     for(DemoBrick b: brrrr){
        //         b.draw(pb);
        //     }
        // }
        for(DemoBrick[] rows: bricks){
            for(DemoBrick b: rows){
                b.draw(pb);
            }
        }
    }
}
