package task3;

import java.util.Scanner;

public class Main {
    //The idea of the solution is to go through every position in the garden, mark those passed as visited,
    // traverse the patches of carrots using recursion and for every patch
    // increment the variable that keeps track of the number of leaps required
    // if the current position in the for loop in findNumberOfLeaps() has already been visited, it is skipped
    private static boolean isValidPosition(int[][] garden, int gardenDimensions,
                                           int row, int col, boolean[][] visited) {
        return row >= 0 && row < gardenDimensions && col >= 0 && col < gardenDimensions &&
            garden[row][col] == 1 && !visited[row][col];
    }

    private static void traverseCurrentPatchOfCarrots(int[][] garden, int gardenDimensions,
                                                      int currentRow, int currentCol, boolean[][] visited) {
        if (!isValidPosition(garden, gardenDimensions, currentRow, currentCol, visited)) {
            return;
        }

        visited[currentRow][currentCol] = true;

        traverseCurrentPatchOfCarrots(garden, gardenDimensions, currentRow - 1, currentCol, visited);
        traverseCurrentPatchOfCarrots(garden, gardenDimensions, currentRow, currentCol + 1, visited);
        traverseCurrentPatchOfCarrots(garden, gardenDimensions, currentRow + 1, currentCol, visited);
        traverseCurrentPatchOfCarrots(garden, gardenDimensions, currentRow, currentCol - 1, visited);
    }

    private static int findNumberOfLeaps(int[][] garden, int gardenDimensions) {
        int leapsNumber = 0;

        boolean[][] visited = new boolean[gardenDimensions][gardenDimensions];

        for (int i = 0; i < gardenDimensions; i++) {
            for (int j = 0; j < gardenDimensions; j++) {
                if (garden[i][j] == 1 && !visited[i][j]) {
                    traverseCurrentPatchOfCarrots(garden, gardenDimensions, i, j, visited);
                    leapsNumber++;
                }
            }
        }

        return leapsNumber;
    }

    public static void main(String[] args) {
        int gardenDimensions;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter garden dimensions:");
        gardenDimensions = Integer.parseInt(sc.nextLine());

        int[][] garden = new int[gardenDimensions][gardenDimensions];
        System.out.println("Enter positions with a carrot as 1, otherwise as 0:");
        for (int i = 0; i < gardenDimensions; i++) {
            for (int j = 0; j < gardenDimensions; j++) {
                garden[i][j] = Integer.parseInt(sc.next());
            }
        }

        System.out.println(findNumberOfLeaps(garden, gardenDimensions));
    }
}
