package com.nhlstenden.JabberPoint.model;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import static org.junit.Assert.*;

public class SlideTest
{
    private Slide slide;

    @Before
    public void setUp ()
    {
        slide = new Slide ();
    }

    @Test
    public void testAddSlideItem ()
    {
        SlideItem item = new TextItem (1, "Test");
        slide.append (item);
        assertEquals (1, slide.getSlideItems ().size ());
    }

    @Test
    public void testGetTitle ()
    {
        slide.setTitle ("Test Title");
        assertEquals ("Test Title", slide.getTitle ());
    }

    @Test
    public void testDraw ()
    {
        SlideItem item = new TextItem (1, "Test");
        slide.append (item);
        Graphics g = new FakeGraphics ();
        ImageObserver observer = new FakeImageObserver ();
        slide.draw (g, new Rectangle (0, 0, 100, 100), observer);
        // Assuming draw calls are correct, no exceptions should be thrown.
    }

    private class FakeGraphics extends Graphics
    {
        @Override
        public Graphics create ()
        {
            return this;
        }

        @Override
        public void translate (int x, int y)
        {
        }

        @Override
        public Color getColor ()
        {
            return Color.BLACK;
        }

        @Override
        public void setColor (Color c)
        {
        }

        @Override
        public void setPaintMode ()
        {
        }

        @Override
        public void setXORMode (Color c1)
        {
        }

        @Override
        public Font getFont ()
        {
            return new Font ("Arial", Font.PLAIN, 12);
        }

        @Override
        public void setFont (Font font)
        {
        }

        @Override
        public FontMetrics getFontMetrics (Font f)
        {
            return null;
        }

        @Override
        public Rectangle getClipBounds ()
        {
            return null;
        }

        @Override
        public void clipRect (int x, int y, int width, int height)
        {
        }

        @Override
        public void setClip (int x, int y, int width, int height)
        {
        }

        @Override
        public Shape getClip ()
        {
            return null;
        }

        @Override
        public void setClip (Shape clip)
        {
        }

        @Override
        public void copyArea (int x, int y, int width, int height, int dx, int dy)
        {
        }

        @Override
        public void drawLine (int x1, int y1, int x2, int y2)
        {
        }

        @Override
        public void fillRect (int x, int y, int width, int height)
        {
        }

        @Override
        public void clearRect (int x, int y, int width, int height)
        {
        }

        @Override
        public void drawRoundRect (int x, int y, int width, int height, int arcWidth, int arcHeight)
        {
        }

        @Override
        public void fillRoundRect (int x, int y, int width, int height, int arcWidth, int arcHeight)
        {
        }

        @Override
        public void drawOval (int x, int y, int width, int height)
        {
        }

        @Override
        public void fillOval (int x, int y, int width, int height)
        {
        }

        @Override
        public void drawArc (int x, int y, int width, int height, int startAngle, int arcAngle)
        {
        }

        @Override
        public void fillArc (int x, int y, int width, int height, int startAngle, int arcAngle)
        {
        }

        @Override
        public void drawPolyline (int[] xPoints, int[] yPoints, int nPoints)
        {
        }

        @Override
        public void drawPolygon (int[] xPoints, int[] yPoints, int nPoints)
        {
        }

        @Override
        public void fillPolygon (int[] xPoints, int[] yPoints, int nPoints)
        {
        }

        @Override
        public void drawString (String str, int x, int y)
        {
        }

        @Override
        public void drawString (AttributedCharacterIterator iterator, int x, int y)
        {
        }

        @Override
        public boolean drawImage (Image img, int x, int y, ImageObserver observer)
        {
            return true;
        }

        @Override
        public boolean drawImage (Image img, int x, int y, int width, int height, ImageObserver observer)
        {
            return true;
        }

        @Override
        public boolean drawImage (Image img, int x, int y, Color bgcolor, ImageObserver observer)
        {
            return true;
        }

        @Override
        public boolean drawImage (Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer)
        {
            return true;
        }

        @Override
        public boolean drawImage (Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)
        {
            return true;
        }

        @Override
        public boolean drawImage (Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer)
        {
            return true;
        }

        @Override
        public void dispose ()
        {
        }
    }

    private class FakeImageObserver implements ImageObserver
    {
        @Override
        public boolean imageUpdate (Image img, int infoflags, int x, int y, int width, int height)
        {
            return false;
        }
    }
}
