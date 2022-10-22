package Pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Interfaces {

    public static void drawCover(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 100));
        win.drawString("PONG", (int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()/2));
    }

    public static void 


    public static void drawGame(Graphics2D win, Paddle pad1, Paddle pad2, Scoreboard score1, Scoreboard score2, Ball ball) {
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

    public static void drawPauseScreen(Graphics2D win) {
        win.setColor(Color.white);
        win.setFont(new Font("TimeRoman", Font.PLAIN, 80));
        win.drawString("Paused", (int)(PongRunner.getMaxWindowY()/4), (int)(PongRunner.getMaxWindowX()/2));
    }
}
