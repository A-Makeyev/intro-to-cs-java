/**
 * This class represents a time in hours & minutes
 *
 * @author Anatoly Makeyev
 * @version 1.0.0@2020
 *
 */

public class Time1 {

    private int _hour;
    private int _minute;



    /**
     * Constructor:
     * creates a new Time object
     *
     * @param hour is the hour as int between 0-23
     * @param minute is the minute as int between 0-59
     */

    public Time1(int hour, int minute) {
        if (hour < 0 || hour > 23)
            this._hour = 0;
        else
            this._hour = hour;

        if (minute < 0 || minute > 59)
            this._minute = 0;
        else
            this._minute = minute;

    }


    /**
     * Copy the constructor
     *
     * @param copyTime to be copied
     */

    public Time1(Time1 copyTime) {
        this._hour = copyTime._hour;
        this._minute = copyTime._minute;
    }


    // getters & setters

    /**
     * Gets the hour
     * @return the hour
     */
    public int getHour() {
        return this._hour;
    }
    /**
     * Gets the minute
     * @return the minute
     */
    public int getMinute() {
        return this._minute;
    }

    /**
     * Sets the hour
     * @param hourToSet
     */
    public void setHour(int hourToSet) {
        if (hourToSet >= 0 && hourToSet <= 23)
            this._hour = hourToSet;
    }
    /**
     * Sets the minute
     * @param minuteToSet
     */
    public void setMinute(int minuteToSet) {
        if (minuteToSet >= 0 && minuteToSet <= 59)
            this._minute = minuteToSet;
    }


    /**
     * returns a String that represents this hour
     * note: overrides default method toString()
     *
     * @return String that represents this hour as: hh:mm
     */

    public String toString() {
        String time = "";

        if (this._hour < 10)
            time += "0";
        time += this._hour + ":";

        if(this._minute < 10)
            time += "0";
        time += _minute;

        return time;
    }


    /**
     * returns the number of minutes passed from midnight
     * e.g. if time is 07:30 returns 450 minutes passed
     *
     * @return minutes passed from midnight
     */

    public int minFromMidnight() {
        return (this._hour * 60) + this._minute;
    }














}