package Pong;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class PongRunner extends GDV5{
	
	public static ArrayList<Double> dir(double theta, double x, double y) {
		ArrayList<Double> xycomponents = new ArrayList<Double>();
		if(90<theta && theta<180){
			xycomponents.add(-x); 
			xycomponents.add(y);
			
		} 
		else if(0<theta && theta<90) {
			xycomponents.add(x);
			xycomponents.add(y);
		}
		else if(180<theta && theta<270) {
			xycomponents.add(-x);
			xycomponents.add(-y);
		}
		else if(270<theta && theta<360) {
			xycomponents.add(x);
			xycomponents.add(-y);
		}
		else if(theta==0 || theta==360 || theta==90) {
			xycomponents.add(x);
			xycomponents.add(y);
		}
		else if(theta==270) {
			xycomponents.add(-x);
			xycomponents.add(y);
		}
		else {
			xycomponents.add(x);
			xycomponents.add(-y);
		}
		return xycomponents;
	}
	
    Ball ball = new Ball(12);
    
    public static void main(String[] args) throws InterruptedException {
        PongRunner runner = new PongRunner();    
        runner.start();
        runner.update();
    }

    public void update() { //60 frames per second
        // TODO Auto-generated method club
    	ball.update();
    }

    @Override
    public void draw(Graphics2D win) {
        win.setColor(Color.red);
        win.drawOval((int)ball.getX(),(int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.setColor(Color.blue);
        win.fillOval((int)ball.getX(), (int)ball.getY(), 25, 25);
    }

}