package Application;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

//Verify invalid booking requests where a user requests more rooms than allowed or where a user requests 0 rooms.
@RunWith(JUnitParamsRunner.class)
public class TestCaseB014 {
	WaitingList waitingList = new WaitingList();
	Room room = new Room(3, 3, 3); // Room setup with 3 rooms available in each category.
	Booking booking = new Booking(room, waitingList);
	
	private Object[] getParams() {
		return new Object[] { 
            new Object[] {"vip", 4}, // More rooms requested than available.
            new Object[] {"vip", 0}, // Zero rooms requested.
            new Object[] {"normal", 3}, // Edge case: Exactly the number of available rooms.
            new Object[] {"normal", 0}, // Zero rooms requested.
            new Object[] {"non-member", 2}, // Valid request but included for completeness.
            new Object[] {"non-member", 0}, // Zero rooms requested.
		};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getParams")
	public void testInvalidBooking(String memberType, int numOfRooms) {
		User user = new User("John", memberType, false);
		booking.makeBooking(user, numOfRooms);
	}
}

