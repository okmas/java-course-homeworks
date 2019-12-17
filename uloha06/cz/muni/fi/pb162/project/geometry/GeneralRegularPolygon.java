package cz.muni.fi.pb162.project.geometry;


/**
 * General reprezentation of an n-gon.
 * 
 * @author Samuel Lesko, 409202
 * @version 12.11.2103
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored
{
    private Vertex2D center;
    private int numEdges;
    private double edgeLength;
    private String color;
    
    /* Constructors */
    /**
     * Constructor.
     * 
     * @param pCenter       center of the polygon
     * @param pNumEdges     number of edges
     * @param pEdgeLength   length of an edge
     */
    public GeneralRegularPolygon(Vertex2D pCenter, int pNumEdges, double pEdgeLength) {
        center = pCenter;
        numEdges = pNumEdges;
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
        return numEdges + "-gon: center=" + center.toString() + ", edge length=" + edgeLength + ", color=" + color;
    }
    
    /**
     * Returns array of triangles whose one side is a side of the polygon
     * and the other two are sides whose one vertex is the center of the polygon
     * and the other is the respective vertex of the polygon.
     * 
     * @return array of triangles
     */
    public Triangle[] triangulate() {
        Triangle[] tri = new Triangle[getNumVertices()];
        
        for (int i = 0; i < getNumVertices(); i++) {
            tri[i] = new Triangle(getVertex(i), getVertex(i + 1), getCenter());
        }
        
        return tri;
    }
    
    /* RegularPolygon implementation */
    
    /**
     * Returns number of edges of the regular polygon.
     * 
     * @return number of edges
     */
    public int getNumEdges() {
        return numEdges;
    }
    
    /**
     * Returns number of vertices of the regular polygon.
     * 
     * @return number of vertices
     */
    public int getNumVertices() {
        return numEdges;
    }
    
    /**
     * Returns vertex at given index modulo number of indices.
     * 
     * @param index vertex index
     * @return vertex at given index modulo number of indices
     * @throws IllegalArgumentException if index is negative
     */
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be positive.");
        }
        
        double x = getCenter().getX() - getRadius() * Math.cos(index * 2 * Math.PI / getNumVertices());
        double y = getCenter().getY() - getRadius() * Math.sin(index * 2 * Math.PI / getNumVertices());
        
        return new Vertex2D(x, y);
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
        return edgeLength / (2 * Math.sin(Math.PI / numEdges));
    }
    
    /**
     * Returns area of the polygon.
     * 
     * @return Area
     */
    public double getArea() {
        return numEdges * Math.pow(getRadius(), 2) * Math.sin(2 * Math.PI / numEdges) / 2;
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
        return numEdges * edgeLength;
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
