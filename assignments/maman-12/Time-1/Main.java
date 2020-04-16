public class Main {
    public static void main(String[] args) {

        Time1 time = new Time1(7, 30);

        System.out.println("Time: " + time.toString());

        System.out.println("Hours: " +  time.getHour());
        System.out.println("Minutes: " + time.getMinute());

        System.out.println("Minutes from midnight: " + time.minFromMidnight());

        Time1 otherTime = new Time1(7, 30);

        System.out.println("Time equals to other time? " + time.equals(otherTime));

        time.setHour(20);
        time.setMinute(20);

        String newTime = time.toString();
        System.out.println("New time: " + newTime);


        if (otherTime.before(time)) {
            System.out.println(otherTime.toString() + " is before " + time.toString());
        }

        if (time.after(otherTime)) {
            System.out.println(time.toString() + " is after " + otherTime.toString());
        }


        System.out.println();


        Time1 bigger = new Time1(2, 0);
        Time1 smaller = new Time1(1, 0);

        System.out.println("Difference between " + bigger.toString() + " and " + smaller.toString() + " is: " + bigger.difference(smaller) + " minutes");
        System.out.println("Difference between " + smaller.toString() + " and " + bigger.toString() + " is: " + smaller.difference(bigger) + " minutes");


        System.out.println();


        Time1 finalTime = new Time1(22, 55);
        System.out.println("Actual Time: " + finalTime.toString());

        finalTime = finalTime.addMinutes(125);
        System.out.println("After 125 minutes: " + finalTime.toString());


        // add 2 hours and 5 minutes to 22:55

        if(finalTime.toString().equals("01:00"))
            System.out.println("\nDay changed successfully");
        else
            System.err.println("There was a problem changing the day");


    }
}
