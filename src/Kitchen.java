interface KitchenImpl{
    void orderPreparation();
    void finishOrder();
}

public class Kitchen implements KitchenImpl {
    // OrderQueue<Order> queueOrders;
    Order currentOrder;
    //class to update order status from time to time and dequeue elements from the queue after marking the order as completed.
    Kitchen(Order currentOrder){
        //should have instance of queue
        this.currentOrder = currentOrder;
    }
    public void orderPreparation(){
        //update status to "Being prepared" -> l.front().status = ""
        System.out.println("Order " + this.currentOrder.orderId + "is being prepared\n\n");
        currentOrder.setOrderStatus("PREPARING");
    }

    public void finishOrder(){
        System.out.println("Order " + this.currentOrder.orderId + "has been prepared\n\n");
        currentOrder.setOrderStatus("PREPARED");
    }
}
