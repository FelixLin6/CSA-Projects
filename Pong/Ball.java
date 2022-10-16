package Pong;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ball extends Rectangle{
	private double angle = 45.0;
    private double dr = 10.0;
    private int width;
    private double dx = this.dr*Math.cos(this.angle);
	private double dy = this.dr*Math.sin(this.angle);
	
	private double leftEdge = this.getCenterX()-width/2;
	private double rightEdge = this.getCenterX()+width/2;
	private double upperEdge = this.getCenterY()+width/2;
	private double lowerEdge = this.getCenterY()-width/2;
	
    public Ball(int radius) {
        super(200, 300, radius*2, radius*2);
        this.width = radius*2;
    }
    
    public void checkDir() {
    	if((int)upperEdge<=0 || (int)lowerEdge>=PongRunner.getMaxWindowY()) {
    		if(dx>0&&dy>0) {this.angle = 360-(90-angle);}
    		else if (dx<0&&dy<0) {this.angle = angle-90;}
    		else {this.angle = 360%(angle+90);}
    	}
    }
    
    public void update() {

    	ArrayList<java.lang.Double> components = PongRunner.dir(this.angle, x, y);
    	this.dx = components.get(0);
    	this.dy = components.get(1);
    	this.checkDir();
    	this.move((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
