package com.nhlstenden.JabberPoint.model;

/**
 * Observer interface for presentations.
 */
public interface PresentationObserver {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
