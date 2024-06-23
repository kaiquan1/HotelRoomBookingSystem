package Application;

public class Room {
    private int availableVIPRooms;
    private int availableDeluxeRooms;
    private int availableStandardRooms;

    public Room(int vipRooms, int deluxeRooms, int standardRooms) {
        this.availableVIPRooms = vipRooms;
        this.availableDeluxeRooms = deluxeRooms;
        this.availableStandardRooms = standardRooms;
    }

    public int getAvailableVIPRooms() {
        return availableVIPRooms;
    }

    public int getAvailableDeluxeRooms() {
        return availableDeluxeRooms;
    }

    public int getAvailableStandardRooms() {
        return availableStandardRooms;
    }
    
	public int getTotalRooms() {
		return availableVIPRooms + availableDeluxeRooms + availableStandardRooms;
	}

    public void bookVIPRoom() {
        availableVIPRooms -= 1;
    }

	public void bookDeluxeRoom() {
		availableDeluxeRooms -= 1;
	}

	public void bookStandardRoom() {
		availableStandardRooms -= 1;
	}
	
	public void addVIPRoom() {
		availableVIPRooms += 1;
	}
	
	public void addDeluxeRoom() {
		availableDeluxeRooms += 1;
	}
	
	public void addStandardRoom() {
		availableStandardRooms += 1;
	}
}
