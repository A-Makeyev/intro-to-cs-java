public class Main {
    public static void main(String[] args) {

        Date date = new Date(2, 2, 2020);

        Date date_2 = new Date(date);

        String first = date.toString(); // 02/02/2020
        System.out.println("first date: " + first);

        String second = date_2.toString(); // 02/02/2020
        System.out.println("second date: " + second);


        int day = date.getDay(); // 2
        int month = date.getMonth(); // 2
        int year = date.getYear(); // 2020

        System.out.println("Day ~> " + day);
        System.out.println("Month ~> " + month);
        System.out.println("Year ~> " + year);


        date.isEqual(date_2); // true
        System.out.println("the dates are equal");

        date.setDay(12);
        date.setMonth(12);
        date.setYear(2012);

        String third = date.toString(); // 12/12/2012
        System.out.println("updated first date: " + third);

        String fourth = date_2.toString(); // 02/02/2020
        System.out.println("second date: " + fourth);


        date.isBefore(date_2); // true
        System.out.println(date.toString() + " is before " + date_2.toString() + "? " + date.isBefore(date_2));

        date.isAfter(date_2); // false
        System.out.println(date.toString() + " is after " + date_2.toString() + "? " + date.isAfter(date_2));
        

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Flight Test ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

         Date date1 = new Date(1, 3, 2011);
         Date date2 = new Date(23, 3, 2011);

         Flight elal1 = new Flight(100, "Tel-Aviv", "Rome", date1);
         Flight elal2 = new Flight(100, "Tel-Aviv", "London", date2);
         Flight elal3 = new Flight(elal1);

         if (elal1.equals(elal2))
            System.out.println("elal1,elal2 alternative flights");
         else
            System.out.println("elal1,elal2 not alternative flights");

         if (elal1.equals(elal3))
            System.out.println("elal1,elal3 alternative flights");
         else
            System.out.println("elal1,elal3 not alternative flights");
         
         System.out.println(elal1.toString()); 
         System.out.println(elal2.toString()); 
         System.out.println(elal3.toString()); 

         date1.setDay(2);

         if (elal1.equals(elal3))
            System.out.println("elal1, elal3 alternative flights");
         else
            System.out.println("elal1, elal3 not alternative flights");

         elal1.setFlightDate(date1);

         if (elal1.equals(elal3)) 
            System.out.println("elal1, elal3 alternative flights");
         else
            System.out.println("elal1, elal3 not alternative flights");
                  
         System.out.println("Year: " + elal1.getFlightDate().getYear());

         Date tempDate = elal1.getFlightDate();
         int tempMonth = tempDate.getMonth();

         if (tempMonth == 12){
            tempMonth = 1;

            int tempYear = tempDate.getYear();

            tempYear++;
            tempDate.setYear(tempYear);
         } else {
            tempMonth++;
         }
           
         tempDate.setMonth(tempMonth);
         elal1.setFlightDate(tempDate);
         System.out.println("Flight details: ");
         System.out.println(elal1.toString()); 
         elal1.book(5);

         System.out.println("Places left on ElAl1 flight: " + elal1.placesLeft());
         System.out.println("Flight Elal1 is: " + (elal1.full() ? "full" : "not full"));

    }
}
