package cz.muni.fi.pb162.project.geometry;


/**
 * General reprezentation of an n-gon.
 * 
 * @author Samuel Lesko, 409202
 * @version 22.10.2103
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored
{
    private Vertex2D center;
    private int edgesCount;
    private double edgeLength;
    private String color;
    
    /* Constructors */
    /**
     * Constructor.
     * 
     * @param pCenter       center of the polygon
     * @param pEdgesCount   number of edges
     * @param pEdgeLength   length of an edge
     */
    public GeneralRegularPolygon(Vertex2D pCenter, int pEdgesCount, double pEdgeLength) {
        center = pCenter;
        edgesCount = pEdgesCount;
        edgeLength = pEdgeLength;
        color = "black";
    }
    
    /* public methods */
    /**
     * Returns string in format "<n>-gon: center=[<center>], edge length=<length>, color=<color>"
     * 
     * @return string
     */
    @Override
    public String toString() {
        return edgesCount + "-gon: center=" + center.toString() + ", edge length=" + edgeLength + ", color=" + color;
    }
    
    /* RegularPolygon implementation */
    
    /**
     * Returns number of edges of the regular polygon.
     * 
     * @return number of edges
     */
    public int getNumEdges() {
        return edgesCount;
    }
    
    /**
     * Returns length of a single edge.
     * 
     * @return edge length
     */
    public double getEdgeLength() {
        return edgeLength;
    }
    
    /**
     * Returns center of the minimum bounding circle.
     * 
     * @return center of the minimum bounding circle
     */
    public Vertex2D getCenter() {
        return center;
    }
    
    /**
     * Returns radius of the minimum bounding circle.
     * 
     * @return radius of the minimum bounding circle
     */
    public double getRadius() {
        return edgeLength / (2 * Math.sin(Math.PI / edgesCount));
    }
    
    /**
     * Returns area of the polygon.
     * 
     * @return Area
     */
    public double getArea() {
        return edgesCount * Math.pow(getRadius(), 2) * Math.sin(2 * Math.PI / edgesCount) / 2;
    }
    
    /**
     * Returns the diameter of the minimum bounding circle.
     * 
     * @return polygon's width
     */
    public double getWidth() {
        return getRadius() * 2;
    }
    
    /**
     * Returns the diameter of the minimum bounding circle.
     * 
     * @return polygons's width
     */
    public double getHeight() {
        return getRadius() * 2;
    }
    
    /**
     * Returns the perimeter of the polygon.
     * 
     * @return length or perimeter
     */
    public double getLength() {
        return edgesCount * edgeLength;
    }
    
    /* Coloured implementation */
    
    /**
     * Returns color of the object.
     * 
     * @return Color name.
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Sets new color.
     * 
     * @param color Color name
     */
    public void setColor(String color) {
        this.color = color;
    }
}
