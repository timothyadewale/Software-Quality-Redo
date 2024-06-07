package com.nhlstenden.JabberPoint.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccessorFactoryTest
{

    private AccessorFactory factory;

    @Before
    public void setUp ()
    {
        factory = new AccessorFactory ();
    }

    @Test
    public void testCreateXMLAccessor ()
    {
        Accessor accessor = factory.createAccessor ("XML");
        assertTrue (accessor instanceof XMLAccessor);
    }

    @Test
    public void testCreateDemoAccessor ()
    {
        Accessor accessor = factory.createAccessor ("DEMO");
        assertTrue (accessor instanceof DemoPresentation);
    }

    @Test
    public void testCreateUnknownAccessor ()
    {
        Accessor accessor = factory.createAccessor ("UNKNOWN");
        assertNull (accessor);
    }
}
