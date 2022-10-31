package Pong;
import utilities.GDV5;
import utilities.DemoObjects.*;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.lang.Math;



public class PongRunner extends GDV5 {

    Paddle pad1 = new Paddle(0, 15, 125);
    Paddle pad2 = new Paddle(PongRunner.getMaxWindowX()-15, 15, 125);
    KeyboardInput game = new KeyboardInput(pad1, pad2);
    Scoreboard score1 = new Scoreboard(0);
    Scoreboard score2 = new Scoreboard(0);
    Ball ball = new Ball(12, score1, score2);
    int screen = 0;
    int count = 0;
    int speed;

    //demo objects on splash/menu screen, a demo of the game will be displayed in a 360x240 window placed at (40, 350)
    int demoX = 40;
    int demoY = 350;
    int demoW = 374;
    int demoH = 254 ;   
    Rectangle window = new Rectangle(demoX, demoY, demoW, demoH);
    DemoBall demoBall = new DemoBall(7, demoY, demoY+demoH, demoX, demoY, demoW, demoH);
    DemoPaddle demoPad1 = new DemoPaddle(demoX, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);
    DemoPaddle demoPad2 = new DemoPaddle(demoX+demoW-3, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);

    public PongRunner() {
        super();
    }

    public void checkScreen(){
        if(screen==0 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){
            screen=2;
            ball.setSpeed(6);
            demoBall = null;
            demoPad1 = null;
            demoPad2 = null;
        }
        else if(screen==2 && (PongRunner.KeysPressed[KeyEvent.VK_ESCAPE])){screen=3; speed = ball.getSpeed(); ball.setSpeed(0);}
        else if(screen==3 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=2; ball.setSpeed(speed);}
        else if(score1.getScore()==11){screen=4; ball.setSpeed(0); score1.resetScore();}
        else if(score2.getScore()==11){screen=5; ball.setSpeed(0); score2.resetScore();}
        else if((screen==4 || screen==5) && (PongRunner.KeysPressed[KeyEvent.VK_SPACE])){
            screen=0;
            this.demoBall = new DemoBall(7, demoY, demoY+demoH, demoX, demoY, demoW, demoH);
            this.demoPad1 = new DemoPaddle(demoX, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);
            this.demoPad2 = new DemoPaddle(demoX+demoW-3, 3, 30, demoY, demoY+demoH, demoY, demoH, demoBall);
        }
    }

    public void smashBallQuestionMark(boolean a, boolean b, boolean[] keysPressed){
        if(a && Math.abs(ball.getSpeed())<9 && keysPressed[KeyEvent.VK_R]){
            ball.setSpeed((int)(ball.getSpeed()*1.5));
        }
        else if((a && Math.abs(ball.getSpeed())>2) && keysPressed[KeyEvent.VK_T]){
            ball.setSpeed((int)(ball.getSpeed()/1.5));
        }
        else if(b && Math.abs(ball.getSpeed())<9 && keysPressed[KeyEvent.VK_K]){
            ball.setSpeed((int)(ball.getSpeed()*1.5));
        }
        else if((b && Math.abs(ball.getSpeed())>2) && keysPressed[KeyEvent.VK_L]){
            ball.setSpeed((int)(ball.getSpeed()/1.5));
        }
    }

    public void checkColor(){
        if(Math.abs(ball.getSpeed())<6){ball.setColor(Color.BLUE);}
        else if(Math.abs(ball.getSpeed())==6){ball.setColor(Color.YELLOW);}
        else if(Math.abs(ball.getSpeed())>6){ball.setColor(Color.RED);}
    }

    public static void main(String[] args) {
        PongRunner runner = new PongRunner(); 
        runner.start();
    }

    public void update() { //60 frames per second
        if(screen==0){
            demoPad1.update();
            demoPad2.update();
            demoBall.update(demoBall.intersects(demoPad1) || demoBall.intersects(demoPad2)); 
        }
        checkScreen();
        game.updatePads(PongRunner.KeysPressed);
        smashBallQuestionMark(ball.intersects(pad1), ball.intersects(pad2), PongRunner.KeysPressed);
        checkColor();
        ball.update(ball.intersects(pad1) || ball.intersects(pad2));
    	// ball.update(pad1.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius) || pad2.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius));
    }

    @Override
    public void draw(Graphics2D win) {
        if(screen==0) {Interfaces.drawCover(win, demoPad1, demoPad2, demoBall, demoX, demoY, demoW, demoH, window);}
        else if(screen==2) {Interfaces.drawGame(win, pad1, pad2, score1, score2, ball);}
        else if(screen==3) {Interfaces.drawPauseScreen(win);}
        else if(screen==4) {Interfaces.drawPlayer1WinScreen(win);}
        else if(screen==5) {Interfaces.drawPlayer2WinScreen(win);}
    }
}