package com.nhlstenden.JabberPoint.view;

import com.nhlstenden.JabberPoint.controller.KeyController;
import com.nhlstenden.JabberPoint.controller.MenuController;
import com.nhlstenden.JabberPoint.model.Presentation;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Represents the main frame for viewing slides.
 */
public class SlideViewerFrame extends JFrame {
    private static final long serialVersionUID = 3227L;
    private static final String JABTITLE = "Jabberpoint 1.6 - OU";
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public SlideViewerFrame(final String title, final Presentation presentation) {
        super(title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation);
        presentation.addObserver(slideViewerComponent);
        setupWindow(slideViewerComponent, presentation);
    }

    public void setupWindow(final SlideViewerComponent slideViewerComponent, final Presentation presentation) {
        setTitle(JABTITLE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(slideViewerComponent);
        addKeyListener(new KeyController(presentation));
        setMenuBar(new MenuController(this, presentation));
        setSize(new Dimension(WIDTH, HEIGHT));
        setVisible(true);
    }
}
