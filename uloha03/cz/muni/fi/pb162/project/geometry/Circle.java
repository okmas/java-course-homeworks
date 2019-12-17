package cz.muni.fi.pb162.project.geometry;


/**
 * A circle in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 8.10.2013
 */
public class Circle implements Solid
{
    private double radius;
    private Vertex2D center;
    
    /**
     * Creates a circle with certain center and radius.
     * 
     * @param newCenter         center of the circle
     * @param newRadius         radius of the circle
     */
    public Circle(Vertex2D newCenter, double newRadius) {
        center = newCenter;
        radius = newRadius;
    }
    
    /**
     * Param-less constructor. Creates a circle with center in the origin and radius of 1.
     */
    public Circle() {
        this(new Vertex2D(0, 0), 1);
    }
    
    /**
    * Returns the area of the circle.
    * 
    * @return area
    */
    public double getArea() {
        return Math.PI * radius * radius;
    }
   
    /**
    * Return circumference of the circle.
    * 
    * @return circumference
    */
    private double getCircumference() {
        return 2 * Math.PI * radius;
    }
    
    /**
    * Returns width of the circle.
    * 
    * @return width
    */
    public double getWidth() {
        return 2 * radius;
    }
   
    /**
    * Returns height of the circle.
    * 
    * @return height
    */
    public double getHeight() {
        return 2 * radius;
    }
    
    /**
    * Returns circumference of the circle.
    * 
    * @return length (circumference)
    */
    public double getLength() {
        return getCircumference();
    }
    
    /**
     * Returns string with info about the circle.
     * 
     * @return string in format "Circle: center=[<x>, <y>], radius=<radius>"
     */
    public String toString() {
        return "Circle: center=" + center.toString() + ", radius=" + radius;
    }
    
    /* getters and setters */
    
    public double getRadius() {
        return radius;
    }
    
    public Vertex2D getCenter() {
        return center;
    }
}
