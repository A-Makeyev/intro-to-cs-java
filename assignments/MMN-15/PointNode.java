/**
 * Class PointNode that represents a list of points in a coordinate system of X and Y
 */

public class PointNode {

    PointNode _next;
    private Point _point;


    /**
     * A constructor with a point parameter that sets the next to null
     * @param _point a point value to copy
     */

    public PointNode(Point _point) {
        this._point = new Point(_point);
        this._next = null;
    }


    /**
     * A constructor with parameters of point and a next item
     * @param _point a point value to copy
     * @param _next an item to set net
     */

    public PointNode(Point _point, PointNode _next) {
        this._point = new Point(_point);
        this._next = _next;
    }


    /**
     * A constructor that copies the value of other items
     * @param pointNode a value to copy
     */

    public PointNode(PointNode pointNode) {
        this._point = pointNode.getPoint();
        this._next = pointNode.getNext();
    }


    /**
     * A method that returns the copy of the item
     * @return the copy of the item
     */

    public Point getPoint() { return this._point == null ? null : new Point(this._point); }


    /**
     * A method that returns the next item on the list
     * @return the next item of the list
     */

    public PointNode getNext() {
        return this._next;
    }


    /**
     * A method that sets the next item on the list
     * @param _next the next value to set
     */

    public void setNext(PointNode _next) {
        this._next = _next;
    }


    /**
     * A method that sets the item's value
     * @param _point the value to copy
     */

    public void setPoint(Point _point) { this._point = new Point(_point); }

}
