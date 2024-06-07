package com.nhlstenden.JabberPoint.model;

/**
 * Factory for creating accessors based on the type.
 */
public class AccessorFactory {
    public Accessor createAccessor(final String type) {
        if (type.equalsIgnoreCase("XML")) {
            return new XMLAccessor();
        } else if (type.equalsIgnoreCase("DEMO")) {
            return new DemoPresentation();
        }
        return null;
    }
}
