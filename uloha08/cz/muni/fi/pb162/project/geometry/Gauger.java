package cz.muni.fi.pb162.project.geometry;


/**
 * 
 * 
 * @author Samuel Lesko, 409202
 * @version 15.10.2013
 */
public class Gauger
{
    /**
     * Prints measurement of a Measurable to the stdout.
     * 
     * @param m         measurable to be printed
     */
    public static void printMeasurement(Measurable m) {
        System.out.println(m.toString());
        System.out.println("Length/Perimeter: " + m.getLength());
    }
    
    /**
     * Prints measurement of a Solid to the stdout.
     * 
     * @param m         solid to be printed
     */
    public static void printMeasurement(Solid s) {
        printMeasurement((Measurable)s);
        System.out.println("Area: " + s.getArea());
    }

}
