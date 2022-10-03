import java.util.ArrayList;
import java.util.Random;

public class Order {
    long orderTrackId;
    String orderId, status;
    private long totalAmount;
    ArrayList<ItalianDish> orderItems;
    Customer customerObj;

    Random random = new Random();

    Order(Customer customerObj){
        this.customerObj = customerObj;//will have details of the customer
        this.orderId = String.format("%04d", random.nextInt(10000)); //we create a random new order id every time
        orderItems = new ArrayList<>();
    }

    private void setOrderTrackId(long trackId){
        this.orderTrackId = trackId;
        System.out.println("Order track id has been set");
    }

    private long getOrderTrackId(){
        return Long.parseLong(String.format("%04d", random.nextInt(10000)));
    }

    void takeOrder(ItalianDish food){
        orderItems.add(food);
        System.out.println("Item has been added to ordered list");
    }

    Order acceptOrder(){
        long trackId = getOrderTrackId();
        this.setOrderTrackId(trackId);
        this.status = "QUEUED";
        //enqueue into queue
        //add the returned trackid into object using private setter and return this obj
        return this;
    }

    String getOrderStatus(){
        //customer can check with status of order.
        return this.status;
    }

    void setOrderStatus(String status){
        this.status = status;
    }

    void setTotalAmount() {
        for(ItalianDish obj: this.orderItems){
            this.totalAmount += obj.getCost(); //obj.price;
        }
    }

    long getTotalAmount(){
        return this.totalAmount;
    }

    

    //good to have
    Boolean cancelOrder(String orderId){
        //we will check if status is 0, we will cancel order else we shall not cancel order
        return true;
    }

}
