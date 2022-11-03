package Pong;
import java.awt.Rectangle;
import java.awt.Color;

<<<<<<< Updated upstream
=======
import java.io.File;
import java.io.IOException;
import java.nio.channels.UnsupportedAddressTypeException;

import javax.sound.sampled.*;

>>>>>>> Stashed changes

public class Ball extends Rectangle{
	public int radius;
    private double dx;
	private double dy;
	private Color color = Color.yellow;
	Scoreboard s1;
	Scoreboard s2;
	AudioInputStream audioStream;
	Clip clip;
	
<<<<<<< Updated upstream
    public Ball(int radius, Scoreboard score1, Scoreboard score2){
=======
    public Ball(int radius, Scoreboard score1, Scoreboard score2) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
>>>>>>> Stashed changes
        super((int)(PongRunner.getMaxWindowX()/2), 280, radius*2, radius*2);
		this.s1 = score1;
		this.s2 = score2;
        this.radius = radius;
<<<<<<< Updated upstream
		
=======
		File file = new File("utilities/pingpong.wav");
		this.audioStream  = AudioSystem.getAudioInputStream(file);
		this.clip = AudioSystem.getClip();
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public void checkDir(boolean contact){
=======
    public void checkDir(boolean contact) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
>>>>>>> Stashed changes
		double upperEdge = this.getCenterY()-radius;
		double lowerEdge = this.getCenterY()+radius;

    	if((int)upperEdge<=0 || (int)lowerEdge>=PongRunner.getMaxWindowY()) {
			dy*=-1;
		}
		if(contact) {
			dx*=-1;
<<<<<<< Updated upstream
			try{
				PongRunner.playSound("Ping Pong Ball Hit.wav");
			}
			catch (Exception e){
				System.out.println(e);
			}
=======
			clip.open(audioStream);
			clip.start();
>>>>>>> Stashed changes
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
