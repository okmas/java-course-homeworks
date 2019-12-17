package cz.muni.fi.pb162.project.geometry;

/**
 * A point in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 8.10.2013
 */
public class Vertex2D {
    private double x;
    private double y;
    
    /**
     * Constructor.
     * 
     * @param newX      initial value of x
     * @param newY      initlal value of y
     */
    public Vertex2D(double newX, double newY) {
        x = newX;
        y = newY;
    }
    
    /**
     * Returns a string with info about the vertex.
     * 
     * @return string in format "[x, y]"
     */
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
    /**
     * Returns distance of the vertex to another given vertex.
     * 
     * @param vert      vetrex to calculate distance to
     * @return if vert is null returns -1, otherwise returns distance
     */
    public double distance(Vertex2D vert) {
        if (vert == null) return -1;
        
        if (vert == this) return 0;
        
        return Math.sqrt(Math.pow(vert.getX() - this.getX(), 2) + Math.pow(vert.getY() - this.getY(), 2));
    }
    
    /**
     * Returns a vertex whose coordinates are arithmethic mean of respective coordinates of parameters.
     * 
     * @param vert1     vertex one
     * @param vert2     vertex two
     */
    public static Vertex2D middleVertex(Vertex2D vert1, Vertex2D vert2) {
        return new Vertex2D((vert1.getX() + vert2.getX()) / 2, (vert1.getY() + vert2.getY()) / 2); 
    }
    
    /* getters and setters */
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
