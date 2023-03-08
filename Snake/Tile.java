package Snake;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;

public class Tile extends Rectangle{

    private int row;
    private int col;
    private int direction;
    private Color color;
    private int dimension = 20;
    private boolean apple = false;
    private boolean pill = false;
    private boolean bomb = false;
    

    public Tile(int x, int y){
        super(x, y, 0, 0);
        this.setSize(dimension, dimension);
        color = new Color(44, 122, 81);
    }

    public Tile(int x, int y, boolean True){
        super(x, y, 0, 0);
        this.setSize(dimension, dimension);
        color = new Color(44, 122, 81);
        this.apple = true;
    }

    public Tile(int x, int y, String isPill){
        super(x, y, 0, 0);
        this.setSize(dimension, dimension);
        color = new Color(44, 122, 81);
        this.pill = true;
    }

    public Tile(int x, int y, int isBomb){
        super(x, y, 0, 0);
        this.setSize(dimension, dimension);
        color = new Color(44, 122, 81);
        this.bomb = true;
    }


    public Tile(int x, int y, Color color, int row, int col){
        super(x, y, 0, 0);
        this.setSize(dimension, dimension);
        this.color = color;
        this.row = row;
        this.col = col;
        this.direction = 2;
    }

    public void draw(Graphics2D pb){
        pb.setColor(color);
        pb.draw(this);
    }

     public void fill(Graphics2D pb){
        pb.setColor(color);
        pb.fill(this);
     }

     public void move(){
        if(direction == 0) {//right
            this.x += this.dimension;
            this.col++;
        }
        else if(direction == 1) {//up
            this.y -= this.dimension;
            this.row--;
        }
        else if(direction == 2) {//left
            this.x -= this.dimension;
            this.col--;;
        }
        else if(direction == 3) {//down
            this.y += this.dimension;
            this.row++;
        }
     }

    public void updateDirection(Tile[] board){
        for(int i = 0; i < board.length; i++){
            if(this.getX() == board[i].getX() && this.getY() == board[i].getY()){
                board[i].setDirection(this.getDirection());
            }
        }
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDimension() {
        return this.dimension;
    }

    public void setDimension(int size) {
        this.dimension = size;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isApple() {
        return this.apple;
    }

    public boolean isPill() {
        return this.pill;
    }

    public boolean getApple() {
        return this.apple;
    }

    public void setApple(boolean apple) {
        this.apple = apple;
    }

    public boolean getPill() {
        return this.pill;
    }

    public void setPill(boolean pill) {
        this.pill = pill;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public boolean getBomb() {
        return this.bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

}
