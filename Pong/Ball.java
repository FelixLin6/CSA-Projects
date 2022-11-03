package Pong;
import java.awt.Rectangle;
import java.awt.Color;


public class Ball extends Rectangle{
	public int radius;
    private double dx;
	private double dy;
	private Color color = Color.yellow;
	Scoreboard s1;
	Scoreboard s2;
	
    public Ball(int radius, Scoreboard score1, Scoreboard score2){
        super((int)(PongRunner.getMaxWindowX()/2), 280, radius*2, radius*2);
		this.s1 = score1;
		this.s2 = score2;
        this.radius = radius;
		
    }
    
	public void setSpeed(int s){
		this.dx = s;
		this.dy = s;
	}

	public int getSpeed(){
		return (int)dx;
	}

	public int getDx(){
		return (int)this.dx;
	}

	public int getDy(){
		return (int)this.dy;
	}

	public Color getColor(){
		return this.color;
	}

	public void setColor(Color color){
		this.color = color;
	}

    public void checkDir(boolean contact){
		double upperEdge = this.getCenterY()-radius;
		double lowerEdge = this.getCenterY()+radius;

    	if((int)upperEdge<=0 || (int)lowerEdge>=PongRunner.getMaxWindowY()) {
			dy*=-1;
		}
		if(contact) {
			dx*=-1;
			try{
				PongRunner.playSound("Ping Pong Ball Hit.wav");
			}
			catch (Exception e){
				System.out.println(e);
			}
		}
    }

	public void updateScore(){
		double leftEdge = this.getCenterX()-radius;
		double rightEdge = this.getCenterX()+radius;
		if(rightEdge<0) {
			s2.update();
			this.setLocation((int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()/2));
		}
		else if(leftEdge>PongRunner.getMaxWindowX()){
			s1.update();
			this.setLocation((int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()/2));
		}
	}
    

    public void update(boolean contact){
		this.updateScore();
    	this.checkDir(contact);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
