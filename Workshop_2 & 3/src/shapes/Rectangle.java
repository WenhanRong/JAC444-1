package shapes;

public class Rectangle extends Parallelogram{
    public Rectangle(double width, double height) throws ParallelogramException{
        super(width, height);
    }

    @Override
    public String toString() {
        return "Rectangle {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + (String.format("%.4f",getPerimeter()));
    }
}
