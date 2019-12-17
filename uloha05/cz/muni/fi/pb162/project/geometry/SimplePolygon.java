package cz.muni.fi.pb162.project.geometry;


/**
 * General representation of a polygon.
 * 
 * @author Samuel Lesko, 409202
 * @version 5.11.2013
 */
public abstract class SimplePolygon implements Polygon
{
    /* abstract methods */
    
    public abstract Vertex2D getVertex(int index) throws IllegalArgumentException;
    
    public abstract int getNumVertices();
    
    /* public methods */
    
    public double getHeight() {
        return maxY() - minY();
    }
    
    public double getWidth() {
        return maxX() - minX();
    }
    
    public double getLength() {
        double length = 0;
        
        for (int i = 0; i < getNumVertices(); i++) {
            length += getVertex(i).distance(getVertex(i + 1));
        }
        
        return length;
    }
    
    public double getArea() {
        double area = 0;
        Vertex2D vert1;
        Vertex2D vert2;
        
        for (int i = 0; i <= getNumVertices() - 1; i++) {
            vert1 = getVertex(i);
            vert2 = getVertex(i + 1);
            area += vert1.getX() * vert2.getY() - vert2.getX() * vert1.getY();
        }
        
        area /= 2;
        
        return area;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder("Polygon: vertices =");
        for (int i = 0; i < getNumVertices(); i++) {
            builder.append(" " + getVertex(i));
        }
        
        return builder.toString();
    }
    
    /* private methods */
    
    private double maxX() {
        double retval = Integer.MIN_VALUE;
        Vertex2D help;
        
        for (int i = 0; i < getNumVertices(); i++) {
            help = getVertex(i);
            
            if (help.getX() > retval) {
                retval = help.getX();
            }
        }
        
        return retval;
    }
    
    private double minX() {
        double retval = Integer.MAX_VALUE;
        Vertex2D help;
        
        for (int i = 0; i < getNumVertices(); i++) {
            help = getVertex(i);
            
            if (help.getX() < retval) {
                retval = help.getX();
            }
        }
        
        return retval;
    }
    
    private double maxY() {
        double retval = Integer.MIN_VALUE;
        Vertex2D help;
        
        for (int i = 0; i < getNumVertices(); i++) {
            help = getVertex(i);
            
            if (help.getY() > retval) {
                retval = help.getY();
            }
        }
        
        return retval;
    }
    
    private double minY() {
        double retval = Integer.MAX_VALUE;
        Vertex2D help;
        
        for (int i = 0; i < getNumVertices(); i++) {
            help = getVertex(i);
            
            if (help.getY() < retval) {
                retval = help.getY();
            }
        }
        
        return retval;
    }
}
