package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room allocation for VIP rooms available to regular members when the deluxe room is full and they have privileges.
public class TestCaseB006 {
   // Create a User object representing a regular member named John with privileges.
    User normalMember = new User("John", "normal", true);
    
    // Create a Room object with 3 VIP rooms available, 0 Deluxe rooms, and 3 Standard rooms.
    Room room = new Room(3, 0, 3);
    
    // Create a WaitingList object to manage users waiting for room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Booking object that manages room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method evaluates if a VIP room is correctly allocated to a privileged regular member when Deluxe rooms are unavailable.
    @Test
    public void testNormalMemberBooking() {
        // Attempt to book a room for the privileged regular member.
        booking.makeBooking(normalMember, 1);
        
        // Assert that the number of available VIP rooms decreases by one after the booking,
        // indicating that a VIP room was allocated to the regular member.
        assertEquals(2, room.getAvailableVIPRooms());
        
        // Check that the member does not have any exclusive rewards that might affect the booking.
        // This ensures the booking privilege comes from status and not from a special reward condition.
        assertFalse(normalMember.hasExclusiveReward());
    }
}