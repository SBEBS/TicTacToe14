/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author alex
 */
public class Player {
    private int score;
    private final Letter letter;
    private final String name;
    
    public Player(Letter letter, String name){
        this.score = 0;
        this.letter = letter;
        this.name = name;
    }
    
    public void win(){
        this.score += 1;
    }
    
    public int getScore(){
        return this.score;
    }
}
 