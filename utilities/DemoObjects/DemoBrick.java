package utilities.DemoObjects;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import utilities.ColorPalettes;

public class DemoBrick extends Rectangle{
    public Color col;
    private static Color[] palette;
    public static int maxX = 375;
    public static int maxY = 254;
    private static int width = maxX/10;
    private static int height = width/4;
    private static int cols = 7;
    private static int spacing = (maxX-cols*width)/(cols+1);
    private static int level = 4;
    private static int numBricks;
    public static int winX = 40;
    public static int winY = 350;
    public boolean activationStatus = true;

    public DemoBrick(int x, int y, Color c){
        super(x, y, width, height);
        col = c;
    }

    public static int height(){
        return height;
    }

    public static Color[] decodePalette(String[] codes){
        palette = new Color[codes.length];
        for(int i=0; i<codes.length; i++){
            palette[i] = Color.decode(codes[i]);
        }
        return palette;
    }

    public static Color getPalette(int index, Color[] plt){
        try{
        return plt[index%(palette.length-1)];
        }
        catch(ArithmeticException e){
            return plt[0];
        }
    }

    public static int numBricks(){
        return numBricks;
    }

    public void pop(){
        this.col = Color.black;
        this.setSize(0, 0);
        this.activationStatus = false;
    }

    public void draw(Graphics2D pb){
        pb.setColor(col);
        pb.drawRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
        pb.fillRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
    }

    public static DemoBrick[][] makeBricks(){
        Color[] palette = decodePalette(ColorPalettes.palette1);
        DemoBrick[][] bricks = new DemoBrick[2+level][cols];
        numBricks = bricks.length * bricks[0].length;
        int x = spacing + winX;
        int y = winY + 20;
        for(int i=0; i<bricks.length; i++){
            DemoBrick[] b = bricks[i];
            for(int j=0; j<b.length; j++){
                b[j] = new DemoBrick(x, y, getPalette(i, palette));
                x += (width + spacing);
            }
            x=spacing + winX;
            y+=winY/20;
        }
        return bricks;
    }
}
