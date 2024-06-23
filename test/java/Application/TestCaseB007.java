package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify room allocation for regular members when deluxe rooms are full and VIP rooms are unavailable with privileges.
public class TestCaseB007 {
 // Create a User object representing a regular member named John, who has certain privileges.
    User normalMember = new User("John", "normal", true);
    
    // Initialize a Room object with 0 available VIP rooms, 0 available Deluxe rooms, and 3 available Standard rooms.
    Room room = new Room(0, 0, 3);
    
    // Create a WaitingList object for managing the queue of users awaiting room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Booking object that is responsible for room bookings and managing waiting lists.
    Booking booking = new Booking(room, waitingList);
    
    // This test checks the functionality of allocating a Standard room to a privileged regular member when no higher-tier rooms are available.
    @Test
    public void testNormalMemberBooking() {
        // Attempt to book a room for the privileged regular member.
        booking.makeBooking(normalMember, 1);
        
        // Assert that the number of available Standard rooms decreases by one following the booking,
        // confirming that a Standard room was successfully allocated.
        assertEquals(2, room.getAvailableStandardRooms());
        
        // Verify that the member indeed has special rewards or privileges that may influence their treatment by the booking system.
        assertTrue(normalMember.hasExclusiveReward());
    }
}