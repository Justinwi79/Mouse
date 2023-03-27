import javax.swing.*;

import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

 

public class CircleViewer {

    private static final int CIRCLE_RADIUS = 30;

    private static final int FRAME_WIDTH = 300;

    private static final int FRAME_HEIGHT = 400;

    private MyCircle myCircle = new MyCircle();

    private int x = 0;
    private int y = 0;


    public static void main(String[] args) {

        CircleViewer circleViewer = new CircleViewer();
        circleViewer.run();
    }

    public void run(){

        myCircle.addMouseListener(new MyCircleMouseListener());

        JFrame frame = new JFrame();
        frame.add(myCircle);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    class MyCircle extends JComponent {

 

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            g.setColor(Color.BLUE);
            g.drawOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);
            g.fillOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);

        }

    }

    class MyCircleMouseListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {

        }
        public void mousePressed(MouseEvent e) {

            x = e.getX();

            y = e.getY();

            myCircle.repaint();

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }
        public void mouseExited(MouseEvent e) {
        }
    }
}
