package cz.muni.fi.pb162.project.demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cz.muni.fi.pb162.project.geometry.Circle;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Vertex2D;

/**
 * 
 * Trida umoznujici vykresleni doposud dokoncenych grafickych objektu (bod, kruznice, trojuhelnik).
 * 
 * @author Bc. Pavel Beran (255625)
 * @version 2012-10-19
 *
 */

public class Draw extends JFrame {

    /**
     * Znaci polovinu delky usecky pro vykresleni bodu.
     */
    public static final int VERT_LENGTH = 3;

    protected JPanel panel;
    
    private List<Vertex2D> vertices  = new ArrayList<Vertex2D>();
    private List<Triangle> triangles = new ArrayList<Triangle>();
    private List<Circle>   circles   = new ArrayList<Circle>();
    
    private Color vertexColor;
    private Color triangleColor;
    private Color circleColor;
    
    /**
     * Defaultni konstruktor nastavi defaultni barvy pro telesa. Pozadi bile, body cervene, kruznice modre, trojuhelniky zelene
     */
    public Draw() {
        initialize();
        panel.setBackground(Color.WHITE);
        this.vertexColor = Color.RED;
        this.triangleColor = Color.BLUE;
        this.circleColor = Color.ORANGE;
    }
    
    private void initialize() {
        panel = new JPanel();
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Vizualizace obrazců. Autor Pavel Beran (255625).");
        add(panel);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        myPaintAll(panel.getGraphics());
    }
    
    /**
     * Spustenim metody zacne vykreslovani vsech teles v seznamech.
     */
    public void startPainting() {
        paint(this.getGraphics());
    }
    
    /**
     * Metoda pro pridani bodu do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni bod mimo vykreslovaci prostor.
     * 
     * @param vertex Bod ktery chci vykreslit
     * @return true pokud se bod vykresli, false nikoliv
     */
    public boolean paintVertex(Vertex2D vertex) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - vertex.getX()));
        int y = (int) Math.rint(halfY - vertex.getY());
        
        if (x-VERT_LENGTH < 0 || x+VERT_LENGTH > width || y-VERT_LENGTH < 0 || y+VERT_LENGTH > height) {
            return false;
        }
        vertices.add(vertex);
        return true;
    }

    /**
     * Metoda pro pridani kruznice do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni kruznice mimo vykreslovaci prostor.
     * 
     * @param circle Kruznice kterou chci vykreslit
     * @return true pokud se kruznice vykresli, false nikoliv
     */
    public boolean paintCircle(Circle circle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - circle.getCenter().getX()));
        int y = (int) Math.rint(halfY - circle.getCenter().getY());
        int r = (int) circle.getRadius();
        
        if (x-r < 0 || x+r > width || y-r < 0 || y+r > height) {
            return false;
        }
        circles.add(circle);
        return true;
    }
    
    /**
     * Metoda pro pridani trojuhelnika do seznamu pro vykresleni.
     * Metoda vraci logickou hodnotu v zavislosti na tom zda-li neni trojuhelnik mimo vykreslovaci prostor.
     * 
     * @param triangle Trojuhelnik ktery chci vykreslit
     * @return true pokud se trojuhelnik vykresli, false nikoliv
     */
    public boolean paintTriangle(Triangle triangle) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        Vertex2D a = triangle.getVertexA();
        Vertex2D b = triangle.getVertexB();
        Vertex2D c = triangle.getVertexC();
        
        int minX = width - ((int) Math.rint(halfX - Math.min(a.getX(), Math.min(b.getX(), c.getX()))));
        int maxX = width - ((int) Math.rint(halfX - Math.max(a.getX(), Math.max(b.getX(), c.getX()))));
        int minY = (int) Math.rint(halfY - Math.min(a.getY(), Math.min(b.getY(), c.getY())));
        int maxY = (int) Math.rint(halfY - Math.max(a.getY(), Math.max(b.getY(), c.getY())));
        
        if (minX < 0 || maxX > width || minY < 0 || maxY > height) {
            return false;
        }
        triangles.add(triangle);
        return true;
    }
    
    protected void paintVertex(Graphics g, Vertex2D v) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int x = width - ((int) Math.rint(halfX - v.getX()));
        int y = (int) Math.rint(halfY - v.getY());
        g.setColor(vertexColor);
        g.drawLine(x-VERT_LENGTH, y+VERT_LENGTH, x+VERT_LENGTH, y-VERT_LENGTH);
        g.drawLine(x-VERT_LENGTH, y-VERT_LENGTH, x+VERT_LENGTH, y+VERT_LENGTH);
    }
 
    protected void paintCircle(Graphics g, Circle c) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int r = (int) Math.rint(c.getRadius());
        int x = width - ((int) Math.rint(halfX - c.getCenter().getX()) + r);
        int y = (int) Math.rint(halfY - c.getCenter().getY()) - r;
        int w = (int) Math.rint(c.getRadius() * 2.0);
        int h = (int) Math.rint(c.getRadius() * 2.0);
        g.setColor(circleColor);
        g.drawOval(x, y, w, h);

    }
    
    protected void paintTriangle(Graphics g, Triangle tri) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        int a1 = width - ((int) Math.rint(halfX - tri.getVertexA().getX()));
        int a2 = (int) Math.rint(halfY - tri.getVertexA().getY());
        int b1 = width - ((int) Math.rint(halfX - tri.getVertexB().getX()));
        int b2 = (int) Math.rint(halfY - tri.getVertexB().getY());
        int c1 = width - ((int) Math.rint(halfX - tri.getVertexC().getX()));
        int c2 = (int) Math.rint(halfY - tri.getVertexC().getY());

        g.setColor(triangleColor);
        Polygon triangle = new Polygon();
        triangle.addPoint(a1, a2);
        triangle.addPoint(b1, b2);
        triangle.addPoint(c1, c2);
        g.drawPolygon(triangle);
    }
    
    protected void paintCross(Graphics g) {
        int width = panel.getWidth();
        int height = panel.getHeight();
        int halfX = width/2;
        int halfY = height/2;
        
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, halfY, width, halfY);
        g.drawLine(halfX, 0, halfX, height);
    }
    
    protected void myPaintAll(Graphics g) {
        paintCross(g);
        for (Vertex2D v : vertices) {
            paintVertex(g, v);
        }
        for (Triangle t : triangles) {
            paintTriangle(g, t);
        }
        for (Circle c : circles) {
            paintCircle(g, c);
        }
    }
    
    public static void main(String[] args) {
        Vertex2D v1 = new Vertex2D(-100,-100);
        Vertex2D v2 = new Vertex2D(0,100);
        Vertex2D v3 = new Vertex2D(100,-100);
        
        Triangle tri = new Triangle(v1, v2, v3);
        Circle   cir = new Circle(new Vertex2D(0,0), 100);
        
        Draw canvas = new Draw();
        canvas.paintTriangle(tri);
        canvas.paintCircle(cir);
        canvas.startPainting();
    }
}

