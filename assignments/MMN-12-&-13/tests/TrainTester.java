public class TrainTester {
    public static void main(String[] args) {

        // Time1 morningDeparture = new Time1(10, 30);
        // Time1 eveningDeparture = new Time1(19, 40);

        // Train
        Train train = new Train("Vevey", 10, 30, 180, 15,50,25);
        Train train_2 = new Train("Geneva", 19, 40, 60, 90,90,60);

        // to String
        System.out.println("Train 1: " + train.toString());
        System.out.println("Train 2: " + train_2.toString());

        // equal
        System.out.print("\nTrain details are equal? " + train.equals(train_2) + "\n");

        // copy Train
        train_2 = new Train(train);
        System.out.print("Are they equal after the copy method? " + train.equals(train_2) + "\n\n");

        // get & set
        Train train_3 = new Train("Amsterdam", 10, 30, 360, 15,190,75);

        System.out.println("Train 3 details: ");
        System.out.println("Destination: " + train_3.getDestination());
        System.out.println("Departure: " + train_3.getDeparture());
        System.out.println("Duration: " + train_3.getDuration());
        System.out.println("Passengers: " + train_3.getPassengers());
        System.out.println("Seats: " + train_3.getSeats());
        System.out.println("Price: " + train_3.getPrice());
        System.out.println();

        train_3.setDestination("Bern");
        train_3.setDeparture(new Time1(20, 20));
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

        // arrival time
        System.out.print("\nTrain that leaves at " + train.getDeparture());
        System.out.print(" will arrive at " + train.getArrivalTime());
        System.out.print(" after " + train.getDuration() + " minutes (3 hours)");

        // is full
        if (train.isFull()) {
            System.out.print("\nTrain 1 currently has " + train.getPassengers() + " passengers ");
            System.out.print("and " + train.getSeats() + " seats which means it's full");
        } else {
            System.out.print("\nTrain 1 currently has " + train.getPassengers() + " passengers ");
            System.out.print("and " + train.getSeats() + " which means it's not full");
        }

        // add passengers
        Train train_4 = new Train("Amsterdam", 10, 30, 30, 5,20,10);

        System.out.println("\nTrain 4 has " + train_4.getPassengers() + " passengers and " + train_4.getSeats() + " seats");

        System.out.println("Added successfully? " + train_4.addPassengers(5));
        System.out.println("After adding 5 passengers it has " + train_4.getPassengers() + " passengers and " + train_4.getSeats() + " seats");

        // is cheaper
        System.out.println("\nTrain 4 price is: " + train_4.getPrice());
        System.out.println("Train 1 price is: " + train.getPrice());

        if (train_4.isCheaper(train))
            System.out.println("Train 4 is cheaper");
        else
            System.out.println("Train 1 is cheaper");

        // total price
        System.out.println("\nTrain 4 ticket price is: " + train_4.getPrice());
        System.out.println("which means " + train_4.getPassengers() + " passengers paid: " + train_4.totalPrice());

        // arrives earlier
        System.out.println("\nTrain 2 arrives at: " + train_2.getArrivalTime());
        System.out.println("Train 3 arrives at: " + train_3.getArrivalTime());

        if (train_2.arrivesEarlier(train_3))
            System.out.println("Train 2 arrives earlier");
        else
            System.out.println("Train 3 arrives earlier");


        System.out.println();
        System.out.println(train_3);
        System.out.println(train_4);

        System.out.println();

        System.out.println("********** Staff Test Train - Started **********");
        System.out.println("\n1. Testing Constructors and toString: ");
        // test constructor with 7 parameters and toString

        // Train tr1 = new Train(new String("Paris"), new Time1(12,30), 90, 70, 100, 10);
        Train tr1 = new Train(new String("Paris"), 12, 30, 90, 70, 100, 10);
        System.out.println("\tTrain 1: " + tr1);
        // test copy constructor
        Train tr2 = new Train(tr1);
        System.out.println("\tTrain 2: " + tr2);

        System.out.println("\n2. Testing accessors and mutator: ");
        // test getters
        System.out.println("\tTrain 1 destination: " + tr1.getDestination());
        System.out.println("\tTrain 1 departure: " + tr1.getDeparture());
        System.out.println("\tTrain 1 duration: " + tr1.getDuration());
        System.out.println("\tTrain 1 passengers: " + tr1.getPassengers());
        System.out.println("\tTrain 1 seats: " + tr1.getSeats());
        System.out.println("\tTrain 1 price: " + tr1.getPrice());

        // test setters
        tr2.setDestination("London");
        tr2.setDeparture(new Time1(17,15));
        tr2.setDuration(60);
        tr2.setPassengers(80);
        tr2.setSeats(200);
        tr2.setPrice(25);
        System.out.println("\tTrain 2: " + tr2);

        System.out.println("\n3. Testing equal method:");
        System.out.println("\tTrain 1: " + tr1);
        System.out.println("\tTrain 2: " + tr2);
        System.out.println("\tTrain 1 is equal to Train 2: " + tr1.equals(tr2));

        System.out.println("\n4. Testing getArrivalTime method:");
        System.out.println("\tTrain 1 arrives at " + tr1.getArrivalTime());

        System.out.println("\n5. Testing addPassengers method:");
        System.out.println("\tAdding 20 passengers to Train 1 returns " + tr1.addPassengers(20) +
                           ". It now has " + tr1.getPassengers() + " passengers.");

        System.out.println("\n6. Testing isFull method:");
        System.out.println("\tTrain 1 is full: " + tr1.isFull());

        System.out.println("\n7. Testing isCheaper method:");
        System.out.println("\tTrain 1 is cheaper than Train 2: " + tr1.isCheaper(tr2));

        System.out.println("\n8. Testing totalPrice method:");
        System.out.println("\tTrain 1 total price is: " + tr1.totalPrice());

        System.out.println("\n9. Testing arrivesEarlier method:");
        System.out.println("\tTrain 1 arrives earlier than Train 2: " + tr1.arrivesEarlier(tr2));

        System.out.println("\n********** Test Train - Finished **********\n");
    }
}

