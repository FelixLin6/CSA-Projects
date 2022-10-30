package utilities.DemoObjects;
import java.awt.Rectangle;
import java.awt.Point;

public class DemoBall extends Rectangle{
	public int radius;
    private double dx = 4;
	private double dy = -3;
    private double upperBound;
    private double lowerBound;
    private Point mid;
	
    public DemoBall(int radius, double upper, double lower, int x, int y, int winWidth, int winHeight) {
        super(x+winWidth/2, y+winHeight/2, radius*2, radius*2);
        // super(40, y+winHeight/2, radius*2, radius*2);x   
        this.upperBound = upper;
        this.lowerBound = lower;
        this.radius = radius;
        mid = new Point(x+winWidth/2, y+winHeight/2);
    }

    public void setSpeed(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public int getRadius(){
        return this.radius;
    }
    

    public void checkDir(boolean contact) {
		double upperEdge = this.getCenterY()-radius;
		double lowerEdge = this.getCenterY()+radius;

    	if((int)upperEdge<=upperBound || (int)lowerEdge>=lowerBound) {
			dy*=-1;
		}
		if(contact) {
			dx*=-1;
		}
    }

    public void update(boolean contact){
        if(this.getCenterX()<=0){this.setLocation(mid);this.setSpeed(3, -2);}
    	this.checkDir(contact);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
