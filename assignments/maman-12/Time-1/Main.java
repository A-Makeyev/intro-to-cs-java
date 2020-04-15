public class Main {
    public static void main(String[] args) {

        Time1 time = new Time1(22, 50);

        time.getMinute();
        time.getHour();

        time.setHour(7);
        time.setMinute(30);

        String printTime = time.toString();
        System.out.println(printTime);

        int minutes = time.minFromMidnight();
        System.out.println(minutes);



    }
}
