/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;

/**
 *
 * @author dtallen97
 */
public class Player
{
    private int score;
    private final Scanner playScan;
    private final Letter letter;
    private final String name;
    
    public Player(Letter letter, String name)
    {
        this.score = 0;
        this.letter = letter;
        this.name = name;
        this.playScan = new Scanner(System.in);
    }
    
    public void win()
    {
        this.score += 1;
    }
    
    public Letter getLetter()
    {
        return this.letter;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public int play()
    {
        return 0;
    }
}
 