package Snake;

import utilities.GDV5;
import java.awt.Graphics2D;


public class Game extends GDV5{

    private Snake s = new Snake();
    private int count = 0;

    public static void main(String[] args){
        Board.makeBoard();
        Game g = new Game();
        g.start();
    }

    @Override
    public void update(){
        count ++;
        s.headSetDirection();
        if(count%10==0){
            s.bodyGetDirection();
            s.move();
        }
    }

    @Override
    public void draw(Graphics2D win){
        Board.drawBoard(win);
        s.draw(win);
    }
}
