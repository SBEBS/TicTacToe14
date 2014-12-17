/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package app.cli;
import app.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alex
 */
public class Game 
{
    private final Player player1;
    private final Player player2;
    private final Scanner scan;
    private Board gameBoard;
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
            
            try
            {
                nextTurn();
            }
            catch (InterruptedException ex) 
            {
                System.exit(1);
            }
        }
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
    
    public void quit()
    {
        this.scan.close();
    }
}
