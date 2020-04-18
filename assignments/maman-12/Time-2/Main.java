public class Main {
    public static void main(String[] args) {

        Time2 time = new Time2(7, 30);

        System.out.println("Time: " + time.toString());

        System.out.println("Hours: " + time.getHour());
        System.out.println("Minutes: " + time.getMinute());

        System.out.println("Minutes from midnight: " + time.minFromMidnight());

        Time2 otherTime = new Time2(7, 30);

        System.out.println("Other Time: " + otherTime.toString());

        System.out.println("Time equals to other time? " + time.equals(otherTime));
        System.out.println();


        time.setHour(10);
        time.setMinute(50);

        String newTime = time.toString();

        if (newTime.equals(otherTime.toString()))
            System.err.println("Time didn't change, fix the setters");
        else
            System.out.println("New time: " + newTime);


        if (otherTime.before(time))
            System.out.println(otherTime.toString() + " is before " + time.toString());

        if (time.after(otherTime))
            System.out.println(time.toString() + " is after " + otherTime.toString());


        System.out.println();


        Time2 bigger = new Time2(2, 0);
        Time2 smaller = new Time2(1, 0);

        System.out.println("Difference between " + bigger.toString() + " and " + smaller.toString() + " is: " + bigger.difference(smaller) + " minutes");
        System.out.println("Difference between " + smaller.toString() + " and " + bigger.toString() + " is: " + smaller.difference(bigger) + " minutes");


        System.out.println();


        Time2 finalTime = new Time2(22, 55);
        System.out.println("Actual Time: " + finalTime.toString());

        finalTime = finalTime.addMinutes(125);
        System.out.println("After 125 minutes: " + finalTime.toString());


        // add 2 hours and 5 minutes to 22:55

        if (finalTime.toString().equals("01:00")) {
            System.out.println("\nDay changed successfully!");
        } else {
            System.err.println("There was a problem changing the day");
        }


        System.out.println();


        // trying a negative number

        System.out.print(finalTime.toString());
        System.out.print(" minus 1445 minutes will be: ");
        finalTime = finalTime.addMinutes(-1445);
        System.out.println(finalTime);


        if (!finalTime.toString().equals("00:55")) {
            System.err.println("There was a problem with the time machine");
        } else {
            System.out.println("Went back in time successfully!");
        }
    }
}
