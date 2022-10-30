package Pong;
import utilities.DemoObjects.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Interfaces {

    public static void drawCover(Graphics2D win, DemoPaddle demoPad1, DemoPaddle demoPad2, DemoBall demoBall, int x, int y, int winWidth, int winHeight, Rectangle window){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.ITALIC, 100));
        win.drawString("PONG", (int)(PongRunner.getMaxWindowX()/2-142), (int)(PongRunner.getMaxWindowY()/3-50));
        win.drawLine((int)(PongRunner.getMaxWindowX()/2), 0, (int)(PongRunner.getMaxWindowX()/2), (int)(PongRunner.getMaxWindowY()));
        win.drawLine(0, (int)(PongRunner.getMaxWindowY()/2), (int)(PongRunner.getMaxWindowX()), (int)(PongRunner.getMaxWindowY()/2));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        win.drawString("Press any key to start", (int)(PongRunner.getMaxWindowX()/2-92), (int)(PongRunner.getMaxWindowY()/2+350));
        
        //draw demo window
        win.drawRect((int)window.getX(), (int)window.getY(),(int)window.getWidth(), (int)window.getHeight());
        

        //demo pads
        win.drawRect((int)demoPad1.getX(),(int)demoPad1.getY(), (int)demoPad1.getWidth(), (int)demoPad1.getHeight());
        win.fillRect((int)demoPad1.getX(),(int)demoPad1.getY(), (int)demoPad1.getWidth(), (int)demoPad1.getHeight());

        win.drawRect((int)demoPad2.getX(),(int)demoPad2.getY(), (int)demoPad2.getWidth(), (int)demoPad2.getHeight());
        win.fillRect((int)demoPad2.getX(),(int)demoPad2.getY(), (int)demoPad2.getWidth(), (int)demoPad2.getHeight());

        //draw demo net
        int netWidth = 4;
        win.drawRect(x+winWidth/2-2, y, netWidth, winHeight);

        //draw demo ball
        win.setColor(Color.blue);
        win.drawOval((int)demoBall.getX(),(int)demoBall.getY(), (int)demoBall.getWidth(), (int)demoBall.getHeight());
        win.fillOval((int)demoBall.getX(), (int)demoBall.getY(), 14, 14);
    }

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
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Paused", (int)(PongRunner.getMaxWindowX()/9), (int)(PongRunner.getMaxWindowY()-100));
    }

    public static void drawPlayer1WinScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Player 1 Wins!", (int)(PongRunner.getMaxWindowX()/4), (int)(PongRunner.getMaxWindowY()/2));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press enter to play again!", (int)(PongRunner.getMaxWindowX()/4), (int)(PongRunner.getMaxWindowY())*3/4);
    }

    public static void drawPlayer2WinScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Player 2 Wins!", (int)(PongRunner.getMaxWindowX()/4), (int)(PongRunner.getMaxWindowY()/2));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press enter to play again!", (int)(PongRunner.getMaxWindowX()/4), (int)(PongRunner.getMaxWindowY()*3/4));
    }
}
