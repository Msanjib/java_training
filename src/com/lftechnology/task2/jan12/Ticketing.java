package com.lftechnology.task2.jan12;

/**
 * The method to be implemented by the ticket model.
 * 
 * @author Sanjib<sanjibmaharjan@lftechnology.com>
 * 
 */
public interface Ticketing {
	/**
	 * This method returns the real price
	 * 
	 * @return value after substrating the discount
	 */
	public float getRealPrice();

	/**
	 * @return the name of the movie
	 */
	public String getMovieName();

	/**
	 * @return the value with substating the discount amount
	 */
	public float getPrice();

	/**
	 * @return the discount percentage
	 */
	public float getDiscountPercent();

	/**
	 * @return the discounted money
	 */
	public float getDiscountedAmount();

	/**
	 * This methods distinguishes the type of ticket whether it is free, discounted, normal or foreigner.
	 * 
	 * @return the type of the ticket
	 */
	public String getTicketType();
}
