package Battleship;

import java.util.ArrayList;

public class Battleship extends Boat implements Attacker{
    
    public Battleship(int teamID, Coordinates pos, int dir){
        super(teamID, pos, dir, 4, 3, 1);
    }

    public String getID(){
        return "B" + getTeam();
    }

    public String getActions(){
        return "Choose any of the following actions for the Battleship:\n1. Move\n2. Turn left\n3. Turn right\n4. Attack";
    }

    @Override
    public String attack(World world){
        String res = "";
        ArrayList<Boat> targets= findTargets(world);
        if(targets.size()!=0) return "There are no boats in range currently.";
        res += "Fire cannons! ";
        for(Boat target: targets){
            if(target!=null) res+=target.takeHit(getStrength()) + "\n"; res+=target.takeHit(getStrength()) + "\n";
        }
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
