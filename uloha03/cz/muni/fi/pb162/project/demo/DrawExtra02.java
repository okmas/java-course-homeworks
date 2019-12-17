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

public class DrawExtra02 extends Draw {

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
        Vertex2D v1 = new Vertex2D(-100,-100);
        Vertex2D v2 = new Vertex2D(0,100);
        Vertex2D v3 = new Vertex2D(100,-100);
        
        Triangle tri = new Triangle(v1, v2, v3, 5);
        
        Draw canvas = new DrawExtra02();
        canvas.paintTriangle(tri);
        canvas.startPainting();
    }
    */
}
