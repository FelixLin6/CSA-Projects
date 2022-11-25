package Breakout;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle extends Rectangle{
    private int width;
    private int movementSpeed = 15;

    public Paddle(int width, int height) {
        super((int)(Breakout.getMaxWindowX()/2-width/2), (int)(Breakout.getMaxWindowY()-100), width, height);
        this.width = width;
    }

    public void draw(Graphics2D pb){
        pb.setColor(Color.white);
        pb.fill(this);
        pb.setColor(Color.white);
        pb.draw(this);
    }

    public void left(){
        if(this.getX()>0){
        this.setLocation((int)(this.getX()-movementSpeed), (int)this.getY());}
    }

    public void right(){
        if(this.getX()<Breakout.getMaxWindowX()-width){
            this.setLocation((int)(this.getX()+movementSpeed), (int)this.getY());}
    }
}

