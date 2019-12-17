package cz.muni.fi.pb162.project.geometry;


/**
 * Representation of the olympic logo. 
 * 
 * @author Samuel Lesko
 * @version 22.10.2013
 */
public class OlympicRings
{
    private Circle[] rings;
    private static final double SPACE_BETWEEN_CIRCLES = 3.0;
    
    /* Constructors */
    
    /**
     * Creates olympic rings representation.
     * 
     * @param centerBlack       center of the black ring
     * @param radius            radius of all rings
     */
    public OlympicRings(Vertex2D centerBlack, double radius) {
        rings = new Circle[5];
        double x = centerBlack.getX();
        double y = centerBlack.getY();
        
        // black ring
        rings[1] = new Circle(centerBlack, radius);
        
        // blue ring
        x = moveLeft(x, radius, 2);
        rings[0] = new Circle(new Vertex2D(x, y), radius);
        rings[0].setColor("blue");
        
        // yellow ring
        x = moveRight(x, radius, 1);
        y = moveDown(y, radius);
        rings[3] = new Circle(new Vertex2D(x, y), radius);
        rings[3].setColor("yellow");
        
        // green ring
        x = moveRight(x, radius, 2);
        rings[4] = new Circle(new Vertex2D(x, y), radius);
        rings[4].setColor("green");
        
        // red ring
        y = moveUp(y, radius);
        x = moveRight(x, radius, 1);
        rings[2] = new Circle(new Vertex2D(x, y), radius);
        rings[2].setColor("red");
    }
    
    /* getters and setters */
    
    public Circle getBlueRing() {
        return rings[0];
    }
    
    public Circle getBlackRing() {
        return rings[1];
    }
    
    public Circle getRedRing() {
        return rings[2];
    }
    
    public Circle getYellowRing() {
        return rings[3];
    }
    
    public Circle getGreenRing() {
        return rings[4];
    }
    
    /* private methods */
    
    private double moveDown(double y, double radius) {
        return y - (radius + SPACE_BETWEEN_CIRCLES);
    }
    
    private double moveUp(double y, double radius) {
        return y + (radius + SPACE_BETWEEN_CIRCLES);
    }
    
    private double moveLeft(double x, double radius, int times) {
        return x - (times * (radius + SPACE_BETWEEN_CIRCLES));
    }
    
    private double moveRight(double x, double radius, int times) {
        return x + (times * (radius + SPACE_BETWEEN_CIRCLES));
    }
}
