package cz.muni.fi.pb162.project.geometry;


/**
 * Represents a general polygon using array of vertices.
 * 
 * @author Samuel Lesko, 409202
 * @version 5.11.2013
 */
public class ArrayPolygon extends SimplePolygon
{
    private Vertex2D[] vertices;
    
    /* constructors */
    /**
     * Constructor.
     * 
     * @param verts     vertices of the polygon
     */
    public ArrayPolygon(Vertex2D[] verts) throws NullPointerException {
        vertices = verts.clone();
        
        if (verts == null) {
            throw new NullPointerException();
        }
        
        for (int i = 0; i < getNumVertices(); i++) {
            if (verts[i] == null) {
                throw new NullPointerException();
            }
        }
    }
    
    /* public methods */
    
    /**
     * Returns inversion of this polygon - means the order of its vertices is inverted.
     * 
     * @return inverted ArrayPolygon
     */
    public ArrayPolygon invert() {
        Vertex2D[] newVerts = new Vertex2D[vertices.length];
        
        for (int i = 0; i < getNumVertices(); i++) {
            newVerts[i] = getVertex(getNumVertices() - 1 - i);
        }
        
        return new ArrayPolygon(newVerts);
    }
    
    /**
     * Compares an ArrayPolygon with this polygon. Takes into account inversion of vertices and shifts in the order of vertices.
     * 
     * @param pol       polygon to compare
     * @return true if polygons are equal, false otherwise
     */
    public boolean compare(ArrayPolygon pol) {
        if (pol.getNumVertices() != getNumVertices()) return false;
        
        // find first vertex that mathes with vertex number 0
        int first = -1;
        for (int i = 0; i < getNumVertices(); i++) {
            if (pol.getVertex(i).isEqual(getVertex(0))) {
                first = i;
                break;
            }
        }
        
        // check if pol seems to be inverted or not
        boolean checkForInverted;
        if (first == -1) {
            return false;
        } else {
            if (pol.getVertex(first + 1).isEqual(getVertex(1))) {
                checkForInverted = false; 
            } else if (pol.getVertex(first + 1).isEqual(getVertex(getNumVertices() - 1))) {
                checkForInverted = true;
            } else {
                return false;
            }
        }
        
        // compare each vertex in both arrays
        if (! checkForInverted) {
            for (int i = 0; i < getNumVertices(); i++) {
                if (! pol.getVertex(first + i).isEqual(getVertex(i))) {
                    return false;
                }
            }
        }
        
        else {
            for (int i = 0; i < getNumVertices(); i++) {
                if (! pol.getVertex(first + i).isEqual(getVertex(getNumVertices() - i))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /* getters and setters */
    
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) throw new IllegalArgumentException();
        
        return vertices[index % getNumVertices()];
    }
    
    public int getNumVertices() {
        return vertices.length;
    }
}
