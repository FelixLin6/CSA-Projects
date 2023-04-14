package Battleship;

import java.util.Arrays;

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

    public String getDirection() {
        if(dir==World.NORTH){
            return "↑";
        }
        else if(dir==World.NORTHEAST){
            return "↗";
        }
        else if(dir==World.EAST){
            return "→";
        }
        else if(dir==World.SOUTHEAST){
            return "↘";
        }
        else if(dir==World.SOUTH){
            return "↓";
        }
        else if(dir==World.SOUTHWEST){
            return "↙";
        }
        else if(dir==World.WEST){
            return "←";
        }
        else if(dir==World.NORTHWEST){
            return "↖";
        }
        return "";
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
        this.dir = (this.dir + direction + 4) % 4;
        return id + " turned " + (direction == -1 ? "left, now facing " : "right, now facing ") + getDirection() + ".";
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

    @Override
    public String toString() {
        return id;
    }
}
