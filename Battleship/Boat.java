package Battleship;

import java.util.ArrayList;

public abstract class Boat {
    private int team;
    private Coordinates location;
    private int dir;
    private int health;
    private int strength;
    private int vision;
    private static int idCounter = 0;
    private final String id;

    public Boat(int team, Coordinates location, int direction, int health, int strength, int vision) {
        this.team = team;
        this.location = location;
        this.dir = direction;
        this.health = health;
        this.strength = strength;
        this.vision = vision;
        this.id = "B" + ++idCounter;
    }

    public int getTeam() {
        return team;
    }

    public Coordinates getLocation() {
        return location;
    }

    public char getDirection() {
        if(dir==World.NORTH){
            return '\u2191';
        }
        else if(dir==World.NORTHEAST){
            return '\u2197';
        }
        else if(dir==World.EAST){
            return '\u2192';
        }
        else if(dir==World.SOUTHEAST){
            return '\u2198';
        }
        else if(dir==World.SOUTH){
            return '\u2193';
        }
        else if(dir==World.SOUTHWEST){
            return '\u2199';
        }
        else if(dir==World.WEST){
            return '\u2190';
        }
        else if(dir==World.NORTHWEST){
            return '\u2196';
        }
        return ' ';
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getVision() {
        return vision;
    }

    public abstract String getID();

    public abstract String act(int[] choices, World world);

    public abstract String getActions();

    public String move(World world) {
        int x = location.getX();
        int y = location.getY();
        int dx = 0;
        int dy = 0;
        if(dir==World.NORTH){
            dy-=1;
        }
        else if(dir==World.NORTHEAST){
            dx = 1;
            dy = -1;
        }
        else if(dir==World.EAST){
            dx = 1;
        }
        else if(dir==World.SOUTHEAST){
            dx = 1;
            dy = 1;
        }
        else if(dir==World.SOUTH){
            dy = 1;
        }
        else if(dir==World.SOUTHWEST){
            dx = -1;
            dy = 1;
        }
        else if(dir==World.WEST){
            dx = -1;
        }
        else if(dir==World.NORTHWEST){
            dx = -1;
            dy = -1;
        }
        Coordinates newLocation  = new Coordinates(x+dx, y+dy);
        if (world.isLocationValid(newLocation)) {
            if (world.isLocationOccupied(newLocation)) {
                return id + " cannot move to " + location.toString() + " as it is occupied.";
            } else {
                world.setOccupant(null, location);
                location = newLocation;
                return id + " moves from " + location.toString() + " to " + location.toString() + ".";
            }
        } 
        else {
            return id + " cannot move off the map.";
        }
    }

    public String turn(int direction) {
        if(dir == 0 && direction == -1) direction = 7;
        else if(dir == 7 && direction == 1) direction = 0;
        else dir += direction;
        String action;
        if(direction == 1) action = "right";
        else action = "left";
        String facing = "";
        if(direction == 0) facing = "N";
        if(direction == 1) facing = "NE";
        if(direction == 2) facing = "E";
        if(direction == 3) facing = "SE";
        if(direction == 4) facing = "S";
        if(direction == 0) facing = "SW";
        if(direction == 6) facing = "W";
        if(direction == 7) facing = "NW";
        return getID() + " turned " + action + ", now facing " + facing;
    }

    public String takeHit(int strength) {
        health -= strength;
        if (health <= 0) {
            health = 0;
            return id + " has been sunk!";
        } else {
            return id + " takes " + strength + " damage.";
        }
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    public Boat findTarget(World world) {
        int x = getLocation().getX();
        int y = getLocation().getY();
        int vision = getVision();

        for (int i = -vision; i <= vision; i++) {
            int targetX = x + i;
            int targetY = y + i;
            Coordinates loc = new Coordinates(targetX, targetY);
            if (world.isLocationValid(loc)) {
                Boat target = world.getOccupant(loc);
                if (target != null && target.getTeam() != getTeam()) {
                    return target;
                }
            }
        }
        return null;
    }

    public ArrayList<Boat> findTargets(World world) {
        ArrayList<Boat> targets = new ArrayList<Boat>();
        int x = getLocation().getX();
        int y = getLocation().getY();
        int vision = getVision();

        for (int i = -vision; i <= vision; i++) {
            int targetX = x + i;
            int targetY = y + i;
            Coordinates loc = new Coordinates(targetX, targetY);
            if (world.isLocationValid(loc)) {
                Boat target = world.getOccupant(loc);
                if (target != null && target.getTeam() != getTeam()) {
                    targets.add(target);
                }
            }
        }
        return targets;
    }

    @Override
    public String toString() {
        return id;
    }
}
