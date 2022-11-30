package Breakout;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Rectangle{
    private Color col;
    private static Color[] palette;
    private static int maxX = GDV5.getMaxWindowX();
    private static int maxY = GDV5.getMaxWindowY();
    private static int width = maxX/10;
    private static int height = width/4;
    private static int cols = 9;
    private static int spacing = (maxX-cols*width)/(cols+1);

    public Brick(int x, int y, Color c){
        super(x, y, width, height);
        col = c;
    }

    public static void decodePalette(String[] codes){
        palette = new Color[codes.length];
        for(int i=0; i<codes.length; i++){
            palette[i] = Color.decode(codes[i]);
        }
    }

    public static Color getPalette(int index){
        try{
        return palette[index%(palette.length-1)];
        }
        catch(ArithmeticException e){
            return palette[0];
        }
    }

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.fill(this);
        pb.draw(this);
    }

    public static Brick[][] makeBricks(int level){
        Brick[][] bricks = new Brick[2+level][cols];
        int x = spacing;
        int y = 10;
        for(int i=0; i<bricks.length; i++){
            Brick[] b = bricks[i];
            for(int j=0; j<b.length; j++){
                b[j] = new Brick(x, y, getPalette(i));
                x += (width + spacing);
            }
            x=spacing;
            y+=30;
        }
        return bricks;
    }
}
