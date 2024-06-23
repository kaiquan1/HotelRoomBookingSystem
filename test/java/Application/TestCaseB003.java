package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room assignments for VIP members for standard rooms available when VIP and Deluxe rooms are full.
public class TestCaseB003 {
 // Create a User object representing a VIP member named John.
    User vipMember = new User("John", "VIP", false);
    
    // Create a WaitingList object which manages the list of users waiting for rooms.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object with 0 VIP rooms, 0 Deluxe rooms, and 3 Standard rooms available.
    Room room = new Room(0, 0, 3);
    
    // Create a Booking object responsible for managing room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method checks if a VIP member is allocated a Standard room when both VIP and Deluxe rooms are unavailable.
    @Test
    public void testVIPBooking(){
        // Make a booking attempt for the VIP member for one room.
        booking.makeBooking(vipMember, 1);
        
        // Assert that the number of available Standard rooms decreases by one due to the VIP booking.
        // Initially, there were 3 Standard rooms, so after one booking, 2 should remain.
        assertEquals(2, room.getAvailableStandardRooms());
    }
}
