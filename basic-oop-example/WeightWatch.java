public class WeightWatch {

    private double _weight;
    private double _height;


    public WeightWatch(double w, double h) {
        if(w > 0) {
            _weight = w;
        } else {
            _weight = 1;
        }

        if(h > 0) {
            _height = h;
        } else {
            _height = 1;
        }
    }


    public double bmi() {
        double bmi = _weight / Math.pow(_height, 2);
        bmi = Math.round(bmi * 100) / (100 * 1.0);
        return bmi;
    }


    public void printBmi(double bmi) {
        if (bmi < 16) {
            System.out.println("your bmi is: " + bmi + ". You are too thin.");
        } else if (bmi > 40) {
            System.out.println("your bmi is: " + bmi + ". You should lose some weight.");
        } else {
            System.out.println("your bmi is: " + bmi + ". Just right.");
        }
    }

    
}
