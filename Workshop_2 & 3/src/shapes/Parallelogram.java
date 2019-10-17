package shapes;

public class Parallelogram implements Shape{
    private double width, height;

    public Parallelogram(double width, double height) throws ParallelogramException{
        if(width > 0.00 && height > 0.00) {
            this.height = height;
            this.width = width;
        }else {
            throw new ParallelogramException("Invalid Side!");
        }
    }

    void setWidth(double width) throws ParallelogramException{
        if(width > 0.00 && height > 0.00) {
            this.width = width;

        }else {
            throw new ParallelogramException("Invalid Side!");
        }
    }

     void setHeight(double height)throws ParallelogramException {
        if(width > 0.00 && height > 0.00) {
            this.height = height;

        } else {
            throw new ParallelogramException("Invalid Side!");
        }
    }

    double getWidth(){
        return width;
    }
    double getHeight(){
        return height;
    }


    @Override
    public double getPerimeter(){
        return (getWidth() + getHeight()) * 2;
    }
    @Override
    public String toString(){
        return "Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = " + (String.format("%.4f",getPerimeter()));
    }
}
