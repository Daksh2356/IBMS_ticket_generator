	package IBMS_ticket_generator;
	
	public class Movies extends BookMyShow {
		String movie_name, seat_type, popcorn_type, coke_type, nachos_type;
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
					System.out.println("no coke selected");
				} else {
					System.out.println("enter proper input ");
					addOns();
				}
	
				System.out.println("Do you want nachos ? 1 for yes, 2 for no");
				choice = sc.nextInt();
				if (choice == 1) {
					System.out.println("enter the quantity for nachos");
					nachos_qty = sc.nextInt();
					nachos_type = typeSelection(nachos_qty);
				} else if (choice == 2) {
					System.out.println("no nachos selected");
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
			}  if (coke_qty > 0) {
	
				System.out.println("Coke type selected :" + coke_type);
				System.out.println("Coke Quantity: " + coke_qty);
			}  if (nachos_qty > 0) {
	
				System.out.println("Nachose type selected :" + nachos_type);
				System.out.println("Nachos Quantity: " + nachos_qty);
			}
	
			System.out.println("Total Amount of Booking is: " + amt);
			System.out.println("Tax: 5%");
			System.out.println("Tax amount:" + 0.05 * amt);
			System.out.println("Convenience Fee: " + 0.1 * amt);
			System.out.println("Final payable amount: " + (amt + (0.05 * amt) + (0.1 * amt)));
	
		}
	
		public void selectMovie() {
			if (loc.equals("Dehi")) {
				System.out.println("Enter movie to watch");
				System.out.println("Press 1 for Fighter, 2 for Animal, 3 for Dunki");
				int ch = sc.nextInt();
				if (ch == 1)
					movie_name = "Fighter";
				else if (ch == 2)
					movie_name = "Animal";
				else if (ch == 3)
					movie_name = "Dunki";
				else
					selectMovie();
	
				System.out.println("Selected " + movie_name + " movie");
			}
	
			else if (loc.equals("Bangalore")) {
				System.out.println("Enter movie to watch");
				System.out.println("Press 1 for Salaar, 2 for KGF, 3 for Kantara");
				int ch = sc.nextInt();
				if (ch == 1)
					movie_name = "Salaar";
				else if (ch == 2)
					movie_name = "KGF";
				else if (ch == 3)
					movie_name = "Kantara";
				else
					selectMovie();
	
				System.out.println("Selected " + movie_name + " movie");
			} else {
				System.out.println("Enter movie to watch");
				System.out.println("Press 1 for Pushpa, 2 for Bahabuli, 3 for RRR");
				int ch = sc.nextInt();
				if (ch == 1)
					movie_name = "Pushpa";
				else if (ch == 2)
					movie_name= "Bahabuli";
				else if (ch == 3)
					movie_name = "RRR";
				else
					selectMovie();
	
				System.out.println("Selected " + movie_name + " movie");
			}
			seatSelection();
			generateBill();
		}
	}
