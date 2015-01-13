package com.lftechnology.task2.jan12;

/**
 * This is a children of {@link TicketModel} and this is a type with no discount but 200% payable which is specially for foreigners.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public class ForeignerTicket extends TicketModel {
	private float discount = -1f;
	private final String TICKET_TYPE = "Foreigner Ticket";

	public ForeignerTicket(float price, String movieName) {
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