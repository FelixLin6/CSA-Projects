package Battleship;

public class Cruiser extends ScoutBoat{

    public Cruiser(int teamID, Coordinates pos, int dir){
        super(teamID, pos, dir, 3, 3);
    }

    public String getID(){
        return "C"+this.getTeam();
    }

    public String getActions(){
        return "Choose any of the following actions for the Cruiser:\n1. Move\n2. Turn left\n3. Turn right";
    }

    public String act(int[] choices, World world){
        String res = "";
        for(int choice: choices){
            if(choice==1) res += move(world) + "\n";
            else if(choice==2) res += turn(-1) + "\n";
            else res += turn(1) + "\n";
        }
        return res;
    }
}
