package shapes;

public class Square extends Rectangle{
    public Square(double side) throws ParallelogramException{
       super(side, side);
    }

    public void setSide(double side) throws ParallelogramException {
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString(){
        return "Square {s=" + getWidth() + "} perimeter = " + (String.format("%.5f",getPerimeter()));
    }
}
