package com.nhlstenden.JabberPoint.util;

import java.awt.Color;
import java.awt.Font;

public class Style
{
    private static Style[] styles;

    private static final String FONTNAME = "Helvetica";
    int indent;
    Color color;
    Font font;
    int fontSize;
    int leading;

    static
    {
        createStyles ();
    }

    public static void createStyles ()
    {
        styles = new Style[5];
        styles[0] = new Style (0, Color.red, 48, 20);
        styles[1] = new Style (20, Color.blue, 40, 10);
        styles[2] = new Style (50, Color.black, 36, 10);
        styles[3] = new Style (70, Color.black, 30, 10);
        styles[4] = new Style (90, Color.black, 24, 10);
    }

    public static Style getStyle (int level)
    {
        if (level >= styles.length)
        {
            level = styles.length - 1;
        }
        return styles[level];
    }

    public Style (int indent, Color color, int points, int leading)
    {
        this.indent = indent;
        this.color = color;
        this.font = new Font (FONTNAME, Font.BOLD, fontSize = points);
        this.leading = leading;
    }

    public Font getFont (float scale)
    {
        return font.deriveFont (fontSize * scale);
    }

    public int getIndent ()
    {
        return indent;
    }

    public Color getColor ()
    {
        return color;
    }

    public int getLeading ()
    {
        return leading;
    }
}
