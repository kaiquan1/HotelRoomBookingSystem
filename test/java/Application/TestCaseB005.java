package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room allocation for regular members when deluxe rooms are available.
public class TestCaseB005 {
 // Create a User object representing a regular member named John.
    User normalMember = new User("John", "normal", true);
    
    // Create a Room object with 0 VIP rooms and 3 available Deluxe and Standard rooms each.
    Room room = new Room(0, 3, 3);
    
    // Create a WaitingList object to manage the queue of users waiting for room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Booking object that handles room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method checks if a Deluxe room is allocated to a regular member when available.
    @Test
    public void testNormalMemberBooking() {
        // Attempt to book a room for the regular member.
        booking.makeBooking(normalMember, 1);
        
        // Assert that the number of available Deluxe rooms decreases by one after the booking.
        // Initially, there were 3 Deluxe rooms, so after one booking, 2 should remain.
        assertEquals(2, room.getAvailableDeluxeRooms());
    }
}