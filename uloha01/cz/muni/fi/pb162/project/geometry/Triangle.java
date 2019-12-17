package cz.muni.fi.pb162.project.geometry;


/**
 * A triangle.
 * 
 * @author Samuel Leško, 409202 
 * @version 1.10.2013
 */
public class Triangle {
   private Vertex2D[] verts;
   private Triangle[] triangles;
   private boolean divided;
   
   /**
    * Param-less constructor
    */
   public Triangle() {
       verts = new Vertex2D[3];
       divided = false;
       triangles = new Triangle[3];
   }
   
   /**
    * Constructor that initializes verteces of the triangle
    * 
    * @param vertA first vertex
    * @param vertB second vertex
    * @param vertC third vertex
    */
   public Triangle(Vertex2D vertA, Vertex2D vertB, Vertex2D vertC) {
       this();
       
       setVertexA(vertA);
       setVertexB(vertB);
       setVertexC(vertC);
   }
   
   /**
    * Return subtriangle at given index withing range 0-2. For indeces out of range returns null.
    * 
    * @param i index
    */
   public Triangle getSubTriangle(int i) {
       return ((i >= 0) && (i <= 2) && isDivided()) ? triangles[i] : null; 
   }
    
   /**
    * Devides triangle into subtriangles. Returns true if triangle has been divided succesfully, returns false if it already was devided.
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
    * Returns a string of format "Triangle: vertices=" + vertA.toString() + " " + vertB.toString() + " " + vertC.toString()
    */
   public String toString() {
       return "Triangle: vertices=" + verts[0].toString() + " " + verts[1].toString() + " " + verts[2].toString();
   }
   
   /* getters and setters */
   
   public void setVertexA(Vertex2D vert) {
       verts[0] = vert;
   }
   
   public void setVertexB(Vertex2D vert) {
       verts[1] = vert;
   }
   
   public void setVertexC(Vertex2D vert) {
       verts[2] = vert;
   }
   
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
