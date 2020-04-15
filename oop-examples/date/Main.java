public class Main {
    public static void main(String[] args) {

        Date date = new Date(2, 2, 2020);

        int day = date.get_day(); // 2
        int month = date.get_month(); // 2
        int year = date.get_year(); // 2020

        Date date_2 = new Date(date);

        String first = date.printDate(); // 02/02/2020
        System.out.println("first date: " + first);

        String second = date_2.printDate(); // 02/02/2020
        System.out.println("second date: " + second);

        date.isEqual(date_2); // true
        System.out.println("the dates are equal");


        date.set_day(12);
        date.set_month(12);
        date.set_year(2012);

        String third = date.printDate(); // 12/12/2012
        System.out.println("first date: " + third);

        String fourth = date_2.printDate(); // 02/02/2020
        System.out.println("second date: " + fourth);


        date.isBefore(date_2); // true
        System.out.println(date.isBefore(date_2));

        date.isAfter(date_2); // false
        System.out.println(date.isAfter(date_2));
        
    }
}
