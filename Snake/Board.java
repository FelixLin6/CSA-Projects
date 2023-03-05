package Snake;

import java.awt.Graphics2D;

public class Board {
    static Tile[][] board;

    public static void makeBoard(){
        int rows = 40;
        int cols = 60;
        board = new Tile[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                board[i][j] = new Tile(j*20, i*20);
            }
        }
    }

    public static void drawBoard(Graphics2D pb){
        for(Tile[] row: board){
            for(Tile t: row){
                t.draw(pb);
            }
        }
    }

}
