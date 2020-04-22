public class Date {

    private int _day;
    private int _month;
    private int _year;


    public Date(int day, int month, int year) {
        if (day > 0)
            this._day = day;
        else
            this._day = 1;

        if (month > 0)
            this._month = month;
        else
            this._month = 1;

        if (year > 1900)
            this._year = year;
        else
            this._year = 1900;
    }


    // prevent aliasing
    public Date(Date other) {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }


    public String toString() {
        String date = "";
        if (this._day < 10) {
            date += "0";
        }

        date += this._day + "/";

        if (this._month < 10) {
            date += "0";
        }

        return date += this._month + "/" + this._year;
    }


    public boolean isEqual(Date other) {

        return this._day == other._day && this._month == other._month && this._year == other._year;

        // same as:

        // if (this._day == other._day && this._month == other._month && this._year == other._year) {
        //     return true;
        // } else {
        //     return false;
        // }
    }

    public boolean isBefore(Date other) {
        // returns true or false
        return this._year < other._year || (this._year == other._year && this._month < other._month) || (this._year == other._year && this._month == other._month && this._day < other._day);
    }

    public boolean isAfter(Date other) {
        // just like isBefore() but for the opposite date
        // which means other date will check if original date is before
        return other.isBefore(this);
        // "if I'm older than Olga, then Olga is younger than me"
    }


    // setters
    public void setDay(int day) {
        if (day > 0)
            this._day = day;
        else
            this._day = 1;
    }
    public void setMonth(int month) {
        if (month > 0)
            this._month = month;
        else
            this._month = 1;
    }
    public void setYear(int year) {
        if (year > 1900)
            this._year = year;
        else
            this._year = 1900;
    }

    // getters
    public int getDay() {
        return this._day;
    }
    public int getMonth() {
        return this._month;
    }
    public int getYear() {
        return this._year;
    }

}