/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class ComputerPlayer extends Player
{
    
    private final ArrayList<String> losses;
    
    
    public ComputerPlayer(Letter letter)
    {
        super(letter, "Computer");
        this.losses = new ArrayList<>();
    }
    
    public void lose(Board lossState)
    {
        this.losses.add(lossState.flattened());
    }
    
    public boolean checkLosses(Board move)
    {
        return this.losses.contains(move.flattened());
    }
}
