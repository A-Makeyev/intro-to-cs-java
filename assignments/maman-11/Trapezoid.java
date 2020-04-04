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
        int _topLeft_xCoordinate = scan.nextInt();
        int _topLeft_yCoordinate = scan.nextInt();
        int _topBase = scan.nextInt();

        System.out.print("Please enter the left point coordinates of the base followed by its length: ");
        int _bottomLeft_xCoordinate = scan.nextInt();
        int _bottomLeft_yCoordinate = scan.nextInt();
        int _bottomBase = scan.nextInt();


        // Finding the length of the left side

        double _leftSideLength = Math.sqrt(Math.pow((_topLeft_xCoordinate - _bottomLeft_xCoordinate), 2) + Math.pow((_topLeft_yCoordinate - _bottomLeft_yCoordinate), 2));


        // Finding the length of the right side

        double  _topRight_xCoordinate = _topLeft_xCoordinate + _topBase,
                _topRight_yCoordinate = _topLeft_yCoordinate;

        double _bottomRight_xCoordinate = _bottomLeft_xCoordinate + _bottomBase,
                _ButtomRight_yCoordinate = _bottomLeft_yCoordinate;

        double _rightSideLength = Math.sqrt(Math.pow((_topRight_xCoordinate - _bottomRight_xCoordinate), 2) + Math.pow((_topRight_yCoordinate - _ButtomRight_yCoordinate), 2));


        // Calculating the height, area and perimeter of the trapezoid

        double height, area, perimeter;

        height = _topLeft_yCoordinate - _bottomLeft_yCoordinate;

        area = Math.abs((height * (_bottomBase + _topBase)) / 2);

        // Perimeter = _bottomBase + _topBase + _leftSideLength + _rightSideLength
        perimeter = Math.round((_bottomBase + _topBase + _leftSideLength + _rightSideLength) * 100) / (100 * 1.0);


        System.out.println("\nThe area of the trapezoid is: " + area);
        System.out.println("The perimeter of the trapezoid is: " + perimeter);

    }
}