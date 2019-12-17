package cz.muni.fi.pb162.project.geometry;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Represents a general polygon using collection of vertices.
 * 
 * @author Samuel Lesko, 409202
 * @version 19.11.2013
 */
public class CollectionPolygon extends SimplePolygon
{
    private List<Vertex2D> vertices;
    
    /* constructors */
    
    /**
     * Constructor.
     * 
     * @param verts         array of vertices
     */
    public CollectionPolygon(Vertex2D[] verts) throws NullPointerException {
        if (verts == null) {
            throw new NullPointerException("Vertices list cannot be null.");
        }
        
        vertices = new ArrayList<Vertex2D>();
        for (Vertex2D v : verts) {
            if (v == null) {
                throw new NullPointerException("No vertex can be null.");
            }
            
            vertices.add(v);
        }
    }
    
    /* public methods */
    
    /**
     * Returns inversion of this polygon - means the order of its vertices is inverted.
     * 
     * @return inverted CollectionPolygon
     */
    public CollectionPolygon invert() {
        Vertex2D[] newVerts = new Vertex2D[getNumVertices()];
        
        for (int i = 0; i < getNumVertices(); i++) {
            newVerts[i] = getVertex(getNumVertices() - 1 - i);
        }
        
        return new CollectionPolygon(newVerts);
    }
    
    /**
     * Removes leftmost vertices from this.
     * 
     * @return collection of leftmost vertices
     */
    public Collection<Vertex2D> removeLeftmostVertices() {
        List<Vertex2D> leftmost = new LinkedList<Vertex2D>();
        
        Vertex2D help;
        do
        {
            help = Collections.min(vertices);
            vertices.remove(help);
            leftmost.add(help);
        } while (help.compareTo(Collections.min(vertices)) == 0);
        
        return leftmost;
    }
    
    /* getters */
    
    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative");
        }
        
        return vertices.get(index % getNumVertices());
    }
    
    @Override
    public int getNumVertices() {
        return vertices.size();
    }
    
    /**
     * Returns collection of vertices.
     * 
     * @return collection of vertices
     */
    public Collection<Vertex2D> getVertices() {
        return Collections.unmodifiableCollection(vertices);
    }
}
