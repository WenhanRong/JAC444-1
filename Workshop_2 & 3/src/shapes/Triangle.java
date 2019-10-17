package shapes;

public class Triangle implements Shape{
    private double sideA, sideB, sideC = 0;     // initialize the variables

    public Triangle(double A, double B, double C) throws TriangleException{
        if(sideCheck( A,  B,  C)) {          // check for all sides
            this.sideA = A;
            this.sideB = B;
            this.sideC = C;
        }

    }
    private boolean sideCheck(double A, double B, double C) throws TriangleException{
        if(A > 0.00 && B > 0.00 && C > 0 &&
                A + B > C && A + C > B && B + C > A){
            return true;

        }else{
            throw new TriangleException("Invalid side(s)!");
        }

    }

    private double getSideA() {
        return sideA;
    }
    private double getSideB() {
        return sideB;
    }
    private double getSideC() {
        return sideC;
    }

    public void setSideA(double A, double B, double C)throws TriangleException{
        if(sideCheck(A, B, C)){
            this.sideA = A;
        }throw new TriangleException("Invalid side(s)!");
    }
    public void setSideB(double A, double B, double C)throws TriangleException{
        if(sideCheck(A, B, C)) {
            this.sideA = A;
        }throw new TriangleException("Invalid side(s)!");
    }
    public void setSideC(double A, double B, double C)throws TriangleException{
        if(sideCheck(A, B, C)) {
            this.sideA = A;
        }throw new TriangleException("Invalid side(s)!");
    }

    @Override
    public double getPerimeter() {

        return getSideA() + getSideB() + getSideC();
    }
    @Override
    public String toString(){
        return "Triangle {s=" + getSideA() +", s="+ getSideB() +", s="+ getSideC() +"} perimeter = "+ (String.format("%.4f", getPerimeter()));

    }
}
