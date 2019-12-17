package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.test.OutputTester;
import cz.muni.fi.pb162.project.demo.Demo;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        Vertex2D v1 = new Vertex2D(-1,0);
        assertTrue("Konstruktor Vertex2D", v1.getX() == -1.0 && v1.getY() == 0.0);

        BasicRulesTester.testRedundantMethod(Vertex2D.class, "setX", Double.TYPE);
        BasicRulesTester.testRedundantMethod(Vertex2D.class, "setY", Double.TYPE);
        
        double dist = new Vertex2D(-1.2, 1.2).distance(new Vertex2D(1.3, 1.3));
        assertTrue("distance() pocita spatne", dist > 2.5 && dist < 2.503);
        try {
            assertTrue("distance() nevraci -1 jako indikator chybneho argumentu", new Vertex2D(-1,0).distance(null) == -1.0);
        } catch (Exception ex) {
            fail("distance() neosetruje null argument");
        }
    }

    @Test public void task02() {
        Triangle tri = new Triangle(new Vertex2D(-1,0), new Vertex2D(1,0), new Vertex2D(0,1));
        assertTrue("Konstruktor Triangle", tri.getVertexA().getX() == -1.0 && tri.getVertexA().getY() == 0.0);
        
        BasicRulesTester.testRedundantMethod(Triangle.class, "setVertexA", Vertex2D.class);
        BasicRulesTester.testRedundantMethod(Triangle.class, "setVertexB", Vertex2D.class);
        BasicRulesTester.testRedundantMethod(Triangle.class, "setVertexC", Vertex2D.class);
        
        assertTrue("isEquilateral()", new Triangle(new Vertex2D(-1.2, 0), new Vertex2D(1.2, 0), new Vertex2D(0, 2.07846097)).isEquilateral());
        assertFalse("isEquilateral()", new Triangle(new Vertex2D(-1.2, 0), new Vertex2D(1.2, 0), new Vertex2D(0, 5.0)).isEquilateral());
        
        try {
            Triangle ntri = new Triangle(null, null, null);
            assertEquals("toString vraci spatny vystup pokud je nektery z vrcholu prazdny", "INVALID TRIANGLE", ntri.toString());
        } catch(NullPointerException ex) {
            fail("toString neosetruje situaci, kdy je nektery z vrcholu prazdny");
        }
    }

    @Test public void task03() {
        // task02 otestuje, zda byl pridan konstruktor a zda byly zruseny settry.
        // Zbyva tedy otestovat vystup (aby studenti pouze nesmazali telo metody main).
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Demo.main(null);
        boolean eq = ot.outputEquals("Triangle: vertices=[-100.0, 0.0] [0.0, 100.0] [100.0, -100.0]");
        ot.releaseOutput();
        assertTrue("Spatny vystup metody Demo.main()", eq);
    }

    @Test public void task04() {
        Circle c1 = new Circle();
        Circle c2 = new Circle(new Vertex2D(1.0, -1.0), 0.5);
        
        assertTrue("Parametricky konstruktor: spatny polomer", c2.getRadius() == 0.5);
        assertTrue("Parametricky konstruktor: spatny stred", c2.getCenter().getX() == 1.0 && c2.getCenter().getY() == -1.0);
        assertTrue("Bezparametricky konstruktor: spatny polomer", c1.getRadius() == 1.0);
        assertTrue("Bezparametricky konstruktor: spatny stred", c1.getCenter().getX() == 0.0 && c1.getCenter().getY() == 0.0);
        //c2.setRadius(0.3);
        //assertTrue("setRadius()", c2.getRadius() == 0.3);
        
        assertEquals("toString", "Circle: center=[1.0, -1.0], radius=0.5", c2.toString());

        System.err.println("Cvicici zkontroluje vzajemne volani konstruktoru ve tride Circle! [-0.5 bodu]");
    }

}
