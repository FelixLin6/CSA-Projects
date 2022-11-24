package Breakout;
import java.awt.Rectangle;
import java.awt.Color;
import java.lang.Math;


public class Ball extends Rectangle{
	public int radius;
    private double dx;
	private double dy;
	

    public Ball(int radius){
        super((int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()/2), radius*2, radius*2);
        this.radius = radius;

    }
    
	public void setSpeed(int s){
		this.dx = s;
		this.dy = s;
	}


public void checkDir(boolean contact){
	double leftEdge = this.getCenterY()-radius;
	double rightEdge = this.getCenterY()+radius;

	if((int)leftEdge==0 || (int)rightEdge==Breakout.getMaxWindowX()) {
		dx*=-1;
	}
	if(contact) {
		dy=-1*Math.abs(dy);
		try{
		Breakout.playSound("Ping Pong Ball Hit.wav");}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

    public void update(boolean contact){
    	this.checkDir(contact);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
