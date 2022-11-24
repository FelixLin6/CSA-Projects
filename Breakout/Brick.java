package Breakout;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Rectangle{
    private Color col;
    private static Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.ORANGE, Color.GREEN};

    public Brick(int x, int y, Color c){
        super(x, y, GDV5.getMaxWindowX()/12, 25);
        col = c;
    }

    public static Color getColor(int index){
        try{
        return colors[(colors.length-1)%index];
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

    public static Brick[][] makeBricks(){
        Brick[][] bricks = new Brick[10][9];
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
