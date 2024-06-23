package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify the room allocation for VIP members when the VIP room is full and the Deluxe room is available.
public class TestCaseB002 {
	 // Create a User object representing a VIP member named John.
    User vipMember = new User("John", "VIP", false);
    
    // Create a WaitingList object to manage users waiting for room allocation.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object with 0 available VIP rooms, and 3 available Deluxe rooms and 3 Standard rooms.
    Room room = new Room(0, 3, 3);
    
    // Create a Booking object responsible for managing room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test checks the allocation of a Deluxe room when no VIP rooms are available.
    @Test
    public void testVIPBooking(){
        // Make a booking attempt for the VIP member for 1 room.
        booking.makeBooking(vipMember, 1);
        
        // Assert that the number of available Deluxe rooms has decreased by one as a result of the VIP booking.
        // Initially, there were 3 Deluxe rooms, so after one booking, 2 should remain.
        assertEquals(2, room.getAvailableDeluxeRooms());
    }
}
