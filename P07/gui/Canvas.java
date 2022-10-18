package gui;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Canvas extends JPanel{
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw Text
        g.drawString("Hayden Johnson",25,20);

        g.setColor(Color.BLUE);
        g.drawLine(10, 10, 20, 20);
        g.drawLine(20, 10, 10, 20);
        g.setColor(Color.RED);
        g.drawLine(15, 10, 15, 20);
    }  
}  

