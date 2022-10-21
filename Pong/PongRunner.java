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
        if(screen==0 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=1; ball.setSpeed(6);}
        else if(screen==2 && (PongRunner.KeysPressed[KeyEvent.VK_ESCAPE])){screen=3; ball.setSpeed(0);}
        else if(screen==3 && (PongRunner.KeysPressed[KeyEvent.VK_ENTER])){screen=1; ball.setSpeed(6);}
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
    }
}