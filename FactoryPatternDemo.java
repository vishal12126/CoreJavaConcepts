import java.awt.*;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();
    }
}

interface Shape {
    public void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle is drawn");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle is drawn");
    }
}

class ShapeFactory {

    public Shape getShape(String shape){
        if(shape == null){
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        } else if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }
        return null;
    }
}
