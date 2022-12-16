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
    public static int width = maxX/10;
    public static int height = width/4;
    private static int cols = 9;
    private static int spacing = (maxX-cols*width)/(cols+1);
    private static int level;
    private static int numBricks;
    private boolean active = true;
    private Pill pill;


    public Brick(int x, int y, Color c){
        super(x, y, width, height);
        col = c;
        pill = new Pill((int)this.getCenterX(), (int)this.getCenterY(), width/3, height/3, this.col);
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

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.fill(this);
        pb.draw(this);
    }

    public Pill getPill(){
        return this.pill;
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

    public void update(Paddle pad, Boolean poweredUp, Breakout runner){
        if(pill.isActive()){
            pill.moveDown();
            if(pill.getY()>(int)Breakout.getMaxWindowY()){
                pill.deactivate();
            }
            else if(pill.intersects(pad) && !poweredUp){
                pill.deactivate();
                runner.newPowerup(pill.powerup);
                runner.enactPowerup(pill.powerup);
            }
        }
    }
}
