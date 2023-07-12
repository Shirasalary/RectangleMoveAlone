package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwayingRectangle extends JPanel {

    private int x, y; // Coordinates of the top-left corner of the rectangle
    private int deltaX; // Amount of horizontal movement
    private final int rectangleWidth = 100;
    private final int rectangleHeight = 50;

    public SwayingRectangle() {
        x = 0;
        y = 200;
        deltaX = 1;

        // Create a timer to animate the rectangle
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the x-coordinate of the rectangle
                x += deltaX;

                // Reverse the direction when the rectangle reaches the screen boundaries
                if (x <= 0 || x + rectangleWidth >= getWidth()) {
                    deltaX *= -1;
                }

                repaint(); // Request a repaint to update the rectangle's position
            }
        });
        timer.start(); // Start the timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, rectangleWidth, rectangleHeight); // Draw the rectangle
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 400); // Set the preferred size of the panel
    }

}
