package Application;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TestCaseB013 {
	WaitingList waitingList = new WaitingList();
	TextFileInputReader reader = new TextFileInputReader();

    private Object[] getParamsExclusive() {
        return reader.readParamsFromFile("B013AParams.txt");
    }
	
	// Tests room booking functionality for normal members with exclusive privileges
	@Test
	@Parameters(method = "getParamsExclusive")
	public void testNormalExclusiveMemberBooking(int vip, int deluxe, int standard, int expectedVIP, int expectedDeluxe, int expectedStandard) {
		// Initializes a user with "normal" status but with exclusive privileges.
        User normalMember = new User("John", "normal", true);
        // Room setup based on parameters.
        Room room = new Room(vip, deluxe, standard);
        // Booking system initialization.
        Booking booking = new Booking(room, waitingList);
        // Simulate booking 2 rooms.
        booking.makeBooking(normalMember, 2);
        // Validate room availability against expected results.
        assertEquals(expectedVIP, room.getAvailableVIPRooms());
        assertEquals(expectedDeluxe, room.getAvailableDeluxeRooms());
        assertEquals(expectedStandard, room.getAvailableStandardRooms());
    }
	
    // Retrieves parameters for tests involving normal members without exclusive privileges.
    private Object[] getParamsNonExclusive() {
        return reader.readParamsFromFile("B013BParams.txt");
    }
	
    // Tests room booking functionality for normal members without exclusive privileges.
    @Test
    @Parameters(method = "getParamsNonExclusive")
    public void testNormalNonExclusiveMemberBooking(int vip, int deluxe, int standard, int expectedVIP, int expectedDeluxe, int expectedStandard) {
        // Initializes a user with "normal" status and no exclusive privileges.
        User normalMember = new User("John", "normal", false);
        // Room setup based on parameters.
        Room room = new Room(vip, deluxe, standard);
        // Booking system initialization.
        Booking booking = new Booking(room, waitingList);
        // Simulate booking 2 rooms.
        booking.makeBooking(normalMember, 2);
        // Validate room availability against expected results.
        assertEquals(expectedVIP, room.getAvailableVIPRooms());
        assertEquals(expectedDeluxe, room.getAvailableDeluxeRooms());
        assertEquals(expectedStandard, room.getAvailableStandardRooms());
    }
}

