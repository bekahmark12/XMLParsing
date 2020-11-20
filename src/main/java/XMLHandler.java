import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    boolean bName = false;
    boolean bCustomerId = false;



    @Override
    public void endElement(String uri,
                           String localName, String qName) {
        if (qName.equalsIgnoreCase("student")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {

        if (bName) {
            System.out.println("Name: "
                    + new String(ch, start, length));
            bName = false;
        } else if (bCustomerId) {
            System.out.println("Customer ID: " + new String(ch, start, length));
            bCustomerId = false;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("CustomerId")) {
            bCustomerId = true;
        }
    }
}
