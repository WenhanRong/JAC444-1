package shapes;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        tasksBegin(args[0]);     // call for task 1 method
    }


    private static void tasksBegin(String inputFile) throws IOException {
        System.out.println("------->JAC 444 Assignment 1<--------");
        System.out.println("-------------->Task 1..... <----------");

        String inputLines = null;                           // initialize string that hold input lines
        String[] inputTokens;
        int tokenLength = 0;
        int shapesCount = 0;

        Path path = Paths.get("././shapes.txt");
        int size = (int) Files.lines(path).count();         // get the size of number of shapes in Shapes.txt

        Shape[] shapes = new Shape[size];

        try (BufferedReader buffer = new BufferedReader(new FileReader(inputFile))) {

            while ((inputLines = buffer.readLine()) != null) {          // loop running until file ends
                inputTokens = inputLines.split(",");              // split the line in different tokens
                tokenLength = inputTokens.length;

                for (int i = 0; i < tokenLength; i++) {

                    if (inputTokens[i].equals("Circle") && tokenLength == 2) {      //compares the token[0]
                        try {
                            shapes[shapesCount] = new Circle(Double.parseDouble(inputTokens[i + 1]));
                            shapesCount++;
                        } catch (CircleException err) {
                            System.out.println(err.getMessage());
                        }
                    } else if (inputTokens[i].equals("Parallelogram") && tokenLength == 3) {
                        try {
                            shapes[shapesCount] = new Parallelogram(Double.parseDouble(inputTokens[i + 1]), Double.parseDouble(inputTokens[i + 2]));
                            shapesCount++;
                        } catch (ParallelogramException err) {
                            System.out.println(err.getMessage());
                        }
                    } else if (inputTokens[i].equals("Rectangle") && tokenLength == 3) {
                        try {
                            shapes[shapesCount] = new Rectangle(Double.parseDouble(inputTokens[i + 1]), Double.parseDouble(inputTokens[i + 2]));
                            shapesCount++;
                        } catch (ParallelogramException err) {
                            System.out.println(err.getMessage());
                        }
                    } else if (inputTokens[i].equals("Square") && tokenLength == 2) {
                        try {
                            shapes[shapesCount] = new Square(Double.parseDouble(inputTokens[i + 1]));
                            shapesCount++;
                        } catch (ParallelogramException err) {
                            System.out.println(err.getMessage());
                        }
                    } else if (inputTokens[i].equals("Triangle") && tokenLength == 4) {
                        try {
                            shapes[shapesCount] = new Triangle(Double.parseDouble(inputTokens[i + 1]), Double.parseDouble(inputTokens[i + 2]), Double.parseDouble(inputTokens[i + 3]));
                            shapesCount++;
                        } catch (TriangleException err) {
                            System.out.println(err.getMessage());
                        }
                    }
                }
            }

           // System.out.println("\n" + shapesCount + " shapes were created:");       // prints out number of times the shapes were created

           displayValue(shapes, shapesCount);                                                    // call out the displayValue func that print out the perimeter along the sides
           task2(shapes, shapesCount);
           task3(shapes);

        } catch (FileNotFoundException err) {
            throw new FileNotFoundException(inputFile + " not found " + err);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void task2(Shape[] shapes, int shapesCount) {
        System.out.println("------->JAC 444 Assignment 2<--------");
        System.out.println("-------------->Task 2..... <----------");

        double maxPerimeter = 0, minPerimeter = 0;

        for(int i = 0; i < shapesCount; i++) {
            if(shapes[i].getClass().getSimpleName().equals("Circle")) {
                if(shapes[i].getPerimeter() >= maxPerimeter) {
                    maxPerimeter = shapes[i].getPerimeter();
                }
                minPerimeter = maxPerimeter;
            } else if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
                if(shapes[i].getPerimeter() <= minPerimeter ) {
                    minPerimeter= shapes[i].getPerimeter();
                }
            }
        }
        for(int i = 0; i < shapesCount; i++) {
            if(shapes[i].getClass().getSimpleName().equals("Circle")) {
              //  System.out.println(maxPerimeter+" "+ shapes[i].getPerimeter());
                if(shapes[i].getPerimeter() == maxPerimeter) {

                    IntStream.range(i, shapesCount).forEach(j -> shapes[j] = shapes[j + 1]);
                    shapesCount--;
                }
            }
        }

        for(int i = 0; i < shapesCount; i++) {
            if(shapes[i].getClass().getSimpleName().equals("Triangle")) {
                if(shapes[i].getPerimeter() == minPerimeter) {
                    for(int j = i; j < shapesCount; j++) {
                        shapes[j] = shapes[j+1];
                    }
                    shapesCount--;
                }
            }
        }
        displayValue(shapes, shapesCount);
        System.out.println("Maximum Perimeter :" + maxPerimeter +"\n");
        System.out.println("Minimum Perimeter :" + minPerimeter +"\n");
      //  System.out.println("\n" + shapesCount + " shapes were created:");



    }

    private static void task3(Shape[] shapes){
        double totalParallelogramPerimeter = 0, totalTrianglePerimeter = 0;

        System.out.println("------->Task 3 ... <-------\n");

	               for(Shape shape : shapes) {
		               if (shape instanceof Parallelogram & !(shape instanceof Rectangle)) {
			              totalParallelogramPerimeter += shape.getPerimeter();
		               } else if(shape instanceof Triangle) {
			              totalTrianglePerimeter += shape.getPerimeter();
		                 }
	               }

	           System.out.println("Total perimeter of Parallelogram is: " + totalParallelogramPerimeter);
	           System.out.println("Total perimeter of Parallelogram is: " + totalTrianglePerimeter);

    }

    private static void displayValue(Shape[] shapes, int shapesCount){
        System.out.println("\n" + shapesCount + " shapes were created:");
        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println("\n" + shape);
            }

        }
        System.out.println("\n");
    }



}
