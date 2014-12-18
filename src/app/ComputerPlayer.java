/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.ArrayList;

/**
 *
 * @author dtallen97
 */
public class ComputerPlayer extends Player
{  
    private final ArrayList<String> losses;
    private Board lastMove;
    
    public ComputerPlayer(Letter letter)
    {
        super(letter, "Computer");
        this.losses = new ArrayList<>();
        this.lastMove = new Board();
    }
    
    @Override
    public int play()
    {
        return 0;
    }
    
    public void lose()
    {
        this.losses.add(lastMove.flattened());
    }
    
    public boolean checkLosses(Board move)
    {
        return this.losses.contains(move.flattened());
    }
}
