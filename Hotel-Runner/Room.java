public class Room {
    private int roomNumber;
    private int daysRented;
    private String roomType;
    private String occupantName;

    public Room(int roomNum, String type){
        this.roomNumber = roomNum;
        this.daysRented = 0;
        this.occupantName = null;
        if(type=="single king" || type=="double queen" || type=="suite"){
            this.roomType = type;
        }
        else{
            roomType = "double queen";
        }
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    public int getDaysRented(){
        return this.daysRented;
    }

    public String getRoomType(){
        return this.roomType;
    }

    public String getOccupantName(){
        return this.occupantName;
    }

    public boolean setOccupant(String name, int days){
        if(this.occupantName==null){
            this.occupantName = name;
            this.daysRented = days;
            return true;
        }
        return false;
    }

    public void advanceDay(){
        this.daysRented--;
        if(this.daysRented<=0){
            this.occupantName = null;
            this.daysRented = 0;
        }
    }

    public String toString(){
        if(this.occupantName!=null){
            return "Room " + this.roomNumber + ": " + this.roomType + " - rented to " + this.occupantName;
        }
        return "Room " + this.roomNumber + ": " + this.roomType + " - free";
    }
}
