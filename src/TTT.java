/**
 * Created by Larry on 1/16/2015.
 */
import java.util.Scanner;


public class TTT {
    public static int row, col, ans;
    public static Scanner scan = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    public static char turn = 'X';

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        PrintBoard();
        Play();
    }

    public static void Play() {
        boolean playing = true;

        while (playing) {
            System.out.println("Please enter a row ");

            do {
                ans = scan.nextInt();
                if (ans > 3) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans = scan.nextInt();
                } else if (ans  < 1) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans = scan.nextInt();
                }

            }while((ans !='1')&& (ans !='2') && (ans !='3') && (ans !='4'));

            row = ans - 1;
            System.out.println("Please enter a Column ");
            valueCheck();
            col = ans - 1;


        }
        board[row][col] = turn;
        if (GameOver(row, col)) {
            playing = false;
            System.out.println("Game over! Player " + turn + "wins");
        }


        if (turn == 'X')
            turn = 'O';
        else
            turn = 'X';
        PrintBoard();
    }


    public static void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j] + " | ");
            }
        }

    }

    public static boolean GameOver(int nMove, int cMove) {

        if (board[0][cMove] == board[1][cMove]
                && board[0][cMove] == board[2][cMove])
            return true;
        if (board[nMove][0] == board[nMove][1]
                && board[nMove][0] == board[nMove][2])
            return true;
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                && board[1][1] != '_')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
                && board[1][1] != '_')
            return true;
        return false;
    }

    public static void valueCheck() {
        do {
            ans = scan.nextInt();
                if (ans > 4) {
                    System.out.println("Please enter a number between 1 - 3");
                     ans = scan.nextInt();
                } else if (ans  < 1) {
                    System.out.println("Please enter a number between 1 - 3");
                   ans = scan.nextInt();
                }

            }while((ans !='1')&& (ans !='2') && (ans !='3') && (ans !='4'));
        }

    }
