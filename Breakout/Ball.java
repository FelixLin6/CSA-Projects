package Breakout;
import java.awt.Color;
import java.awt.Rectangle;
import java.lang.Math;
import java.awt.Graphics2D;


public class Ball extends Rectangle{
	public int radius;
    private double dx;
	private double dy;
	private Color col = Color.yellow;

	public Ball(int radius){
        super((int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()/2), radius*2, radius*2);
        this.radius = radius;
    }

    public Ball(int radius, int speed){
        super((int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()/2), radius*2, radius*2);
        this.radius = radius;
		this.dx = speed;
		this.dy = speed;
    }
    
	public void setSpeed(int s){
		this.dx = s;
		this.dy = s;
	}

	public Color getColor(){
		return col;
	}

	public void draw(Graphics2D pb){
		pb.setColor(col);
        pb.drawOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
		pb.fillOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
	}

public void checkDir(boolean contact){
	double upperEdge = this.getCenterY()-radius;
	double lowerEdge = this.getCenterY()+radius;
	double leftEdge = this.getCenterX()-radius;
	double rightEdge = this.getCenterX()+radius;

	if((int)leftEdge<=0) {
		dx=Math.abs(dx);
	}
	else if((int)rightEdge>=Breakout.getMaxWindowX()){
		dx = -1*Math.abs(dx);
	}
	else if((int)upperEdge<=0){
		dy = Math.abs(dy);
	}
	else if((int)lowerEdge>=Breakout.getMaxWindowY()){
		dy=-1*Math.abs(dy);
	}
	else if(contact) {
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
