package shapes;

public class Square extends Rectangle {
    private FunctionalityInterface area = () -> getHeight() * getWidth(); //lambda expression
    public Square(double side) throws ParallelogramException{
       super(side, side);
    }

    public void setSide(double side) throws ParallelogramException {
        super.setWidth(side);
        super.setHeight(side);
    }



    private double sValue(double width, FunctionalityInterface functionalInterface){
        return functionalInterface.getArea();
    }

    @Override
    public double getArea(){
        return sValue(getWidth(), area);
    }


    @Override
    public double getPerimeter() {
        return 4 * getWidth();
    }

    @Override
    public String toString(){
        return "Square {s=" + getWidth() + "} perimeter = " + (String.format("%.4f",getPerimeter()))+ "} *******AREA******* = " + (String.format("%.5f",getArea()));
    }
}
