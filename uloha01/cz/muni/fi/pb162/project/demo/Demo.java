package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Write a description of class Demo here.
 * 
 * @author Samuel Lesko, 409202 
 * @version 24.9.
 */
public class Demo {
    
    /**
     * Main function
     * 
     * @param args Arguments from command line
     */
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        
        Vertex2D vertA = new Vertex2D();
        vertA.setX(-100);
        vertA.setY(0);
        
        Vertex2D vertB = new Vertex2D();
        vertB.setX(0);
        vertB.setY(100);
        
        Vertex2D vertC = new Vertex2D();
        vertC.setX(100);
        vertC.setY(-100);
        
        triangle.setVertexA(vertA);
        triangle.setVertexB(vertB);
        triangle.setVertexC(vertC);
        
        System.out.println(triangle.toString());
    }
}