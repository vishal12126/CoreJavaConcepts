import com.sun.org.apache.xpath.internal.operations.Or;

//Use the Broker class to take and execute commands.
import java.util.ArrayList;
import java.util.List;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock bstock = new BuyStock(stock);
        SellStock sstock = new SellStock(stock);

        Broker broker = new Broker();
        broker.addOrder(bstock);
        broker.addOrder(sstock);

        broker.placeorder();
    }
}

//Create a command interface.
interface Order{
    public void execute();
}
    //Create a request class.
class Stock {
    private String name = "ABC";
    private int quantity = 10;
    public void buy(){
        System.out.println("Stock [ Name: "+name+" , Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
//Create concrete classes implementing the Order interface.
class BuyStock implements Order {
    private Stock abcStock;
    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }
    public void execute() {
        abcStock.buy();
    }
}

class SellStock implements Order {
    private Stock abcStock;
    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }
    public void execute() {
        abcStock.sell();
    }
}

//Create command invoker class.
class Broker {
    private List<Order> items = new ArrayList<Order>();
    public void addOrder(Order order){
        items.add(order);
    }

    public void placeorder(){
        for(Order o: items){
            o.execute();
        }
        items.clear();
    }
}

