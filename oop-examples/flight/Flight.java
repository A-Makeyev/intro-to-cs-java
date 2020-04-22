
public class Flight {

    private int seats;
    private int booked;
    private String origin;
    private String destination;
    private Date flightDate;


    public Flight(int seats, String origin, String destination, Date flightDate) {
        this.booked = 0;
        this.seats = seats;
        this.origin = origin; // Strings are immutable therefore no need for new String
        this.destination  = destination;
        this.flightDate = new Date(flightDate); // define new object for anti aliasing!
    }

    public Flight (Flight otherFlight) {
        seats = otherFlight.seats;
        booked = otherFlight.booked;
        flightDate = new Date(otherFlight.flightDate);
        destination = otherFlight.destination;
        origin = otherFlight.origin;
     }
     
    public int getSeats() {
        return this.seats;
     }
    public int getBooked() {
        return this.booked;
     }
    public Date getFlightDate() {
        return new Date(flightDate);
     }
    public String getdestination() {
        return this.destination;
     }
    public String getOrigin() {
        return this.origin;
     } 
    public void setSeats(int seats) {
        this.seats = seats;
     }
    public void  setBooked(int booked) {
        this.booked = booked;
    }
         
    public void setFlightDate(Date newDate) {
        this.flightDate = new Date(newDate);
    }

    public void setdestination(String destination) {
        this.destination = destination;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    } 
         
    public String toString() {
       return ("Date: " + flightDate + "\nDestination: " + destination
              + "\nOrigin: " + origin + "\nCapacity: " + seats + "\nBooked: " + booked);
    }

    public boolean equals(Flight otherFlight) {
        if (flightDate.equals(otherFlight.flightDate) && destination.equals(otherFlight.destination)
           && origin.equals(otherFlight.origin))
            return true;
        return false;
    }

    public boolean full() {
        if (this.booked == this.seats)
            return true;
        return false;
    }

    public int placesLeft() {
        return this.seats - this.booked;
    }

    public boolean book(int places) { 
        if (places <= placesLeft()) {
            this.booked += places;
                return true;
        }   
        return false;
    }
}