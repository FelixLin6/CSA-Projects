package Battleship;
import java.util.Random;

public class Submarine extends ScoutBoat{
    private int numOfTorpedoes;

    public Submarine(int teamID, Coordinates pos, int dir, int torpedoes){
        super(teamID, pos, dir, 3, 2);
        numOfTorpedoes = torpedoes;
    }

    public String getID(){
        return "S" + getTeam();
    }

    public String getActions(){
        return "Choose any of the following actions for the Submarine:\n1. Move\n2. Turn left\n3. Turn right\n4. Submerge\n5. Fire torpedoes";
    }

    public String submerge(World world) {
        Coordinates oldCords = this.getLocation();
        Coordinates cords = new Coordinates(this.getLocation().getX()+(int)(Math.random()*4-2), this.getLocation().getX()+(int)(Math.random()*4-2));
        while(world.isLocationOccupied(cords)){
            cords = new Coordinates(this.getLocation().getX()+(int)(Math.random()*4-2), this.getLocation().getX()+(int)(Math.random()*4-2));
        }
        String res = getID() + " moves from " + oldCords + " to " + cords + ".";
        world.setOccupant(this, cords);
        world.setOccupant(null, oldCords);
        return res; 
    }

    public String act(int[] choices, World world){
        String res = "";
        for(int choice: choices){
            if(choice==1) res += move(world) + "\n";
            else if(choice==2) res += turn(-1) + "\n";
            else if(choice==3) res += turn(1) + "\n";
            else if(choice==4) res += submerge(world) + "\n";
            else if(choice==5) res += attack(world) + "\n";
        }
        return res;
    }

    public String attack(World world) {
        if (numOfTorpedoes > 0) {
            Boat target = findTarget(world);
            if (target != null) {
                int attackStrength = new Random().nextInt(getHealth()) + 1;
                target.takeHit(attackStrength);
                return "Fire torpedoes! " + target.getID() + " took " + attackStrength + " damage.";
            } else {
                return "There are no boats in range currently.";
            }
        }
        return getID() + " has no torpedoes remaining.";
    }
}
