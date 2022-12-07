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
    private Scoreboard score = new Scoreboard(0, level, 100);
    private Ball ball = new Ball(12, 0, score);
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

    public void checkgameState(){
        if(gameState==0 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
            ball.setSpeed(6);
        }
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_ESCAPE])){gameState=2; ball.setSpeed(0);}
        else if(gameState==3 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){gameState=2; ball.setSpeed(speed);}
        else if(score1.getScore()==11){gameState=4; ball.setSpeed(0); score1.resetScore();}
        else if(score2.getScore()==11){gameState=5; ball.setSpeed(0); score2.resetScore();}
        else if((gameState==4 || gameState==5) && (Breakout.KeysPressed[KeyEvent.VK_SPACE])){
            gameState=0;
            this.demoBall = new DemoBall(7, demoY, demoY+demoH, demoX, demoY, demoW, demoH);
            this.demoPad1 = new DemoPaddle(demoX, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);
            this.demoPad2 = new DemoPaddle(demoX+demoW-3, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);
        }
    }
    
    public static void main(String[] args) {
        Brick.decodePalette(ColorPalettes.palette2);
        Breakout runner = new Breakout(); 
        runner.start();
    }

    public void update() { //60 frames per second
        game.updatePads(Breakout.KeysPressed);
        ball.update(ball.intersects(pad), bricks);
    }

    @Override
    public void draw(Graphics2D win) {
        // if (gameState==0){
        //     Interfaces.drawCover(win, null, null, null, ALLBITS, ABORT, WIDTH, HEIGHT, ball);
        // }
        if(gameState==1){
        for(Brick[] row:bricks){
            for(Brick b: row){
            b.draw(win);
            }
        }
        pad.draw(win);
        ball.draw(win);
        score.draw(win);
        }
    }
}