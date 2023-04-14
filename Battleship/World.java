package Battleship;

public class World {
    private Boat[][] map;
    
    public static final int NORTH = 0;
    public static final int NORTHEAST = 1;
    public static final int EAST = 2;
    public static final int SOUTHEAST = 3;
    public static final int SOUTH = 4;
    public static final int SOUTHWEST = 5;
    public static final int WEST = 6;
    public static final int NORTHWEST = 7;
    
    public static int width = 0;
    public static int height = 0;
    
    public World(int w, int h) {
        if (w < 4) {
            width = 4;
        } else if (w > 10) {
            width = 10;
        }
        if (h < 4) {
            height = 4;
        } else if (h > 10) {
            height = 10;
        }
        map = new Boat[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = null;
            }
        }
    }
    
    public int getWidth() {
        return map[0].length;
    }
    
    public int getHeight() {
        return map.length;
    }
    
    public Boat getOccupant(Coordinates c) {
        int x = c.getX();
        int y = c.getY();
        if (isLocationValid(c) && isLocationOccupied(c)) {
            return map[y][x];
        } else {
            return null;
        }
    }
    
    public boolean isLocationValid(Coordinates c) {
        int x = c.getX();
        int y = c.getY();
        int width = getWidth();
        int height = getHeight();
        return (x >= 0 && x < width && y >= 0 && y < height);
    }
    
    public boolean isLocationOccupied(Coordinates c) {
        return (getOccupant(c) != null);
    }
    
    public boolean setOccupant(Boat b, Coordinates c) {
        int x = c.getX();
        int y = c.getY();
        if (isLocationValid(c) && !isLocationOccupied(c)) {
            map[y][x] = b;
            return true;
        } else {
            return false;
        }
    }
    
    public Coordinates getAdjacentLocation(Coordinates c, int dir) {
        int x = c.getX();
        int y = c.getY();
        int dx = 0;
        int dy = 0;
        if(dir==NORTH){
            dy-=1;
        }
        else if(dir==NORTHEAST){
            dx = 1;
            dy = -1;
        }
        else if(dir==EAST){
            dx = 1;
        }
        else if(dir==SOUTHEAST){
            dx = 1;
            dy = 1;
        }
        else if(dir==SOUTH){
            dy = 1;
        }
        else if(dir==SOUTHWEST){
            dx = -1;
            dy = 1;
        }
        else if(dir==WEST){
            dx = -1;
        }
        else if(dir==NORTHWEST){
            dx = -1;
            dy = -1;
        }
        Coordinates result = new Coordinates(x + dx, y + dy);
        if (isLocationValid(result)) {
            return result;
        }
        return null;
    }
    
    public static String drawTeamMap(Boat[] boats, int view) {
        String[][] map = new String[height][width];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = "###";
            }
        }
        for (Boat boat : boats) {
            if (boat.getTeam() ==  ) {

            }
        }
    }
}