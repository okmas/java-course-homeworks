package cz.muni.fi.pb162.project.geometry;

/**
 * A point in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 4.12.2013
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private double x;
    private double y;
    
    /* Constructors */
    
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
    
    /* public methods */
    
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
     * Compares this vertex with another one.
     * 
     * @param vert      other vertex
     * @return true if x and y coordinates of both vertices are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (! (obj instanceof Vertex2D)) {
            return false;
        }
        
        Vertex2D vert = (Vertex2D) obj;
        return (this.getX() == vert.getX()) && (this.getY() == vert.getY());
    }
    
    /**
     * Returns hash code of vertex.
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + Double.valueOf(x).hashCode();
        hash = hash * 23 + Double.valueOf(y).hashCode();
        
        return hash;
    }
    
    /**
     * Compares two vertices by their x value.
     * 
     * @param vert      vertex to compare this to
     * @return positive value if this is greater, 0 if equal, negative value if less than vert
     */
    @Override
    public int compareTo(Vertex2D vert) {
        int retval = Double.valueOf(this.getX()).compareTo(vert.getX());
        if (retval == 0) {
            retval = Double.valueOf(this.getY()).compareTo(vert.getY());
        }
        
        return retval;
    }
    
    /**
     * Returns a string with info about the vertex.
     * 
     * @return string in format "[x, y]"
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
    
    /* getters and setters */
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    /* static methods */
    
    /**
     * Returns a vertex whose coordinates are arithmethic mean of respective coordinates of parameters.
     * 
     * @param vert1     vertex one
     * @param vert2     vertex two
     */
    public static Vertex2D middleVertex(Vertex2D vert1, Vertex2D vert2) {
        return new Vertex2D((vert1.getX() + vert2.getX()) / 2, (vert1.getY() + vert2.getY()) / 2); 
    }
}
