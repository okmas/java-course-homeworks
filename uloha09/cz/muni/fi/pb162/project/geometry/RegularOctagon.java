package cz.muni.fi.pb162.project.geometry;


/**
 * Representation of a regular octagon.
 * 
 * @author Samuel Lesko, 409202 
 * @version 22.10.2013
 */
public class RegularOctagon extends GeneralRegularPolygon 
{
    /**
     * Constructor for regular octagon.
     * 
     * @param center        center of the octagon
     * @param edgeLength    length of one edge
     */
    public RegularOctagon(Vertex2D center, double edgeLength) {
        super(center, 8, edgeLength);
    }
}
