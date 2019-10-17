package student;

import students.Students;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

class StudentAdd {



    static void getStdInfo(ObjectOutputStream oos) {
        try {


            Scanner reader = new Scanner(System.in);
                int stdID = 0;

                Students students = new Students();

                System.out.println("Enter student number: ");
                while (stdID == 0) {

                    try {
                        stdID = reader.nextInt();
                        students.setStdID(stdID);
                    } catch (Exception exception) {
                        System.out.println("Invalid student number! Please enter a valid student number: ");
                    }
                    reader.nextLine();
                }

                System.out.println("Enter student's first name: ");
                students.setFirstName(reader.nextLine());           //calling setFirstName to set value

                System.out.println("Enter student's last name: ");
                students.setLastName(reader.nextLine());            //calling setLastName to set value

                boolean moreCourses = true;

                do {
                    System.out.println("Enter student's course [Enter 0 to finish adding courses]: ");
                    String course = reader.nextLine();

                    if (course.equals("0")) {
                        moreCourses = false;
                    } else {
                        students.setCourses(course);
                    }

                } while (moreCourses);

            oos.writeObject(students);      //

    } catch (IOException e) {
                e.printStackTrace();
        }
    }}


