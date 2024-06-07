package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.model.Presentation;
import com.nhlstenden.JabberPoint.model.XMLAccessor;
import com.nhlstenden.JabberPoint.util.AboutBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controls the menu options for the presentation.
 */
public class MenuController extends MenuBar
{
    private final Frame parent;
    private final Presentation presentation;

    protected static final String ABOUT = "About";
    protected static final String FILE = "File";
    protected static final String EXIT = "Exit";
    protected static final String GOTO = "Go to";
    protected static final String HELP = "Help";
    protected static final String NEW = "New";
    protected static final String NEXT = "Next";
    protected static final String OPEN = "Open";
    protected static final String PAGENR = "Page number?";
    protected static final String PREV = "Prev";
    protected static final String SAVE = "Save";
    protected static final String VIEW = "View";

    protected static final String TESTFILE = "test.xml";
    protected static final String SAVEFILE = "dump.xml";

    protected static final String IOEX = "IO Exception: ";
    protected static final String LOADERR = "Load Error";
    protected static final String SAVEERR = "Save Error";

    public MenuController (final Frame frame, final Presentation presentation)
    {
        parent = frame;
        this.presentation = presentation;
        createFileMenu ();
        createViewMenu ();
        createHelpMenu ();
    }

    private void createFileMenu ()
    {
        Menu fileMenu = new Menu (FILE);
        MenuItem menuItem;
        fileMenu.add (menuItem = mkMenuItem (OPEN));
        menuItem.addActionListener (actionEvent ->
        {
            presentation.clear ();
            XMLAccessor xmlAccessor = new XMLAccessor ();
            try
            {
                xmlAccessor.loadFile (presentation, TESTFILE);
                presentation.setSlideNumber (0);
            } catch (IOException exc)
            {
                JOptionPane.showMessageDialog (parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
            }
            parent.repaint ();
        });
        fileMenu.add (menuItem = mkMenuItem (NEW));
        menuItem.addActionListener (actionEvent ->
        {
            presentation.clear ();
            parent.repaint ();
        });
        fileMenu.add (menuItem = mkMenuItem (SAVE));
        menuItem.addActionListener (e ->
        {
            XMLAccessor xmlAccessor = new XMLAccessor ();
            try
            {
                xmlAccessor.saveFile (presentation, SAVEFILE);
            } catch (IOException exc)
            {
                JOptionPane.showMessageDialog (parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
            }
        });
        fileMenu.addSeparator ();
        fileMenu.add (menuItem = mkMenuItem (EXIT));
        menuItem.addActionListener (actionEvent -> System.exit (0));
        add (fileMenu);
    }

    private void createViewMenu ()
    {
        Menu viewMenu = new Menu (VIEW);
        MenuItem menuItem;
        viewMenu.add (menuItem = mkMenuItem (NEXT));
        menuItem.addActionListener (actionEvent -> presentation.nextSlide ());
        viewMenu.add (menuItem = mkMenuItem (PREV));
        menuItem.addActionListener (actionEvent -> presentation.prevSlide ());
        viewMenu.add (menuItem = mkMenuItem (GOTO));
        menuItem.addActionListener (actionEvent ->
        {
            String pageNumberStr = JOptionPane.showInputDialog ((Object) PAGENR);
            try
            {
                int pageNumber = Integer.parseInt (pageNumberStr);
                if (pageNumber > 0 && pageNumber <= presentation.getSlides ().size ())
                {
                    presentation.setSlideNumber (pageNumber - 1);
                }
                else
                {
                    JOptionPane.showMessageDialog (parent, "Invalid slide number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog (parent, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add (viewMenu);
    }

    private void createHelpMenu ()
    {
        Menu helpMenu = new Menu (HELP);
        MenuItem menuItem;
        helpMenu.add (menuItem = mkMenuItem (ABOUT));
        menuItem.addActionListener (actionEvent -> AboutBox.show (parent));
        setHelpMenu (helpMenu);
    }

    private MenuItem mkMenuItem (final String name)
    {
        return new MenuItem (name, new MenuShortcut (name.charAt (0)));
    }
}
