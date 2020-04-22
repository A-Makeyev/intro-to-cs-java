/**
 * This class represents a certain time in hours & minutes
 *
 * @author Anatoly Makeyev
 * @version 1.0.0@2020
 *
 */

public class Time1 {

    private int _hour;
    private int _minute;


    final int ZERO = 0;
    final int MAX_HOURS = 23;
    final int MAX_MINUTES = 59;
    final int HOUR_IN_MINUTES = 60;
    final int DAY_IN_MINUTES = 1440;
    final int TWO_DIGIT_NUMBER = 10;


    /**
     * Constructor:
     * creates a new Time object
     *
     * @param hour is the hour as int between 0-23
     * @param minute is the minute as int between 0-59
     */

    public Time1(int hour, int minute) {
        if (hour < ZERO || hour > MAX_HOURS)
            this._hour = ZERO;
        else
            this._hour = hour;

        if (minute < ZERO || minute > MAX_MINUTES)
            this._minute = ZERO;
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
     * @param hourToSet hour to be set
     */
    public void setHour(int hourToSet) {
        if (hourToSet >= ZERO && hourToSet <= MAX_HOURS)
            this._hour = hourToSet;
    }
    /**
     * Sets the minute
     * @param minuteToSet minute to be set
     */
    public void setMinute(int minuteToSet) {
        if (minuteToSet >= ZERO && minuteToSet <= MAX_MINUTES)
            this._minute = minuteToSet;
    }


    /**
     * returns a String that represents this time
     * note: overrides default method toString()
     *
     * @return String that represents this hour as: hh:mm
     */

    public String toString() {
        String time = "";

        if (this._hour < TWO_DIGIT_NUMBER)
            time += "0";
        time += this._hour + ":";

        if(this._minute < TWO_DIGIT_NUMBER)
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
        return (this._hour * HOUR_IN_MINUTES) + this._minute;
    }


    /**
     * checks whether the times are equal
     *
     * @param otherTime an object that represents time
     * @return true if they are, false otherwise
     */

    public boolean equals(Time1 otherTime) {
        return this._hour == otherTime._hour && this._minute == otherTime._minute;
    }


    /**
     * checks whether a time is before another time
     * e.g. 07:30 is before 13:24 in which case returns true
     *
     * @param otherTime an object that represents time
     * @return true if it is, false otherwise
     */

    public boolean before(Time1 otherTime) {
        if (this._hour < otherTime._hour) {
            return true;
        }

        if (this._hour == otherTime._hour && this._minute < otherTime._minute) {
            return true;
        }
        return false;
    }


    /**
     * checks whether a time is after another time
     * e.g. 13:24 is after 07:30 in which case returns true
     * "this" refers to Time1 (if otherTime is before Time1 return true)
     *
     * @param otherTime an object that represents time
     * @return true if it is, false otherwise
     */

    public boolean after(Time1 otherTime) {
        return otherTime.before(this);
    }


    /**
     * checks difference between times
     *
     * @param otherTime an object that represents time
     * @return the time difference in minutes
     */

    public int difference(Time1 otherTime) {
        return Math.abs(((this._hour - otherTime._hour) * HOUR_IN_MINUTES) + (this._minute - otherTime._minute));
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

    public Time1 addMinutes(int minutesToAdd) {
        int timeInMinutesBefore, timeInMinutesAfter, newDay, hours, minutes;

        timeInMinutesBefore = (this._hour * HOUR_IN_MINUTES) + this._minute;
        timeInMinutesAfter = timeInMinutesBefore + minutesToAdd;

        if (timeInMinutesAfter < ZERO) {
            newDay = timeInMinutesAfter % DAY_IN_MINUTES;
            newDay += DAY_IN_MINUTES; // a day has 1440 minutes!

            hours = newDay / HOUR_IN_MINUTES;
            minutes = newDay % HOUR_IN_MINUTES;

            return new Time1(hours, minutes);
        }

        timeInMinutesAfter %= DAY_IN_MINUTES;
        hours = timeInMinutesAfter / HOUR_IN_MINUTES;
        minutes = timeInMinutesAfter % HOUR_IN_MINUTES;

        return new Time1(hours, minutes);
    }
}
