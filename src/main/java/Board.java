/**********************
 Hambartzum Gamburian
 Board.java
 **********************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Board {
    //Declaring main variables to be used within the class
    private int[][] the_frame;
    private int zeroSpot;
    private File file01;
    Scanner keyboard;

    //Creating default constructor
    public Board() {
        the_frame = new int[5][5];
        zeroSpot = 0;
    } //End of Board() constructor


    //Reading from file "input.txt" into the board - the_frame
    public void readInitialBoard(String fileName) {
        try {
            keyboard = new Scanner(new File("input.txt")); }
        catch(FileNotFoundException e) {
            System.out.println("The \"input.txt\" file is either corrupt or not is not found.");
            return; }
        for (int row = 0; row < the_frame.length; row++) {
            for (int column = 0; column < the_frame[row].length; column++) {
                the_frame[row][column] = keyboard.nextInt();
            }
        }
    } //End of readInitialBoard() method


    //Making moving on the board possible
    public void makeMove(int num) {
        int placeHolder;
        int x = 0, xx = 0;
        int y = 0, yy = 0;

        for (int row = 0; row < the_frame.length; row++) {
            for (int column = 0; column < the_frame[row].length; column++) {
                if (the_frame[row][column] == zeroSpot) {
                    xx = row;
                    yy = column; }

                if (the_frame[row][column] == num) {
                    x = row;
                    y = column; }
            }
        }

        if (((x == (xx + 1)) && (y == yy))
                || ((x == xx) && (y == (yy - 1)))
                || ((x == xx) && (y == (yy + 1)))
                || ((x == (xx - 1)) && (y == yy))) {
            placeHolder = the_frame[xx][yy];
            the_frame[xx][yy] = the_frame[x][y];
            the_frame[x][y] = placeHolder;
        }
        else {
            System.out.println("You are trying to make an invalid move, please try again.");
        }
    } //End of makeMove() method


    //Writing to a file called "output.txt", if it doesn't exists, it creates a new file
    public void writeToFile() throws Exception {
        file01 = new File("output.txt");
        PrintWriter output = new PrintWriter(file01);
        for (int row = 0; row < the_frame.length; row++) {
            for (int column = 0; column < the_frame[row].length; column++) {
                output.print(the_frame[row][column] + " ");
            }
            output.println();
        }
        output.close();
    } //End of writeToFile() method


    //Showing the board to the user
    public void showBoard() {
        for (int row = 0; row < the_frame.length; row++) {
            System.out.println("  |-----------------------------|");
            for (int column = 0; column < the_frame[row].length; column++) {
                if (the_frame[row][column] == 0) {
                    System.out.print("  |   ");
                }
                else {
                    System.out.printf("  |%3d", the_frame[row][column]);
                }
            }
            System.out.print("  |");
            System.out.println();
        }
        System.out.println("  |-----------------------------|");
    } //End of showBoard() method


    //Checking to see if the user completed the game or not
    public boolean isCorrect() {
        if ((the_frame[0][0] == 1) && (the_frame[0][1] == 2) && (the_frame[0][2] == 3) && (the_frame[0][3] == 4) && (the_frame[0][4] == 5)
                && (the_frame[1][0] == 6) && (the_frame[1][1] == 7) && (the_frame[1][2] == 8) && (the_frame[1][3] == 9) && (the_frame[1][4] == 10)
                && (the_frame[2][0] == 11) && (the_frame[2][1] == 12) && (the_frame[2][2] == 13) && (the_frame[2][3] == 14) && (the_frame[2][4] == 15)
                && (the_frame[3][0] == 16) && (the_frame[3][1] == 17) && (the_frame[3][2] == 18) && (the_frame[3][3] == 19) &&  (the_frame[3][4] == 20)
                && (the_frame[4][0] == 21) &&  (the_frame[4][1] == 22) && (the_frame[4][2] == 23) && (the_frame[4][3] == 24) && (the_frame[4][4] == 0))
            return true;
        else {
            return false; }
    } //End of isCorrect() method
} //End of class