
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.swing.event.*; 


public class DragPanel extends JPanel implements MouseListener, MouseMotionListener
{
Graphics2D g2;
Rectangle2D square;
Color colour;

double x1, y1, x2, y2, size;
double offsetX, offsetY;

boolean dragging = false;



    public DragPanel()
    {

        x1 = 10.0;
        y1 = 10.0;
        size = 40.0;
        x2 = x1 + size;
        y2 = y1 + size;

        square = new Rectangle2D.Double(x1, y1, size, size);
        colour = Color.BLUE;

        setFocusable(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        this.requestFocus();

    }

    public void paintComponent(Graphics g)
{

super.paintComponent(g);
g2 = (Graphics2D) g;
g2.draw(square);
g2.setColor(colour);
g2.draw(square);

}

//@Override
public void mouseDragged(MouseEvent ev) 
{
    if (dragging)
    {
    double mx = ev.getX();
    double my = ev.getY();

    x1 = mx - offsetX;
    y1 = mx - offsetY;
    x2 = x1 + size; 
    y2 = y1 + size; 
    square = new Rectangle2D.Double(x1, y1, size, size);
    repaint();  
    }

}

//@Override
public void mousePressed(MouseEvent ev) 
{
double mx = ev.getX();
double my = ev.getY();

if (mx > x1 && mx < x2 && my > y1 && my < y2)
{
    dragging = true;
    offsetX  = mx - x1;
    offsetY = my - y1;
}

}

//@Override
public void mouseReleased(MouseEvent arg0) 
{
dragging = false;
}



}