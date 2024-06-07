package com.nhlstenden.JabberPoint;

import com.nhlstenden.JabberPoint.model.Accessor;
import com.nhlstenden.JabberPoint.model.AccessorFactory;
import com.nhlstenden.JabberPoint.model.Presentation;
import com.nhlstenden.JabberPoint.view.SlideViewerFrame;
import com.nhlstenden.JabberPoint.util.Style;

import javax.swing.JOptionPane;

/**
 * The main class for starting the JabberPoint application.
 */
public class JabberPoint {
    protected static final String IOERR = "IO Error: ";
    protected static final String JABERR = "Jabberpoint Error ";
    protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

    public static void main(final String[] argv) {
        Style.createStyles();
        Presentation presentation = new Presentation();
        new SlideViewerFrame(JABVERSION, presentation);
        try {
            AccessorFactory factory = new AccessorFactory();
            Accessor accessor;
            if (argv.length == 0) {
                accessor = factory.createAccessor("DEMO");
                accessor.loadFile(presentation, "");
            } else {
                accessor = factory.createAccessor("XML");
                accessor.loadFile(presentation, argv[0]);
            }
            presentation.setSlideNumber(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
