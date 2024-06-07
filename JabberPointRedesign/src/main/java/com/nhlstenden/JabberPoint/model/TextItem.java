package com.nhlstenden.JabberPoint.model;

import com.nhlstenden.JabberPoint.util.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * Represents a text item on a slide.
 */
public class TextItem extends SlideItem {
    private final String text;

    public TextItem(final int level, final String text) {
        super(level);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public Rectangle getBoundingBox(final Graphics g, final ImageObserver observer, final float scale, final Style style) {
        return new Rectangle(0, 0, (int) (text.length() * style.getFont(scale).getSize() * scale), (int) (style.getFont(scale).getSize() * scale));
    }

    @Override
    public void draw(final int x, final int y, final float scale, final Graphics g, final Style style, final ImageObserver observer) {
        g.setFont(style.getFont(scale));
        g.setColor(style.getColor());
        g.drawString(text, x + style.getIndent(), y + (int) (style.getFont(scale).getSize() * scale));
    }
}
