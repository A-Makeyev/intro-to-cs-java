/**
 * This class represents a train commute
 *
 * @author Anatoly Makeyev
 * @version 1.0.0@2020
 *
 */

public class Train {

    private String _destination;
    private Time1 _departure;
    private int _duration;
    private int _passengers;
    private int _seats;
    private int _price;

    private final int EMPTY_SEATS = 0;
    private final int EMPTY_PRICE = 0;
    private final int NO_DURATION = 0;
    private final int NONE_PASSENGERS = 0;


    /**
     * Constructor of class Train. Constructs a new train. duration should be positive,
     * otherwise it should be set to 0. passengers should be positive, otherwise it should be set to 0.
     * passengers should be less than seats otherwise it should be set to seats. seats should be positive,
     * otherwise it should be set to 0. price should be positive, otherwise it should be set to 0.
     * destination should not be empty, if it is, it will be set to unknown destination.
     *
     * @param destination is the destination as String
     * @param hour is the departure hour
     * @param minute is the departure minute
     * @param duration is the commute duration as int
     * @param passengers is the number of passengers as int
     * @param seats is the number of seats as int
     * @param price is the price as it
     */

    public Train(String destination, int hour, int minute, int duration, int passengers, int seats, int price) {

        this._departure = new Time1(hour, minute);

        if (destination != null && !destination.isEmpty())
            this._destination = new String(destination);
        else
            this._destination = "Unknown Destination";

        if (duration < NO_DURATION)
            this._duration = NO_DURATION;
        else
            this._duration = duration;

        if (price < EMPTY_PRICE)
            this._price = EMPTY_PRICE;
        else
            this._price = price;

        if (seats < EMPTY_SEATS)
            this._seats = EMPTY_SEATS;
        else
            this._seats = seats;

        if (passengers < NONE_PASSENGERS)
            this._passengers = NONE_PASSENGERS;
        else
            this._passengers = passengers;

        if (this._passengers > this._seats)
            this._passengers = this._seats;
        else
        	this._passengers = this._passengers;
    }


    /**
     * Copy the constructor
     *
     * @param copyTrain object to be copied
     */

    public Train(Train copyTrain) {
        this._seats = copyTrain._seats;
        this._price = copyTrain._price;
        this._duration = copyTrain._duration;
        this._passengers = copyTrain._passengers;
        this._destination = copyTrain._destination;
        // define a new object for anti aliasing!
        this._departure = new Time1(copyTrain._departure);
    }


    // getters

    /**
     * Gets the destination
     * @return the destination
     */
    public String getDestination() {
        return new String(this._destination);
    }
    /**
     * Gets the departure
     * @return the departure
     */
    public Time1 getDeparture() {
    	// define a new object for anti aliasing!
        return new Time1(this._departure);
    }
    /**
     * Gets the duration
     * @return the duration
     */
    public int getDuration() {
        return this._duration;
    }
    /**
     * Gets the passengers
     * @return the passengers
     */
    public int getPassengers() {
        return this._passengers;
    }
    /**
     * Gets the seats
     * @return the seats
     */
    public int getSeats() {
        return this._seats;
    }
    /**
     * Gets the price
     * @return the price
     */
    public int getPrice() {
        return this._price;
    }

    // setters

    /**
     * Sets the destination
     * @param destination to be set
     */
    public void setDestination(String destination) {
        if (destination != null && !destination.isEmpty())
            this._destination = destination;
        else
            this._destination = "Unknown Destination";
    }
    /**
     * Sets the departure
     * @param departure to be set
     */
    public void setDeparture(Time1 departure) {
    	// define new object for anti aliasing!
        this._departure = new Time1(departure);
    }
    /**
     * Sets the duration
     * @param duration to be set
     */
    public void setDuration(int duration) {
        if (duration >= NO_DURATION)
            this._duration = duration;
    }
    /**
     * Sets the passengers
     * @param passengers to be set
     */
    public void setPassengers(int passengers) {
        if (passengers > this._seats) {	
        	this._passengers = this._seats;
        } else if (passengers >= NONE_PASSENGERS) {
        	this._passengers = passengers;
        }
    }
    /**
     * Sets the seats
     * @param seats to be set
     */
    public void setSeats(int seats) {
        if (seats >= this._passengers)
            this._seats = seats;
    }
    /**
     * Sets the price
     * @param price to be set
     */
    public void setPrice(int price) {
        if (price >= EMPTY_PRICE)
            this._price = price;
    }


    /**
     * asserts whether the train commute details are equal
     * checks by destination, number of seats, and time of departure
     *
     * @param otherTrain an object that represents a train commute
     * @return true if they are, false otherwise
     */

    public boolean equals(Train otherTrain) {
        return this._destination.equals(otherTrain._destination)
        	   && this._departure.equals(otherTrain._departure)
               && this._seats == otherTrain._seats;
    }


    /**
     * calculates the time the train will arrive to the destination
     * e.g. if the train leaves at 10:00 and the duration is 2 hours (120 minutes) it will arrive at 12:00
     * note: uses addMinutes() method from Time1
     *
     * @return the arrival time as a time object
     */

    public Time1 getArrivalTime() {
        return this._departure.addMinutes(this._duration);
    }


    /**
     * adds passengers if there are empty seats
     *
     * @param passengersToAdd number of passengers to add as an int
     * @return true if the passengers were added, false otherwise
     */

    public boolean addPassengers(int passengersToAdd) {
        if (this._passengers + passengersToAdd <= this._seats) {
            this._passengers += passengersToAdd;
            return true;
        }
        return false;
    }


    /**
     * asserts whether the train is full
     *
     * @return true if it is, otherwise false
     */

    public boolean isFull() {
        return this._passengers == this._seats;
    }


    /**
     * asserts whether the train ticket price is cheaper
     *
     * @param otherTrain is a Train object
     * @return true if it is, otherwise false
     */

    public boolean isCheaper(Train otherTrain) {
        return this._price < otherTrain._price;
    }


    /**
     * calculates the total price of all passengers on the train
     *
     * @return the total price
     */

    public int totalPrice() {
        return this._passengers * this._price;
    }


    /**
     * asserts whether a train arrives before another train
     *
     * @param otherTrain
     * @return true if it is, false otherwise
     */

    public boolean arrivesEarlier(Train otherTrain) {
    	return this.getArrivalTime().before(otherTrain.getArrivalTime());
    }


    /**
     * prints the train details as follows:
     * "Train to (destination) departs at (departure). Train is full"
     * if the train is not full it will print accordingly
     * note: overrides default method toString()
     *
     * @return train details
     */

    public String toString() {
        if (this.isFull()) {
            return "Train to " + this._destination + " departs at " + this._departure + ". Train is full.";
        } else {
            return "Train to " + this._destination + " departs at " + this._departure + ". Train is not full.";
        }
    }
}
