import java.util.*;

class Palindrome {
    public static void main (String[] args){
        // argument values for testing
        // arg[0] = "1234554321 ", arg[1] = "civic " , arg[2] = "alpha " ,arg[3] = "123454321", arg[4] = " adda"

        char[] argsToChar = args[4].toCharArray();              // convert the string to charArray and store it

        if(check(argsToChar))                                   // call the check function passing a charArray as an argument and print out a statement is its true or false
            System.out.println(Arrays.toString(argsToChar) + " is indeed a Palindrome! ");
        else
            System.out.println(Arrays.toString(argsToChar) + " is not a Palindrome!");
    }


    private static boolean check(char[] input){
        Stack stackObj = new Stack(input.length);      //new Stack object created
        char[] reverse = new char[input.length];    // reverse char array created with same length an input

        for (char c : input) {                      //push every character from input to stackObj
            stackObj.push(c);
        }
        for (int j = 0; j < input.length; j++) {    //pop char element from stackObj and store it in reverse charArray
            reverse[j] = stackObj.pop();
        }
        display(input, reverse);                    //call display function with original charArray and reverse charArray as its argument

        return Arrays.equals(reverse, input);       // return the comparison between original charArray and reverse charArray
    }

    private static void display(char[] original, char[] reverse){
        System.out.println("\n\n\n************************************** PALINDROME TEST **************************************");
        System.out.println("The command line argument          : " + Arrays.toString(original));
        System.out.println("The reverse string is              : " + Arrays.toString(reverse) + "\n");
        System.out.println("***** RESULT *****\n");
    }
}