package utilities.DemoObjects;
import java.awt.Rectangle;

public class DemoBall extends Rectangle{
	public int radius;
    private double dx = 2;
	private double dy = 2;
    private double upperBound;
    private double lowerBound;
	
    public DemoBall(int radius, double upper, double lower, int x, int y, int winWidth, int winHeight) {
        super(x+winWidth/2, y+winHeight/2, radius*2, radius*2);
        this.upperBound = upper;
        this.lowerBound = lower;
        this.radius = radius;
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
    	this.checkDir(contact);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
