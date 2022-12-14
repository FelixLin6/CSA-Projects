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
    private Brick [] pills;
    private Paddle pad = new Paddle(120, 15);
    private Scoreboard score = new Scoreboard(0, 100);
    private Ball ball;
    private KeyboardInput game;
    private BreakoutDemo demo = new BreakoutDemo();
    private int gameState = 0;
    private static boolean lost = false;
    private boolean poweredUp = false;
    private int powerup;
    private int count = 0;



    public Breakout() {
        super();
        bricks = Brick.makeBricks(level);
        pills = Brick.makePills(Brick.numBricks());
        ball = new Ball(12, 6, score, pills, lost);
        game  = new KeyboardInput(pad, ball);
    }

    public static void lost(){
        Breakout.lost = true;
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
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_ESCAPE])){gameState=2;}
        //Quit
        else if(gameState==2 && (Breakout.KeysPressed[KeyEvent.VK_Q])){gameState=0;}
        //Resume
        else if(gameState==2 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){gameState=1;}
        //Transition
        else if(gameState==1 && this.score.getScore()==Brick.numBricks()){gameState=3; this.level++; this.bricks = Brick.makeBricks(level); this.pills = Brick.makePills(Brick.numBricks());System.out.println("HERE");}
        //Continue to next level
        else if(gameState==3 && (Breakout.KeysPressed[KeyEvent.VK_ENTER])){gameState=1; score.resetScore();}
        //Won
        else if(gameState==1 && this.level==10){gameState=4; score.resetScore();}
        //Lost
        else if(gameState==1 && lost){gameState=5; score.resetScore(); lost = false;}
        //Cheat
        else if(gameState==1 && (Breakout.KeysPressed[KeyEvent.VK_P])){score.setScore(Brick.numBricks());}
        //Return to Cover
        else if((gameState==4 || gameState==5) && (Breakout.KeysPressed[KeyEvent.VK_SPACE])){gameState=0;}
    }
    
    public void enactPowerup(int x){
        if(x==0){
            game.activateTelekinesis();
            System.out.println("Bro");
        }
        else if(x==1){
            pad.setSpeed((int)(pad.getSpeed()*1.5));
            System.out.println("That's");
        }
        else if(x==2){
            ball.setSpeed((int)(ball.getSpeed()*0.5));
            System.out.println("Crazy");
        }
        poweredUp = true;
    }

    public void stopPowerup(int x){
        if(x==0){
            game.deactivateTelekinesis();
        }
        else if(x==1){
            ball.setSpeed((int)(ball.getSpeed()*2/3));
        }
        else if(x==2){
            ball.setSpeed((int)(ball.getSpeed()*2));
        }
        powerup = 9;
        poweredUp = false;
    }

    public void updatePills(){
        for(Brick p: pills){
            if(p!=null && p.getActivationStatus()){
                p.moveDown();
                if(p.getY()>(int)getMaxWindowY()){
                    p.pop();
                }
                else if(p.intersects(pad) && !poweredUp){
                    p.pop();
                    powerup = p.powerup;
                    this.enactPowerup(p.powerup);
                }
            }
        }
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
            game.updatePads(Breakout.KeysPressed);
            game.telekBall(Breakout.KeysPressed);
            ball.update(ball.intersects(pad), bricks);
            updatePills();
            timer();
        }
    }

    @Override
    public void draw(Graphics2D win) {
        if (gameState==0){
            Interfaces.drawCover(win, demo);
        }
        else if(gameState==1){
            Interfaces.drawGame(win, bricks, pills, pad, ball, score, Integer.toString((int)(count/60)));
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