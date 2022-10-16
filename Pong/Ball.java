package Pong;
import java.awt.Rectangle;

public class Ball extends Rectangle{
	private int radius;
    private double dx = 20;
	private double dy = -20;

	private double leftEdge = this.getCenterX()-radius;
	private double rightEdge = this.getCenterX()+radius;
	private double upperEdge = this.getCenterY()-radius;
	private double lowerEdge = this.getCenterY()+radius;
	
    public Ball(int radius) {
        super(200, 300, radius*2, radius*2);
        this.radius = radius;
    }
    
    public void checkDir() {
    	if((int)upperEdge<=199 || (int)lowerEdge>=PongRunner.getMaxWindowY()) {
			dx *= -1;
			dy *= -1;
		}
    }
    
    public void update(){
    	this.checkDir();
		try {
			Thread.sleep(100);
		} catch(InterruptedException e) {
			System.out.println("got interrupted!");
		}
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
