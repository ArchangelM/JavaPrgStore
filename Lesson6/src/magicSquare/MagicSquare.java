package magicSquare;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Random;

public class MagicSquare {
    Random random;

    public MagicSquare() {

        random = new Random(20000);

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocation(100, 100);

        frame.getContentPane().add(CreateSquare());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        MagicSquare magicSquare = new MagicSquare();

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
                colorPanel.setBackground(randomColor());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                colorPanel.setBackground(randomColor());
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

    private Color randomColor() {
        Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GREEN};
        return colors[random.nextInt(5)];
    }
}

