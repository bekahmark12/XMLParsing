import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private boolean customerIdSet = false;
    private StringBuilder stringBuilder;
    private Customer customer;
    private Order order;
    private OrderLine orderLine;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        stringBuilder = new StringBuilder();

        if (qName.equals("Customer")){
           customer = new Customer();
           customerIdSet = false;
           order = new Order();
           orderLine = new OrderLine();
       }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       if (customer != null){
           if (qName.equals("CustomerId")){
               if (!customerIdSet) {
                   customer.setId(Integer.parseInt(stringBuilder.toString()));
                   order.setCustomerId(Integer.parseInt(stringBuilder.toString()));
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
           }else if (qName.equals("OrderId")){
               order.setOrderId(Integer.parseInt(stringBuilder.toString()));
           }else if (qName.equals("OrderLineId")){
                orderLine.setOrderLineId(Integer.parseInt(stringBuilder.toString()));
           }else if (qName.equals("Price")){
               orderLine.setPrice(Integer.parseInt(stringBuilder.toString()));
           }
           else if (qName.equals("ProductId")){
               orderLine.setProductId(Integer.parseInt(stringBuilder.toString()));
           }
           else if (qName.equals("Qty")){
               orderLine.setQuantity(Integer.parseInt(stringBuilder.toString()));

           }else if (qName.equals("Total")){
               order.setTotal(Integer.parseInt(stringBuilder.toString()));
               orderLine.setTotal(Integer.parseInt(stringBuilder.toString()));
           }
           else if (qName.equals("Order")){
               System.out.println(order.toString());
           }
           else if (qName.equals("OrderLine")){
               System.out.println(orderLine.toString());
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
