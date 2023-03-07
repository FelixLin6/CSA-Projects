package Snake;

import java.awt.Graphics2D;
import java.lang.Math;

public class Board {
    static Tile[][] board;
    public static int rows;
    public static int cols;

    public static void makeBoard(){
        rows = 40;
        cols = 30;
        board = new Tile[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                board[i][j] = new Tile(j*20, i*20);
            }
        }
    }

    public static void newApple(int row, int col){
        int x = (int)board[row][col].getX(), y = (int)board[row][col].getY();
        board[row][col] = new Tile(x, y);
        int r = (int)(Math.random()*rows);
        int c = (int)(Math.random()*cols);
        x = (int)board[r][c].getX();
        y = (int)board[r][c].getY();
        board[r][c] = new Tile(x, y, true);
    }

    public static void newPill(int row, int col){
        int x = (int)board[row][col].getX(), y = (int)board[row][col].getY();
        board[row][col] = new Tile(x, y);
        int r = (int)(Math.random()*rows);
        int c = (int)(Math.random()*cols);
        x = (int)board[r][c].getX();
        y = (int)board[r][c].getY();
        board[r][c] = new Tile(x, y, true);
    }

    public static void drawBoard(Graphics2D pb, Images images, Game game){
        int width = 20, height = 20;
        for(Tile[] row: board){
            for(Tile t: row){
                if(t.isApple()){
                    pb.drawImage(images.apple1, (int)t.getX()-(width/2-10), (int)t.getY()-(height/2-10), width, height, game);
                }
                else{
                    t.fill(pb);
                }
            }
        }
    }
}
