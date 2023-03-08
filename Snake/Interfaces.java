package Snake;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import utilities.GDV5;

public class Interfaces {
    public static void drawCover(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.ITALIC, Game.getMaxWindowX()*4/50));
        win.drawString("Snake", (int)(Game.getMaxWindowX()/2-75), (int)(Game.getMaxWindowY()/3-100));

        //draw grid
        // win.drawLine((int)(Game.getMaxWindowX()/2), 0, (int)(Game.getMaxWindowX()/2), (int)(Game.getMaxWindowY()));
        // win.drawLine(0, (int)(Game.getMaxWindowY()/2), (int)(Game.getMaxWindowX()), (int)(Game.getMaxWindowY()/2));

        win.setFont(new Font("Courier", Font.PLAIN, 30));
        win.drawString("Press ENTER to start", (int)(Game.getMaxWindowX()/2-150), (int)(Game.getMaxWindowY()*3/4));
        

        //draw win condition
        win.setFont(new Font("Courier", Font.PLAIN, 20));
        win.drawString("Eat as many apples as you can before it bumps into itself or the wall", (int)(GDV5.getMaxWindowX())-(int)(GDV5.getMaxWindowX())+3, (int)(GDV5.getMaxWindowY())/2-40);
        win.drawString("The speediness of your snake increases as you eat more apples", (int)(GDV5.getMaxWindowX())-(int)(GDV5.getMaxWindowX())+22, (int)(GDV5.getMaxWindowY())/2);
        win.drawString("Eat PILLS to slow down your snake", (int)(GDV5.getMaxWindowX())/4-5, (int)(GDV5.getMaxWindowY())/2+40);
        win.drawString("Don't run into the bombs!", (int)(GDV5.getMaxWindowX())/3-10, (int)(GDV5.getMaxWindowY())/2+80);

        //  //draw controls
         win.drawString("Control your snake with: ↑, ↓, ←, →", (int)(GDV5.getMaxWindowX())/2-150, (int)(GDV5.getMaxWindowY())/2+120);
    }

    public static void drawCover1(Graphics2D win){
        win.setColor(Color.white);
        win.setFont(new Font("Courier", Font.PLAIN, Game.getMaxWindowX()*5/50));
        win.drawString("Snake", (int)(Game.getMaxWindowX()/2-210), (int)(Game.getMaxWindowY()/3-50));

        //draw grid
        win.drawLine((int)(Game.getMaxWindowX()/2), 0, (int)(Game.getMaxWindowX()/2), (int)(Game.getMaxWindowY()));
        win.drawLine(0, (int)(Game.getMaxWindowY()/2), (int)(Game.getMaxWindowX()), (int)(Game.getMaxWindowY()/2));

        win.setFont(new Font("Courier", Font.PLAIN, 30));
        win.drawString("Press ENTER to start", (int)(Game.getMaxWindowX()/2-140), (int)(Game.getMaxWindowY()/2));
    }

    public static void drawPauseScreen(Graphics2D win) {
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Paused", (int)(Game.getMaxWindowX()/9), (int)(Game.getMaxWindowY()/2)+60);
        //options
        win.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        win.drawString("Resume (ENTER)", (int)(Game.getMaxWindowX()/9), (int)(Game.getMaxWindowY()/2+150));
        win.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        win.drawString("Quit (Q)", (int)(Game.getMaxWindowX()/9), (int)(Game.getMaxWindowY()/2+200));
    }

    public static void drawEndScreen(Graphics2D win, Scoreboard score){
        win.setColor(Color.white);
        win.setFont(new Font("TimesRoman", Font.PLAIN, 80));
        win.drawString("Score: " + Scoreboard.getScore(), (int)(Game.getMaxWindowX()/9), (int)(Game.getMaxWindowY()/2+60));

        win.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        win.drawString("Press SPACE to play again!", (int)(Game.getMaxWindowX()/9), (int)(Game.getMaxWindowY()*3/4));
    }
}
