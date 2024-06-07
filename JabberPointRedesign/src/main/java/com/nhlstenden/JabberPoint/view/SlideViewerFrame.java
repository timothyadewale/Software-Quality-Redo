package com.nhlstenden.JabberPoint.view;

import com.nhlstenden.JabberPoint.controller.KeyController;
import com.nhlstenden.JabberPoint.controller.MenuController;
import com.nhlstenden.JabberPoint.model.Presentation;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SlideViewerFrame extends JFrame
{
    private static final long serialVersionUID = 3227L;
    private static final String JABTITLE = "Jabberpoint 1.6 - OU";
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;

    public SlideViewerFrame (String title, Presentation presentation)
    {
        super (title);
        SlideViewerComponent slideViewerComponent = new SlideViewerComponent (presentation);
        presentation.addObserver (slideViewerComponent);
        setupWindow (slideViewerComponent, presentation);
    }

    public void setupWindow (SlideViewerComponent slideViewerComponent, Presentation presentation)
    {
        setTitle (JABTITLE);
        addWindowListener (new WindowAdapter ()
        {
            public void windowClosing (WindowEvent e)
            {
                System.exit (0);
            }
        });
        getContentPane ().add (slideViewerComponent);
        addKeyListener (new KeyController (presentation));
        setMenuBar (new MenuController (this, presentation));
        setSize (new Dimension (WIDTH, HEIGHT));
        setVisible (true);
    }
}
