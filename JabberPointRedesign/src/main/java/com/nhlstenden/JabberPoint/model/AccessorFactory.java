package com.nhlstenden.JabberPoint.model;

public class AccessorFactory {
    public Accessor createAccessor(String type) {
        if (type.equalsIgnoreCase("XML")) {
            return new XMLAccessor();
        } else if (type.equalsIgnoreCase("DEMO")) {
            return new DemoPresentation();
        }
        return null;
    }
}
