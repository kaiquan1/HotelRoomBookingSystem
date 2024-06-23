package Application;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


//Verify cancellation of booking removes the user from waiting list
public class TestCaseC003 {
	@Test
	public void testCancelBookingRemoveFromWaitingListVIP() {
  Room room = mock(Room.class); // Mocking Room to isolate test.
        User user = mock(User.class); // Mocking User to control member type and interaction.
        WaitingList waitingList = mock(WaitingList.class); // Mocking WaitingList to verify interactions.
        Booking booking = new Booking(room, waitingList); // Instance of Booking with mocked dependencies.
        
        when(user.getMemberType()).thenReturn("vip"); // Stubbing to simulate VIP user.
        // Stubbing to simulate finding the user in the VIP waiting list.
        when(waitingList.findUserInWaitingList(waitingList.getVIPWaitingList(), user)).thenReturn(true);
        
        booking.cancelBooking(user); // Perform cancellation.
        
        assertTrue(booking.getBookedRooms().isEmpty()); // Verify that all bookings are cleared.
        // Verify that the user is removed from the VIP waiting list.
        verify(waitingList).removeFromVIPWaitingList(user);
	}
	
	@Test
	public void testCancelBookingRemoveFromWaitingListNormal() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		when(user.getMemberType()).thenReturn("normal");
		  // Stubbing to simulate finding the user in the normal waiting list.
		when(waitingList.findUserInWaitingList(waitingList.getNormalWaitingList(), user)).thenReturn(true);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(waitingList).removeFromNormalWaitingList(user);
	}
	
	@Test
	public void testCancelBookingRemoveFromWaitingListNonMember() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		when(user.getMemberType()).thenReturn("non-member");
		 // Stubbing to simulate finding the user in the non-member waiting list.
		when(waitingList.findUserInWaitingList(waitingList.getNonMemberWaitingList(), user)).thenReturn(true);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(waitingList).removeFromNonMemberWaitingList(user);
	}
}

