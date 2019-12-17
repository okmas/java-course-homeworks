package cz.muni.fi.pb162.project.geometry;

/**
 * A circle in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 22.10.2013
 */
public class Circle extends GeneralRegularPolygon
{
    private double radius;
    
    /* Constructors */
    
    /**
     * Creates a circle with certain center and radius.
     * 
     * @param center         center of the circle
     * @param radius         radius of the circle
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, 0);
        
        this.radius = radius;
    }
    
    /**
     * Param-less constructor. Creates a circle with center in the origin and radius of 1.
     */
    public Circle() {
        this(new Vertex2D(0, 0), 1);
    }
    
    /* public methods */
    
    /**
     * Returns string with info about the circle.
     * 
     * @return string in format "Circle: center=[<x>, <y>], radius=<radius>"
     */
    public String toString() {
        return "Circle: center=" + getCenter().toString() + ", radius=" + radius;
    }
    
    /* public methods */
    
    /**
     * Returns the radius of the circle.
     * 
     * @return radius of the circle
     */
    @Override
    public double getRadius() {
        return radius;
    }
    
    /**
     * Returns area of the circle.
     * 
     * @return Area
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    /**
     * Returns the circumference of the circle.
     * 
     * @return length or perimeter
     */
    @Override
    public double getLength() {
        return 2 * Math.PI * radius;
    }
}
