package com.nhlstenden.JabberPoint.util;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.awt.Font;

import static org.junit.Assert.*;

public class StyleTest
{
    @Before
    public void setUp ()
    {
        Style.createStyles ();
    }

    @Test
    public void testGetStyle ()
    {
        Style style = Style.getStyle (0);
        assertNotNull (style);
        assertEquals (Color.red, style.color);
        assertEquals (new Font ("Helvetica", Font.BOLD, 48), style.getFont (1.0f));
    }

    @Test
    public void testGetStyleOutOfBounds ()
    {
        Style style = Style.getStyle (10);
        assertNotNull (style);
        assertEquals (Color.black, style.color);
        assertEquals (new Font ("Helvetica", Font.BOLD, 24), style.getFont (1.0f));
    }
}
