package utilities.DemoObjects;
import java.awt.Rectangle;

public class DemoPaddle extends Rectangle{
    private int height;
    private double movementSpeed = 3;
    private double upperBound;
    private double lowerBound;

    public DemoPaddle(int x, int width, int height, double upper, double lower, int demoY, int winHeight) {
        super(x, (int)(demoY+winHeight/2-height/2), width, height);
        this.width = width;
        this.height = height;
        this.upperBound = upper;
        this.lowerBound = lower;
    }

    public void up(){
        if(this.getY()>upperBound){
        this.setLocation((int)this.getX(), (int)(this.getY()-movementSpeed));}
    }

    public void down(){
        if(this.getY()<lowerBound-height){
            this.setLocation((int)this.getX(), (int)(this.getY()+movementSpeed));}
    }
}

