package IBMS_ticket_generator;

public class BMSRunner {
	public static void main(String[] args) {
		IBMS i = new BookMyShow();
		if (i.login()) {
			i.fullBookings();
		} else {
			System.out.println("login failed");
		}
	}
}
