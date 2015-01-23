/**
 * Created by Larry on 1/16/2015.
 */
import java.util.Scanner;


public class TTT {
    public static int row, col, ans, ans1;
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
        System.out.println('\n');
        while (playing) {
            System.out.println("Please enter a row : Player " + turn);

            do {
                ans = scan.nextInt();
                if (ans > 3) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans = scan.nextInt();
                } else if (ans  < 1) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans = scan.nextInt();
                }
                if ((ans < 4) && (ans > 0))
                {
                    playing = false;
                } //else should exit loop

            }while(playing);

            row = ans - 1;
            playing = true;
            System.out.println("Please enter a Column " + turn);


            do {
                ans1 = scan.nextInt();
                if (ans1 > 3) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans1 = scan.nextInt();
                } else if (ans1  < 1) {
                    System.out.println("Please enter a number between 1 - 3");
                    ans1 = scan.nextInt();
                }
                if ((ans1 < 4) && (ans1 > 0))
                {
                    playing = false;
                } //else should exit loop

            }while(playing);

            col = ans1 - 1;




        }
        board[row][col] = turn;
        playing = true;
        if (GameOver(row, col)) {
            playing = false;
            System.out.println("Game over! Player " + turn + "wins");
        }


        if (turn == 'X')
            turn = 'O';
        else
            turn = 'X';
        PrintBoard();
        Play();
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



    }
