package com.nhlstenden.JabberPoint.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

import org.xml.sax.SAXException;

public class XMLAccessor implements Accessor
{
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";

    @Override
    public void loadFile (Presentation presentation, String filename) throws IOException
    {
        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance ().newDocumentBuilder ();
            Document document = builder.parse (new File (filename));
            Element doc = document.getDocumentElement ();
            presentation.setTitle (getTitle (doc, SHOWTITLE));

            NodeList slides = doc.getElementsByTagName (SLIDE);
            for (int i = 0; i < slides.getLength (); i++)
            {
                Element xmlSlide = (Element) slides.item (i);
                Slide slide = new Slide ();
                slide.setTitle (getTitle (xmlSlide, SLIDETITLE));
                presentation.addSlide (slide);

                NodeList slideItems = xmlSlide.getElementsByTagName (ITEM);
                for (int j = 0; j < slideItems.getLength (); j++)
                {
                    Element item = (Element) slideItems.item (j);
                    loadSlideItem (slide, item);
                }
            }
        } catch (SAXException | ParserConfigurationException e)
        {
            throw new IOException (e);
        }
    }

    private String getTitle (Element element, String tagName)
    {
        NodeList titles = element.getElementsByTagName (tagName);
        return titles.item (0).getTextContent ();
    }

    protected void loadSlideItem (Slide slide, Element item)
    {
        int level = 1;
        NamedNodeMap attributes = item.getAttributes ();
        String levelText = attributes.getNamedItem (LEVEL).getTextContent ();
        if (levelText != null)
        {
            level = Integer.parseInt (levelText);
        }
        String type = attributes.getNamedItem (KIND).getTextContent ();
        if (TEXT.equals (type))
        {
            slide.append (new TextItem (level, item.getTextContent ()));
        }
        else if (IMAGE.equals (type))
        {
            slide.append (new BitmapItem (level, item.getTextContent ()));
        }
    }

    public void saveFile (Presentation presentation, String filename) throws IOException
    {
        try (PrintWriter out = new PrintWriter (new FileWriter (filename)))
        {
            out.println ("<?xml version=\"1.0\"?>");
            out.println ("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
            out.println ("<presentation>");
            out.print ("<showtitle>");
            out.print (presentation.getTitle ());
            out.println ("</showtitle>");
            for (Slide slide : presentation.getSlides ())
            {
                out.println ("<slide>");
                out.println ("<title>" + slide.getTitle () + "</title>");
                for (SlideItem slideItem : slide.getSlideItems ())
                {
                    out.print ("<item kind=");
                    if (slideItem instanceof TextItem)
                    {
                        out.print ("\"text\" level=\"" + slideItem.getLevel () + "\">");
                        out.print (((TextItem) slideItem).getText ());
                    }
                    else if (slideItem instanceof BitmapItem)
                    {
                        out.print ("\"image\" level=\"" + slideItem.getLevel () + "\">");
                        out.print (((BitmapItem) slideItem).getName ());
                    }
                    else
                    {
                        System.out.println ("Ignoring " + slideItem);
                    }
                    out.println ("</item>");
                }
                out.println ("</slide>");
            }
            out.println ("</presentation>");
        }
    }
}
