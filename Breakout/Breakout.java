package Breakout;
import utilities.GDV5;
import java.awt.Graphics2D;
import utilities.ColorPalettes;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;



public class Breakout extends GDV5 {

    private int level = 1;
    private Brick[][] bricks;
    private Paddle pad = new Paddle(120, 15);
    private KeyboardInput game = new KeyboardInput(pad);
    private Scoreboard score = new Scoreboard(0, 100);
    private int speed;
    private Ball ball = new Ball(12, speed, score);
    private int gameState = 0;
    


    public Breakout() {
        super();
        bricks = Brick.makeBricks(level);
    }

    public static void playSound(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("utilities/" + name);
		AudioInputStream audioStream  = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}

    public void checkGameState(){
        if(gameState==0 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
            ball.setSpeed(6);
        }
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_ESCAPE])){gameState=2; this.speed = ball.getSpeed(); ball.setSpeed(0);}
        else if(gameState==2 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){gameState=1; ball.setSpeed(this.speed);}
        else if(gameState==1 && this.score.getScore()==Brick.numBricks()){gameState=3; ball.setSpeed(0); score.resetScore();}
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_P])){score.setScore(Brick.numBricks());}
        else if((gameState==3) && (Breakout.KeysPressed[KeyEvent.VK_SPACE])){gameState=0;}
    }
    
    public static void main(String[] args) {
        Brick.decodePalette(ColorPalettes.palette2);
        Breakout runner = new Breakout(); 
        runner.start();
    }

    public void update() { //60 frames per second
        this.checkGameState();
        game.updatePads(Breakout.KeysPressed);
        ball.update(ball.intersects(pad), bricks);
    }

    @Override
    public void draw(Graphics2D win) {
        if (gameState==0){
            Interfaces.drawCover(win);
        }
        else if(gameState==1){
            for(Brick[] row:bricks){
                for(Brick b: row){
                b.draw(win);
                }
            }
            pad.draw(win);
            ball.draw(win);
            score.draw(win);
        }
        else if(gameState==2){
            Interfaces.drawPauseScreen(win);
        }
        else if(gameState==3){
            Interfaces.drawPlayer1WinScreen(win);
        }
    }
}