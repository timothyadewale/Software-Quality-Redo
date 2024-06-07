package com.nhlstenden.JabberPoint.model;

public interface PresentationObserver
{
    void addObserver (Observer observer);

    void removeObserver (Observer observer);

    void notifyObservers ();
}
