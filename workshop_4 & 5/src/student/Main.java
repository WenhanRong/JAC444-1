package student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{

    menu();         // Calling the main menu function

    }


    private static void menu() throws IOException {
        int option;
        Scanner inputOption = new Scanner(System.in);

        FileOutputStream fs = new FileOutputStream("studentData.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fs);

        do {                                        // loop through until 0 is pressed
        System.out.println("1. Add Student Data");
        System.out.println("2. Show Student Data");
        System.out.println("0. Exit\n");
        System.out.print("Enter the Number : ");
        option = inputOption.nextInt();


            switch (option){
                case 1 :
                    StudentAdd.getStdInfo(objectOutputStream);            // calling the getStdInfo() for data input

                    break;
                case 2:
                    StudentsRead.read();               //calling the read() for data read
                    break;
                case 0:
                    System.exit(0);             // exit the program
                    break;
            }

         } while (option != 0);

      objectOutputStream.flush();
    }
}
