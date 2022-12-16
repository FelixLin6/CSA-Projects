package Breakout;
import utilities.DemoObjects.BreakoutDemo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Interfaces {
    public static void drawCover(Graphics2D win, BreakoutDemo demo){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.PLAIN, Breakout.getMaxWindowX()*4/50));
        win.drawString("BREAKOUT", (int)(Breakout.getMaxWindowX()/2-260), (int)(Breakout.getMaxWindowY()/3-100));

        //draw grid
        win.drawLine((int)(Breakout.getMaxWindowX()/2), 0, (int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()));
        win.drawLine(0, (int)(Breakout.getMaxWindowY()/2), (int)(Breakout.getMaxWindowX()), (int)(Breakout.getMaxWindowY()/2));

        win.setFont(new Font("Courier", Font.PLAIN, 30));
        win.drawString("Press ENTER to start", (int)(Breakout.getMaxWindowX()/2-150), (int)(Breakout.getMaxWindowY()*3/4+130));
        

        //draw win condition
        win.setFont(new Font("Courier", Font.PLAIN, 20));
        win.drawString("Shoot down all the bricks in each level to win", (int)(demo.getWinX()), (int)(demo.getWinY()-110));
        win.drawString("The # of layers increases as the level increases", (int)(demo.getWinX()), (int)(demo.getWinY()-80));
        win.drawString("Take pills to recieve 5-second powerups", (int)(demo.getWinX()), (int)(demo.getWinY()-50));
        win.drawString("Lose if you miss the ball's rebound!", (int)(demo.getWinX()), (int)(demo.getWinY()-20));

         //draw controls
         win.drawString("Paddle controls: ←, →", (int)(Breakout.getMaxWindowX()*0.5+100), (int)(demo.getWinY()-110));
         win.drawString("Three powerups:", (int)(Breakout.getMaxWindowX()*0.5+100), (int)(demo.getWinY()-50));
         win.drawString("[Telekinesis] Controls: W, A, S, D", (int)(Breakout.getMaxWindowX()*0.5+100), (int)(demo.getWinY()-20));
         win.drawString("[Speed up your paddle]", (int)(Breakout.getMaxWindowX()*0.5+100), (int)(demo.getWinY()+10));
         win.drawString("[Speed down the ball]", (int)(Breakout.getMaxWindowX()*0.5+100), (int)(demo.getWinY()+40));
         

        //draw demo 
        demo.draw(win);
    }

    public static void drawCover1(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.PLAIN, Breakout.getMaxWindowX()*5/50));
        win.drawString("BREAKOUT", (int)(Breakout.getMaxWindowX()/2-210), (int)(Breakout.getMaxWindowY()/3-50));

        //draw grid
        win.drawLine((int)(Breakout.getMaxWindowX()/2), 0, (int)(Breakout.getMaxWindowX()/2), (int)(Breakout.getMaxWindowY()));
        win.drawLine(0, (int)(Breakout.getMaxWindowY()/2), (int)(Breakout.getMaxWindowX()), (int)(Breakout.getMaxWindowY()/2));

        win.setFont(new Font("Courier", Font.PLAIN, 30));
        win.drawString("Press ENTER to start", (int)(Breakout.getMaxWindowX()/2-140), (int)(Breakout.getMaxWindowY()/2));
    }

    public static void drawGame(Graphics2D win, Brick[][] bricks, Paddle pad, Ball ball, Scoreboard score, String timer) {
        for(Brick[] row:bricks){
            for(Brick b: row){
                b.draw(win);
                if(b.getPill().isActive()){
                    b.getPill().draw(win);
                }
            }
        }
        pad.draw(win);
        ball.draw(win);
        score.draw(win);
        win.setFont(new Font("Courier", Font.PLAIN, 20));
        win.drawString(timer, (int)(Breakout.getMaxWindowX()+40), (int)(Breakout.getMaxWindowY()-40));
    }

    public static void drawPauseScreen(Graphics2D win) {
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Paused", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2)+60);
        //options
        win.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        win.drawString("Resume (ENTER)", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2+150));
        win.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        win.drawString("Quit (Q)", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2+200));
    }

    public static void drawTransition(Graphics2D win, int level){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Level cleared!", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2+60));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press ENTER to continue into: LEVEL " + level, (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY())*3/4);
    }

    public static void drawWinScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("You won!", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2+60));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press SPACE to play again!", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()*3/4));
    }

    public static void drawLoseScreen(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("You lost :(", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()/2+60));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        win.drawString("Press SPACE to play again!", (int)(Breakout.getMaxWindowX()/9), (int)(Breakout.getMaxWindowY()*3/4));
    }
}
