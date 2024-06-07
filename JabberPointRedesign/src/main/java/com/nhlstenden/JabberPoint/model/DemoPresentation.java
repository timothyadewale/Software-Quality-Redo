package com.nhlstenden.JabberPoint.model;

/**
 * Represents a demo presentation with predefined slides.
 */
public class DemoPresentation implements Accessor {
    @Override
    public void loadFile(final Presentation presentation, final String unusedFilename) {
        presentation.setTitle("Demo Presentation");
        Slide slide;

        slide = new Slide();
        slide.setTitle("JabberPoint");
        slide.append(new TextItem(1, "The Java Presentation Tool"));
        slide.append(new TextItem(2, "Copyright (c) 1996-2000: Ian Darwin"));
        slide.append(new TextItem(2, "Copyright (c) 2000-now:"));
        slide.append(new TextItem(2, "Gert Florijn and Sylvia Stuurman"));
        slide.append(new TextItem(4, "Starting JabberPoint without a filename"));
        slide.append(new TextItem(4, "shows this presentation"));
        slide.append(new TextItem(1, "Navigate:"));
        slide.append(new TextItem(3, "Next slide: PgDn or Enter"));
        slide.append(new TextItem(3, "Previous slide: PgUp or up-arrow"));
        slide.append(new TextItem(3, "Quit: q or Q"));
        presentation.addSlide(slide);

        slide = new Slide();
        slide.setTitle("Demonstration of levels and styles");
        slide.append(new TextItem(1, "Level 1"));
        slide.append(new TextItem(2, "Level 2"));
        slide.append(new TextItem(1, "Again level 1"));
        slide.append(new TextItem(1, "Level 1 has style number 1"));
        slide.append(new TextItem(2, "Level 2 has style number 2"));
        slide.append(new TextItem(3, "This is how level 3 looks like"));
        slide.append(new TextItem(4, "And this is level 4"));
        presentation.addSlide(slide);

        slide = new Slide();
        slide.setTitle("The third slide");
        slide.append(new TextItem(1, "To open a new presentation,"));
        slide.append(new TextItem(2, "use File->Open from the menu."));
        slide.append(new TextItem(1, " "));
        slide.append(new TextItem(1, "This is the end of the presentation."));
        slide.append(new BitmapItem(1, "JabberPoint.jpg"));
        presentation.addSlide(slide);
    }
}
