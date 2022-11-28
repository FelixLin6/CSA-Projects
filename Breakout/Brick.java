package Breakout;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Rectangle{
    private Color col;
    private static Color[] colors = {Color.decode("#fbf8cc"), Color.decode("#fde4cf"), Color.decode("#ffcfd2"), Color.decode("#f1c0e8"), Color.decode("#cfbaf0"), Color.decode("#a3c4f3"), Color.decode("#90dbf4"), Color.decode("#8eecf5"), Color.decode("#98f5e1"), Color.decode("#b9fbc0")};

    public Brick(int x, int y, Color c){
        super(x, y, GDV5.getMaxWindowX()/12, 25);
        col = c;
    }

    public static Color getColor(int index){
        try{
        return colors[index%(colors.length-1)];
        }
        catch(ArithmeticException e){
            return colors[0];
        }
    }

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.fill(this);
        pb.setColor(Color.white);
        pb.draw(this);
    }

    public static Brick[][] makeBricks(int level){
        Brick[][] bricks = new Brick[10][2+level];
        int x = 20;
        int y = 10;
        for(int i=0; i<bricks.length; i++){
            Brick[] b = bricks[i];
            for(int j=0; j<b.length; j++){
                b[j] = new Brick(x, y, getColor(i));
                x += (GDV5.getMaxWindowX()/12+GDV5.getMaxWindowX()/36);
            }
            x=20;
            y+=30;
        }
        return bricks;
    }
}
