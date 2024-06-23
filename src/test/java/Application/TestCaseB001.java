package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room assignments for VIP members when VIP rooms are available
public class TestCaseB001 {
 // Create a WaitingList object which will manage the list of users waiting for rooms.
    WaitingList waitingList = new WaitingList();
    
    // Create a User object representing a VIP member named John.
    User vipMember = new User("John", "VIP", false);
    
    // Create a Room object representing a room with 3 total VIP rooms.
    Room room = new Room(3, 3, 3);
    
    // Create a Booking object that manages room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method verifies if a VIP booking decreases the number of available VIP rooms.
    @Test
    public void testVIPBooking(){
        // Attempt to book a room for the VIP member.
        booking.makeBooking(vipMember, 1);
        
        // Assert that the number of available VIP rooms is decreased by one after booking.
        // Initially, there were 3 VIP rooms, so after one booking, 2 should remain.
        assertEquals(2, room.getAvailableVIPRooms());
    }
}