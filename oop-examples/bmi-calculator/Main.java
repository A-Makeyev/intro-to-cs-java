public class Main {
    public static void main(String[] args) {


        WeightWatch yoni = new WeightWatch(75, 1.85);
        WeightWatch yossi = new WeightWatch(40, 1.66);
        WeightWatch nurit = new WeightWatch(122, 1.71);
        WeightWatch yael = new WeightWatch(50, 1.75);


        double yoni_bmi = yoni.bmi();
        double yossi_bmi = yossi.bmi();
        double nurit_bmi = nurit.bmi();
        double yael_bmi = yael.bmi();


        System.out.print("Yoni ");
        yoni.printBmi(yoni_bmi);

        System.out.print("Yossi ");
        yossi.printBmi(yossi_bmi);

        System.out.print("Nurit ");
        nurit.printBmi(nurit_bmi);

        System.out.print("Yael ");
        yael.printBmi(yael_bmi);


    }
}
