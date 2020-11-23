import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {
    private int countTags = 0;
    private boolean inElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("<" + qName + ">");
        inElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        countTags++;
        System.out.println("</" + qName + ">");
        inElement = false;

        if(countTags > 15) {
            // throw some exception to stop parsing
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(inElement) {
            System.out.println(new String(ch, start, length));
        }
    }



//    boolean bName = false;
//    boolean bCustomerId = false;
//
//
//
//    @Override
//    public void endElement(String uri,
//                           String localName, String qName) {
//        if (qName.equalsIgnoreCase("Customer")) {
//            System.out.println("End Element :" + qName);
//        }
//    }
//
//    @Override
//    public void characters(char ch[], int start, int length) {
//
//        if (bName) {
//            System.out.println("Name: "
//                    + new String(ch, start, length));
//            bName = false;
//        } else if (bCustomerId) {
//            System.out.println("Customer ID: " + new String(ch, start, length));
//            bCustomerId = false;
//        }
//    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        if (qName.equalsIgnoreCase("Name")) {
//            bName = true;
//        } else if (qName.equalsIgnoreCase("CustomerId")) {
//            bCustomerId = true;
//        }
//    }
}
