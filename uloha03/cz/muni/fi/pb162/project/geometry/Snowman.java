package cz.muni.fi.pb162.project.geometry;


/**
 * Class that represents a snowman.
 * 
 * @author Samuel Lesko, 409202 
 * @version 15.10.2013
 */
public class Snowman
{
    private static final double ORIGIN_X = 0;
    private static final double ORIGIN_Y = 0;
    private Circle[] balls;
    
    /**
     * Constructor.
     * 
     * @param radius        radius of bottom circle
     * @param ratio         ratio of changing size of the circles going upwards
     */
    public Snowman(double radius, double ratio)
    {
        balls = new Circle[5];
        if (ratio < 0 || ratio > 1) ratio = 0.8;
        
        createBody(ORIGIN_X, ORIGIN_Y, radius, ratio);
        
        createHands(balls[1].getCenter().getX(),
                    balls[1].getCenter().getY(),
                    balls[1].getRadius() * 0.5);
    }
    
    /**
     * Creates body of snowman.
     * 
     * @param x             x of center of bottom circle
     * @param y             y of center of bottom circle
     * @param radius        radius of bottom circle
     * @param ratio         ratio of changing size of the circles going upwards
     */
    private void createBody(double x, double y, double radius, double ratio) {
        for (int i = 0; i < 3; i++) {
            balls[i] = new Circle(new Vertex2D(x, y), radius);
            y += radius;
            radius *= ratio;
            y += radius;
        }
    }
    
    /**
     * Creates hands of snowman.
     * 
     * @param middleX       x of middle circle of snowmans's body
     * @param middleY       y of middle circle of snowmans's body
     * @param radius        radius of hand circles
     */
    private void createHands(double middleX, double middleY, double radius) {
        balls[3] = new Circle(new Vertex2D(middleX - radius * 3, middleY), radius);
        balls[4] = new Circle(new Vertex2D(middleX + radius * 3, middleY), radius);
    }
    
    /* getters and setters */
    
    public Circle getBottomBall() {
        return balls[0];
    }
    
    public Circle getMiddleBall() {
        return balls[1];
    }
    
    public Circle getTopBall() {
        return balls[2];
    }
    
    public Circle getLeftHandBall() {
        return balls[3];
    }
    
    public Circle getRightHandBall() {
        return balls[4];
    }
}
