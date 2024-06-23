package Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(2, 2, 2);
        WaitingList waitingList = new WaitingList(); 
        User user = new User();
        Booking booking = new Booking(room, waitingList); 
        Scanner scanner = new Scanner(System.in); 
        Printer printer = new Printer();

        System.out.println("Welcome to the Hotel Room Booking System!");
        
        while (true) {
            try {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Sign In");
                System.out.println("2. Display available rooms");
                System.out.println("3. Book Rooms");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Display Your Booking Information");
                System.out.println("6. Display Current Waiting Lists");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        // Sign In
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Are you a VIP member, normal member, or non-member? ");
                        String memberType = scanner.nextLine().toLowerCase();
                        boolean hasExclusiveReward = false;
                        if (memberType.equals("normal")) {
                            System.out.print("Do you have an exclusive reward? (yes/no): ");
                            String rewardInput = scanner.nextLine().toLowerCase();
                            if (rewardInput.equals("yes")) {
                                hasExclusiveReward = true;
                            }
                        }
                        user.setName(name);
                        user.setMemberType(memberType);
                        user.setExclusiveReward(hasExclusiveReward);
                        System.out.println("Signed in as: " + user.getName());
                        break;
                        
                    case 2:
                    	// Display Available Rooms
                    	printer.printAvailableRooms(room);
                    	break;
                    	
                    case 3:
                        // Book Rooms
                        System.out.print("Enter the number of rooms you want to book: ");
                        int numOfRooms = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        booking.makeBooking(user, numOfRooms);
                        System.out.println("Booking successful!");
                        break;
                        
                    case 4:
                        // Cancel Booking
                    	try {
	                        System.out.println("Are you sure you want to cancel your booking? (yes/no)");
	                        String cancelInput = scanner.nextLine();
							if (cancelInput.equalsIgnoreCase("yes")) {
								booking.cancelBooking(user);
								System.out.println("Booking cancelled successfully.");
							}
	                        break;
						} catch (IllegalStateException e) {
							System.out.println(e.getMessage());
						}
						break;

                    case 5:
                    	// Print Booking Information
                    	printer.printBookingInfo(user, booking.getBookedRooms());
                    	break;
                    	
                    case 6:
						// Display Waiting Lists
						printer.printWaitingLists(waitingList);
						break;
						
                    case 7:
                    	// Exit
                        System.out.println("Exiting the Hotel Room Booking System...");
                        printer.printBookingInfo(user, booking.getBookedRooms());
                        printer.printWaitingLists(waitingList);
                        scanner.close();
                        return; // Exit the program
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Booking failed: " + e.getMessage());
            }
        }
    } 
}



