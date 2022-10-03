import java.util.HashMap;
import java.util.Map;

public class Pizza extends ItalianDish{
    String[] size = new String[] { "small", "medium", "large" };
    String[] crust = new String[] { "thin", "thick" };
    String[] flavours = new String[] { "vegetarian", "non-vegetarian", "vegan" };
    String[] toppings = new String[] { "cheese", "mushroom", "tomato", "jalapeno", "spinach" };
    int[][] pricePizza = new int[][] { { 20, 40, 60 }, { 25, 50, 75 }, { 15, 30, 45 } };
    int[] priceToppings = new int[] { 1, 1, 1, 1, 1 };

    String typeOfPizza, sizeOfPizza, crustPizza, toppingsPizza;

    Pizza(String typeOfPizza, String sizeOfPizza, String crustPizza, String toppingsPizza) {
        this.typeOfPizza = typeOfPizza;
        this.sizeOfPizza = sizeOfPizza;
        this.crustPizza = crustPizza;
        this.toppingsPizza = toppingsPizza;
    }

    @Override
    int getCost() {
        int priceIndex, price;
        if (this.typeOfPizza.equalsIgnoreCase("vegetarian")) {
            priceIndex = 0;
        } else if (this.typeOfPizza.equalsIgnoreCase("non-vegetarian")) {
            priceIndex = 1;
        } else {
            priceIndex = 2;
        }

        if (this.sizeOfPizza.equalsIgnoreCase("small")) {
            price = pricePizza[priceIndex][0];
        } else if (this.sizeOfPizza.equalsIgnoreCase("medium")) {
            price = pricePizza[priceIndex][1];
        } else {
            price = pricePizza[priceIndex][2];
        }

        return price + this.getToppingsCost();
    }

    int getToppingsCost() {
        int price = 0;
        String[] selectedToppings = this.toppingsPizza.split(",");
        for (String topping : selectedToppings) {
            switch (topping) {
                case "cheese":
                case "mushroom":
                case "tomato":
                case "jalapeno":
                case "spinach": {
                    price += 1;
                    break;
                }
                default:
                    price += 0;
            }
        }

        return price;
    }

    @Override
    void display(){
        System.out.println("Pizza: ["+ this.typeOfPizza + " Size: " + this.sizeOfPizza + " Crust: "+ this.crustPizza + " Price: " + this.getCost() + " Toppings: "+ this.toppingsPizza+ " ]");
    } 

}
