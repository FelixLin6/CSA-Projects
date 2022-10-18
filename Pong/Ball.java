package Pong;
import java.awt.Rectangle;

public class Ball extends Rectangle{
	public int radius;
    private double dx = 4;
	private double dy = 4;
	Scoreboard s1;
	Scoreboard s2;
	
    public Ball(int radius, Scoreboard score1, Scoreboard score2) {
        super((int)(PongRunner.getMaxWindowX()/2), 280, radius*2, radius*2);
		this.s1 = score1;
		this.s2 = score2;
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

	public void updateScore(){
		double leftEdge = this.getCenterX()-radius;
		double rightEdge = this.getCenterX()+radius;

		try{
			if(rightEdge<0) {
				s2.update();
				Thread.sleep(1000);
				this.setLocation((int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()/2));
			}
			else if(leftEdge>PongRunner.getMaxWindowX()){
				s1.update();
				Thread.sleep(1000);
				this.setLocation((int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()/2));
			}
		}
		catch(InterruptedException e){
			System.out.println("error: InturruptedException");
		}
	}
    

    public void update(boolean contact){
		this.updateScore();
    	this.checkDir(contact);
    	this.setLocation((int)(this.getX()+dx), (int)(this.getY()+dy));
    }
}
