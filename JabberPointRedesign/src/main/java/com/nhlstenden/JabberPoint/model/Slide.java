package com.nhlstenden.JabberPoint.model;

import com.nhlstenden.JabberPoint.util.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * Represents a slide in the presentation.
 */
public class Slide {
    private String title;
    private final Vector<SlideItem> items = new Vector<>();

    public Slide() {
    }

    public void append(final SlideItem item) {
        items.add(item);
    }

    public Vector<SlideItem> getSlideItems() {
        return items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void draw(final Graphics g, final Rectangle area, final ImageObserver view) {
        int x = area.x;
        int y = area.y;
        for (SlideItem item : items) {
            Style style = Style.getStyle(item.getLevel());
            item.draw(x, y, 1.0f, g, style, view);
            y += item.getBoundingBox(g, view, 1.0f, style).height + style.getLeading();
        }
    }
}
