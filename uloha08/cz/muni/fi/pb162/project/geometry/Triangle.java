package cz.muni.fi.pb162.project.geometry;


/**
 * A triangle in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 5.11.2013
 */
public class Triangle extends ArrayPolygon 
{
   private Triangle[] subTriangles;
   private boolean divided;
   
   /* Constructors */
   
   /**
    * Constructor that initializes verteces of the triangle.
    * 
    * @param vertA      first vertex
    * @param vertB      second vertex
    * @param vertC      third vertex
    */
   public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC) {
       super(new Vertex2D[]{vertA, vertB, vertC});
       
       divided = false;
       subTriangles = new Triangle[3];
   }
   
   /**
    * Constructor that initializes verteces of the triangle and sets depth of fractal to be created.
    * 
    * @param vertA      first vertex
    * @param vertB      second vertex
    * @param vertC      third vertex
    * @param depth      depth of fractal
    */
   public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC, int depth) {
       this(vertA, vertB, vertC);
       
       divide(depth);
   }
   
   /* public methods */
   
   /**
    * Return subtriangle at index.
    * 
    * @param i          index
    * @return subtriangle at given index withing range 0-2, for indeces out of range returns null
    */
   public Triangle getSubTriangle(int i) {
       return ((i >= 0) && (i <= 2) && isDivided()) ? subTriangles[i] : null; 
   }
    
   /**
    * Devides triangle into subtriangles. 
    * 
    * @return true if triangle has been divided succesfully, false if it has already been devided
    */
   public boolean divide() {
       if (isDivided()) return false;
     
       for (int i = 0; i < 3; i++) {
           subTriangles[i] = new Triangle(getVertex(i), Vertex2D.middleVertex(getVertex(i), getVertex((i + 1) % 3)), Vertex2D.middleVertex(getVertex(i), getVertex((i + 2) % 3)));
       }
       
       divided = true;
       
       return true;
   }
   
   /**
    * Creates fractal structure - Sierpinski triangle.
    * 
    * @param depth      depth of fractal
    */
   public void divide(int depth) {
       if (depth > 0) {
           divide();
           
           for (int i = 0; i < 3; i++) 
                subTriangles[i].divide(depth - 1);
       }
   }
    
   /**
    * Checks whether the triangle is equilateral.
    * 
    * @return true if it is, false otherwise
    */
   public boolean isEquilateral() {
       final double EPSILON = 0.001;
       
       double dist1 = getSideLength(0, 1);
       double dist2 = getSideLength(0, 2);
       double dist3 = getSideLength(1, 2);
       
       return (Math.abs(dist1 - dist2) < EPSILON) && 
              (Math.abs(dist2 - dist3) < EPSILON) && 
              (Math.abs(dist3 - dist1) < EPSILON); 
   }
   
   /* getters and setters */
   
   public boolean isDivided() {
       return divided;
   }
   
   /* private methods */
   
   private double getSideLength(int vert1, int vert2) {
       return getVertex(vert1).distance(getVertex(vert2));
   }
}
