package com.nhlstenden.JabberPoint.model;

import com.nhlstenden.JabberPoint.util.Style;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class TextItem extends SlideItem
{
    private String text;

    public TextItem (int level, String text)
    {
        super (level);
        this.text = text;
    }

    public String getText ()
    {
        return text;
    }

    @Override
    public Rectangle getBoundingBox (Graphics g, ImageObserver observer, float scale, Style style)
    {
        return new Rectangle (0, 0, (int) (text.length () * style.getFont (scale).getSize () * scale), (int) (style.getFont (scale).getSize () * scale));
    }

    @Override
    public void draw (int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {
        g.setFont (style.getFont (scale));
        g.setColor (style.getColor ());
        g.drawString (text, x + style.getIndent (), y + (int) (style.getFont (scale).getSize () * scale));
    }
}
