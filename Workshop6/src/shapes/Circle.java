package shapes;

public class Circle implements Shape, FunctionalityInterface{
    private double radius;
    private FunctionalityInterface area = () -> Math.PI * getRadius() * getRadius(); //lambda expression


    public Circle(double radius) throws CircleException{
        if (radius > 0.00)
            this.radius = radius;
        else
            throw new CircleException("Invalid Radius!");

    }

    public void setRadius(double radius) throws CircleException{
        if(radius > 0){
        this.radius = radius;
        } else{
            throw new CircleException("Invalid Radius!");
        }
    }


    //
    private double cValue(FunctionalityInterface functionInterface){
        return functionInterface.getArea();
    }

    @Override
    public double getArea(){
        return cValue(area);
    }


    private double getRadius() {
        return radius;
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI *getRadius();
    }
    @Override
    public String toString(){
        return "Circle {r= "+ getRadius() + "} perimeter = " + (String.format("%.4f",getPerimeter()))+ " *******AREA******* = " + (String.format("%.4f",getArea()));
    }
}
