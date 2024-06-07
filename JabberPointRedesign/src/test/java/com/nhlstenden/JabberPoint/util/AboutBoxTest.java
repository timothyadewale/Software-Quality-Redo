package com.nhlstenden.JabberPoint.util;

import org.junit.jupiter.api.Test;

import java.awt.Frame;

class AboutBoxTest {
    @Test
    void testShow() {
        // This method opens a dialog which cannot be easily tested.
        // It's included here to show how you would invoke it.
        AboutBox.show(new Frame());
    }
}
