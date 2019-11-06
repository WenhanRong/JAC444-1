package student;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.Optional;

public class StudentProcess {

    public static void main(String[] args){
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media") };

        //*********** TASK 1 ***********
        List<Student> studentList = Arrays.asList(students);
        System.out.println("\nTASK: 1 \n\n" + "Complete Student List: ");
        studentList.forEach(System.out::println);

        //*********** TASK 2 ***********
        System.out.println("\nTASK: 2 \n\n" + "Students who got 50.0-100.0 sorted by grade: ");
        studentList.stream().sorted(Comparator.comparing(Student::getGrade))
                .filter(student -> student.getGrade() >= 50.0 && student.getGrade() <= 100.0)
                .forEach(System.out::println);

        //*********** TASK 3 ***********
        System.out.println("\nTASK: 3 \n\n" + "First student who got 50.0 - 100.0: ");
        System.out.println(studentList.stream().findFirst().get());


        //*********** TASK 4 ***********
        System.out.println("\nTASK: 4 \n\n" + "Students in ascending order by last name then first: ");
        studentList.stream().sorted( Comparator.comparing(Student::getLastName)
                        .thenComparing(Comparator.comparing(Student::getFirstName)))
                        .forEach(System.out::println);

        System.out.println("\nStudents in descending order by last name then first:");
        studentList
                .stream().sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Comparator.comparing(Student::getFirstName)).reversed())
                        .forEach(System.out::println);

        //*********** TASK 5 ***********
        System.out.println("\nTASK: 5 \n\n" + "Unique Student last names: ");
        studentList.stream().map(Student::getLastName).distinct().sorted().forEach(System.out::println);
    }
}
