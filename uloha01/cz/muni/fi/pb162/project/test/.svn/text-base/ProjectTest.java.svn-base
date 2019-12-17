package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.OutputTester;
import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.demo.Demo;
import cz.muni.fi.pb162.project.geometry.Triangle;
import java.lang.reflect.Field;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        BasicRulesTester.testMethodsAndAttributes(Vertex2D.class);
        assertEquals("Pocet atributu", 2, Vertex2D.class.getDeclaredFields().length);
        for (Field field: Vertex2D.class.getDeclaredFields()) {
            assertEquals("Typ atributu", Double.TYPE, field.getType());
        }
        
        Vertex2D vert = new Vertex2D();
        vert.setX(-1.2);
        vert.setY(1.2);
        assertTrue("setX() + getX()", vert.getX() == -1.2);
        assertTrue("setY() + getY()", vert.getY() ==  1.2);
        
        assertEquals("toString()", "[-1.2, 1.2]", vert.toString());
    }
    
    @Test public void task02() {
        BasicRulesTester.testMethodsAndAttributes(Triangle.class);
        // Next test is not strict because extra tasks require more attributes
        // then only A,B and C vertices:
        assertTrue("Pocet atributu", Triangle.class.getDeclaredFields().length >= 3);

        Vertex2D vert1 = new Vertex2D();
        Vertex2D vert2 = new Vertex2D();
        Vertex2D vert3 = new Vertex2D();
        vert1.setX(-1.2);
        vert1.setY( 0.0);
        vert2.setX( 1.2);
        vert2.setY( 0.0);
        vert3.setX( 0.0);
        vert3.setY( 2.07846097);
        
        Triangle tri = new Triangle();
        tri.setVertexA(vert1);
        tri.setVertexB(vert2);
        tri.setVertexC(vert3);
        
        assertTrue("getVertexA()", tri.getVertexA().getX() == -1.2 && tri.getVertexA().getY() == 0.0);

        assertEquals("toString()", "Triangle: vertices=[-1.2, 0.0] [1.2, 0.0] [0.0, 2.07846097]", tri.toString());
    }
    
    @Test public void task03() {
        BasicRulesTester.testRunnableClass(Demo.class);
        
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Demo.main(null);
        boolean eq = ot.outputEquals("Triangle: vertices=[-100.0, 0.0] [0.0, 100.0] [100.0, -100.0]");
        ot.releaseOutput();
        assertTrue("Spatny vystup metody Demo.main()", eq);        
    }
}
