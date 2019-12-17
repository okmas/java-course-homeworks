package cz.muni.fi.pb162.project.geometry;


/**
 * Representation of a square.
 * 
 * @author Samuel Lesko, 409202
 * @version 22.10.2013
 */
public class Square extends GeneralRegularPolygon
{
    /**
     * Creates a square.
     * 
     * @param center        center of the square
     * @param edgeLength    length of one edge
     */
    public Square(Vertex2D center, double edgeLength) {
        super(center, 4, edgeLength);
    }
    
    /**
     * Creates a square.
     *
     * @param radius        radius of the smallest bounding rectangl
     * @param center        center of the square
     */
    public Square(double radius, Vertex2D center) {
        this(center, Math.sqrt(2) * radius);
    }
}
