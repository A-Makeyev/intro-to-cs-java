/*
 *******************************************************************
 * A program that calculates the area and perimeter of a trapezoid
 *******************************************************************
 */

import java.util.Scanner;

public class Trapezoid {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the left point coordinates of the base followed by its length: ");
        int topLeft_xCoordinate = scan.nextInt();
        int topLeft_yCoordinate = scan.nextInt();
        int topBase = scan.nextInt();

        System.out.print("Please enter the left point coordinates of the base followed by its length: ");
        int bottomLeft_xCoordinate = scan.nextInt();
        int bottomLeft_yCoordinate = scan.nextInt();
        int bottomBase = scan.nextInt();


        // Finding the length of the left side

        double leftSideLength = Math.sqrt(Math.pow((topLeft_xCoordinate - bottomLeft_xCoordinate), 2) + Math.pow((topLeft_yCoordinate - bottomLeft_yCoordinate), 2));


        // Finding the length of the right side

        double  topRight_xCoordinate = topLeft_xCoordinate + topBase,
                topRight_yCoordinate = topLeft_yCoordinate;

        double bottomRight_xCoordinate = bottomLeft_xCoordinate + bottomBase,
               bottomRight_yCoordinate = bottomLeft_yCoordinate;

        double rightSideLength = Math.sqrt(Math.pow((topRight_xCoordinate - bottomRight_xCoordinate), 2) + Math.pow((topRight_yCoordinate - bottomRight_yCoordinate), 2));


        // Calculating the height, area and perimeter of the trapezoid

        double height, area, perimeter;

        height = topLeft_yCoordinate - bottomLeft_yCoordinate;

        area = Math.abs((height * (bottomBase + topBase)) / 2);

        // Perimeter = bottomBase + topBase + leftSideLength + _rightSideLength
        perimeter = Math.round((bottomBase + topBase + leftSideLength + rightSideLength) * 100) / (100 * 1.0);


        System.out.println("\nThe area of the trapezoid is: " + area);
        System.out.println("The perimeter of the trapezoid is: " + perimeter);

    }
}