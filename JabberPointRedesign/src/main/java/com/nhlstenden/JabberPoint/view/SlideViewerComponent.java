package com.nhlstenden.JabberPoint.view;

import com.nhlstenden.JabberPoint.model.Observer;
import com.nhlstenden.JabberPoint.model.Presentation;
import com.nhlstenden.JabberPoint.model.Slide;
import com.nhlstenden.JabberPoint.util.Style;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;

/**
 * Represents the component for viewing slides.
 */
public class SlideViewerComponent extends JComponent implements Observer {
    private final Presentation presentation;

    public SlideViewerComponent(final Presentation presentation) {
        this.presentation = presentation;
        presentation.addObserver(this);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Slide slide = presentation.getCurrentSlide();
        if (slide != null) {
            slide.draw(g, new Rectangle(0, 0, getWidth(), getHeight()), this);

            // Set font style and color for the page number
            Font pageNumberFont = new Font("Helvetica", Font.BOLD, 12);
            Color pageNumberColor = Color.BLACK;
            g.setFont(pageNumberFont);
            g.setColor(pageNumberColor);

            // Draw the page number at the bottom right corner with left padding
            int slideNumber = presentation.getSlideNumber() + 1; // slide number is 0-based
            int totalSlides = presentation.getSlides().size();
            String pageNumberText = "Slide " + slideNumber + " of " + totalSlides;
            int paddingLeft = 20; // Left padding value
            g.drawString(pageNumberText, paddingLeft, getHeight() - 10);
        }
    }
}
