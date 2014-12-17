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
public class ComputerPlayer extends Player{
    
    private final ArrayList<Integer> losses;
    
    
    public ComputerPlayer(Letter letter){
        super(letter, "Computer");
        this.losses = new ArrayList<>();
    }
    
    public void lose(Board lossState){
        this.losses.add(lossState.getFlattened());
    }
    
    public boolean checkLosses(Board move){
        return this.losses.contains(move.getFlattened());
    }
}
