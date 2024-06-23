package Application;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


//Verify cancellation of booking multiple rooms
public class TestCaseC002 {
	@Test
	public void testCancelBookingMultipleRoomsVIP() {
 Room room = mock(Room.class); // Mocking the Room class.
        User user = mock(User.class); // Mocking the User class.
        WaitingList waitingList = mock(WaitingList.class); // Mocking the WaitingList class.
        Booking booking = new Booking(room, waitingList); // Creating an instance of Booking with mocked dependencies.
        
        // Simulating the booking of three VIP rooms.
        booking.bookedRooms.add("VIP");
        booking.bookedRooms.add("VIP");
        booking.bookedRooms.add("VIP");
        
        // Setting up the user type and waiting list behavior.
        when(user.getMemberType()).thenReturn("vip");
        when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
        
        // Performing the cancellation.
        booking.cancelBooking(user);
        
        // Verifying the booking list is empty after cancellation.
        assertTrue(booking.getBookedRooms().isEmpty());
        
        // Verifying that the addVIPRoom method was called three times, once for each cancelled room.
        verify(room, times(3)).addVIPRoom();
        
        // Verifying that the user was not erroneously removed from the VIP waiting list.
        verify(waitingList, never()).removeFromVIPWaitingList(user);
	}
	
	@Test
	public void testCancelBookingMultipleRoomsNormal() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		// Simulating the booking of three Deluxe rooms.
		booking.bookedRooms.add("Deluxe");
		booking.bookedRooms.add("Deluxe");
		booking.bookedRooms.add("Deluxe");
		when(user.getMemberType()).thenReturn("normal");
		when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(room, times(3)).addDeluxeRoom();
		verify(waitingList, never()).removeFromNormalWaitingList(user);
	}
	
	@Test
	public void testCancelBookingMultipleRoomsNonMember() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		// Simulating the booking of three Standard rooms.
		booking.bookedRooms.add("Standard");
		booking.bookedRooms.add("Standard");
		booking.bookedRooms.add("Standard");
		when(user.getMemberType()).thenReturn("non-member");
		when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(room, times(3)).addStandardRoom();
		verify(waitingList, never()).removeFromNonMemberWaitingList(user);
	}
}
