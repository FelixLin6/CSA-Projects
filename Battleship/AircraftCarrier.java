package Battleship;

import java.util.ArrayList;

public class AircraftCarrier extends Boat implements Attacker{
    private boolean hasPlanes;

    public AircraftCarrier(int teamID, Coordinates pos, int dir){
        super(teamID, pos, dir, 5, 1, 1);
    }

    public String getID(){
        return "A" + getTeam();
    }

    public String getActions(){
        return "Choose any of the following actions for the Aircraft Carrier:\n1. Move\n2. Turn left\n3. Turn right\n4. Launch planes";
    }

    @Override
    public String attack(World world){
        Double successRate = 1.00;
        String res = "";
        if(hasPlanes){
            ArrayList<Boat> targets = findTargets(world);
            res += "Air raid! ";
            for(Boat target: targets){
                if(target!=null) res += target.takeHit(getStrength()) + "\n"; successRate *=0.8;
            }
        }
        else res = getID() + " has no planes remaining.";
        if(Math.random() > successRate) hasPlanes = false; res += "The planes have been destroyed.";
        return res;
    }

    public String act(int[] choices, World world){
        String res = "";
        for(int choice: choices){
            if(choice==1) res += move(world) + "\n";
            else if(choice==2) res += turn(-1) + "\n";
            else if(choice==3) res += turn(1) + "\n";
            else if(choice==4) res += attack(world) + "\n";
            else res += "Invalid action choice.";
        }
        return res;
    }
}
