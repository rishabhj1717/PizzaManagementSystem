import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        CC.enqueue(1);
        CC.enqueue(10);
        System.out.println(CC.fetchElement());
        CC.dequeue();
        System.out.println(CC.fetchElement());

    }
}

class CC {
    static ArrayList<Integer> al;

    static void enqueue(int k){
        al.add(k);
    }

    static int fetchElement(){
        return al.get(0);
    }

    static void dequeue(){
        al.remove(0);
    }

}