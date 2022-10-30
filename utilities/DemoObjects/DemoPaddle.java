package utilities.DemoObjects;
import java.awt.Rectangle;

public class DemoPaddle extends Rectangle{
    private int height;
    private double upperBound;
    private double lowerBound;
    private DemoBall dBall;
    private int x;

    public DemoPaddle(int x, int width, int height, double upper, double lower, int demoY, int winHeight, DemoBall dBall) {
        super(x, (int)(demoY+winHeight/2-height/2), width, height);
        this.x = x;
        this.width = width;
        this.height = height;
        this.upperBound = upper;
        this.lowerBound = lower;
        this.dBall = dBall;
    }

    public void update(){
        if(dBall.getCenterY()<=upperBound+height/2){
            this.setLocation(x, (int)upperBound);
        }
        else if(dBall.getCenterY()>=lowerBound-height/2){
            this.setLocation(x, (int)(lowerBound-height));
        }
        else{
            this.setLocation(x, (int)(dBall.getCenterY()-height/2));
        }
    }
}

