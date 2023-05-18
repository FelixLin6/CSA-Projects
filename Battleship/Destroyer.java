package Battleship;

public class Destroyer extends Boat implements Attacker{

    private int health;

    public Destroyer(int teamID, Coordinates pos, int dir){
        super(teamID, pos, dir, 2, 2, 1);
        health = 2;
    }

    public String getID(){
        return "D" + getTeam();
    }

    public String getActions(){
        return "Choose any of the following actions for the Destroyer:\n1. Move\n2. Turn left\n3. Turn right\n4. Attack";
    }

    public Boat findTarget(World world){
        int x = getLocation().getX();
        int y = getLocation().getY();
        int vision = getVision();
        int dir = getDirection();
        

        if(dir==0){
            for(int i = 0; i<=vision; i++){
                int targetX = x;
                int targetY = y - i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }   
        }
        else if(dir==1){
            for(int i = 0; i<=vision; i++){
                int targetX = x - i;
                int targetY = y - i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==2){
            for(int i = 0; i<=vision; i++){
                int targetX = x - i;
                int targetY = y;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==3){
            for(int i = 0; i<=vision; i++){
                int targetX = x - i;
                int targetY = y + i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==4){
            for(int i = 0; i<=vision; i++){
                int targetX = x;
                int targetY = y + i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==5){
            for(int i = 0; i<=vision; i++){
                int targetX = x + i;
                int targetY = y + i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==6){
            for(int i = 0; i<=vision; i++){
                int targetX = x + i;
                int targetY = y;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        else if(dir==7){
            for(int i = 0; i<=vision; i++){
                int targetX = x + i;
                int targetY = y - i;
                Boat target = world.getOccupant(new Coordinates(targetX, targetY));
                if (target != null && target.getTeam() != getTeam()) return target;
            }
        }
        return null;
    }

    @Override
    public String attack(World world){
        String res = "";
        Boat target = findTarget(world);
        if(target!=null)res += target.takeHit(getStrength());
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

    public String takeHit(int strength){
        if(Math.random()<0.5){
            health -= strength;
            if (health <= 0) {
                return getID() + " has been sunk!";
            } 
            else {
                return getID() + " takes " + strength + " damage.";
            }
        }
        return getID() + " avoids the attack!";
    }
}


