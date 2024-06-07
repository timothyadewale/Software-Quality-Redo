package com.nhlstenden.JabberPoint.view;

import com.nhlstenden.JabberPoint.model.Presentation;
import com.nhlstenden.JabberPoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SlideViewerComponentTest {
    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        slideViewerComponent = new SlideViewerComponent(presentation);
    }

    @Test
    void testPaintComponent() {
        Slide slide = new Slide();
        presentation.addSlide(slide);
        presentation.setSlideNumber(0);

        JFrame frame = new JFrame();
        frame.add(slideViewerComponent);
        frame.setSize(800, 600);
        frame.setVisible(true);

        Graphics graphics = slideViewerComponent.getGraphics();
        assertNotNull(graphics);
        slideViewerComponent.paintComponent(graphics);
    }
}
