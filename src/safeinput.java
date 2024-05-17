import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class safeinput {


    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0); // loop exit

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int userInt = 0;
        String trash = "";
        boolean done = false;
        // loop
        do {
            System.out.println("What is your favorite integer?");
            if (pipe.hasNextInt()) {
                userInt = pipe.nextInt();
                // loop exit
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter numbers only please.");
            }


        } while (!done);
        // return
        return userInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double userDouble = 0;
        String trash = "";
        boolean done = false;
        // loop
        do {
            System.out.println(prompt);
            if (pipe.hasNextDouble()) {
                userDouble = pipe.nextDouble();
                // loop exit
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter numbers only please.");
            }


        } while (!done);
        // return
        return userDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int userInput = 0;
        String trash = "";
        boolean done = false;
        // loop
        do {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();

                if (userInput >= low && userInput <= high) {

                    done = true;
                } else {
                    System.out.println("This number is not in the range accepted.");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("This is not a correct input. Enter numbers only.");
            }


        } while (!done);
        return userInput;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double userInput = 0;
        String trash = "";
        boolean done = false;
        // loop
        do {
            System.out.println(prompt);
            if (pipe.hasNextInt()) {
                userInput = pipe.nextInt();

                if (userInput >= low && userInput <= high) {

                    done = true;
                } else {
                    System.out.println("This number is not in the range accepted.");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("This is not a correct input. Enter numbers only.");
            }


        } while (!done);
        return userInput;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean done = false;
        String userChoiceYesOrNo;

        System.out.println(prompt);

        userChoiceYesOrNo = pipe.nextLine();

        userChoiceYesOrNo = userChoiceYesOrNo.toLowerCase();

        switch (userChoiceYesOrNo) {
            case "y":
                done = true;
                break;
            case "n":
                done = false;
                break;
            default:
                System.out.println("That is not a valid input, please enter y or n only.");
                break;
        }

        return done;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String userInput="a";
        boolean done = false;
        // loop start
        do {

            System.out.println(prompt);

            userInput = pipe.nextLine();

            if (userInput.matches(regEx)) {

                done = true;

                // loop exit after user input matches up with proper regex pattern

            } else {
                System.out.println("That does not match the regEx pattern, please try again.");
            }
        } while (!done);

        return userInput;
    }


    public static int twoNumbers(int a, int b) {

        int c = 0;

        c = a + b;

        return c;
    }

    public static void prettyHeader(String msg) {

        int totalSpaces = 60 - 6 - msg.length();
        int leftSpace;
        int rightSpace;

        if (totalSpaces % 2 == 0) {

            leftSpace = rightSpace = totalSpaces / 2;

        } else {

            rightSpace = totalSpaces / 2;
            leftSpace = rightSpace + 1;

        }

        //print top border
        for (int i = 0; i <= 60; i++) {
            System.out.print("*");
        }
        System.out.println();
        // first 3 *
        System.out.print("***");
        for (int i = 0; i <= leftSpace; i++) {

            System.out.print(" ");
        }
        // printing message
        System.out.print(msg);
        //print right side
        for (int i = 0; i <= rightSpace; i++) {

            System.out.print(" ");
        }
        System.out.print("***");
        System.out.println();
        //bottom border
        for (int i = 0; i <= 60; i++) {
            System.out.print("*");
        }


        return;
    }
    public static int rollDie(){

        int die1;
        int die2;

        Random rnd = new Random();

        die1 = rnd.nextInt(6)+1;
        die2 = rnd.nextInt(6)+1;

        int dieRoll = die1+die2;



        return dieRoll;
    }
    public static double getAverage(double values[]) {
        double average = 0;
        double total = 0;


        for (int i = 0; i < values.length; i ++){

            total = total + values[i];

        }

        average = total / 101;


        return average;
    }
    public static int min(int values[]) {
        int min = 0;

        // minimum scan
        for (int i = 0; i < values.length; i ++ ){

            if (values[i] < min){
                min = values[i];
            }

        }

        return min;
    }

    public static int max(int values[]) {
        int max = 0;

        for (int i = 0; i < values.length; i ++ ){

            if (values[i] > max){
                max = values[i];
            }

        }

        return max;
    }

    public static int occuranceScan(int values[], int target) {
        int counter = 0;
        int userInput = 0;

        for (int i = 0; i < values.length; i ++){

            if (userInput == values[i]){
                counter +=1;
            }

        }

        return counter;
    }
    public static int sum(int values[]) {
        int total  = 0;


        for (int i = 0; i < values.length; i ++){

            total  = total + values[i];

        }

        return total;
    }
    public static boolean contains(int values[], int target) {
        boolean targetFound = false;

        for (int i = 0; i < values.length; i ++){
            if (target == values[i]){

                targetFound = true;
                break;
            }

        }
        return targetFound;
    }


}


