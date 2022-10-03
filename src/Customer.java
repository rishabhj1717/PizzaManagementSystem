import java.util.Random;

public class Customer {
    String customerName, customerAddress;
    private long customerId;
    Random random = new Random();

    Customer(String customerName, String customerAddress){
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerId = Long.parseLong(String.format("%04d", random.nextInt(10000))); //we create a random new customer id every time
    }
    
}
