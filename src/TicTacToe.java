import util.Input;

import java.util.Arrays;

public class TicTacToe {

    public static void game() {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Response Structure: (rowNumber)(columnLetter) / Ex. 1a, 3c");
        String[][] startBoard = startBoard();
        turnLoop(startBoard);
    }
    public static void turnLoop(String[][] newBoard) {
        boolean fullBoard = false;
        String player1 = new Input().getString("\nPlayer 1: ");
        String[][] afterPlayer1 = turn(newBoard, player1, "X");
        String player2 = new Input().getString("\nPlayer 2: ");
        String[][] afterPlayer2 = turn(afterPlayer1, player2, "O");
//        if(fullBoard) {
//        }
//        turnLoop(afterPlayer2);
    }

    public static String[][] turn(String[][] startBoard, String player, String symbol) {
        String[] p1Breakdown = player.split("");
        int row = (Integer.parseInt(p1Breakdown[0]));
        int column = positionToNum(p1Breakdown[1]);
        String[][] newBoard = newBoard(startBoard, row, column, symbol);
        for (String[] eachRow : newBoard) {
            for (String n : eachRow) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return newBoard;
    }

    public static String[][] newBoard(String[][] oldMatrix, int row, int column, String symbol) {
        String[][] newMatrix = Arrays.copyOf(oldMatrix, oldMatrix.length);
        if (newMatrix[row][column].equalsIgnoreCase("-X-") || newMatrix[row][column].equalsIgnoreCase("-O-")) {
            System.out.println("This space is occupied!");
            return newBoard(oldMatrix, row, column, symbol);
        } else {
            newMatrix[row][column] = "-"+symbol+"-";
            for (String[] eachRow : newMatrix) {
                System.out.print(" ");
                for (String n : eachRow) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            return newMatrix;
        }
    }

    public static String[][] startBoard() {
        String[][] matrix = {
                {"   A   B   C  "},
                {"1", "---", "---", "---"},
                {"2", "---", "---", "---"},
                {"3", "---", "---", "---"},
        };
        for (String[] row : matrix) {
            System.out.print(" ");
            for (String n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static int positionToNum(String position) {
        int letterToNum = 0;
        switch (position) {
            case "a":
                letterToNum = 1;
                break;
            case "b":
                letterToNum = 2;
                break;
            case "c":
                letterToNum = 3;
                break;
        }
        return letterToNum;


    }

    public static void main(String[] args) {
        game();
    }
}