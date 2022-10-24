package Pong;
import utilities.GDV5;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class PongRunner extends GDV5 {

    Paddle pad1 = new Paddle(0, 15, 125);
    Paddle pad2 = new Paddle(PongRunner.getMaxWindowX()-15, 15, 125);
    KeyboardInput game = new KeyboardInput(pad1, pad2);
    Scoreboard score1 = new Scoreboard(0);
    Scoreboard score2 = new Scoreboard(0);
    Ball ball = new Ball(12, score1, score2);
    int screen = 0;

    public PongRunner() {
        super();
    }

    public void checkScreen(){
        if(screen==0 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=2; ball.setSpeed(6);}
        else if(screen==2 && (PongRunner.KeysPressed[KeyEvent.VK_ESCAPE])){screen=3; ball.setSpeed(0);}
        else if(screen==3 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=2; ball.setSpeed(6);}
        else if(score1.getScore()==11){screen=4; ball.setSpeed(0); score1.resetScore();}
        else if(score2.getScore()==11){screen=5; ball.setSpeed(0); score2.resetScore();}
        else if((screen==4 || screen==5) && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=0;}
    }

    public static void main(String[] args) {
        PongRunner runner = new PongRunner(); 
        runner.start();
    }

    public void update() { //60 frames per second
        checkScreen();
        game.updatePads(PongRunner.KeysPressed);
        ball.update(ball.intersects(pad1) || ball.intersects(pad2));
    	// ball.update(pad1.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius) || pad2.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius));
    }

    @Override
    public void draw(Graphics2D win) {
        if(screen==0) {Interfaces.drawCover(win);}
        else if(screen==2) {Interfaces.drawGame(win, pad1, pad2, score1, score2, ball);}
        else if(screen==3) {Interfaces.drawPauseScreen(win);}
        else if(screen==4) {Interfaces.drawPlayer1WinScreen(win);}
        else if(screen==5) {Interfaces.drawPlayer2WinScreen(win);}
    }
}