package Pong;
import utilities.GDV5;
import java.awt.Color;
import java.awt.Graphics2D;


public class PongRunner extends GDV5{

    Ball ball = new Ball(12);
    
    public static void main(String[] args) throws InterruptedException {
        PongRunner runner = new PongRunner();    
        runner.start();
        runner.update();
    }

    public void update() { //60 frames per second
        // TODO Auto-generated method club
    	ball.update();
    }

    @Override
    public void draw(Graphics2D win) {
        win.setColor(Color.red);
        win.drawOval((int)ball.getX(),(int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.setColor(Color.blue);
        win.fillOval((int)ball.getX(), (int)ball.getY(), 25, 25);
    }

}