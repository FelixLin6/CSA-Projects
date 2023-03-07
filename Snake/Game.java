package Snake;

import utilities.GDV5;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.lang.Math;

public class Game extends GDV5{

    private int count = 0;
    private int songCount = 0;
    private Scoreboard score = new Scoreboard(100);
    private int gameState = 0;
    private static boolean lost = false;
    private static int index = 0;
    private static int[] dividends = {10, 5, 3};
    Images images = new Images();
    private Snake s = new Snake(this, images);
    static SoundDriverHo s1;

    public static void main(String[] args){
        String[] filenames = new String[2];
        filenames[0] = "apple_crunch.wav";
        filenames[1] = "8_bit_bgm.mp3";

        Board.makeBoard();
        Board.newApple((int)Math.random()*Board.rows, (int)Math.random()*Board.cols);
        Game g = new Game();
        s1 = new SoundDriverHo(filenames, g);
        g.start();
        s1.play(1);
    }

    public static void lost(){
        Game.lost = true;
    }
    
    public static void upLevel(){
        if(index < dividends.length-1 && Scoreboard.getScore()!=0 && Scoreboard.getScore()%10==0){
            index++;
            System.out.println("Level up");
        }
    }


    public void checkGameState(){
        //Game states: 0 == Home, 1 == Game, 2 == Pause, 3 == Ending screen
        //Start game
        if(gameState==0 && (Game.KeysPressed[KeyEvent.VK_ENTER])){
            s = new Snake(this, images);
            score.resetScore(); 
            count = 0;
            gameState=1;
            index = 0;
        }
        //Pause
        else if(gameState==1 && (Game.KeysPressed[KeyEvent.VK_ESCAPE])){
            gameState=2;
        }
        //Quit
        else if(gameState==2 && (Game.KeysPressed[KeyEvent.VK_Q])){
            gameState=0;
        }
        //Resume
        else if(gameState==2 && (Game.KeysPressed[KeyEvent.VK_ENTER])){
            gameState=1;
        }
        //Ending
        else if(gameState==1 && lost){
            gameState=3; 
            lost = false;
        }
        //Return to Cover
        else if((gameState==3) && (Game.KeysPressed[KeyEvent.VK_SPACE])){
            gameState=0;
        }
    }

    @Override
    public void update(){
        checkGameState();
        if(gameState==1){
            count ++;
            
            s.action();
            s.headSetDirection();
            if(count%dividends[index]==0){
                s.bodyGetDirection();
                try{
                    s.move();
                }
                catch(java.lang.ArrayIndexOutOfBoundsException e){
                    lost();
                }
            }
            // if(this.songCount%3900==0){
            //     s1.play(0);
            // }
            songCount++;
        }
    }

    @Override
    public void draw(Graphics2D win){
        if (gameState==0){//Home
            Interfaces.drawCover(win);
        }
        else if(gameState==1){//Game
            Board.drawBoard(win, images, this);
            s.draw(win);
            score.draw(win);
        }
        else if(gameState==2){//Pause
            Interfaces.drawPauseScreen(win);
        }
        else if(gameState==3){//Ending
            Interfaces.drawEndScreen(win, score);
        }
    }
}
