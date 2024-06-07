package com.nhlstenden.JabberPoint.model;

import java.util.ArrayList;
import java.util.List;

public class Presentation implements PresentationObserver
{
    private List<Observer> observers = new ArrayList<> ();
    private int currentSlideNumber;
    private List<Slide> slides = new ArrayList<> ();
    private Accessor accessor;
    private String title;

    @Override
    public void addObserver (Observer observer)
    {
        observers.add (observer);
    }

    @Override
    public void removeObserver (Observer observer)
    {
        observers.remove (observer);
    }

    @Override
    public void notifyObservers ()
    {
        for (Observer observer : observers)
        {
            observer.update ();
        }
    }

    public void setSlideNumber (int number)
    {
        this.currentSlideNumber = number;
        notifyObservers ();
    }

    public int getSlideNumber ()
    {
        return currentSlideNumber;
    }

    public void setAccessor (Accessor accessor)
    {
        this.accessor = accessor;
    }

    public List<Slide> getSlides ()
    {
        return slides;
    }

    public void addSlide (Slide slide)
    {
        slides.add (slide);
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public Slide getCurrentSlide ()
    {
        if (currentSlideNumber >= 0 && currentSlideNumber < slides.size ())
        {
            return slides.get (currentSlideNumber);
        }
        return null;
    }

    public void nextSlide ()
    {
        if (currentSlideNumber < slides.size () - 1)
        {
            setSlideNumber (currentSlideNumber + 1);
        }
    }

    public void prevSlide ()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber (currentSlideNumber - 1);
        }
    }

    public void clear ()
    {
        slides.clear ();
        setSlideNumber (-1);
    }
}
