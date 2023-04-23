package task4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int findNumberOfLettersRemoved(String firstWord, String secondWord) {
        char[] arrayFirst = firstWord.toCharArray();
        char[] arraySecond = secondWord.toCharArray();
        int lengthFirst = arrayFirst.length;
        int lengthSecond = arraySecond.length;

        Arrays.sort(arrayFirst);
        Arrays.sort(arraySecond);

        int indexFirst = 0, indexSecond = 0;
        int lettersRemovedFirst = 0, lettersRemovedSecond = 0;

        while (indexFirst < lengthFirst && indexSecond < lengthSecond) {
            if (arrayFirst[indexFirst] == arraySecond[indexSecond]) {
                indexFirst++;
                indexSecond++;
            }
            else if (arrayFirst[indexFirst] < arraySecond[indexSecond]) {
                lettersRemovedFirst++;
                indexFirst++;
            }
            else {
                lettersRemovedSecond++;
                indexSecond++;
            }
        }

        lettersRemovedFirst += lengthFirst-indexFirst;
        lettersRemovedSecond += lengthSecond-indexSecond;

        int totalRemovedLetters=lettersRemovedFirst + lettersRemovedSecond;
        return totalRemovedLetters;
    }

    public static void main(String[] args) {
        String firstWord, secondWord;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first word:");
        firstWord = sc.nextLine();
        System.out.println("Enter second word:");
        secondWord = sc.nextLine();

        System.out.println(findNumberOfLettersRemoved(firstWord, secondWord));
    }
}
