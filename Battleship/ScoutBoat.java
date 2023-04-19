package Battleship;

public abstract class ScoutBoat extends Boat {
    
    public ScoutBoat(int team, Coordinates location, int direction, int health, int vision) {
        super(team, location, direction, health, 1, vision);
    }
    
    public String takeHit(int numAttacks) {
        for(int i = 0; i < numAttacks; i++){
            if (Math.random() < 0.25) {
                super.takeHit(1);
                return this.getID() + " takes " + 1 + " damage.";
            } 
            else {
                return this.getID() + " has avoided the attack!";
            }
        }
        return "";
    }
}
