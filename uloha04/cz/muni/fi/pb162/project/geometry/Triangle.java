package cz.muni.fi.pb162.project.geometry;


/**
 * A triangle in 2D plane.
 * 
 * @author Samuel Lesko, 409202 
 * @version 15.10.2013
 */
public class Triangle implements Solid 
{
   public static final double EPSILON = 0.001;
   
   private Vertex2D[] verts;
   private Triangle[] triangles;
   private boolean divided;
   
   /* Constructors */
   
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
   
   /* public methods */
   
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
       if (depth > 0) {
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
       double dist1 = getSideLength(0, 1);
       double dist2 = getSideLength(0, 2);
       double dist3 = getSideLength(1, 2);
       
       return (Math.abs(dist1 - dist2) < EPSILON) && 
              (Math.abs(dist2 - dist3) < EPSILON) && 
              (Math.abs(dist3 - dist1) < EPSILON); 
   }
   
   /**
    * Returns a string with info about the triangle.
    * 
    * @return string in format "Triangle: vertices=" + vertA.toString() + " " + vertB.toString() + " " + vertC.toString()
    */
   @Override
   public String toString() {
       if (verts[0] == null || verts[1] == null || verts[2] == null) return "INVALID TRIANGLE";
       
       return "Triangle: vertices=" + verts[0].toString() + " " + verts[1].toString() + " " + verts[2].toString();
   }
   
   /* Solid implementation */
   
   /**
    * Returns the area of the triangle.
    * 
    * @return area
    */
   public double getArea() {
       double s = getCircumference() / 2;
       double side1 = getSideLength(0, 1);
       double side2 = getSideLength(0, 2);
       double side3 = getSideLength(1, 2);
       
       return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
   }
   
   /**
    * Returns width of the triangle.
    * 
    * @return width
    */
   public double getWidth() {
       double min = (verts[0].getX() < verts[1].getX())
                        ? ((verts[0].getX() < verts[2].getX()) ? verts[0].getX() : verts[2].getX())
                        : ((verts[1].getX() < verts[2].getX()) ? verts[1].getX() : verts[2].getX());
       double max = (verts[0].getX() > verts[1].getX())
                        ? ((verts[0].getX() > verts[2].getX()) ? verts[0].getX() : verts[2].getX())
                        : ((verts[1].getX() > verts[2].getX()) ? verts[1].getX() : verts[2].getX());
       return max - min;
   }
   
   /**
    * Returns height of the triangle.
    * 
    * @return height
    */
   public double getHeight() {
       double min = (verts[0].getY() < verts[1].getY())
                        ? ((verts[0].getY() < verts[2].getY()) ? verts[0].getY() : verts[2].getY())
                        : ((verts[1].getY() < verts[2].getY()) ? verts[1].getY() : verts[2].getY());
       double max = (verts[0].getY() > verts[1].getY())
                        ? ((verts[0].getY() > verts[2].getY()) ? verts[0].getY() : verts[2].getY())
                        : ((verts[1].getY() > verts[2].getY()) ? verts[1].getY() : verts[2].getY());
       return max - min;
   }
   
   /**
    * Returns circumference of the triangle.
    * 
    * @return length (circumference)
    */
   public double getLength() {
       return getCircumference();
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
   
   /* private methods */
   
   /**
    * Return circumference of the triangle.
    * 
    * @return circumference
    */
   private double getCircumference() {
       return getSideLength(0, 1) + getSideLength(0, 2) + getSideLength(1, 2);
   }
   
   /**
    * Returns length of a side of a triangle.
    * 
    * @param vert1      index of first vertex of the side
    * @param vert2      index of second vertex of the side
    * @return length of the side
    */
   private double getSideLength(int vert1, int vert2) {
       return verts[vert1].distance(verts[vert2]);
   }
}
