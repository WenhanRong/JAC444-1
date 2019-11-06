package shapes;

public class Rectangle extends Parallelogram{
    private FunctionalityInterface area = () -> getWidth() * getHeight(); //lambda expression

    public Rectangle(double width, double height) throws ParallelogramException{
        super(width, height);
    }



    private double rValue(double width, double height, FunctionalityInterface functionalityInterface) {
        return functionalityInterface.getArea();
    }

    @Override
    public double getArea() {
        return rValue(getWidth(), getHeight(), area);
    }


    @Override
    public String toString() {
        return "Rectangle {w=" + getWidth()  + "} perimeter = " + (String.format("%.4f",getPerimeter()))+ ", h=" + getHeight() + "} *******AREA******* = " + (String.format("%.4f",getArea()));
    }
}
