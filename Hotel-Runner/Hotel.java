import java.lang.Math;

public class Hotel {
    private String hotelName;
    private Room[][] rooms;
    private int totalRooms;

    public Hotel(String name, int numRooms, int floors){
        this.hotelName = name;
        this.totalRooms = numRooms;
        this.rooms = new Room[floors][numRooms/floors];
        for(int i=0; i<floors; i++){
            for(int j=numRooms/floors-1; j>=0; j--){
                if(j==numRooms/floors-1){
                    this.rooms[i][j] = new Room((i+1)*100+j, "suite");
                }
                else if(j>numRooms/floors-6 && j<numRooms/floors-1){
                    this.rooms[i][j] = new Room((i+1)*100+j,"single king");
                }
                else{
                    this.rooms[i][j] = new Room((i+1)*100+j, "double queen");
                }
            }
        }
    }

    public int getTotalRooms(){
        return this.totalRooms;
    }

    public int getNumberOccupied(){
        int count = 0;
        for(Room[] row: this.rooms){
            for(Room room: row){
                if(room.getOccupantName()!=null){
                    count++;
                }
            }
        }
        return count;
    }

    public double getOccupancyRate(){
        double rate = this.getNumberOccupied()/this.totalRooms;
        double rounded = Math.round((rate*100.0)/100.0);
        return rounded;
    }

    public boolean rentRoom(String type, String name, int numDays){
        for(Room[] row: this.rooms){
            for(Room room: row){
                if(room.getRoomType()==type && room.getOccupantName()==null){
                    room.setOccupant(name, numDays);
                    return true;
                }
            }
        }
        return false;
    }

    public void advanceDay(){
        for(Room[] row: this.rooms){
            for(Room room: row){
                if(room.getOccupantName()!=null){
                    room.advanceDay();
                }
            }
        }
    }

    public String toString(){
        return this.hotelName + ": " + this.getOccupancyRate()*100 + "% occupied";
    }

    public void printRooms(){
        for (Room[] row: this.rooms){
            for(Room room: row){
                if(room.getOccupantName()!= null){
                    System.out.println("Room " + room.getRoomNumber()+ ": " + room.getRoomType() + " - rented to " + room.getOccupantName());
                }
                else{
                    System.out.println("Room " + room.getRoomNumber()+ ": " + room.getRoomType() + " - free");
                }
            }
        }
    }
}
