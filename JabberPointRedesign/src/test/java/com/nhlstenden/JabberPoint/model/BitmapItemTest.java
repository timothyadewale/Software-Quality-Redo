package com.nhlstenden.JabberPoint.model;

import com.nhlstenden.JabberPoint.util.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitmapItemTest {
    private BitmapItem bitmapItem;
    private Style style;

    @BeforeEach
    void setUp() {
        bitmapItem = new BitmapItem(1, "testImagePath");
        style = Style.getStyle(1);
    }

    @Test
    void testGetBoundingBox() {
        ImageIcon imageIcon = new ImageIcon("testImagePath");
        int expectedWidth = imageIcon.getIconWidth();
        int expectedHeight = imageIcon.getIconHeight();

        Graphics graphics = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        Rectangle boundingBox = bitmapItem.getBoundingBox(graphics, null, 1.0f, style);

        assertEquals(expectedWidth, boundingBox.width);
        assertEquals(expectedHeight, boundingBox.height);
    }

}
