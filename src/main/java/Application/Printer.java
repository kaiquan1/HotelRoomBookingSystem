package Application;
import java.util.List;
import java.util.Collections;

public class Printer {
    public void printBookingInfo(User user, List<String> bookedRooms) {
    	 System.out.println("\nBooking Information:");
    	 System.out.println("User: " + user.getName());
    	 System.out.println("Member Type: " + user.getMemberType());
    	 if (!bookedRooms.isEmpty()) {
    		 System.out.println("Rooms Booked:");
	
	    	 if (bookedRooms.contains("VIP")) {
	    	     System.out.println("VIP: " + Collections.frequency(bookedRooms, "VIP"));
	    	 }
	    	 if (bookedRooms.contains("Deluxe")) {
	    	     System.out.println("Deluxe: " + Collections.frequency(bookedRooms, "Deluxe"));
	    	 }
	    	 if (bookedRooms.contains("Standard")) {
	    	     System.out.println("Standard: " + Collections.frequency(bookedRooms, "Standard"));
	    	 }
	    	 System.out.println();
		} else
			System.out.println("No rooms booked.");
    }
    
    public void printWaitingLists(WaitingList waitingList) {
        System.out.println("\nCurrent Waiting List:");

        
        System.out.println("VIP Waiting List:");
        for (User user : waitingList.getVIPWaitingList()) {
            System.out.println("- " + user.getName());
        }

        
        System.out.println("\nNormal Member Waiting List:");
        for (User user : waitingList.getNormalWaitingList()) {
            System.out.println("- " + user.getName());
        }

       
        System.out.println("\nNon-Member Waiting List:");
        for (User user : waitingList.getNonMemberWaitingList()) {
            System.out.println("- " + user.getName());
        }
    }
    
	public void printAvailableRooms(Room room) {
		System.out.println("\nAvailable Rooms:");
		System.out.println("VIP Rooms: " + room.getAvailableVIPRooms());
		System.out.println("Deluxe Rooms: " + room.getAvailableDeluxeRooms());
		System.out.println("Standard Rooms: " + room.getAvailableStandardRooms());
	}
}
