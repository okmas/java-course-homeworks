package cz.muni.fi.pb162.project.geometry;


/**
 * A point in 2D plane.
 * 
 * @author Samuel Leško, 409202 
 * @version 1.10.2013
 */
public class Vertex2D {
    private double x;
    private double y;
    
    /**
     * Param-less constructor.
     */
    public Vertex2D() {
    }
    
    /**
     * Constructor.
     * 
     * @param newX initial value of x
     * @param newY initlal value of y
     */
    public Vertex2D(double newX, double newY) {
        x = newX;
        y = newY;
    }
    
    /**
     * Return value of vertex as string in format "[x, y]"
     */
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
    /**
     * Returns a vertex whose coordinates are arithmethic mean of respective coordinates of parameters.
     * 
     * @param vert1 vertex one
     * @param vert2 vertex two
     */
    public static Vertex2D middleVertex(Vertex2D vert1, Vertex2D vert2) {
        return new Vertex2D((vert1.getX() + vert2.getX()) / 2, (vert1.getY() + vert2.getY()) / 2); 
    }
    
    /* getters and setters */
    
    public double getX() {
        return x;
    }
    
    public void setX(double newX) {
        x = newX;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double newY) {
        y = newY;
    }
}
