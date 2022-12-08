package Breakout;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Rectangle;
import java.lang.Math;
import java.awt.Graphics2D;


public class Ball extends Rectangle{
	public int radius;
    private double dx;
	private double dy;
	private Color col = Color.white;
	private Scoreboard score;

	public Ball(int radius){
        super((int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()/2), radius*2, radius*2);
        this.radius = radius;
    }

    public Ball(int radius, int speed, Scoreboard score){
        super((int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()/2), radius*2, radius*2);
        this.radius = radius;
		this.dx = speed;
		this.dy = speed;
		this.score = score;
    }
    
	public void setSpeed(int s){
		this.dx = s;
		this.dy = s;
	}

	public void setColor(Color c){
		this.col = c;
	}
	
	public int getSpeed(){
		return (int)dx;
	}
	
	public Color getColor(){
		return col;
	}

	public void draw(Graphics2D pb){
		pb.setColor(col);
        pb.drawOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
		pb.fillOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
	}

	public void collideBricks(Brick[][] bricks){
		for(Brick[] row: bricks){
			for(Brick brick: row) {
				if(this.intersects(brick)) {
					int direction = GDV5.collisionDirection(brick, this, (int)this.dx, (int)this.dy);
					if(direction == 0 || direction == 2) {
						dx = -dx;
					} 
					else {
						dy = -dy;
					}
					brick.pop();
					score.update();
				}
			}
		}
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

    public void update(boolean contact, Brick[][] bricks){
    	this.checkDir(contact);
		this.collideBricks(bricks);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
