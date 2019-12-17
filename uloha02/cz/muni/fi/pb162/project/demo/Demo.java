package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Demo class.
 * 
 * @author Samuel Lesko, 409202 
 * @version 8.10.2013
 */
public class Demo {
    
    /**
     * Main function
     * 
     * @param args Arguments from command line
     */
    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Vertex2D(-100, 0), 
                                         new Vertex2D(0, 100), 
                                         new Vertex2D(100, -100));
      
        System.out.println(triangle.toString());
    }
}