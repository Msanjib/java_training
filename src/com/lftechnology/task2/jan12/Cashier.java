package com.lftechnology.task2.jan12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Question: In QFX cinemas, there are different types of customers.
 * <ul>
 * <li>Less than 4 feet will get free entry.</li>
 * <li>Above 60 years will get 50% discount on the tickets.</li>
 * <li>Foreign customers will have to pay 200% on the tickets.</li>
 * </ul>
 * The Cashier in QFX counter uses certain button to print the ticket based on above conditions.WAP to accommodate the above scenario.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class Cashier {
	private static int seatCapacity = 4;
	private static int seatRem = seatCapacity;
	private static String movieName = "Assassins Creed";
	private static String location = "QFX, Kathmandu";
	private static float priceTicket = 1000;
	private static final Logger LOGGER = Logger.getLogger(Cashier.class.getName());

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Ticketing ticket = null;
		String choice = "";
		List<Ticketing> soldTickets = new ArrayList<Ticketing>();
		try {
			while (seatRem > 0) {
				displayUIMessage(location, seatRem);
				choice = getSelectedInputFromUser(userInput, "Select choice(1,2,3,4,5):", "1", "2", "3", "4", "5");
				switch (choice) {
				case "1":
					// Free ticket
					ticket = new FreeTicket(priceTicket, movieName);
					displayTicketInfo(ticket);
					break;
				case "2":
					// Discounted Ticket
					ticket = new DiscountedTicket(priceTicket, movieName);
					displayTicketInfo(ticket);
					break;
				case "3":
					// Normal Ticket with no discount
					ticket = new NormalTicket(priceTicket, movieName);
					displayTicketInfo(ticket);
					break;
				case "4":
					// Foreigner Ticket with 200% payable
					ticket = new ForeignerTicket(priceTicket, movieName);
					displayTicketInfo(ticket);
					break;
				case "5":
					displayAllSoldTickets(soldTickets);
					// increase seats to neutralize with the seat decrement below because this choice does not require the decement of seats
					seatRem++;
					break;

				default:
					break;
				}
				seatRem--;
				soldTickets.add(ticket);
				if (seatRem == 0) {
					LOGGER.info("All tickets are sold. Wait for new session");
				} else {
					getSelectedInputFromUser(userInput, "Seats Remaining:" + seatRem + "\nPress \"g\" to go again:", "g");
				}

			}
		} finally {
			userInput.close();
		}

	}

	/**
	 * displays all the tickets sold
	 * 
	 * @param soldTickets
	 *            lists of {@link Ticketing} instance to be displayed
	 * @author Sanjib<sanjibmaharjan@lftechnology.com>
	 */
	public static void displayAllSoldTickets(List<Ticketing> soldTickets) {
		for (Ticketing ticket : soldTickets) {
			displayTicketInfo(ticket);
		}
	}

	/**
	 * This method provides UI functionality to the cashier.
	 * 
	 * @param location
	 *            location of the cinema
	 * @param seatRem
	 *            no. of seat remaining in the cinema hall
	 * @author Sanjib<sanjibmaharjan@lftechnology.com>
	 */
	public static void displayUIMessage(String location, int seatRem) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		LOGGER.log(
				Level.INFO,
				"Welcome\n{0}, Seats Remaining:{1}, {2}\n1.Print Free Ticket\n2.Print Discounted Ticket\n3.Print Normal Ticket\n4.Print Foreigners Ticket\n5.Show all sold Tickets",
				new Object[] { location, seatRem, dateFormat.format(cal.getTime()) });

	}

	/**
	 * This method logs the information of {@link Ticketing} instance in a ticket format
	 * 
	 * For eg.
	 * <p>
	 * ...............................
	 * 
	 * Ticket:Free Movie:Hobbit
	 * 
	 * Rs.1000 Discount:10%
	 * 
	 * ...............................
	 * </p>
	 * 
	 * @param ticket
	 *            a {@link Ticketing} instance
	 * @author Sanjib<sanjibmaharjan@lftechnology.com>
	 */
	public static void displayTicketInfo(Ticketing ticket) {
		LOGGER.log(
				Level.INFO,
				"\n{0}\n\n  {1}  Movie - {2}\n\n  Price:Rs{3}\n  Discount:Rs{4}({5}%)\n {6}\n  Total:Rs.{7}\n\n{8}",
				new Object[] { getStringSequence(".", 50), ticket.getTicketType(), movieName, ticket.getPrice(),
						ticket.getDiscountedAmount(), ticket.getDiscountPercent(), getStringSequence("-", 25), ticket.getRealPrice(),
						getStringSequence(".", 50) });
	}

	/**
	 * This method gets the input from the user
	 * 
	 * @param scanner
	 *            A {@link Scanner} instance to get user input
	 * @param message
	 *            a message to display to the users
	 * @param selectedInputs
	 *            if conditions are set then the users will be prompted until and unless the user inputs the values in the conditions
	 * @return the input from the user as the String object @see {@link Scanner}
	 * @author Sanjib<sanjibmaharjan@lftechnology.com>
	 */
	public static String getSelectedInputFromUser(Scanner scanner, String message, String... selectedInputs) {
		String inputUser = "";
		boolean loopAgain = true;
		while (loopAgain) {
			LOGGER.info(message);
			inputUser = scanner.nextLine();
			if (!inputUser.equals("") && selectedInputs.length == 0) {
				loopAgain = false;
			} else {
				for (String cond : selectedInputs) {
					if (inputUser.equals(cond)) {
						loopAgain = false;
						break;
					}
				}
			}
		}
		return inputUser;
	}

	/**
	 * This method gets the sequence of strings
	 * 
	 * @param type
	 *            the string to append in the sequence
	 * @param nums
	 *            number of times the string should be appended
	 * @return the sequence of {@link String} <code>type</code> appended {@link Integer} <code>nums</code> times.
	 * @author Sanjib<sanjibmaharjan@lftechnology.com>
	 */
	public static String getStringSequence(String type, int nums) {
		StringBuilder sequenceBuilder = new StringBuilder();
		for (int i = 0; i < nums; i++) {
			sequenceBuilder.append(type);
		}
		return sequenceBuilder.toString();

	}
}
