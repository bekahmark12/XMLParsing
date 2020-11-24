import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler extends DefaultHandler {

    private boolean customerIdSet = false;
    private StringBuilder stringBuilder;
    private Customer customer;
    private Order order;
    private List<OrderLine> orderLines;
    private OrderLine tempOrderLine;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

        stringBuilder = new StringBuilder();

        if (qName.equals("Customer")){
           customer = new Customer();
           customerIdSet = false;
           order = new Order();
           orderLines = new ArrayList<>();
           tempOrderLine = new OrderLine();
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
           else if (qName.equals("Email")) {
               customer.setEmail(stringBuilder.toString());
           }else if (qName.equals("OrderId")){
               order.setOrderId(Integer.parseInt(stringBuilder.toString()));
           }else if (qName.equals("OrderLineId")){
                tempOrderLine.setOrderLineId(Integer.parseInt(stringBuilder.toString()));
           }else if (qName.equals("Price")){
               tempOrderLine.setPrice(Integer.parseInt(stringBuilder.toString()));
           }
           else if (qName.equals("ProductId")){
               tempOrderLine.setProductId(Integer.parseInt(stringBuilder.toString()));
           }
           else if (qName.equals("Qty")){
               tempOrderLine.setQuantity(Integer.parseInt(stringBuilder.toString()));

           }else if (qName.equals("Total")){
               order.setTotal(Integer.parseInt(stringBuilder.toString()));
               tempOrderLine.setTotal(Integer.parseInt(stringBuilder.toString()));
           }

           else if (qName.equals("OrderLine")){

              orderLines.add(tempOrderLine);
              tempOrderLine = new OrderLine();

           }

           else if (qName.equals("Order")){

               for (OrderLine orderLine: orderLines) {
                   orderLine.setOrderId(order.getOrderId());

                   System.out.println(orderLine.toString());
                   try {
                       FileWriter fileWriter = new FileWriter("orderLines.txt",true);
                       fileWriter.write(orderLine.toString()+"\n");
                       fileWriter.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }

               orderLines.clear();

//               try {
//                   FileWriter fileWriter = new FileWriter("orders.txt",true);
//                   fileWriter.write(order.toString()+"\n");
//                   fileWriter.close();
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
           }
//            else if (qName.equals("Customer")){
//
//               System.out.println(customer.toString());
//               try {
//                   FileWriter fileWriter = new FileWriter("customers.txt",true);
//                   fileWriter.write(customer.toString()+"\n");
//                    fileWriter.close();
//               } catch (IOException e) {
//                   e.printStackTrace();
//               }
//           }
       }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(ch,start, length);
    }
}
