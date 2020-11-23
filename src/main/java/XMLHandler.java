import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private boolean customerIdSet = false;
    private StringBuilder stringBuilder;
    private Customer customer;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        stringBuilder = new StringBuilder();

        if (qName.equals("Customer")){
           customer = new Customer();
           customerIdSet = false;
       }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       if (customer != null){
           if (qName.equals("CustomerId")){
               if (!customerIdSet) {
                   customer.setId(Integer.parseInt(stringBuilder.toString()));
               }
               //Set Order's Cusotmer id
           }
           else if (qName.equals("Age")){
               customer.setAge(stringBuilder.toString());
           }
           else if (qName.equals("Name")){
               customer.setName(stringBuilder.toString());
           }
           else if (qName.equals("Email")){
               customer.setEmail(stringBuilder.toString());
           }




           else if (qName.equals("Order")){
               System.out.println();
           }
           else if (qName.equals("Customer")){
               System.out.println(customer.toString());
           }
       }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(ch,start, length);
    }
}
