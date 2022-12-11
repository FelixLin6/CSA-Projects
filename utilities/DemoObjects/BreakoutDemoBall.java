package utilities.DemoObjects;
import Breakout.Breakout;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Rectangle;
import java.lang.Math;
import java.awt.Graphics2D;


public class BreakoutDemoBall extends Rectangle{
	public int radius;
    private double dx = 3;
	private double dy = 3;
	private double upperBound;
	private double lowerBound;
	private double leftBound;
	private double rightBound;
	private Color col = Color.white;

	public BreakoutDemoBall(int radius, int xCord, int yCord, int winWidth, int winHeight){
        super(xCord+winWidth/2, yCord+winHeight/2, radius*2, radius*2);
        this.radius = radius;
		this.upperBound = yCord;
		this.lowerBound = yCord + winHeight;
		this.leftBound = xCord;
		this.rightBound = xCord + winWidth;
    }

	public void draw(Graphics2D pb){
		pb.setColor(col);
        pb.drawOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
		pb.fillOval((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
	}

	public void collideBricks(DemoBrick[][] bricks){
		for(DemoBrick[] row: bricks){
			for(DemoBrick brick: row) {
				if(this.intersects(brick)) {
					int direction = GDV5.collisionDirection(brick, this, (int)this.dx, (int)this.dy);
					if(direction == 0 || direction == 2) {
						dx = -dx;
					} 
					else {
						dy = -dy;
					}
					brick.pop();
				}
			}
		}
	}

    public void checkDir(boolean contact){
		double upperEdge = this.getCenterY()-radius;
		double lowerEdge = this.getCenterY()+radius;
		double leftEdge = this.getCenterX()-radius;
		double rightEdge = this.getCenterX()+radius;
	
		if((int)leftEdge<=leftBound) {
			dx=Math.abs(dx);
		}
		else if((int)rightEdge>=rightBound){
			dx = -1*Math.abs(dx);
		}
		else if((int)upperEdge<=upperBound){
			dy = Math.abs(dy);
		}
		else if((int)lowerEdge>=lowerBound){
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

    public void update(boolean contact, DemoBrick[][] bricks){
    	this.checkDir(contact);
		this.collideBricks(bricks);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
