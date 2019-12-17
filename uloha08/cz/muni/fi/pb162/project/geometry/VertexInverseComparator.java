package cz.muni.fi.pb162.project.geometry;

import java.util.Comparator;

/**
 * Compares objects of type Vertex2D first by x (descending), then by y (descending).
 * 
 * @author Samuel Lesko, 409202
 * @version 3.12.2013
 */
public class VertexInverseComparator implements Comparator<Vertex2D>
{
    /**
     * Compares two vertices according to Vertex2D compareTo.
     * 
     * @param vert1 vertex one
     * @param vert2 vertex two
     * @return inverse comparation implemented by Vertex2D compareTo
     */
    @Override
    public int compare(Vertex2D vert1, Vertex2D vert2) {
        return vert1.compareTo(vert2) * -1;
    }
}
