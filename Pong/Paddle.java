package Pong;
import java.awt.Rectangle;

public class Paddle extends Rectangle{
    private int height;
    private int width;
    private double rightSide = width;
    private double leftSide = PongRunner.getMaxWindowX()-width;
    private double movementSpeed = 15;

    public Paddle(int x, int width, int height) {
        super(x, (int)(PongRunner.getMaxWindowY()/2-height/2), width, height);
        this.width = width;
        this.height = height;
    }

    public Boolean checkContact(int y, double leftEdge, double rightEdge) {
        double upperBound = this.getY();
        double lowerBound = this.getY() + height;
        if(upperBound<=y && y<=lowerBound){
            if(leftEdge<=rightSide || rightEdge>=leftSide){
                return true;
            }
        }
        return false;
    }

    public void up(){
        this.setLocation((int)this.getX(), (int)(this.getY()-movementSpeed));
    }

    public void down(){
            this.setLocation((int)this.getX(), (int)(this.getY()+movementSpeed)); 
    }
}
