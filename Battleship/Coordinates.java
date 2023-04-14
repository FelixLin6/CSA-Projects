package Battleship;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        char row = (char) (this.y + 65);
        int col = this.x + 1;
        return row + "" + col;
    }
}
