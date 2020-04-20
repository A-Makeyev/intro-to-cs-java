public class WeightWatch {

    private double weight;
    private double _height;

	// "this" refers to the variable we declared above
    public WeightWatch(double weight, double height) {
    	// "this" is only required when the name of the parameter
        // is the same as the variable we declared (weight = weight)
        if(weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 1;
        }
        // here the names are different therefore no need for "this"
        if(height > 0) {
            _height = height;
        } else {
            _height = 1;
        }
    }


    public double bmi() {
        double bmi = weight / Math.pow(_height, 2);
        bmi = Math.round(bmi * 100) / (100 * 1.0);
        return bmi;
    }


    public String printBmi(double bmi) {
        if (bmi < 16) {
            return "your bmi is: " + bmi + ". You are too thin.";
        } else if (bmi > 40) {
            return "your bmi is: " + bmi + ". You should lose some weight.";
        } else {
            return "your bmi is: " + bmi + ". Just right.";
        }
    } 
}
