package org.example;

import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;
@Setter
@Getter
public class MazeGame {
    private static final char STOP = 'B';
    private static final char EMPTY = '.';
    private static final char OBSTACLE = 'X';

    private char[][] board;
    private int rows;
    private int cols;
    private int startRow;
    private int startCol;
    private int stopRow;
    private int stopCol;

    private int playerRow;
    private int playerCol;

    public MazeGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new char[rows][cols];
        initializeBoard();
        this.playerRow = startRow;
        this.playerCol = startCol;
    }


    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void generateMaze() {
        stopRow = 4;
        stopCol = 4;

        board[stopRow][stopCol] = STOP;
        board[1][2] = OBSTACLE;
        board[0][0] = OBSTACLE;
        board[4][3] = OBSTACLE;
        board[3][3] = OBSTACLE;
        board[2][1] = OBSTACLE;
    }
    public void displayMazeWithPlayer() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("P ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public void moveLeft() {
        if (playerCol - 1 >= 0 && board[playerRow][playerCol - 1] != OBSTACLE) {
            board[playerRow][playerCol] = EMPTY;
            playerCol--;
        } else {
            System.out.println("Wrong direction, choose another way!");
        }
    }

    public void moveRight() {
        if (playerCol + 1 < cols && board[playerRow][playerCol + 1] != OBSTACLE) {
            board[playerRow][playerCol] = EMPTY;
            playerCol++;
        } else {
            System.out.println("Wrong direction, choose another way!");
        }
    }

    public void moveUp() {
        if (playerRow - 1 >= 0 && board[playerRow - 1][playerCol] != OBSTACLE) {
            board[playerRow][playerCol] = EMPTY;
            playerRow--;
        } else {
            System.out.println("Wrong direction, choose another way!");
        }
    }

    public void moveDown() {
        if (playerRow + 1 < rows && board[playerRow + 1][playerCol] != OBSTACLE) {
            board[playerRow][playerCol] = EMPTY;
            playerRow++;
        } else {
            System.out.println("Wrong direction, choose another way!");
        }
    }


    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        char direction;

        do {
            displayMazeWithPlayer();
            System.out.print("Enter direction (L - left, R - right, U - up, D - down, Q - quit): ");
            direction = scanner.next().toUpperCase().charAt(0);

            switch (direction) {
                case 'L':
                    moveLeft();
                    break;
                case 'R':
                    moveRight();
                    break;
                case 'U':
                    moveUp();
                    break;
                case 'D':
                    moveDown();
                    break;
                case 'Q':
                    System.out.println("Game Over. Quitting...");
                    break;
                default:
                    System.out.println("Invalid direction. Try again.");
            }

        } while (direction != 'Q' && (playerRow != stopRow || playerCol != stopCol));

        if (playerRow == stopRow && playerCol == stopCol) {
            System.out.println("Congratulations! You reached the destination!");
        }
    }

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame(5, 5);
        mazeGame.generateMaze();
        mazeGame.playGame();
    }
}