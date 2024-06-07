package com.nhlstenden.JabberPoint.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

import com.nhlstenden.JabberPoint.util.Style;

/**
 * Represents an image item on a slide.
 */
public class BitmapItem extends SlideItem {
    private final String imagePath;

    public BitmapItem(final int level, final String imagePath) {
        super(level);
        this.imagePath = imagePath;
    }

    @Override
    public Rectangle getBoundingBox(final Graphics g, final ImageObserver observer, final float scale, final Style style) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        return new Rectangle(0, 0, (int) (imageIcon.getIconWidth() * scale), (int) (imageIcon.getIconHeight() * scale));
    }

    @Override
    public void draw(final int x, final int y, final float scale, final Graphics g, final Style style, final ImageObserver observer) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        g.drawImage(imageIcon.getImage(), x, y, (int) (imageIcon.getIconWidth() * scale), (int) (imageIcon.getIconHeight() * scale), observer);
    }

    public String getName() {
        return imagePath;
    }
}
