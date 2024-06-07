package com.nhlstenden.JabberPoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

import com.nhlstenden.JabberPoint.util.Style;


public class BitmapItem extends SlideItem
{
    private String imagePath;

    public BitmapItem (int level, String imagePath)
    {
        super (level);
        this.imagePath = imagePath;
    }

    @Override
    public Rectangle getBoundingBox (Graphics g, ImageObserver observer, float scale, Style style)
    {
        ImageIcon imageIcon = new ImageIcon (imagePath);
        return new Rectangle (0, 0, (int) (imageIcon.getIconWidth () * scale), (int) (imageIcon.getIconHeight () * scale));
    }

    @Override
    public void draw (int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {
        ImageIcon imageIcon = new ImageIcon (imagePath);
        g.drawImage (imageIcon.getImage (), x, y, (int) (imageIcon.getIconWidth () * scale), (int) (imageIcon.getIconHeight () * scale), observer);
    }

    public String getName ()
    {
        return imagePath;
    }
}
