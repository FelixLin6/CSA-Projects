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
    
    public World(int w, int h) {
        int width = w;
        int height = h;
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
        int col = c.getX();
        int row = c.getY();
        if(col < 0 || col >= getWidth()) return false;
        if(row < 0 || row >= getHeight()) return false;
        return true;
    }
    
    public boolean isLocationOccupied(Coordinates c) {
        int col = c.getX();
        int row = c.getY();
        if(map[row][col] != null) return true;
        return false;
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
    
    public String drawTeamMap(Boat[] boats, int view) {
        int rows = getHeight();
        int cols = getWidth();
        String[][] strMap = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                strMap[i][j] = "###";
            }
        }

        if(view == 2 || view == 3){
            for(Boat b: boats){
                setOccupant(b, b.getLocation());
                Coordinates loc = b.getLocation();
                int row = loc.getY();
                int col = loc.getX();
                if(view == 2) strMap[row][col] = b.getDirection() + b.getID();
                if(view == 3) strMap[row][col] = b.getHealth() + b.getID();
                int startRow = row - b.getVision();
                int endRow = row + b.getVision();
                int startCol = col - b.getVision();
                int endCol = col + b.getVision();
                for(int i = startRow; i < endRow; i ++){
                    for(int j = startCol; j < endCol; j++){
                        Coordinates waterLoc = new Coordinates(j, i);
                        if(isLocationValid(waterLoc)){
                            if(isLocationOccupied(waterLoc)){
                                if(view==2) strMap[i][j] = map[i][j].getDirection() + map[i][j].getID();
                                if(view==3) strMap[i][j] = map[i][j].getHealth() + map[i][j].getID();
                            }
                            else{strMap[i][j] = "~~~";}
                        }
                    }
                }
            }
        }

        String result = "@ ";
        char c = 'A';
        for(int i = 1; i < cols; i++){
            result += " " + i + " ";
        }
        result += "\n";
        for(int i = 0; i < rows; i++){
            result += (char)(c + i) + " ";
            for(int j = 0; j < cols; j++){
                result += strMap[i][j];
            }
            result += " \n";
        }
        return result;
    }
}