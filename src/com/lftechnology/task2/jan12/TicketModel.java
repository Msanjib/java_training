package com.lftechnology.task2.jan12;

/**
 * This is the parent class for the Tickets
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public abstract class TicketModel implements Ticketing {
	public float price;
	public String movieName;

	public TicketModel(float price, String movieName) {
		this.price = price;
		this.movieName = movieName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getMovieName()
	 */
	@Override
	public String getMovieName() {
		return movieName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lftechnology.task2.jan12.Ticketing#getPrice()
	 */
	@Override
	public float getPrice() {
		return price;
	}

}
