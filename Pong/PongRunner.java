package Pong;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;



public class PongRunner extends GDV5 {

    Ball ball = new Ball(12);
    Paddle pad1 = new Paddle(0, 15, 200);
    Paddle pad2 = new Paddle(PongRunner.getMaxWindowX()-15, 15, 200);
    KeyboardInput game = new KeyboardInput(pad1, pad2);


    public PongRunner() {
        super();
    }

    public static void main(String[] args) {
        PongRunner runner = new PongRunner(); 
        runner.start();
        runner.update();
    }

    public void update() { //60 frames per second
        game.updatePads(PongRunner.KeysPressed);
    	ball.update(pad1.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius) || pad2.checkContact((int)ball.getY(), ball.getCenterX()-ball.radius, ball.getCenterX()+ball.radius));
    }

    @Override
    public void draw(Graphics2D win) {
        //draw paddles 1 and 2
        win.setColor(Color.white);
        win.drawRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());
        win.fillRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());

        win.drawRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());
        win.fillRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());

        //draw ball
        win.setColor(Color.red);
        win.drawOval((int)ball.getX(),(int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.setColor(Color.blue);
        win.fillOval((int)ball.getX(), (int)ball.getY(), 25, 25);
    }

}