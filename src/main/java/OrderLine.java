public class OrderLine {
    private int OrderLineId;
    private int Price;
    private int ProductId;
    private int Quantity;
    private int Total;
    private int OrderId;

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public int getOrderLineId() {
        return OrderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        OrderLineId = orderLineId;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    @Override
    public String toString() {
        return OrderLineId + "," + Price + "," + ProductId + "," +Quantity +"," +Total + "," +OrderId;
    }
}
