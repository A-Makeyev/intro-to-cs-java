import java.util.Scanner;

public class Trapezoid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the left point coordinates of the base followed by its length: ");
        int AB_left_x = scan.nextInt();
        int AB_left_y = scan.nextInt();
        int AB_base = scan.nextInt();

        System.out.print("Please enter the left point coordinates of the base followed by its length: ");
        int DC_left_x = scan.nextInt();
        int DC_left_y = scan.nextInt();
        int DC_base = scan.nextInt();


        // Finding the length of DC

        
        double DC_length = Math.sqrt(Math.pow((AB_left_x - DC_left_x), 2) + Math.pow((AB_left_y - DC_left_y), 2));


        // Finding the length of CB

        double  DC_right_x = DC_left_x + DC_base,
                DC_right_y = DC_left_y;

        double AB_right_x = AB_left_x + AB_base,
               AB_right_y = AB_left_y;

        double CB_length = Math.sqrt(Math.pow((DC_right_x - AB_right_x), 2) + Math.pow((DC_right_y - AB_right_y), 2));


        // Calculating the height, area and perimeter of the trapezoid

        double height, area, perimeter;

        height = DC_left_y - AB_left_y;

        area = (height * (AB_base + DC_base)) / 2;

        // Perimeter = AB_base + DC_base + DC_length + CB_length
        perimeter = Math.round((AB_base + DC_base + DC_length + CB_length) * 100) / (100 * 1.0);


        System.out.println("\nThe area of the trapezoid is: " + area);
        System.out.println("The perimeter of the trapezoid is: " + perimeter);

    }
}
