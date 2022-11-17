package Breakout;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Rectangle{
    private Color col;

    public Brick(int x, int y, Color c){
        super(x, y, GDV5.getMaxWindowX()/12, 25);
        col = c;
    }

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.fill(this);
        pb.setColor(Color.white);
        pb.draw(this);
    }

    public static Brick[] makeBricks(){
        Brick[] bricks = new Brick[12];
        int x = 0;
        int y = 50;
        for(int i=0; i< bricks.length; i++){
            bricks[i] = new Brick(x, y, Color.blue);
            x += GDV5.getMaxWindowX()/12;
        }
        return bricks;
    }
}
