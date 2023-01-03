import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader extends Reader {
    /**
     * Default API to use.
     */
    protected static final String DEFAULT_API_TO_USE = "dom";

    /**
     * Names of xml tags of attributes
     */
    protected static final String SHOWTITLE = "showtitle";
    protected static final String SLIDETITLE = "title";
    protected static final String SLIDE = "slide";
    protected static final String ITEM = "item";
    protected static final String LEVEL = "level";
    protected static final String KIND = "kind";

    /**
     * Text of messages
     */
    protected static final String PCE = "Parser Configuration Exception";
    protected static final String NFE = "Number Format Exception";


    private String getTitle(Element element, String tagName) {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();

    }

    public void loadFile(Presentation presentation, String filename) throws IOException {
        int slideNumber, itemNumber, max = 0, maxItems = 0;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename)); //Create a JDOM document
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, SHOWTITLE));

            NodeList slides = doc.getElementsByTagName(SLIDE);
            max = slides.getLength();
            for (slideNumber = 0; slideNumber < max; slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);
                Slide slide = SlideFactory.createSlide();
                slide.setTitle(getTitle(xmlSlide, SLIDETITLE));
                presentation.getSlideController().append(slide);

                NodeList slideItems = xmlSlide.getElementsByTagName(ITEM);
                maxItems = slideItems.getLength();
                for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(slide, item);
                }
            }
        } catch (IOException iox) {
            System.err.println(iox.toString());
        } catch (SAXException sax) {
            System.err.println(sax.getMessage());
        } catch (ParserConfigurationException pcx) {
            System.err.println(PCE);
        }
    }

    protected void loadSlideItem(Slide slide, Element item) {
        int level = 1; // default
        NamedNodeMap attributes = item.getAttributes();
        String levelText = attributes.getNamedItem(LEVEL).getTextContent();

        if (levelText != null) {
            try {
                level = Integer.parseInt(levelText);
            } catch (NumberFormatException x) {
                System.err.println(NFE);
            }
        }

        String type = attributes.getNamedItem(KIND).getTextContent();
        SlideItem slideItem = SlideItemFactory.createSlideItemWithItemAndType(type, level, item);
        if (slideItem != null) {
            SlideFactory.appendSlideItemToSlide(slideItem, slide);
        }
    }
}