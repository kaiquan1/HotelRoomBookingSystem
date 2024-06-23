package Application;

import org.junit.Test;
import static org.junit.Assert.*;

//Verify Waiting List Processing for Non-Members when standard rooms are unavailable
public class TestCaseB011 {
 // Create a User object representing a non-member named John.
    User nonMember = new User("John", "non-member", false);
    
    // Initialize a WaitingList object to manage the queue of users awaiting room assignments.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object indicating that all room categories (VIP, Deluxe, Standard) are completely booked (0 available).
    Room room = new Room(0, 0, 0);
    
    // Create a Booking object responsible for managing room bookings and waiting lists.
    Booking booking = new Booking(room, waitingList);
    
    // This test method evaluates the system's handling of non-members when no rooms are available.
    @Test(expected = IllegalArgumentException.class)
    public void testNormalMemberBooking() {
        // Attempt to book a room for the non-member, expecting to throw an IllegalArgumentException due to no room availability.
        booking.makeBooking(nonMember, 1);
        
        // Assert that the non-member is indeed added to the non-member waiting list.
        // This is verified by checking that the waiting list contains exactly the tested non-member.
        assertArrayEquals(new User[] {nonMember}, waitingList.getNonMemberWaitingList().toArray());
    }
}

