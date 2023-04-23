package task2;

import java.util.Scanner;

public class Main {
    //OBSERVATION: Considering we can't see the colour of the balls we take out of the box,
    // it is impossible to determine that there will be balls of only one colour in the box
    // without removing all but one, because if we have two or more balls in the box
    // there is nothing we can use to guarantee they will not be of the same colour.

    //The program will take the input, save the total number of balls and return that number -1,
    // following the logic from the observation above
    public static void main(String[] args) {
        int totalNumberOfBalls = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command:");
        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split(": ");
            totalNumberOfBalls += Integer.parseInt(info[1]);
            System.out.println("Enter command:");
            input = sc.nextLine();
        }

        System.out.println(totalNumberOfBalls-1);
    }
}
