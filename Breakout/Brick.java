package Breakout;
import utilities.GDV5;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;

public class Brick extends Rectangle{
    private Color col;
    private static Color[] palette;
    private static int maxX = GDV5.getMaxWindowX();
    private static int maxY = GDV5.getMaxWindowY();
    public static int width = maxX/10;
    public static int height = width/4;
    private static int cols = 9;
    private static int spacing = (maxX-cols*width)/(cols+1);
    private static int level;
    private static int numBricks;
    private boolean active = true;
    public int powerup = (int)(Math.random()*4);

    private 

    public Brick(int x, int y, Color c){
        super(x, y, width, height);
        col = c;
    }

    public Brick(int x, int y, int w, int h){
        super(x, y, w, h);
    }

    public static int height(){
        return height;
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

    public static int numBricks(){
        return numBricks;
    }

    public boolean getActivationStatus(){
        return this.active;
    }

    public void pop(){
        this.col = Color.black;
        this.setSize(0, 0);
        active = false;
    }

    public void moveDown(){
        this.setLocation((int)(this.getX()), (int)(this.getY()+6));
    }

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.fill(this);
        pb.draw(this);
    }

    public static Brick[][] makeBricks(int level){
        Brick.level = level;
        Brick[][] bricks = new Brick[2+Brick.level][cols];
        numBricks = bricks.length * bricks[0].length;
        int x = spacing;
        int y = 10;
        for(int i=0; i<bricks.length; i++){
            Brick[] b = bricks[i];
            for(int j=0; j<b.length; j++){
                b[j] = new Brick(x, y, getPalette(i));
                x += (width + spacing);
            }
            x=spacing;
            y+=maxY/20;
        }
        return bricks;
    }

    public static Brick[] makePills(int x){
        Brick[] pills = new Brick[x];
        for(int i = 0; i < pills.length; i++){
            pills[i] = new Brick(0,0,0,0);
            pills[i].active = false;
        }
        return pills;
    }
}
