package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.test.OutputTester;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Gauger;
import cz.muni.fi.pb162.project.geometry.Measurable;
import cz.muni.fi.pb162.project.geometry.Solid;
import cz.muni.fi.pb162.project.geometry.Triangle;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        assertTrue("Trida Triangle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Solid.class.isAssignableFrom(Triangle.class));
        assertTrue("Trida Circle neimplementuje pozadovane rozhrani -- chyba v hlavicce tridy", Solid.class.isAssignableFrom(Circle.class));

        Solid tri = new Triangle(new Vertex2D(-1,0), new Vertex2D(1,0), new Vertex2D(0,1));
        Solid cir = new Circle();
        
        assertTrue("Triangle.getWidth()", tri.getWidth() == 2.0);
        assertTrue("Triangle.getHeight()", tri.getHeight() == 1.0);
        assertTrue("Triangle.getLength()", Math.abs(tri.getLength() - 4.82842712474619) < 0.001);
        assertTrue("Triangle.getArea()", Math.abs(tri.getArea() - 1.0) < 0.001);
        
        assertTrue("Circle.getWidth()", cir.getWidth() == 2.0);
        assertTrue("Circle.getHeight()", cir.getHeight() == 2.0);
        assertTrue("Circle.getLength()", Math.abs(cir.getLength() - (Math.PI * 2.0)) < 0.001);
        assertTrue("Circle.getArea()", Math.abs(cir.getArea() - Math.PI) < 0.001);
    }

    @Test public void task02() {
        BasicRulesTester.testStaticMethod(Gauger.class, "printMeasurement", Measurable.class);
        BasicRulesTester.testStaticMethod(Gauger.class, "printMeasurement", Solid.class);
        
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Gauger.printMeasurement((Measurable)new Circle(new Vertex2D(0,0), 1));
        boolean eq = ot.outputEquals("Circle: center=[0.0, 0.0], radius=1.0" +
                System.lineSeparator() +
                "Length/Perimeter: 6.283185307179586");
        ot.releaseOutput();
        assertTrue("Spatny vystup metody Gauger.printMeasurement(Measurable)", eq);
        
        ot = new OutputTester();
        ot.captureOutput();
        Gauger.printMeasurement((Solid) new Circle(new Vertex2D(0,0), 1));
        eq = ot.outputEquals("Circle: center=[0.0, 0.0], radius=1.0" +
                System.lineSeparator() +
                "Length/Perimeter: 6.283185307179586" +
                System.lineSeparator() +
                "Area: 3.141592653589793");
        ot.releaseOutput();
        assertTrue("Spatny vystup metody Gauger.printMeasurement(Solid)", eq);
        
        System.err.println("Cvicici zkontroluje vzajemne volani metod v Gauer [-0.5 bodu]");
    }

    @Test public void task03() {
        boolean hasStaticField = false;
        for (Field field : Triangle.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                hasStaticField = true;
                break;
            }
        }
        if (!hasStaticField) fail("Epsilon neni verejna konstanta");
        BasicRulesTester.testAttributes(Triangle.class);
        
        System.err.println("Cvicici zkontroluje pouziti konstanty v Triangle.isEquilateral() [-0.5 bodu]");
    }

}
