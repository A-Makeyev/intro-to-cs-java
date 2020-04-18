/**
 * This class represents time that has passed from midnight
 *
 * @author Anatoly Makeyev
 * @version 1.0.0@2020
 *
 */


public class Time2 {

    private int _minFromMid;


    /**
     * Constructor:
     * creates a new Time object in minutes
     *
     * @param hours is the hour as int between 0-23
     * @param minutes is the minute as int between 0-59
     */

    public Time2(int hours, int minutes) {
        if (hours < 0 || hours > 23)
            hours = 0;

        if ((minutes < 0 || minutes > 59))
            minutes = 0;

        _minFromMid = (hours * 60) + minutes;
    }


    /**
     * Copy the constructor
     *
     * @param copyTime to be copied
     */

    public Time2(Time2 copyTime) {
        _minFromMid = copyTime._minFromMid;
    }


// getters & setters

    /**
     * Gets the hour
     * @return the hour
     */
    public int getHour() {
        return _minFromMid / 60;
    }
    /**
     * Gets the minute
     * @return the minute
     */
    public int getMinute() {
        return _minFromMid % 60;
    }

    /**
     * Sets the hour
     * @param hourToSet hour to be set
     */
    public void setHour(int hourToSet) {
        if (hourToSet >= 0 && hourToSet <= 23)
            _minFromMid = hourToSet * 60;
    }
    /**
     * Sets the minute
     * @param minuteToSet minute to be set
     */
    public void setMinute(int minuteToSet) {
        if (minuteToSet >= 0 && minuteToSet <= 59)
            _minFromMid += minuteToSet;
    }


    /**
     * returns the number of minutes passed from midnight
     * e.g. if time is 07:30 returns 450 minutes passed
     *
     * @return minutes passed from midnight
     */

    public int minFromMidnight() {
        return _minFromMid;
    }


    /**
     * checks whether the times are equal
     *
     * @param otherTime an object that represents time
     * @return true if they are, false otherwise
     */

    public boolean equals(Time2 otherTime) {
        return _minFromMid / 60 == otherTime._minFromMid / 60 && _minFromMid % 60 == otherTime._minFromMid % 60;
    }


    /**
     * checks whether a time is before another time
     * e.g. 07:30 is before 13:24 in which case returns true
     *
     * @param otherTime an object that represents time
     * @return true if it is, false otherwise
     */

    public boolean before(Time2 otherTime) {
        return _minFromMid < otherTime._minFromMid;
    }


    /**
     * checks whether a time is after another time
     * e.g. 13:24 is after 07:30 in which case returns true
     * "this" refers to Time2 (if otherTime is before Time2 return true)
     *
     * @param otherTime an object that represents time
     * @return true if it is, false otherwise
     */

    public boolean after(Time2 otherTime) {
        return otherTime.before(this);
    }


    /**
     * checks difference between times
     *
     * @param otherTime an object that represents time
     * @return the time difference in minutes
     */

    public int difference(Time2 otherTime) {
        return Math.abs(_minFromMid - otherTime._minFromMid);
    }


    /**
     * returns a String that represents this time
     * note: overrides default method toString()
     *
     * @return String that represents this hour as: hh:mm
     */

    public String toString() {
        String time = "";
        int hours = _minFromMid / 60;
        int minutes = _minFromMid % 60;

        if (hours < 10)
            time += "0";
        time += hours + ":";

        if(minutes < 10)
            time += "0";
        time += minutes;

        return time;
    }


    /**
     * adds minutes to a time object
     * if the number is negative it reduces it instead
     * creates a new object with the updated time
     * the original object doesn't change
     * e.g. time.addMinutes(25); ~> time object will stay the same
     * time = time.addMinutes(25); ~> will update the current object
     *
     * @param minutesToAdd represents minutes to add
     * @return new time object with added minutes
     */

    public Time2 addMinutes(int minutesToAdd) {
        int timeInMinutesAfter, newDay, hours, minutes;

        timeInMinutesAfter = _minFromMid + minutesToAdd;

        if (timeInMinutesAfter < 0) {
            newDay = timeInMinutesAfter % 1440;
            newDay += 1440; // a day has 1440 minutes!

            hours = newDay / 60;
            minutes = newDay % 60;

            return new Time2(hours, minutes);
        }

        timeInMinutesAfter %= 1440;
        hours = timeInMinutesAfter / 60;
        minutes = timeInMinutesAfter % 60;

        return new Time2(hours, minutes);
    }

}
