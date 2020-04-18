public class Main {
    public static void main(String[] args) {

        // Train
        Time1 morningDeparture = new Time1(10, 30);
        Time1 eveningDeparture = new Time1(19, 40);

        Train train = new Train("Vevey", morningDeparture, 180, 50,50,25);
        Train train_2 = new Train("Geneva", eveningDeparture, 60, 2,90,60);

        // equal
        System.out.print("Train details are equal? " + train.equal(train_2) + "\n");

        // copy Train
        train_2 = new Train(train);
        System.out.print("Are they equal after the copy method? " + train.equal(train_2) + "\n\n");

        // get & set
        Train train_3 = new Train("Lausanne", morningDeparture, 360, 15,190,75);

        System.out.println("Train 3 details: ");
        System.out.println("Destination: " + train_3.getDestination());
        System.out.println("Departure: " + train_3.getDeparture());
        System.out.println("Duration: " + train_3.getDuration());
        System.out.println("Passengers: " + train_3.getPassengers());
        System.out.println("Seats: " + train_3.getSeats());
        System.out.println("Price: " + train_3.getPrice());
        System.out.println();

        train_3.setDestination("Bern");
        train_3.setDeparture(eveningDeparture);
        train_3.setDuration(60);
        train_3.setPassengers(60);
        train_3.setSeats(60);
        train_3.setPrice(60);

        System.out.println("Updated train 3 details: ");
        System.out.println("New Destination: " + train_3.getDestination());
        System.out.println("New Departure: " + train_3.getDeparture());
        System.out.println("New Duration: " + train_3.getDuration());
        System.out.println("New Passengers: " + train_3.getPassengers());
        System.out.println("New Seats: " + train_3.getSeats());
        System.out.println("New Price: " + train_3.getPrice());


        



    }
}
