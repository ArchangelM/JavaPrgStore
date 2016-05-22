package fuckingcircle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class FCircle extends JPanel{
    Random random;
    final int xDimention = 800;
    final int yDimention = 600;

    final int diametr = 150;

    int xMax = xDimention - 2*diametr;
    int yMax = yDimention - 2*diametr;

    public FCircle() {
        random = new Random(20000);

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(xDimention, yDimention));
        frame.setLocation(100, 100);

        JLabel text = new JLabel("Click the red circle!");
        text.setFont(new Font("TimesNewRoman", Font.BOLD, 16));

        this.add(text, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        frame.getContentPane().add(this);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        FCircle FCircle = new FCircle();
        //FCircle.repaint();


    }

    private void drawCircle(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 150, 150);
        System.out.println("x = " + x + " y = " + y);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g, randomX(), randomY());


    }


    private int randomX(){
        return random.nextInt(xMax);
    }

    private int randomY (){
        return random.nextInt(yMax);
    }
}

