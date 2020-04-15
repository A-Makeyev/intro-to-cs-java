public class Date {

    private int _day;
    private int _month;
    private int _year;


    public Date(int day, int month, int year) {
        this._day = day;
        this._month = month;
        this._year = year;
    }


    // prevent aliasing
    public Date(Date other) {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }


    public String printDate() {
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
    public void set_day(int day) {
        this._day = day;
    }
    public void set_month(int month) {
        this._month = month;
    }
    public void set_year(int year) {
        this._year = year;
    }

    // getters
    public int get_day() {
        return this._day;
    }
    public int get_month() {
        return this._month;
    }
    public int get_year() {
        return this._year;
    }


}