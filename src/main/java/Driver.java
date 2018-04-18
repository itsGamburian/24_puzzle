/**********************
 Hambartzum Gamburian
 Driver.java
 **********************/

import java.util.Scanner;
import java.io.File;

public class Driver {
    public static void main(String [] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        Board brd = new Board();
        String action;
        File file02 = new File("input.txt");

//Reading file
        if(file02.exists()) {
            brd.readInitialBoard("input.txt"); }

        System.out.println("Enjoy the Puzzle! \nLoading the game from \"input.txt\"... \nPlay On!");

//Displaying board
        brd.showBoard();

//Checking to see if game is completed or not
        while(true) {
            if (brd.isCorrect()) {
                System.out.println("You won the game! Good Job!");
                break;
            }

            System.out.println("Enter a command or enter \"help\" to see valid commands.");
            action = keyboard.next();

//Creating user commands
            switch(action) {
                case "move": brd.makeMove(keyboard.nextInt()); brd.isCorrect(); brd.showBoard(); brd.writeToFile(); break;
                case "quit": System.out.println("Quitting game."); brd.writeToFile(); System.exit(1); break;
                case "help": System.out.println("This is your current board:"); brd.showBoard();
                    System.out.println("The valid commands are: \nmove #: Moves the square number into the empty spot. \nhelp: Lists the available valid commands. \nquit: Does exactly what it says, exits the game."); brd.writeToFile(); break;
                default: System.out.println("Enter a command or enter \"help\" to see valid commands."); break;
            } //End of switch statement
        } //End of while loop
    } //End of main method
} //End of class