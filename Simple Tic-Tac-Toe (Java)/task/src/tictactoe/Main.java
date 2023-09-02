package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       game();
    }

    static void game() {

        char[] chosenSymbols = {'_', '_', '_', '_', '_', '_', '_', '_', '_'};
        board(chosenSymbols);
        move(chosenSymbols);

    }

    public static void move(char[] chosenSymbols) {
        boolean verif = true;
        int player = 1;

        while (verif) {
            Scanner scanner = new Scanner(System.in);
            boolean gameOver = false;
            while (!gameOver) {
                try {
                    int first = scanner.nextInt() - 1;
                    int second = scanner.nextInt() - 1;
//                System.out.println(first + " " + second); // test wstawionych koordynatow

                    if (first >= 0 && first < 3 && second >= 0 && second < 3) {
                        int field;
                        if (first == 0) {
                            field = second;
                        } else if (first == 1) {
                            field = second + 3;
                        } else {
                            field = second + 6;
                        }
                        if (chosenSymbols[field] == '_') {
                            if (player % 2 == 0) {
                                chosenSymbols[field] = 'O';
                            } else {
                                chosenSymbols[field] = 'X';
                            }
                            verif = false;
                            player++;
                            gameOver = result(chosenSymbols);
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                        }

                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                }


            }
        }

    }

    public static void board(char[] symbols) {
        System.out.println("-".repeat(9));
        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(symbols[j + i] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(9));
    }

    static boolean result(char[] result) {
        int sumX = 0;
        int sumO = 0;
        int sum_ = 0;
        int winX = 0;
        int winO = 0;
        board(result);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'X') {
                sumX++;
            } else if (result[i] == 'O') {
                sumO++;
            } else if (result[i] == '_') {
                sum_++;
            }
            if (result[0] == 'X' && result[1] == 'X' && result[2] == 'X' ||
                    result[3] == 'X' && result[4] == 'X' && result[5] == 'X' ||
                    result[6] == 'X' && result[7] == 'X' && result[8] == 'X' ||
                    result[0] == 'X' && result[4] == 'X' && result[8] == 'X' ||
                    result[2] == 'X' && result[4] == 'X' && result[6] == 'X' ||
                    result[0] == 'X' && result[3] == 'X' && result[6] == 'X' ||
                    result[1] == 'X' && result[4] == 'X' && result[7] == 'X' ||
                    result[2] == 'X' && result[5] == 'X' && result[8] == 'X' ) {
                winX = 1;
            } if (result[0] == 'O' && result[1] == 'O' && result[2] == 'O' ||
                    result[3] == 'O' && result[4] == 'O' && result[5] == 'O' ||
                    result[6] == 'O' && result[7] == 'O' && result[8] == 'O' ||
                    result[0] == 'O' && result[4] == 'O' && result[8] == 'O' ||
                    result[2] == 'O' && result[4] == 'O' && result[6] == 'O' ||
                    result[0] == 'O' && result[3] == 'O' && result[6] == 'O' ||
                    result[1] == 'O' && result[4] == 'O' && result[7] == 'O' ||
                    result[2] == 'O' && result[5] == 'O' && result[8] == 'O' ) {
                winO = 1;
            }
        }
        if (winX == 1 && winO == 1 || Math.abs(sumX - sumO) > 1) {
            System.out.println("Impossible");
        }  else if (winX == 1) {
            System.out.println("X wins");
            return true;
        } else if (winO == 1) {
            System.out.println("O wins");
            return true;
        } else if (sum_ > 0) {
//            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
            return true;
        }

        return false;
//        System.out.println(sumX + " " + sumO + " " + sum_ + " " + winX + " " + winO); // test danych
    }

}
