package Breakout;
import utilities.DemoObjects.*;
import utilities.*;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;



public class Breakout extends GDV5 {

    private int level = 1;
    private Brick[][] bricks;
    private Paddle pad = new Paddle(120, 15);
    private Scoreboard score = new Scoreboard(0, 100);
    private Ball ball;
    private KeyboardInput game;
    private BreakoutDemo demo = new BreakoutDemo();
    private int gameState = 0;
    private static boolean lost = false;
    private boolean poweredUp = false;
    private int powerup = 0;
    private int count = 0;


    public Breakout() {
        super();
        bricks = Brick.makeBricks(level);
        ball = new Ball(12, 6, score, lost);
        game  = new KeyboardInput(pad, ball);
    }

    public static void lost(){
        Breakout.lost = true;
    }

    public void newPowerup(int x){
        powerup = x;
    }

    public static void playSound(String name) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("utilities/" + name);
		AudioInputStream audioStream  = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}

    public void checkGameState(){
        //Game states: 0 == Cover, 1 == Pause, 2 == Game, 3 == Transition, 4 == Winning screen, 5 == Losing screen

        //Start game
        if(gameState==0 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
        }
        //Pause
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_ESCAPE])){
            gameState=2;
        }
        //Quit
        else if(gameState==2 && (Breakout.KeysPressed[KeyEvent.VK_Q])){
            gameState=0;
        }
        //Resume
        else if(gameState==2 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
        }
        //Transition
        else if(gameState==1 && this.score.getScore()==Brick.numBricks()){
            gameState=3; 
            this.level++; 
            this.bricks = Brick.makeBricks(level);
        }
        //Continue to next level
        else if(gameState==3 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
            score.resetScore();
        }
        //Won
        else if(gameState==1 && this.level==10){
            gameState=4; 
            score.resetScore();
        }
        //Lost
        else if(gameState==1 && lost){
            gameState=5; 
            score.resetScore(); 
            lost = false;
        }
        //Cheat
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_P])){
            score.setScore(Brick.numBricks());
        }
        //Return to Cover
        else if((gameState==4 || gameState==5) && (Breakout.KeysPressed[KeyEvent.VK_SPACE])){
            level = 1;
            this.bricks = Brick.makeBricks(level);
            this.demo = new BreakoutDemo();
            gameState=0;
        }
    }
    
    //Powerups: 1 == Telekinesis, 2 == Speed up paddle, 3 == Slow down ball
    public void enactPowerup(int x){
        if(x==1){
            game.activateTelekinesis();
            System.out.println("Telekinesis");
        }
        else if(x==1){
            pad.setSpeed((int)(pad.getSpeed()*1.5));
            System.out.println("Pad speed up");
        }
        else if(x==3){
            ball.setSpeed((int)(ball.getSpeed()*0.5));
            System.out.println("Ball speed down");
        }
        poweredUp = true;
    }

    public void stopPowerup(int x){
        if(x==1){
            game.deactivateTelekinesis();
            System.out.println("Telekinesis deactivated");
        }
        else if(x==2){
            ball.setSpeed((int)(ball.getSpeed()*2/3));
            System.out.println("Pad sped down");
            
        }
        else if(x==3){
            ball.setSpeed((int)(ball.getSpeed()*2));
            System.out.println("Ball sped back up");
        }
        powerup = 0;
        poweredUp = false;
    }

    public void timer(){
        if(count==300){
            stopPowerup(powerup);
            count = 0;
        }
        else if(poweredUp){
            count++;
        }
    }

    public static void main(String[] args) {
        Brick.decodePalette(ColorPalettes.palette2);
        Breakout runner = new Breakout(); 
        runner.start();
        
    }

    public void update() { //60 frames per second
        this.checkGameState();
        if(gameState==0){
            demo.update();
        }
        else if(gameState==1){
            for(Brick[] row: bricks){
                for(Brick b: row){
                    b.update(pad, poweredUp, this);
                }
            }
            game.updatePads(Breakout.KeysPressed);
            game.telekBall(Breakout.KeysPressed);
            ball.update(ball.intersects(pad), bricks);
            timer();
        }
    }

    @Override
    public void draw(Graphics2D win) {
        if (gameState==0){
            Interfaces.drawCover(win, demo);
        }
        else if(gameState==1){
            Interfaces.drawGame(win, bricks, pad, ball, score, Integer.toString((int)(count/60)));
        }
        else if(gameState==2){
            Interfaces.drawPauseScreen(win);
        }
        else if(gameState==3){
            Interfaces.drawTransition(win, level);
        }
        else if(gameState==4){
            Interfaces.drawWinScreen(win);
        }
        else if(gameState==5){
            Interfaces.drawLoseScreen(win);
        }
    }
}