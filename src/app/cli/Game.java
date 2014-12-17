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
 * @author alex
 */
public class Game 
{
    private final Player player1;
    private final Player player2;
    private final Board gameBoard;
    private final Scanner scan;
    
    
    public Game()
    {
        this.scan = new Scanner(System.in);
        this.gameBoard = new Board();
        
        System.out.print("What would you like your name to be? ");
        String name = this.scan.next();
        
        System.out.print("What would you like your letter to be? ");
        String letter = this.scan.next();
        
        if(letter.equalsIgnoreCase("o")) {
            this.player1 = new Player(Letter.O, name);
            this.player2 = new ComputerPlayer(Letter.X);
        }
        else{
            this.player1 = new Player(Letter.X, name);
            this.player2 = new ComputerPlayer(Letter.O);
        }
    
    }
    
    public void quit()
    {
        this.scan.close();
    }
}
