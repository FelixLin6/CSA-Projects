package Pong;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



public class PongRunner extends GDV5 {

    Paddle pad1 = new Paddle(0, 15, 200);
    Paddle pad2 = new Paddle(PongRunner.getMaxWindowX()-15, 15, 200);
    KeyboardInput game = new KeyboardInput(pad1, pad2);
    Scoreboard score1 = new Scoreboard(0);
    Scoreboard score2 = new Scoreboard(0);
    Ball ball = new Ball(12, score1, score2);


    public PongRunner() {
        super();
    }

    public static void main(String[] args) {
        PongRunner runner = new PongRunner(); 
        runner.start();
    }

    public void update() { //60 frames per second
        game.updatePads(PongRunner.KeysPressed);
        ball.update(ball.intersects(pad1) || ball.intersects(pad2));
    	// ball.update(pad1.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius) || pad2.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius));
    }

    @Override
    public void draw(Graphics2D win) {
         //draw paddles 1 and 2
        win.setColor(Color.white);
        win.drawRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());
        win.fillRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());

        win.drawRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());
        win.fillRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());

        //draw net
        win.drawRect((int)(PongRunner.getMaxWindowX()/2-5), 0, 10, (int)PongRunner.getMaxWindowY());

        //scores 1 and 2
        win.setFont(new Font("TimesRoman", Font.PLAIN, 70));
        win.drawString(score1.getScoreStr(), (int)(PongRunner.getMaxWindowX()/4), (int)(PongRunner.getMaxWindowY()/2));
        win.drawString(score2.getScoreStr(), (int)(PongRunner.getMaxWindowX()*3/4), (int)(PongRunner.getMaxWindowY()/2));

        //draw ball
        win.setColor(Color.blue);
        win.drawOval((int)ball.getX(),(int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.fillOval((int)ball.getX(), (int)ball.getY(), 25, 25);
    }

}