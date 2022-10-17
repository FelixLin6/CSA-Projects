package Pong;
import java.awt.Rectangle;

public class Ball extends Rectangle{
	public int radius;
    private double dx = 5;
	private double dy = 5;
	
    public Ball(int radius) {
        super(200, 280, radius*2, radius*2);
        this.radius = radius;
    }
    
    public void checkDir(boolean contact) {
		double upperEdge = this.getCenterY()-radius;
		double lowerEdge = this.getCenterY()+radius;

    	if((int)upperEdge<=0 || (int)lowerEdge>=PongRunner.getMaxWindowY()) {
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
