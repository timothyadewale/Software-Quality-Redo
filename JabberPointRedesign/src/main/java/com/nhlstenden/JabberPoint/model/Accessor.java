package com.nhlstenden.JabberPoint.model;

import java.io.IOException;

public interface Accessor {
    void loadFile(Presentation presentation, String filename) throws IOException;
}
