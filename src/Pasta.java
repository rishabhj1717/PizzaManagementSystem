public class Pasta extends ItalianDish{
    int[] price = new int[]{10,20};
    String[] flavours = new String[]{"white sauce", "red sauce"};
    String[] types = new String[]{"penne", "diatilini", "spaghetti"};

    String flavour,type;

    Pasta(String flavour,String type){
        this.flavour = flavour;
        this.type = type;
    }

    @Override
    int getCost(){
        if(this.flavour.equalsIgnoreCase("white sauce")){
            return this.price[0];
        }
        return this.price[1];
    }

    @Override
    void display(){
        System.out.println("Pasta: ["+ this.flavour + " Type: " + this.type + " Price: " + this.getCost() + " ]");
    } 
}
