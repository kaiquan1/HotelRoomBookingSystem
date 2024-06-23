package Application;

import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

//Verify cancellation of booking when no rooms are booked and user is not in waiting list
public class TestCaseC004 {
	@Test(expected = IllegalStateException.class)
	public void testCancelBookingNoRoomsVIP() {
		  Room room = mock(Room.class); // Mock the Room class to control behavior.
        User user = mock(User.class); // Mock the User class to specify user details.
        WaitingList waitingList = mock(WaitingList.class); // Mock the WaitingList to control waiting list behavior.
        Booking booking = new Booking(room, waitingList); // Inject mocks into Booking instance.
        
        when(user.getMemberType()).thenReturn("vip"); // Define the user type as VIP.
        when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false); // Ensure user is not on any waiting list.
        
        booking.cancelBooking(user); // Perform cancellation which is expected to fail.
        
        assertTrue(booking.getBookedRooms().isEmpty()); // Assert no rooms are booked.
        verify(room, never()).addVIPRoom(); // Verify no VIP room is added back, since none were booked.
        verify(waitingList, never()).removeFromVIPWaitingList(user); // Ensure no attempt to remove user from VIP waiting list.
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCancelBookingNoRoomsNormal() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		when(user.getMemberType()).thenReturn("normal");
		when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(room, never()).addDeluxeRoom();
		verify(waitingList, never()).removeFromNormalWaitingList(user);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCancelBookingNoRoomsNonMember() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		when(user.getMemberType()).thenReturn("non-member");
		when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(room, never()).addStandardRoom();
		verify(waitingList, never()).removeFromNonMemberWaitingList(user);
	}
}
