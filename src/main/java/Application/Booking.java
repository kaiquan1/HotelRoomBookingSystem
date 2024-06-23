package Application;
import java.util.ArrayList;
import java.util.List;

public class Booking {
	Printer printer = new Printer(); 
    private Room room;
    private WaitingList waitingList;
    List<String> bookedRooms = new ArrayList<>();

    public Booking(Room room, WaitingList waitingList) {
        this.room = room;
        this.waitingList = waitingList;
    }

    public void makeBooking(User user, int numOfRooms) {
        String memberType = user.getMemberType().toLowerCase();
        
		if (numOfRooms == 0) {
			throw new IllegalArgumentException("Number of rooms cannot be 0.");
		} else {
	        if (memberType.equals("vip")) {
	        	if (numOfRooms > 3) {
	        		throw new IllegalArgumentException("VIP members are only allowed to book up to 3 rooms at a time. ");
	        	} else 
	        		bookVIPRoom(user, numOfRooms);
	        } else if (memberType.equals("normal")) {
	        	if (numOfRooms > 2) 
	        	 	throw new IllegalArgumentException("Normal members are only allowed to book up to 2 rooms at a time. ");
	        	else
	        		bookNormalRoom(user, numOfRooms);
	        } else if (memberType.equals("non-member")) {
	        	if (numOfRooms > 1)
	         		throw new IllegalArgumentException("Non-members are only allowed to book up to 1 room at a time. ");
	          	else
	          		bookNonMemberRoom(user, numOfRooms);
	        }
		}
    }

    private void bookVIPRoom(User user, int numOfRooms) {
    	if (room.getTotalRooms() >= numOfRooms) {
			for (int i = 0; i < numOfRooms; i++) {
				if (room.getAvailableVIPRooms() > 0) {
					room.bookVIPRoom();
					bookedRooms.add("VIP");
				} else if (room.getAvailableDeluxeRooms() > 0) {
					room.bookDeluxeRoom();
					bookedRooms.add("Deluxe");
				} else if (room.getAvailableStandardRooms() > 0) {
					room.bookStandardRoom();
					bookedRooms.add("Standard");
				}
			}
    	} else {
    		waitingList.addToVIPWaitingList(user);
    		throw new IllegalArgumentException("Insufficient rooms, you will be added to the waiting list.");
    	}
    }
    
    private void bookNormalRoom(User user, int numOfRooms) {
    	if (room.getTotalRooms() >= numOfRooms) {
			for (int i = 0; i < numOfRooms; i++) {
				if (user.hasExclusiveReward()) {
					if (room.getAvailableVIPRooms() > 0) {
						room.bookVIPRoom();
						user.setExclusiveReward(false);
						System.out.println("\nExclusive Reward Redeemed!\n\n");
						bookedRooms.add("VIP");
					} else if (room.getAvailableDeluxeRooms() > 0) {
						room.bookDeluxeRoom();
						bookedRooms.add("Deluxe");
					} else if (room.getAvailableStandardRooms() > 0) {
						room.bookStandardRoom();
						bookedRooms.add("Standard");
					} 
				} else if (room.getAvailableDeluxeRooms() > 0) {
					room.bookDeluxeRoom();
					bookedRooms.add("Deluxe");
				} else if (room.getAvailableStandardRooms() > 0) {
					room.bookStandardRoom();
					bookedRooms.add("Standard");
				} 
			}
		} else {
			waitingList.addToNormalWaitingList(user);
			throw new IllegalArgumentException("Insufficient rooms, you will be added to the waiting list.");
    	} 
		
    }
    
    private void bookNonMemberRoom(User user, int numOfRooms) {
    	if (room.getTotalRooms() >= numOfRooms) {
			if (room.getAvailableStandardRooms() >= numOfRooms) {
				for (int i = 0; i < numOfRooms; i++) {
					room.bookStandardRoom();
					bookedRooms.add("Standard");
				}
			} 
    	} else {
    		waitingList.addToNonMemberWaitingList(user);
			throw new IllegalArgumentException("Insufficient rooms, you will be added to the waiting list.");
		}
    }
    
    public void cancelBooking(User user) {
        if (!bookedRooms.isEmpty()) {
            //User has booked rooms, cancel the booking and add back the rooms
            for (String r : bookedRooms) {
                if (r.equals("VIP")) {
                    room.addVIPRoom();
                } else if (r.equals("Deluxe")) {
                    room.addDeluxeRoom();
                } else if (r.equals("Standard")) {
                    room.addStandardRoom();
                }
            }
            
            clearBookedRooms();
            
            //Remove the user from waiting list if found
            if (user.getMemberType().equals("vip")) {
                if (waitingList.findUserInWaitingList(waitingList.getVIPWaitingList(), user))
                    waitingList.removeFromVIPWaitingList(user);
            } else if (user.getMemberType().equals("normal")) {
                if (waitingList.findUserInWaitingList(waitingList.getNormalWaitingList(), user))
                    waitingList.removeFromNormalWaitingList(user);
            } else if (user.getMemberType().equals("non-member")) {
                if (waitingList.findUserInWaitingList(waitingList.getNonMemberWaitingList(), user))
                    waitingList.removeFromNonMemberWaitingList(user);
            }
            
        } else {
            //Remove the user from waiting list if found
            if (user.getMemberType().equals("vip")) {
                if (waitingList.findUserInWaitingList(waitingList.getVIPWaitingList(), user))
                    waitingList.removeFromVIPWaitingList(user);
                else
                    throw new IllegalStateException("User does not have any bookings or is not in the waiting list.");
            } else if (user.getMemberType().equals("normal")) {
                if (waitingList.findUserInWaitingList(waitingList.getNormalWaitingList(), user))
                    waitingList.removeFromNormalWaitingList(user);
                else
                    throw new IllegalStateException("User does not have any bookings or is not in the waiting list.");
            } else if (user.getMemberType().equals("non-member")) {
                if (waitingList.findUserInWaitingList(waitingList.getNonMemberWaitingList(), user))
                    waitingList.removeFromNonMemberWaitingList(user);
                else
                    throw new IllegalStateException("User does not have any bookings or is not in the waiting list.");
            } 
        }
    }
    
	public List<String> getBookedRooms() {
		return bookedRooms;
	}
	
	public void clearBookedRooms() {
		bookedRooms.clear();
	}
}
