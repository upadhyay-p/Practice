package Java;
import java.util.Scanner;

class TicTacToe {
    private final int n;
    private int filledSquares;
    private final int[][] board;
    // in progress = 0, complete 1, draw = 2
    private int gameStatus;
    public TicTacToe(int n) {
        this.n= n;
        this.board = new int[n][n];
        this.gameStatus = 0;
        this.filledSquares = 0;
    }
    public boolean isInProgress() {
        return gameStatus == 0;
    }

    // returns 0 for game in progress, 1 for user 1 win, -1 for user 2 win, 2 for draw
    public void makeMove(String input, int user) throws IllegalArgumentException{
        String[] inputArr = input.split(" ");
        // validate input
        if(inputArr.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }
        int x = Integer.parseInt(inputArr[0]);
        int y = Integer.parseInt(inputArr[1]);
        if(x <0 || x>=n || y<0 || y>=n) {
            throw new IllegalArgumentException("Square outside game board");
        }
        if(board[x][y]!=0) {
            throw new IllegalArgumentException("Square is already filled");
        }

        // set move on the board
        board[x][y] = user;
        filledSquares++;
        // Check if this was a winning move;
        boolean winningMoveRow = true, winningMoveCol = true, winningMoveDiag = true, winningMoveRevDiag = true;
        for(int i = 0; i < n; i++) {
            if(board[x][i] != user) {
                winningMoveRow = false;
            }
            if(board[i][y] != user) {
                winningMoveCol = false;
            }
            if( board[i][i] != user) {
                winningMoveDiag = false;
            }
            if(board[i][n-i-1] != user) {
                winningMoveRevDiag = false;
            }
        }

        if (winningMoveRow || winningMoveCol || winningMoveDiag || winningMoveRevDiag) {
            System.out.println("Game won by user " + user);
            printBoard();
            this.gameStatus = 1;
            return;
        }

        if(filledSquares == n*n) {
            System.out.println("Game draw!");
            printBoard();
            this.gameStatus = 2;
            return;
        }

        return;
    }

    void printBoard() {
        for(int i = 0; i < board.length; i++) {
            String r = "";
            for(int j = 0; j < board[0].length; j++) {
                r = r + " " + board[i][j];
            }
            System.out.println(r);
        }
    }


    public static void main(String[] args) {
        int n = 3;
        TicTacToe game = new TicTacToe(n);
        Scanner scanner = new Scanner(System.in);
        int user = 1;
        while(game.isInProgress()) {
            System.out.println("User " + user + " please enter your move [x y] on a "+n+"x"+n+" board. Valid input 0=<x<"+n+" 0=<y<"+n);
            String input = scanner.nextLine();
            try {
                game.makeMove(input, user);
            } catch(IllegalArgumentException e) {
                continue;
            }
            user = -1*user;
        }
        scanner.close();
    }
}