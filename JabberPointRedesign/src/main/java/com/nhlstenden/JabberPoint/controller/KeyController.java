package com.nhlstenden.JabberPoint.controller;

import com.nhlstenden.JabberPoint.model.Presentation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles key events for controlling the presentation.
 */
public class KeyController extends KeyAdapter
{
    private final Presentation presentation;

    public KeyController (final Presentation presentation)
    {
        this.presentation = presentation;
    }

    @Override
    public void keyPressed (final KeyEvent e)
    {
        switch (e.getKeyCode ())
        {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                presentation.nextSlide ();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                presentation.prevSlide ();
                break;
            case 'q':
            case 'Q':
                System.exit (0);
                break;
            default:
                break;
        }
    }
}
