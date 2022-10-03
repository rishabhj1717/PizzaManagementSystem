import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // static enum ORDER_STATUS = [];
    public static void main(String[] args) {
        OrderQueue<Order> l = new OrderQueue<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        String custName, custAddress;
        String conChoice = "";
        String custChoice = "";
        do {
            System.out.println("Welcome to Great Learnings Italian world");
            System.out.println("Please enter your name");
            custName = sc.nextLine();
            System.out.println("Please enter your address");
            custAddress = sc.nextLine();
            Customer custObj = new Customer(custName, custAddress);
            Order orderObj = new Order(custObj);
            do {
                ArrayList<String> foodChoices = new ArrayList<>();
                System.out.println("What would you like to order\n 1. Pizza 2. Pasta");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("Please choose the type of pizza:\n 1.Vegetarian 2.Non-vegetarian 3.Vegan");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        foodChoices.add("vegetarian");
                    } else if (choice == 2) {
                        foodChoices.add("non-vegetarian");
                    } else {
                        foodChoices.add("vegan");
                    }
                    sc.nextLine();
                    System.out.println("Please enter the size of pizza - small, medium or large");
                    foodChoices.add(sc.nextLine());

                    System.out.println("Please enter the type of crust(thick/thin)");
                    foodChoices.add(sc.nextLine());

                    char ch;
                    System.out.println("Do you want toppings?");
                    ch = sc.nextLine().charAt(0);
                    String toppings = "";
                    while (ch == 'y') {
                        System.out.println(
                                "Please enter the toppings needed : Options -> cheese, mushroom, tomato, jalapeno, spinach");
                        toppings += sc.nextLine() + ",";
                        System.out.println("do you wish to add more toppings");
                        ch = sc.nextLine().charAt(0);
                    }
                    Pizza pizzaObj = new Pizza(foodChoices.get(0), foodChoices.get(1), foodChoices.get(2), toppings);
                    orderObj.takeOrder(pizzaObj);
                } else {
                    System.out.println("Please choose the flavours of pasta:\n 1.White sauce 2. Red sauce");
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {
                        foodChoices.add("white sauce");
                    } else {
                        foodChoices.add("red sauce");
                    }

                    System.out.println("Please choose the type of pasta -> penne, diatilini, spaghetti");
                    foodChoices.add(sc.nextLine());
                    Pasta pastaObj = new Pasta(foodChoices.get(0), foodChoices.get(1));
                    orderObj.takeOrder(pastaObj);
                }
                System.out.println("Do you want to continue to order(y/n)");
                conChoice = sc.nextLine();

            } while (conChoice.charAt(0) == 'y');
            l.enqueue(orderObj.acceptOrder());
            orderObj.setTotalAmount();
            System.out.println("Your order has been added to the queue, to track here is your orderId: "+ orderObj.orderId);
            System.out.println("Total amount of the order is: " + orderObj.getTotalAmount());

            System.out.println("Here is a bill of the complete order");
            System.out.println("---------------------------------------------");
            System.out.println("Customer Name: "+ orderObj.customerObj.customerName);
            System.out.println("Customer Address: "+ orderObj.customerObj.customerAddress);
            System.out.println("Order Id: "+ orderObj.orderId);
            System.out.println("*********************** ORDER *****************************");
            for(ItalianDish italianObj: orderObj.orderItems){
                italianObj.display();
            }
            System.out.println("***********************************************************\n\n");
            System.out.println("Do you wish to continue?(y/n)");
            custChoice = sc.nextLine();
            
        } while (custChoice.charAt(0) == 'y');

        while(!l.empty()){
            System.out.println("Currently kitchen is working on: " + l.front().orderId);
            Kitchen k = new Kitchen(l.front());
            k.orderPreparation();
            k.finishOrder();
            l.dequeue();
        }

    }
}
