package Breakout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Interfaces {

    public static void drawCover(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.PLAIN, Breakout.getMaxWindowX()*5/50));
        win.drawString("BREAKOUT", (int)(Breakout.getMaxWindowX()/2-210), (int)(Breakout.getMaxWindowY()/3-50));

        //draw grid
        win.drawLine((int)(Breakout.getMaxWindowX()/2), 0, (int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()));
        win.drawLine(0, (int)(Breakout.getMaxWindowY()/2), (int)(Breakout.getMaxWindowX()), (int)(Breakout.getMaxWindowY()/2));

        win.setFont(new Font("Courier", Font.PLAIN, 30));
        win.drawString("Press ENTER to start", (int)(Breakout.getMaxWindowX()/2-140), (int)(Breakout.getMaxWindowY()/2+200));
    }

    public static void drawGame(Graphics2D win, Paddle pad1, Paddle pad2, Ball ball) {
         //draw paddles 1 and 2
        win.setColor(Color.white);
        win.drawRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());
        win.fillRect((int)pad1.getX(),(int)pad1.getY(), (int)pad1.getWidth(), (int)pad1.getHeight());

        win.drawRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());
        win.fillRect((int)pad2.getX(),(int)pad2.getY(), (int)pad2.getWidth(), (int)pad2.getHeight());

        //draw net
        win.drawRect((int)(Breakout.getMaxWindowX()/2-5), 0, 10, (int)Breakout.getMaxWindowY());

        //draw ball
        win.setColor(ball.getColor());
        win.drawOval((int)ball.getX(),(int)ball.getY(), (int)ball.getWidth(), (int)ball.getHeight());
        win.fillOval((int)ball.getX(), (int)ball.getY(), 25, 25);
    }

    public static void drawPauseScreen(Graphics2D win) {
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Paused", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()-100));
    }

    public static void drawPlayer1WinScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Player 1 Wins!", (int)(Breakout.getMaxWindowX()/4), (int)(Breakout.getMaxWindowY()/2));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press SPACE to play again!", (int)(Breakout.getMaxWindowX()/4), (int)(Breakout.getMaxWindowY())*3/4);
    }

    public static void drawPlayer2WinScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Player 2 Wins!", (int)(Breakout.getMaxWindowX()/4), (int)(Breakout.getMaxWindowY()/2));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press SPACE to play again!", (int)(Breakout.getMaxWindowX()/4), (int)(Breakout.getMaxWindowY()*3/4));
    }
}
