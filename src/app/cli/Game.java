/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package app.cli;

import app.*;
import java.util.Scanner;

/**
 *
 * @author dtallen97
 */
public class Game 
{
    private final Player player1;
    private final Player player2;
    private final Scanner scan;
    private final Board gameBoard;
    private Player currentPlayer;
    
    
    public Game()
    {
        this.scan = new Scanner(System.in);
        this.gameBoard = new Board();
        
        System.out.print("What would you like your name to be? ");
        String name = this.scan.next();
        
        System.out.print("What would you like your letter to be? ");
        String letter = this.scan.next();
        
        if(letter.equalsIgnoreCase("o")) 
        {
            this.player1 = new Player(Letter.O, name);
            this.player2 = new ComputerPlayer(Letter.X);
        }
        else
        {
            this.player1 = new Player(Letter.X, name);
            this.player2 = new ComputerPlayer(Letter.O);
        }
    
    }
    
    public void run()
    {
        boolean playing = true;
        while (playing)
        {
            int play = currentPlayer.play();
            gameBoard.recordMove(currentPlayer.getLetter(), play);
            System.out.println(gameBoard.toString());
            
            if(gameBoard.checkWin()) 
            {
                currentPlayer.win();
                
                try
                {
                    playing = newGame();
                    gameBoard.resetBoard();
                }
                catch (IllegalArgumentException ex)
                {
                    System.out.println("That is not an option. Try again!");
                    playing = newGame();
                }
            }
            else
            {
                try
                {
                    nextTurn();
                }
                catch (InterruptedException ex) 
                {
                    System.out.println("Wait your turn!");
                }
            }
        }
        System.out.println("Thanks for playing! See you next time!");
        quit();
    }
    
    public void nextTurn() throws InterruptedException
    {
        if(!(currentPlayer instanceof ComputerPlayer))
            {
                currentPlayer = player2;
                System.out.println("The computer is playing...");
                Thread.sleep(3000);
            }
            else
            {
                currentPlayer = player1;
                System.out.println("Your turn!");
            }
    }
    
    public boolean newGame() throws IllegalArgumentException
    {
        if(this.currentPlayer.equals(this.player1))
            System.out.println("YOU WIN!");
        else
            System.out.println("YOU LOSE!");
        
        System.out.print("Would you like to play again? (yes/no)");
        String option = this.scan.next();
        
        if(option.equalsIgnoreCase("yes"))
            return true;
        else if(option.equalsIgnoreCase("no")) 
            return false;
        else
            throw new IllegalArgumentException("Option not valid.");
    }
    
    public void quit()
    {
        this.scan.close();
    }
}
