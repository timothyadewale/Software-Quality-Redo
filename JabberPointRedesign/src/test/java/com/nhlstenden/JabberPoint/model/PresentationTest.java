package com.nhlstenden.JabberPoint.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PresentationTest {
    private Presentation presentation;

    @Before
    public void setUp() {
        presentation = new Presentation();
    }

    @Test
    public void testAddSlide() {
        Slide slide = new Slide();
        presentation.addSlide(slide);
        assertEquals(1, presentation.getSlides().size());
    }

    @Test
    public void testSetSlideNumber() {
        Slide slide = new Slide();
        presentation.addSlide(slide);
        presentation.setSlideNumber(0);
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testNextSlide() {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.addSlide(slide1);
        presentation.addSlide(slide2);
        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    public void testPrevSlide() {
        Slide slide1 = new Slide();
        Slide slide2 = new Slide();
        presentation.addSlide(slide1);
        presentation.addSlide(slide2);
        presentation.setSlideNumber(1);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    public void testClear() {
        Slide slide = new Slide();
        presentation.addSlide(slide);
        presentation.clear();
        assertEquals(0, presentation.getSlides().size());
    }

    @Test
    public void testNotifyObservers() {
        MockObserver observer = new MockObserver();
        presentation.addObserver(observer);
        presentation.notifyObservers();
        assertTrue(observer.isUpdated());
    }

    private class MockObserver implements Observer {
        private boolean updated = false;

        @Override
        public void update() {
            updated = true;
        }

        public boolean isUpdated() {
            return updated;
        }
    }
}
