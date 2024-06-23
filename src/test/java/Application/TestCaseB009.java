package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify that regular members are added to the member waiting list when all rooms are full
public class TestCaseB009 {
// Create a User object representing a regular member named John with privileges.
    User normalMember = new User("John", "normal", true);
    
    // Initialize a WaitingList object to manage the list of users waiting for room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object indicating that all room types (VIP, Deluxe, Standard) are fully occupied (0 available).
    Room room = new Room(0, 0, 0);
    
    // Create a Booking object that is responsible for managing room bookings and waiting lists.
    Booking booking = new Booking(room, waitingList);
    
    // This test checks that when a booking attempt is made for a regular member and no rooms are available,
    // the member is added to the normal waiting list.
    @Test(expected = IllegalArgumentException.class)
    public void testNormalMemberBooking() {
        // Attempt to book a room for the regular member, expecting to throw an IllegalArgumentException due to no availability.
        booking.makeBooking(normalMember, 1);
        
        // Assert that the normal member is indeed added to the normal waiting list.
        // This is checked by comparing the list content to an array containing only the tested normal member.
        assertArrayEquals(new User[] {normalMember}, waitingList.getNormalWaitingList().toArray());
    }
}
