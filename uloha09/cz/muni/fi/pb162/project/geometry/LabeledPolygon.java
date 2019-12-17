package cz.muni.fi.pb162.project.geometry;

import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.StringBuilder;

/**
 * Represents a simple polygon with additional feature of naming vertices.
 * 
 * @author Samuel Lesko, 409202
 * @version 3.12.2013
 */
public class LabeledPolygon extends SimplePolygon implements PolygonIO
{
    private Map<String, Vertex2D> vertices = new TreeMap<String, Vertex2D>();
    
    /**
     * Adds vertex to polygon.
     * 
     * @param label label of vertex
     * @param vert  vertex to add
     */
    public void addVertex(String label, Vertex2D vert) {
        if (label == null || vert == null) {
            throw new IllegalArgumentException("Label or vert cannot be null.");
        }
        
        vertices.put(label, vert);
    }
    
    /**
     * Returns vertex with given label.
     * 
     * @param label label of vertex
     * @return vertex with given label
     */
    public Vertex2D getVertex(String label) {
        Vertex2D retval = vertices.get(label);
        if (retval == null) {
            throw new IllegalArgumentException("Vertex with label \"" + label + "\" not found.");
        }
        
        return retval;
    }
    
    /**
     * Returns vertex at specified index. Vertices are ordered alphabethically according to their labels.
     * 
     * @param index index of polygon
     * @return vertex at specified index
     */
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be non-negative.");
        }
        
        if (getNumVertices() == 0) {
            throw new IllegalArgumentException("Vertices are empty.");
        }
        
        int i = 0;
        index %= vertices.size();
        for (Vertex2D v : vertices.values()) {
            if (i == index) {
                return v;
            }
            
            ++i;
        }
        
        return null;
    }
    
    /**
     * Returns number of vertices in polygon.
     * 
     * @return number of vertices
     */
    public int getNumVertices() {
        return vertices.size();
    }
    
    /**
     * Returns set of labels of vertices.
     * 
     * @return set of labels of vertices
     */
    public Set<String> getLabels() {
        return Collections.unmodifiableSet(vertices.keySet());
    }
    
    /**
     * Returns collection of sorted vertices.
     * 
     * @return collection of sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices() {
        return getSortedVertices(null);
    } 
    
    /**
     * Returns collection of vertices sorted using comparator.
     * 
     * @param comparator comparator to be used for sorting
     * @return collection of sorted vertices
     */
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        List<Vertex2D> verts = new ArrayList<>(vertices.values());
        
        // remove duplicites
        Iterator<Vertex2D> it = verts.iterator();
        while (it.hasNext()) {
            Vertex2D v = it.next();
            if (Collections.frequency(verts, v) > 1) {
                it.remove();
            }
        }
        
        // sort
        if (comparator == null) {
            Collections.sort(verts);
        } else {
            Collections.sort(verts, comparator);
        }
        
        return verts;
    }
    
    /**
     * Returns collection of labels of vertices equal to vert.
     * 
     * @param vert vertex to be used to search for labels
     * @return collection of labels of vertices equal to vert
     */
    public Collection<String> getLabels(Vertex2D vert) {
        Set<String> labels = new HashSet<>();
        
        for (Map.Entry e : vertices.entrySet()) {
            if (((Vertex2D)e.getValue()).equals(vert)) {
                labels.add((String)e.getKey());
            }
        }
        
        return labels;
    }
    
    /**
     * Returns set of vertices that have more than one label associated with it.
     * 
     * @return set of vertices that have more than one label associated with it
     */
    public Set<Vertex2D> duplicateVertices() {
        Set<Vertex2D> verts = new HashSet<>();
        
        for (Vertex2D v : vertices.values()) {
            if (getLabels(v).size() > 1) {
                verts.add(v);
            }
        }
        
        return verts;
    }
    
    /**
     * Reads vertices from input stream and adds them to this polygon.
     * 
     * @param is input stream to read from
     */
    public void read(InputStream is) throws IOException {
        try {
            Map<String, Vertex2D> vertsToAdd = new TreeMap<>();
            BufferedReader bread = new BufferedReader(new InputStreamReader(is));
        
            String line;
            while ((line = bread.readLine()) != null) {
                int pastXIndex = line.indexOf(' ');
                String x = line.substring(0, pastXIndex);
                int pastYIndex = pastXIndex + 1 + line.substring(pastXIndex + 1, line.length()).indexOf(' ');
                String y = line.substring(pastXIndex + 1, pastYIndex);
                String label = line.substring(pastYIndex + 1, line.length());
                
                vertsToAdd.put(label, new Vertex2D(Double.parseDouble(x), Double.parseDouble(y)));
            }
            
            vertices.putAll(vertsToAdd);
        } catch (Exception e) {
            throw new IOException("Invalid input file format.", e);
        }
    }
    
    /**
     * Writes vertices of this polygon to output stream.
     * 
     * @param os output stream to write to
     */
    public void write(OutputStream os) throws IOException {
        BufferedWriter bwrit = new BufferedWriter(new OutputStreamWriter(os));
        
        for (Map.Entry e : vertices.entrySet()) {
            Vertex2D vert = (Vertex2D)e.getValue();
            String label = (String)e.getKey();
            bwrit.write(vert.getX() + " " + vert.getY() + " " + label);
            bwrit.newLine();
        }
        
        bwrit.flush();
    }
    
    /**
     * Reads vertices from file and adds them to this polygon.
     * 
     * @param file file to read from
     */
    public void read(File file) throws IOException {
        read(new FileInputStream(file));
    }
    
    /**
     * Writes vertices of this polygon to file.
     * 
     * @param file file to write to
     */
    public void write(File file) throws IOException {
        write(new FileOutputStream(file));
    }
    
    /**
     * Writes vertices of this polygon to output stream using binary write.
     * 
     * @param os output stream to write to
     */
    public void binaryWrite(OutputStream os) throws IOException {
        for (Map.Entry e : vertices.entrySet()) {
            Vertex2D vert = (Vertex2D)e.getValue();
            String label = (String)e.getKey();
            
            StringBuilder sb = new StringBuilder();
            sb.append(vert.getX());
            sb.append(" ");
            sb.append(vert.getY());
            sb.append(" ");
            sb.append(label);
            sb.append(System.lineSeparator());
            
            os.write(sb.toString().getBytes());
        }
    }
}
