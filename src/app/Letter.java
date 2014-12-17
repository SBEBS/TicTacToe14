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
public enum Letter 
{
    E(-1, "-"), 
    X(0, "x"), 
    O(1, "o");
    
    private final int value;
    private final String letter;
    
    Letter(int value, String letter)
    {
        this.value = value;
        this.letter = letter;
    }
    public int value()
    {
        return this.value;
    }
    
    public String letter()
    {
        return this.letter;
    }
}
