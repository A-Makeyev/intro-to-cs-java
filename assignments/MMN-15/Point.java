/**
 * A class that represents a point in coordinate system of X and Y
 */

public class Point {

    private double _x;
    private double _y;


    /**
     * A constructor that gets 2 parameters of the point coordination
     * @param _x an x coordination
     * @param _y an y coordination
     */

    public Point(double _x, double _y) {
        this._x = _x;
        this._y = _y;
    }


    /**
     * A constructor that gets a point and copies its value
     * @param point a point to copy
     */

    public Point(Point point) {
        if (point == null)
            return;

        this._x = point.getX();
        this._y = point.getY();
    }


    /**
     * A method that returns the coordination value of x
     * @return the coordination value of x
     */

    public double getX() { return _x; }


    /**
     * A method that returns the coordination value of y
     * @return the coordination value of y
     */

    public double getY() { return _y; }


    /**
     * A method that sets the coordination value of x
     * @param _x a value to set
     */

    public void setX(double _x) { this._x = _x; }


    /**
     * A method that sets the coordination value of y
     * @param _y a value to set
     */

    public void setY(double _y) { this._y = _y; }


    /**
     * A method that compares the coordination of points
     * @param point an object to compare
     * @return true if the objects have the same coordination, false otherwise
     */

    public boolean equals(Point point) {
        if (point == null)
            return false;

        return (this._x == point.getX() && this._y == point.getY());
    }


    /**
     * A method that compares the coordination of points
     * @param point an object to compare
     * @return true if this point is above the other one, false otherwise
     */

    public boolean isAbove(Point point) {
        if (point == null)
            return false;

        return this._y > point.getY();
    }


    /**
     * A method that compares the coordination of points
     * @param point an object to compare
     * @return true if this point is under the other one, false otherwise
     */

    public boolean isUnder(Point point) {
        return /* point != null && */ point.isAbove(this);
    }


    /**
     * A method that compares the coordination of points
     * @param point an object to compare
     * @return true if this point is left to the other one, false otherwise
     */

    public boolean isLeft(Point point) {
        if (point == null)
            return false;

        return this._x < point.getX();
    }


    /**
     * A method that compares the coordination of points
     * @param point an object to compare
     * @return true if this point is right to the other one, false otherwise
     */

    public boolean isRight(Point point) {
        return /* point != null && */ point.isLeft(this);
    }


    /**
     * A method that calculates the distance between points
     * @param point the second point
     * @return the distance between the points
     */

    public double distance(Point point) {
        if (point == null)
            return 0;

        return Math.sqrt(Math.pow(this._x - point.getX(), 2) + Math.pow(this._y - point.getY(), 2));
    }


    /**
     * A method that moves the point a few steps
     * @param _x number of steps to move on x's line
     * @param _y number of steps to move on y's line
     */

    public void move (double _x, double _y) {
        this._x += _x;
        this._y += _y;
    }


    /**
     * A method that shows the object by the format of: (x,y)
     * @return the point coordination
     */

    @Override
    public String toString() {
        return "(" + _x + ',' + _y + ')';
    }

}
