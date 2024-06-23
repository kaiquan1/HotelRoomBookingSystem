package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room allocation for non-members when standard rooms are available
public class TestCaseB010 {
 // Create a User object representing a non-member named John.
    User nonMember = new User("John", "non-member", false);
    
    // Initialize a WaitingList object to manage the queue of users waiting for room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object with 3 available rooms in each category: VIP, Deluxe, and Standard.
    Room room = new Room(3, 3, 3);
    
    // Create a Booking object that is responsible for managing room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method evaluates if a Standard room is allocated to a non-member when such rooms are available.
    @Test
    public void testNormalMemberBooking() {
        // Attempt to book a Standard room for the non-member.
        booking.makeBooking(nonMember, 1);
        
        // Assert that the number of available Standard rooms decreases by one after the booking,
        // confirming that a Standard room was successfully allocated.
        assertEquals(2, room.getAvailableStandardRooms());
    }
}