package cz.muni.fi.pb162.project.geometry;


/**
 * A triangle in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 8.10.2013
 */
public class Triangle {
   private Vertex2D[] verts;
   private Triangle[] triangles;
   private boolean divided;
   
   /**
    * Param-less constructor.
    */
   public Triangle() {
       verts = new Vertex2D[3];
       divided = false;
       triangles = new Triangle[3];
   }
   
   /**
    * Constructor that initializes verteces of the triangle.
    * 
    * @param vertA      first vertex
    * @param vertB      second vertex
    * @param vertC      third vertex
    */
   public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC) {
       this();
       
       verts[0] = vertA;
       verts[1] = vertB;
       verts[2] = vertC;
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
   
   /**
    * Return subtriangle at index.
    * 
    * @param i          index
    * @return subtriangle at given index withing range 0-2, for indeces out of range returns null
    */
   public Triangle getSubTriangle(int i) {
       return ((i >= 0) && (i <= 2) && isDivided()) ? triangles[i] : null; 
   }
    
   /**
    * Devides triangle into subtriangles. 
    * 
    * @return true if triangle has been divided succesfully, false if it has already been devided
    */
   public boolean divide() {
       if (isDivided()) return false;
     
       for (int i = 0; i < 3; i++) {
           triangles[i] = new Triangle(verts[i], Vertex2D.middleVertex(verts[i], verts[(i + 1) % 3]), Vertex2D.middleVertex(verts[i], verts[(i + 2) % 3]));
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
       if (depth <= 0) {
       
       } else {
           divide();
           
           for (int i = 0; i < 3; i++) 
                triangles[i].divide(depth - 1);
       }
   }
    
   /**
    * Checks whether the triangle is equilateral.
    * 
    * @return true if it is, false otherwise
    */
   public boolean isEquilateral() {
       double dist1 = verts[0].distance(verts[1]);
       double dist2 = verts[0].distance(verts[2]);
       double dist3 = verts[1].distance(verts[2]);
       
       return (Math.abs(dist1 - dist2) < 0.001 ) && (Math.abs(dist2 - dist3) < 0.001) && (Math.abs(dist3 - dist1) < 0.001); 
   }
   
   /**
    * Returns a string with info about the triangle.
    * 
    * @return string in format "Triangle: vertices=" + vertA.toString() + " " + vertB.toString() + " " + vertC.toString()
    */
   public String toString() {
       if (verts[0] == null || verts[1] == null || verts[2] == null) return "INVALID TRIANGLE";
       
       return "Triangle: vertices=" + verts[0].toString() + " " + verts[1].toString() + " " + verts[2].toString();
   }
   
   /* getters and setters */
   
   public Vertex2D getVertexA() {
       return verts[0];
   }
   
   public Vertex2D getVertexB() {
       return verts[1];
   }
   
   public Vertex2D getVertexC() {
       return verts[2];
   }
   
   public boolean isDivided() {
       return divided;
   }
}
