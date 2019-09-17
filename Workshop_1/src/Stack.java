class Stack{
    private char[] stackArray;
    private int headElementPos;
    private int capacity;

    Stack(int size){    //1 arg constructor that initialize a character array with input string length, intialize an int capacity with the size and a head variable
        stackArray = new char[size] ;
        capacity = size;
        headElementPos = -1;
    }

    void push(char element){                // push method that throw an error is array goes out of bonds and exit the program with -1 status

        if (isFull()){
            System.out.println("OverFlow..........Program Terminated with Status: 1\n");
            System.exit(1);
        }
        System.out.println("Inserting character: " + element);
        stackArray[++headElementPos] = element;
    }

    char pop(){                               // pop method that throw an error is array goes out of bonds and exit the program with -1 status
        if (isEmpty()){
            System.out.println("UnderFlow..........Program Terminated with Status: 1\n");
            System.exit(1);
        }
        System.out.println("Removing character : " + peekHeadElement());
        return stackArray[headElementPos-- ];
    }

    private char peekHeadElement(){                        // return a char with is at the top element of stack array
        if(!isEmpty()){
            return stackArray[headElementPos];
        }
        else{
            System.exit(1);
        }
        return (char) -1;
    }
    private Boolean isFull(){ return headElementPos == capacity -1; }         // return true is array is full

    private Boolean isEmpty(){ return headElementPos == -1; }                 //return true is array is empty
}