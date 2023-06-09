import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragCircle extends JFrame 
{
    private static final long serialVersionUID = 1L;

    public static int size = 400;

    public static int r = 10;

    private int x;

    private int y;

    private int cX;

    private int cY;

    private int dX;

    private int dY;

    private MouseHandler mh;

    boolean isCircleClicked = false;

    public static void main(String[] args) {
        DragCircle c1 = new DragCircle();
        c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public DragCircle() {

        super("Drag circle");

        cX = r + 100;
        cY = r + 100;

        mh = new MouseHandler();
        addMouseListener(mh);
        addMouseMotionListener(mh);

        setSize(size, size);
        setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(cX, cY, r * 2, r * 2);

    }

    private class MouseHandler extends MouseAdapter implements
            MouseMotionListener {
        public void mousePressed(MouseEvent me)

        {
            isCircleClicked =
            (cX - me.getX()) * (cX - me.getX()) +
            (cY - me.getY()) * (cY - me.getY()) < r * r;
        }

        public void mouseDragged(MouseEvent me) {
            if (isCircleClicked = true) {

                x = me.getX() - dX;
                y = me.getY() - dY;
                cX = x + r;
                cY = y + r;
                repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            isCircleClicked = false;
        }

    }

}