/**
 * Class Polygon that represents a polygon built of a list of vertices
 * with one property that is the head of the vertices list
 */

public class Polygon {

    // Property made of PointNode
    // that represents the head of the list of vertices of the Polygon
    private PointNode _vertices;


    // A constructor with no parameters
    // that creates a new Polygon with no vertices
    public Polygon() {
        this._vertices = null;
    }


    /**
     * A method that adds a new point to the list of the vertices
     * @param point a point to add
     * @param position a position to locate the point
     * @return true if the point been added successfully, false otherwise
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public boolean addVertex(Point point, int position) {
        if (position < 1 || position > getVerticesCount() + 1)
            return false;

        if (position == 1) {
            this._vertices = new PointNode(point, this._vertices);
            return true;
        }

        int currentPos = 2;
        PointNode temp = this._vertices;

        while (currentPos++ < position) {
            temp = temp.getNext();
        }
        temp.setNext(new PointNode(point, temp.getNext()));

        return true;
    }


    /**
     * A method that returns the point of the vertex with the highest Y coordination value
     * @return the point with the highest Y coordination value
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public Point highestVertex() {
        if (this._vertices == null)
            return null;

        PointNode temp = this._vertices;
        PointNode highest = temp;

        while (temp.getNext() != null) {
            if (temp.getPoint().isAbove(highest.getPoint())) {
                highest = temp;
            }
            temp = temp.getNext();
        }
        return new Point(highest.getPoint());
    }


    /**
     * A method that calculates the perimeter of the polygon
     * @return the perimeter of the polygon
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public double calcPerimeter() {
        int verticesAmount = getVerticesCount();

        if (verticesAmount < 2)
            return 0;

        if (verticesAmount == 2)
            return this._vertices.getPoint().distance(this._vertices.getNext().getPoint());

        double sum = 0;
        PointNode temp = this._vertices;

        while (temp.getNext() != null) {
            sum += temp.getPoint().distance(temp.getNext().getPoint());
            temp = temp.getNext();
        }
        sum += temp.getPoint().distance(this._vertices.getPoint());

        return sum;
    }


    /**
     * A method that  calculates the area of the polygon
     * @return the area of the polygon
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public double calcArea() {
        if (getVerticesCount() < 3)
            return 0;

        double sum = 0;
        PointNode temp = this._vertices.getNext();

        while (temp.getNext() != null) {
            sum += calcTriangleArea(this._vertices.getPoint(),temp.getPoint(),temp.getNext().getPoint());
            temp = temp.getNext();
        }

        return sum;
    }


    /**
     * A method that compares the area of the polygons
     * @param polygon a polygon to compare
     * @return true if the area is bigger, false otherwise
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public boolean isBigger(Polygon polygon) {
        if (polygon == null) {
            return false;
        }
        return (calcArea() > polygon.calcArea());
    }


    /**
     * A method that gets a point as a parameter and checks if there is a vertex with the coordination
     * @param point a point to search
     * @return the position of the vertex or -1 if it doesn't appear
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public int findVertex(Point point) {
        if (point == null)
            return -1;

        int count = 1;
        PointNode temp = this._vertices;

        while (temp != null) {
            if (temp.getPoint().equals(point)) {
                return count;
            }
            temp = temp.getNext();
            count ++;
        }
        return -1;
    }


    /**
     * A method that gets a point as a parameter and returns his next vertex
     * @param point a point to search
     * @return the next vertex, the first vertex if it's the same as the last, -1 if there is no point in the polygon
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public Point getNextVertex(Point point) {
        if (point == null || findVertex(point) == -1)
            return null;

        PointNode temp = this._vertices;

        while (temp != null) {
            if (temp.getPoint().equals(point)) {
                if (temp.getNext() == null) {
                    return this._vertices.getPoint();
                } else {
                    return temp.getNext().getPoint();
                }
            }
            temp = temp.getNext();
        }
        return null;
    }


    /**
     * A method that creates a new polygon that blocks with 4 edges the polygon which matches the coordinate system
     * @return the new polygon that blocks the other polygon
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    public Polygon getBoundingBox() {
        if (getVerticesCount() < 3)
            return null;

        PointNode temp = this._vertices.getNext();

        Point topLeftPoint = this._vertices.getPoint();
        Point bottomRightPoint = this._vertices.getPoint();

        while(temp != null) {
            if (temp.getPoint().isLeft(topLeftPoint))
                topLeftPoint.setX(temp.getPoint().getX());

            else if (temp.getPoint().isRight(bottomRightPoint))
                bottomRightPoint.setX(temp.getPoint().getX());

            if (temp.getPoint().isAbove(topLeftPoint))
                topLeftPoint.setY(temp.getPoint().getY());

            else if (temp.getPoint().isUnder(bottomRightPoint))
                bottomRightPoint.setY(temp.getPoint().getY());

            temp = temp.getNext();
        }

        Polygon polygon = new Polygon();

        polygon.addVertex(topLeftPoint,1);
        polygon.addVertex(new Point(bottomRightPoint.getX(),topLeftPoint.getY()),2);
        polygon.addVertex(new Point(bottomRightPoint),3);
        polygon.addVertex(new Point(topLeftPoint.getX(),bottomRightPoint.getY()),4);

        return polygon;
    }


    /**
     * A method that calculates the area of the triangle
     * @param pointA a first point of the triangle
     * @param pointB a second point of the triangle
     * @param pointC a third point of the triangle
     * @return the triangle area
     * Runtime: O(1)
     * Space complexity: O(1)
     */

    private double calcTriangleArea(Point pointA, Point pointB, Point pointC) {
        double a = pointA.distance(pointB);
        double b = pointB.distance(pointC);
        double c = pointC.distance(pointA);
        double s = (a + b + c) / 2.0;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }


    /**
     * A method that counts the amount of vertices of the polygon
     * @return the amount of the vertices
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    private int getVerticesCount() {
        int count = 0;
        PointNode temp = this._vertices;

        while(temp != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }


    /**
     * toString method that returns text that describe about this polygon
     * with info of his vertices and amount of vertices
     * @return polygon description
     * Runtime: O(n)
     * Space complexity: O(1)
     */

    @Override
    public String toString() {
        if (getVerticesCount() > 0) {
            String text = "The polygon has " + getVerticesCount() + " vertices:\n(" + this._vertices.getPoint().toString();
            PointNode temp = this._vertices.getNext();

            while(temp != null) {
                text = String.format("%s,%s", text, temp.getPoint().toString());
                temp = temp.getNext();
            }
            return text + ")";
        } else {
            return "The polygon has 0 vertices.";
        }
    }
}
