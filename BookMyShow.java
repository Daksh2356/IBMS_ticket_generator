package IBMS_ticket_generator;

import java.util.Scanner;

public class BookMyShow implements IBMS {
	String email_id, pwd, loc;
	Scanner sc = new Scanner(System.in);

	@Override
	public void signup() {
		System.out.println("Enter the email id");
		email_id = sc.next();
		System.out.println("Enter the password");
		pwd = sc.next();
		System.out.println("Signed up sucessfully");
		login();
	}

	@Override
	public boolean login() {
		System.out.println("Do you have an account already ? Yes or No");
		char ch = sc.next().charAt(0);
		if (ch == 'n' || ch == 'N') {
			System.out.println("Please sign up first");
			signup();
//			return true;
		} else if (ch == 'Y' || ch == 'y') {
			System.out.println("enter your email id");
			String cnfmail = sc.next();
			System.out.println("Enter the pwd");
			String cnfpwd = sc.next();
			if (cnfmail.equalsIgnoreCase(email_id) && cnfpwd.equals(pwd)) {
				System.out.println("Login successfull");
//				return true;
			}
			else {
				System.out.println("enter valid credentials");
				login();
			}
		} else {
			System.out.println("enter proper input");
			login();
		}
		
		return true;
	}
	
	@Override
	public int content() {
		System.out.println("Enter choice");
		System.out.println("1 for movies");
		System.out.println("2 for comedy");
		int ch = sc.nextInt();
		
		if(ch == 1) {
			System.out.println("movies entered");
		}
		else if(ch == 2) {
			System.out.println("comedy entered");
		}
		else {
			System.out.println("wrong choice");
		}
		
		return ch;
	}
	
	@Override
	public void loc(BookMyShow b) {
		if(b instanceof Movies) {
			System.out.println("enter location");
			System.out.println("press 1 for Delhi, 2 for Bangalore, 3 for Pune ");
			int ch = sc.nextInt();
			if(ch == 1)
				loc = "Delhi";
			else if(ch == 2)
				loc = "Bangalore";
			else if(ch == 3)
				loc = "Pune";
			else 
				loc(b);
			System.out.println("Selected location is : " + loc);
		}
		else if(b instanceof Comedy) {
			System.out.println("enter location");
			System.out.println("press 1 for Delhi, 2 for Hyderabad, 3 for Gurugram ");
			int ch = sc.nextInt();
			if(ch == 1)
				loc = "Delhi";
			else if(ch == 2)
				loc = "Hyderabad";
			else if(ch == 3)
				loc = "Gurugram";
			else 
				loc(b);
			System.out.println("Selected location is : " + loc);
		}
	}
	
	@Override
	public void fullBookings() {
		int x = content();
		if(x == 1) {
			Movies m = new Movies();
			m.loc(m);
			m.selectMovie();
		}
		else if(x == 2) {
			Comedy c = new Comedy();
			c.loc(c);
			c.selectShow();
		}
		else {
			System.out.println("enter proper input");
			fullBookings();
		}
		
	}
	
}
