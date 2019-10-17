package student;
import students.Students;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;


class StudentsRead{

    static void read() {
        try {
            FileInputStream fis = new FileInputStream("studentData.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            boolean read = true;
            int stdCounter = 1;

            while(read) {
                Students std = (Students) ois.readObject();

                if(std != null) {
                    System.out.println("\n\n*************PRINTING STUDENT DATA*************\n" );
                    System.out.println("------ STUDENT NO:" + stdCounter++);
                    System.out.println("Student Number: " + std.getStdID());
                    System.out.println("Student Name: " + std.getFirstName() + " " + std.getLastName());
                    System.out.println("Student Course(s): " + std.getCourses());
                    System.out.println();

                } else{
                    read = false;
                }
            }

            fis.close();


        }catch(EOFException e){
            System.out.print("*************End of file reached!*************\n\n");
        } catch(Throwable e){
            System.err.println(e.getMessage());
        }
    }


}


