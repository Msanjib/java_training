package com.lftechnology.task2.jan12;

/**
 * This is a children of {@link TicketModel} and this is a type with 50% and specifically for old aged people above 60 years
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class DiscountedTicket extends TicketModel {
	private float discount = 0.5f;
	private final String TICKET_TYPE = "Old Age Ticket(Above 60 years)";

	public DiscountedTicket(float price, String movieName) {
		super(price, movieName);
	}

	@Override
	public String getTicketType() {
		return TICKET_TYPE;
	}

	@Override
	public float getDiscountPercent() {
		return discount * 100;
	}

	@Override
	public float getDiscountedAmount() {
		return discount * price;
	}

	@Override
	public float getRealPrice() {
		return price - getDiscountedAmount();
	}

}