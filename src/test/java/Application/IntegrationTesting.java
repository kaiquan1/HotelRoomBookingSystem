package Application;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Verify room assignments for VIP members when VIP rooms are available
public class IntegrationTesting {
	WaitingList waitingList = new WaitingList();
	User vipMember = new User("John", "VIP", false);
	Room room = new Room(3, 3, 3);
	Booking booking = new Booking(room, waitingList);
	
	@Test
	public void testVIPBooking(){
		booking.makeBooking(vipMember, 1);
		assertEquals(2, room.getAvailableVIPRooms());
	}
	
	//Cancel the booking for the VIP room
	@Test
	public void testCancelBookingVIP() {
		Room room = mock(Room.class);
		User user = mock(User.class);
		WaitingList waitingList = mock(WaitingList.class);
		Booking booking = new Booking(room, waitingList);
		booking.bookedRooms.add("VIP");
		when(user.getMemberType()).thenReturn("vip");
		when(waitingList.findUserInWaitingList(anyList(), eq(user))).thenReturn(false);
		booking.cancelBooking(user);
        assertTrue(booking.getBookedRooms().isEmpty());
		verify(room).addVIPRoom();
		verify(waitingList, never()).removeFromVIPWaitingList(user);
	}
}
