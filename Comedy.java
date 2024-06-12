package IBMS_ticket_generator;

public class Comedy extends BookMyShow {
	String comedian_name, seat_type, popcorn_type, coke_type, nachos_type;
	double amt;
	int no_of_seat, popcorn_qty, coke_qty, nachos_qty;

	public void seatSelection() {
		System.out.println("enter the type of seat");
		System.out.println("1 for normal 150rs, 2 for executive 250rs, 3 for recliner 500rs");
		int ch = sc.nextInt();
		System.out.println("enter the number of seat");
		no_of_seat = sc.nextInt();
		if (ch == 1) {
			seat_type = "Normal";
			amt += no_of_seat * 150;
		} else if (ch == 2) {
			seat_type = "executive";
			amt += no_of_seat * 250;
		} else if (ch == 3) {
			seat_type = "recliner";
			amt += no_of_seat * 500;
		} else {
			System.out.println("enter proper input");
			seatSelection();
		}
		addOns();
	}

	public void addOns() {
		System.out.println("let's get you started for addons!!");
		System.out.println("Do you want to continue ? Y/N");
		char addon = sc.next().charAt(0);
		if (addon == 'Y' || addon == 'y') {
			System.out.println("Do you want popcorn ? 1 for yes , 2 for no ");
			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("enter the quantity for popcorn");
				popcorn_qty = sc.nextInt();
				popcorn_type = typeSelection(popcorn_qty);
			} else if (choice == 2) {
				System.out.println("no popcorn selected");
			} else {
				System.out.println("enter proper input ");
				addOns();
			}

			System.out.println("Do you want coke ? 1 for yes, 2 for no");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("enter the quantity for coke");
				coke_qty = sc.nextInt();
				coke_type = typeSelection(coke_qty);
			} else if (choice == 2) {
				System.out.println("no popcorn selected");
			} else {
				System.out.println("enter proper input ");
				addOns();
			}

			System.out.println("Do you want nachos ? 1 for yes, 2 for no");
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("enter the quantity for nachos");
				coke_qty = sc.nextInt();
				coke_type = typeSelection(coke_qty);
			} else if (choice == 2) {
				System.out.println("no popcorn selected");
			} else {
				System.out.println("enter proper input ");
				addOns();
			}

		}
	}

	public String typeSelection(int qty) {
		System.out.println("press 1 for small ---> 150 rs");
		System.out.println("press 2 for medium ---> 300 rs");
		System.out.println("press 3 for large ---> 500 rs");
		int type = sc.nextInt();
		String addonType = "";
		if (type == 1) {
			amt += 150 * qty;
			addonType = "small";
		} else if (type == 2) {
			amt += 300 * qty;
			addonType = "medium";
		} else if (type == 3) {
			amt += 500 * qty;
			addonType = "large";
		}
		return addonType;

	}

	public void generateBill() {
		System.out.println("Here's your bill");
		System.out.println("Seat type selected :" + seat_type);
		System.out.println("Number of seats: " + no_of_seat);
		if (popcorn_qty > 0) {
			System.out.println("Popcorn type selected :" + popcorn_type);
			System.out.println("Popcorn Quantity: " + popcorn_qty);
		} else if (coke_qty > 0) {

			System.out.println("Coke type selected :" + coke_type);
			System.out.println("Coke Quantity: " + coke_qty);
		} else if (nachos_qty > 0) {

			System.out.println("Nachose type selected :" + nachos_type);
			System.out.println("Nachos Quantity: " + nachos_qty);
		}

		System.out.println("Total Amount of Booking is: " + amt);
		System.out.println("Tax: 5%");
		System.out.println("Tax amount:" + 0.05 * amt);
		System.out.println("Convenience Fee: " + 0.1 * amt);
		System.out.println("Final payable amount: " + (amt + (0.05 * amt) + (0.1 * amt)));

	}

	public void selectShow() {
		if (loc.equals("Dehi")) {
			System.out.println("Enter comedian to listen");
			System.out.println("Press 1 for Bassi, 2 for Gujral");
			int ch = sc.nextInt();
			if (ch == 1)
				comedian_name = "Bassi";
			else if (ch == 2)
				comedian_name = "Gurjal";
			else
				selectShow();

			System.out.println("Selected " + comedian_name + " comedian");
		}

		else if (loc.equals("Hyderabad")) {
			System.out.println("Enter movie to watch");
			System.out.println("Press 1 for Abhimnayu, 2 for Munna Bhai");
			int ch = sc.nextInt();
			if (ch == 1)
				comedian_name = "Abhimanyu";
			else if (ch == 2)
				comedian_name = "Munna Bhai";
			else
				selectShow();

			System.out.println("Selected " + comedian_name + " comedian");
		} else {
			System.out.println("Enter movie to watch");
			System.out.println("Press 1 for Abhishek, 2 for Zakir");
			int ch = sc.nextInt();
			if (ch == 1)
				comedian_name = "Abhishek";
			else if (ch == 2)
				comedian_name = "Zakir";
			else
				selectShow();

			System.out.println("Selected " + comedian_name + " comedian");
		}
		seatSelection();
		generateBill();
	}

}
