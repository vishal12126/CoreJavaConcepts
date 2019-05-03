public class FacadePatternDemo {

    public static void main(String[] args) {

        ShapeMaker smaker = new ShapeMaker();
        smaker.drawCircle();
        smaker.drawRectangle();
    }
}

interface FShape {
    public void draw();
}

class FRectangle implements FShape {
    @Override
    public void draw() {
        System.out.println("FRectangle is drawn");
    }
}

class FCircle implements FShape {
    @Override
    public void draw() {
        System.out.println("Fcircle is drawn");
    }
}

class ShapeMaker {
    private FShape circle;
    private FShape rectangle;

    public ShapeMaker() {
       circle = new FCircle();
       rectangle = new FRectangle();
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
}