package Breakout;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;

public class Pill extends Rectangle{
    private Color col;
    private Color black = Color.BLACK;
    private Color currentCol;
    private boolean activationStatus = false;
    public int powerup = (int)(Math.random()*3) + 1;

    public Pill(int x, int y, int h, int w, Color c){
        super(x, y, w, h);
        col = c;
        currentCol = black;
    }

    public void activate(){
        this.activationStatus = true;
        currentCol = col;
    }

    public void deactivate(){
        this.col = Color.black;
        activationStatus = false;
    }

    public boolean isActive(){
        return this.activationStatus;
    }

    public void moveDown(){
        this.setLocation((int)(this.getX()), (int)(this.getY()+3));
    }

    public void draw(Graphics2D pb){
        pb.setColor(currentCol);
        pb.fill(this);
        pb.draw(this);
    }
}
