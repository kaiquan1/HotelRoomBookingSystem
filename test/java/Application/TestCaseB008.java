package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify Room Assignment for Regular Members when Deluxe Rooms are full and Standard Rooms are available for unprivileged members.
public class TestCaseB008 {
    // Create a User object representing a regular member named John, who does not have special privileges.
    User normalMember = new User("John", "normal", false);
    
    // Initialize a Room object with 3 available VIP rooms, 0 available Deluxe rooms, and 3 available Standard rooms.
    Room room = new Room(3, 0, 3);
    
    // Create a WaitingList object to manage the queue of users waiting for room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Booking object that is responsible for managing room bookings.
    Booking booking = new Booking(room, waitingList);
    
    // This test method evaluates if a Standard room is allocated to a regular, unprivileged member under specific conditions.
    @Test
    public void testNormalMemberBooking() {
        // Attempt to book a room for the regular member.
        booking.makeBooking(normalMember, 1);
        
        // Assert that the number of available Standard rooms decreases by one after the booking,
        // confirming that a Standard room was successfully allocated.
        assertEquals(2, room.getAvailableStandardRooms());
    }
}
