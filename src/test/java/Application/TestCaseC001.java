package Application;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


//Verify cancellation of booking one room
public class TestCaseC001 {
	@Test
	public void testCancelBookingVIP() {
 Room room = mock(Room.class); // Mock Room object.
        User user = mock(User.class); // Mock User object.
        WaitingList waitingList = mock(WaitingList.class); // Mock WaitingList object.
        Booking booking = new Booking(room, waitingList);
        booking.bookedRooms.add("VIP"); // Simulate a VIP room booking.
        
        when(user.getMemberType()).thenReturn("vip"); // Stubbing to return 'vip' for the member type.
        when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false); // Ensure user is not in any waiting list.
        
        booking.cancelBooking(user); // Perform the cancellation.
        
        assertTrue(booking.getBookedRooms().isEmpty()); // Check if the booking list is empty post-cancellation.
        verify(room).addVIPRoom(); // Verify that a VIP room was added back to the inventory.
        verify(waitingList, never()).removeFromVIPWaitingList(user); // Ensure the user is not removed from the VIP waiting list.
	}
	
	@Test
	public void testCancelBookingNormal() {
   Room room = mock(Room.class);
        User user = mock(User.class);
        WaitingList waitingList = mock(WaitingList.class);
        Booking booking = new Booking(room, waitingList);
        booking.bookedRooms.add("Deluxe"); // Simulate a Deluxe room booking.
        when(user.getMemberType()).thenReturn("normal"); // Stubbing to return 'normal' for the member type.
        when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
        booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
        verify(room).addDeluxeRoom(); // Verify that a Deluxe room was added back to the inventory.
        verify(waitingList, never()).removeFromNormalWaitingList(user);
	}
	
	@Test
	public void testCancelBookingNonMember() {
 		Room room = mock(Room.class);
        User user = mock(User.class);
        WaitingList waitingList = mock(WaitingList.class);
        Booking booking = new Booking(room, waitingList);
        booking.bookedRooms.add("Standard"); // Simulate a Standard room booking.       
        when(user.getMemberType()).thenReturn("non-member"); // Stubbing to return 'non-member' for the member type.
        when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);       
        booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
        verify(room).addStandardRoom(); // Verify that a Standard room was added back to the inventory.
        verify(waitingList, never()).removeFromNonMemberWaitingList(user);
	}
}
