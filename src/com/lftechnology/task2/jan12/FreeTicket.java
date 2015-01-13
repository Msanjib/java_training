package com.lftechnology.task2.jan12;

/**
 * This is a children of {@link TicketModel} and this is a type with 100% discount and it is specially for children
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class FreeTicket extends TicketModel {
	private float discount = 1f;
	private final String TICKET_TYPE = "Free Ticket";

	public FreeTicket(float price, String movieName) {
		super(price, movieName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getTicketType()
	 */
	@Override
	public String getTicketType() {
		return TICKET_TYPE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getDiscountPercent()
	 */
	@Override
	public float getDiscountPercent() {
		return discount * 100;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getDiscountedAmount()
	 */
	@Override
	public float getDiscountedAmount() {
		return discount * price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getRealPrice()
	 */
	@Override
	public float getRealPrice() {
		return price - getDiscountedAmount();
	}

}
