package com.nhlstenden.JabberPoint.model;

import com.nhlstenden.JabberPoint.util.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * Represents an item on a slide.
 */
public abstract class SlideItem {
    private final int level;

    public SlideItem(final int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
}
