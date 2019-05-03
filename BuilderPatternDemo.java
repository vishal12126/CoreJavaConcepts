import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {
    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
    }
}

interface Item {
    public String name();
    public Packing packing();
    public float price();
}
 interface Packing {
    public String pack();
}
//////Packing
//Wrapper
 class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

//Bottle
class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}

////////////Item
abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
    @Override
    public abstract float price();
}

abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
    @Override
    public abstract float price();
}

class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }
    @Override
    public String name() {
        return "Veg Burger";
    }
}

class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }
    @Override
    public String name() {
        return "Coke";
    }
}

class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){

        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}

//builder class
class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

}