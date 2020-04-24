public class Time1Tester {
    public static void main(String [] args) {

    	Time1 time = new Time1(7, 30);

        System.out.println("Time: " + time.toString());
        System.out.println("Hours: " + time.getHour());
        System.out.println("Minutes: " + time.getMinute());

        System.out.println("Minutes from midnight: " + time.minFromMidnight());

        Time1 otherTime = new Time1(7, 30);
        
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

    	System.out.println();

        System.out.println("\n********** Staff Test Time1 - Started **********\n");
        System.out.println("\n1. Testing Constructors and toString:");
        Time1 t1 = new Time1(17, 45);
        System.out.println("\tt1 = " + t1);
        Time1 t2 = new Time1(t1);
        System.out.println("\tt2 = " + t2);

        System.out.println("\n2. Testing accessors and mutator:");
        t1.setHour(20);
        t1.setMinute(10);
        System.out.println("\tt1 = " + t1);
        System.out.println("\tHour   of t1 = " + t1.getHour());
        System.out.println("\tMinute of t1 = " + t1.getMinute());

        System.out.println("\n3. Testing minFromMidnight method:");
        t1 = new Time1(10, 15);
        System.out.println("\tt1 = " + t1);
        System.out.println("\tMinutes from midnight of t1 = " + t1.minFromMidnight());

        System.out.println("\n4. Testing equals method:");
        Time1 t3 = new Time1(12, 34);
        Time1 t4 = new Time1(23, 45);
        System.out.println("\tt3 = " + t3);
        System.out.println("\tt4 = " + t4);
        if(t3.equals(t4))
            System.out.println("\tt3 is the same time as t4");
        else
            System.out.println("\tt3 isn't the same time as t4");

        System.out.println("\n5. Testing before method:");
        if(t3.before(t4))
            System.out.println("\tt3 is before t4");
        else
            System.out.println("\tt3 isn't before t1");

        System.out.println("\n6. Testing after method:");
        if(t4.after(t3))
            System.out.println("\tt4 is after t3");
        else
            System.out.println("\tt4 isn't after t3");

        System.out.println("\n7. Testing difference method:");
        t1 = new Time1(11, 25);
        t2 = new Time1(10, 15);
        System.out.println("\tt1 = " + t1);
        System.out.println("\tt2 = " + t2);
        System.out.println("\tThe difference in minutes between times t1 and t2 is : " + t1.difference(t2));

        System.out.println("\n8. Testing addMinutes method:");
        System.out.println("\tt1 = " + t1);
        System.out.println("\tAdding 10 minutes to t1 = "+t1.addMinutes(10));

        System.out.println("\n********** Test Time1 - Finished **********\n");

    }
}
