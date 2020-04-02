import java.util.Scanner;

public class Petrol {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        final double MAX = 100,
                     MILE_TO_KM = 1.609,
                     LITRES_PER_GALLON = 3.785;


        System.out.print("Please enter the car's petrol consumption measured in miles/gallon: ");
        double milesPerGallon = scan.nextDouble();

        if (milesPerGallon <= 0) {
            System.err.println("Miles Per Gallon cannot be zero or a negative number.");
            System.exit(1);
        }


        /*
         *
         * 1 mile = 1.609km
         * 1 gallon = 3.785 litres
         *
         * 20 miles per 1 gallon => (20 * 1.609) / 3.785 => 8.5 litres per 1 km
         *
         */


        double litresTo100km = 100 / ((milesPerGallon * MILE_TO_KM) / LITRES_PER_GALLON);


        double afterRounding = Math.round(litresTo100km * MAX) / (MAX * 1.0);
        System.out.println("The car's petrol consumption converted to litres/100km is: " + afterRounding);

    }
}
