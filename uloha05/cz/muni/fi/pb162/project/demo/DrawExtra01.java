package cz.muni.fi.pb162.project.demo;

import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * 
 * Trida umoznujici vykresleni grafickych objektu pozadovanych v ramci nepovinnych ukolu.
 * 
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;
 * @version 2013-09-05
 *
 */

public class DrawExtra01 extends Draw {
    
    /*
    @Override
    public boolean paintTriangle(Triangle triangle) {
        boolean ret = super.paintTriangle(triangle);
        if (!ret) return ret;
        if (!triangle.isDivided()) return false;
        for (int i = 0; i < 3; i++) {
            paintTriangle(triangle.getSubTriangle(i));
        }
        return true;
    }
    
    public static void main(String[] args) {
        Vertex2D v1 = new Vertex2D();
        Vertex2D v2 = new Vertex2D();
        Vertex2D v3 = new Vertex2D();
        v1.setX(-100);
        v1.setY( 0);
        v2.setX( 0);
        v2.setY( 100);
        v3.setX( 100);
        v3.setY(-100);
        
        Triangle tri = new Triangle();
        tri.setVertexA(v1);
        tri.setVertexB(v2);
        tri.setVertexC(v3);
        
        System.out.println(tri);
        
        Draw demo = new DrawExtra01();
        tri.divide();
        demo.paintTriangle(tri);
        demo.startPainting();
    }
    */
}
