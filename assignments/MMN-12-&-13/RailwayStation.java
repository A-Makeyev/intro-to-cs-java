/**
 * This class represents a railway station
 *
 * @author Anatoly Makeyev
 * @version 1.0.0@2020
 *
 */

public class RailwayStation {

    private Train[] _station;
    private int _numberOfTrains;
    private final int MAX_TRAINS = 100;


    /**
     * Default constructor
     */

    public RailwayStation() {
        this._station = new Train[MAX_TRAINS];
        this._numberOfTrains = 0;
    }


    /**
     * Adds a train commute to the train list
     * checks if the train list is not full, and if the same train doesn't exist already
     *
     * @param train represents a Train object
     * @return true if the train was added successfully, false otherwise
     */

    public boolean addTrain(Train trainToAdd) {
        if (this._numberOfTrains == MAX_TRAINS)
            return false;

        if (trainToAdd == null)
            return false;

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].toString().equals(trainToAdd.toString()))
                return false;
        }

        this._station[this._numberOfTrains] = new Train(trainToAdd);
        this._numberOfTrains++;
        return true;
    }


    /**
     * Removes a train commute from the train list
     * checks if the train list is not empty, and if the train exists
     *
     * @param trainToRemove represents a Train object
     * @return true if the train was removed successfully, false otherwise
     */

    public boolean removeTrain(Train trainToRemove) {
        if (this._numberOfTrains == 0)
            return false;

        if (trainToRemove == null)
            return false;

        for (int x = 0; x < this._numberOfTrains; x++) {
            if (this._station[x].toString().equals(trainToRemove.toString())) {
                for (int y = x; y < this._numberOfTrains - 1; y++) {
                    this._station[y] = this._station[y + 1];
                }

                if (x != this._numberOfTrains -1) {
                    this._station[this._numberOfTrains - 1] = null;
                    this._numberOfTrains--;
                    return true;

                } else if (x == _numberOfTrains - 1) {
                    this._station[x] = null;
                    _numberOfTrains--;
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Checks the earliest departure to a given destination
     * if there are no trains at all or no train to this destination it will return null
     * if there are several same destinations it will return the earliest of them
     *
     * @param destination is the destination to check
     * @return the time of the first departure
     */

    public Time1 firstDepartureToDestination(String destination) {
        if (this._numberOfTrains == 0)
            return null;

        boolean isExists = false;
        int temp = 0, earliest = 0;
        Time1 firstDeparture = new Time1(earliest / 60, earliest % 60);

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].getDestination().equals(destination)) {
                temp = this._station[i].getDeparture().minFromMidnight();
                isExists = true;
                break;
            }
        }

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].getDestination().equals(destination)) {
                earliest = this._station[i].getDeparture().minFromMidnight();
                if (earliest <= temp) {
                    firstDeparture = new Time1(earliest / 60, earliest % 60);
                }
            }
        }

        if (isExists)
            return firstDeparture;
        else
            return null;
    }


    /**
     * Checks how many trains are full
     *
     * @return the number of full trains
     */

    public int howManyFullTrains() {
        int fullTrains = 0;
        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].isFull())
                fullTrains++;
        }
        return fullTrains;
    }


    /**
     * Checks the most popular destination
     * if there 2 or more destinations with the same number of trains, return the first one
     * if there are no trains at all, returns null
     *
     * @return the most popular destination
     */

    public String mostPopularDestination() {
        if (this._numberOfTrains == 0)
            return null;

        int count = 0;
        String place = "";

        for(int x = 0; x < this._numberOfTrains; x++) {
            int tempCount = 0;
            String tempPlace = this._station[x].getDestination();

            for(int y = 0; y < this._numberOfTrains; y++) {
                if (this._station[y].getDestination().equals(tempPlace)) {
                    tempCount++;
                }
            }
            if (tempCount > count) {
                place = tempPlace;
                count = tempCount;
            }
        }
        return place;
    }


    /**
     * Checks which train has the most expensive ticket
     * if there 2 or more train with the most expensive ticket, return the first one
     * if there are no trains at all, returns null
     *
     * @return the train with the most expensive ticket
     */

    public Train mostExpensiveTicket() {
        if (this._numberOfTrains == 0)
            return null;

        int mostExpensiveTrain = 0, mostExpensive = this._station[0].getPrice();

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].getPrice() > mostExpensive) {
                mostExpensive = this._station[i].getPrice();
                mostExpensiveTrain = i;
            }
        }
        return new Train(this._station[mostExpensiveTrain]);
    }


    /**
     * Checks which train has the longest ride
     * if 2 or more trains have the same time, returns the first one
     * if there are no trains at all, returns null
     *
     * @return the train with the longest ride
     */

    public Train longestTrain() {
        if (this._numberOfTrains == 0)
            return null;

        int theLongestTrain = 0, highestDuration = this._station[0].getDuration();

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i].getDuration() > highestDuration) {
                highestDuration = this._station[i].getDuration();
                theLongestTrain = i;
            }
        }
        return new Train(this._station[theLongestTrain]);
    }


    /**
     * Prints all the current trains in the station
     * Note: overrides default method toString()
     *
     * @return all the current trains
     */

    public String toString() {
        if (this._numberOfTrains == 0)
            return "There are no trains today.";

        String trainList = "The trains today are: \n";

        for (int i = 0; i < this._numberOfTrains; i++) {
            if (this._station[i] != null) {
                trainList += this._station[i].toString() + "\n";
            }
        }
        return trainList;
    }
}
