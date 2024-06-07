package com.nhlstenden.JabberPoint.model;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class XMLAccessorTest
{
    private Presentation presentation;
    private XMLAccessor accessor;
    private static final String TEST_FILE = "test.xml";
    private static final String SAVE_FILE = "save_test.xml";

    @Before
    public void setUp ()
    {
        presentation = new Presentation ();
        accessor = new XMLAccessor ();
        createTestFile ();
    }

    private void createTestFile ()
    {
        try
        {
            String xmlContent = """
                    <presentation>
                        <showtitle>Demo Presentation</showtitle>
                        <slide>
                            <title>Slide 1</title>
                            <item kind="text" level="1">First item</item>
                            <item kind="text" level="2">Second item</item>
                        </slide>
                        <slide>
                            <title>Slide 2</title>
                            <item kind="text" level="1">Another item</item>
                        </slide>
                    </presentation>
                    """;
            Files.write (Paths.get (TEST_FILE), xmlContent.getBytes ());
        } catch (IOException e)
        {
            fail ("Failed to create test file");
        }
    }

    @Test
    public void testLoadFile ()
    {
        try
        {
            accessor.loadFile (presentation, TEST_FILE);
            assertEquals ("Demo Presentation", presentation.getTitle ());
            assertEquals (2, presentation.getSlides ().size ());
        } catch (IOException e)
        {
            fail ("IOException should not have been thrown");
        }
    }

    @Test
    public void testSaveFile ()
    {
        Slide slide = new Slide ();
        slide.setTitle ("Test Slide");
        presentation.addSlide (slide);
        try
        {
            accessor.saveFile (presentation, SAVE_FILE);
            File file = new File (SAVE_FILE);
            assertTrue (file.exists ());
        } catch (IOException e)
        {
            fail ("IOException should not have been thrown");
        }
    }
}
