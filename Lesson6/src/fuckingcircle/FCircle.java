package fuckingcircle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class FCircle {
    Random random;

    public FCircle() {

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);

        frame.getContentPane().add(CreateSquare());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        FCircle FCircle = new FCircle();

    }


    private JPanel CreateSquare() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLUE);
        colorPanel.setMinimumSize(new Dimension(50, 50));
        colorPanel.setPreferredSize(new Dimension(200, 200));
        //colorPanel.setBounds(100, 100, 100, 100);

        colorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                colorPanel.setBackground(Color.BLUE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                colorPanel.setBackground(Color.BLUE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panel.add(colorPanel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));



        return panel;
    }
}

