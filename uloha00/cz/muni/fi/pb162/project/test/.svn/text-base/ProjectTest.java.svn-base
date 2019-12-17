package cz.muni.fi.pb162.project.test;

import cz.muni.fi.pb162.project.test.BasicRulesTester;
import cz.muni.fi.pb162.project.test.OutputTester;
import cz.muni.fi.pb162.project.demo.Demo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Radek Oslejsek &lt;oslejsek@fi.muni.cz&gt;, Masaryk University, Faculty of Informatics
 */
public class ProjectTest {
    
    @Test public void task01() {
        BasicRulesTester.testRunnableClass(Demo.class);
        
        OutputTester ot = new OutputTester();
        ot.captureOutput();
        Demo.main(null);
        boolean b1 = ot.outputEqualsIgnoreCase("Hello World!");
        boolean b2 = ot.outputEquals("Hello World!");
        ot.releaseOutput();
        assertTrue("Chybny vystup, zalezi i na mezerach apod.", b1);
        assertTrue("Chybny vystup, zalezi i na velikosti pismen!", b2);
    }
    
    @Test public void task02() {
    }
    
    @Test public void task03() {
    }
}
