package Application;

import org.junit.Test;
import static org.junit.Assert.*;

// Verify that VIP members are added to the VIP waiting list when all rooms are full.
public class TestCaseB004 {
 // Create a User object representing a VIP member named John.
    User vipMember = new User("John", "VIP", false);
    
    // Create a WaitingList object which manages the list of users waiting for rooms.
    WaitingList waitingList = new WaitingList();
    
    // Create a Room object with 0 VIP, 0 Deluxe, and 0 Standard rooms available.
    Room room = new Room(0, 0, 0);
    
    // Create a Booking object that handles room bookings and manages waiting lists.
    Booking booking = new Booking(room, waitingList);
    
    // The test expects an IllegalArgumentException when trying to book a room because none are available.
    @Test(expected = IllegalArgumentException.class)
    public void testVIPBooking(){
        // Attempt to book a room for the VIP member.
        booking.makeBooking(vipMember, 1);
        
        // Assert that the VIP member is added to the VIP waiting list after the failed booking attempt.
        // The array should contain exactly one member, the VIP member John.
        assertArrayEquals(new User[] {vipMember}, waitingList.getVIPWaitingList().toArray());
    }
}
