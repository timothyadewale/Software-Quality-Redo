package com.nhlstenden.JabberPoint.model;

import java.io.IOException;

/**
 * Interface for accessing presentation data.
 */
public interface Accessor
{
    void loadFile (Presentation presentation, String filename) throws IOException;
}
