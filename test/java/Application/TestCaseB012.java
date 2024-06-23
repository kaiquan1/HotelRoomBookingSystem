package Application;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

//Verify multi-room booking for VIP members when only one VIP room is available.
@RunWith(JUnitParamsRunner.class)
public class TestCaseB012 {
	User vipMember = new User("John", "VIP", false);
	WaitingList waitingList = new WaitingList();
	TextFileInputReader reader = new TextFileInputReader();

	// Method to retrieve test parameters from file.
    private Object[] getParams() {
        return reader.readParamsFromFile("B012Params.txt");
    }
	
	@Test
	@Parameters(method = "getParams") // Specifies that the parameters for the test will be provided by the getParams method.
	public void testVIPMemberBooking(int vip, int deluxe, int standard, int expectedVIP, int expectedDeluxe, int expectedStandard) {
		Room room = new Room(vip, deluxe, standard);
		Booking booking = new Booking(room, waitingList);
		// Simulate booking 3 rooms for a VIP member.
		booking.makeBooking(vipMember, 3);
		 // Assert that the number of available rooms in each category matches the expected values after the booking.
		assertEquals(expectedVIP, room.getAvailableVIPRooms());
		assertEquals(expectedDeluxe, room.getAvailableDeluxeRooms());
		assertEquals(expectedStandard, room.getAvailableStandardRooms());
	}
}

