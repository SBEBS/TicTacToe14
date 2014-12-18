/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author dtallen97
 */
public class Board 
{
    private Letter[] grid;
    
    public Board()
    {
        this.grid = new Letter[9];
        for(Letter letter: grid)
            letter = Letter.E;
    }
    
    @Override
    public String toString()
    {
        String gridString = "";
        
        for(int i = 0; i < grid.length; i++)
        {
            if(i % 3 == 0)
                gridString += "\n";
            gridString += grid[i];
        }
        
        return gridString;
    }
    
    public String flattened()
    {
        String result = "";
        
        for(Letter letter: grid)
            result += letter.value();
        
        return result;
    }
    
    private boolean isLegalMove(int pos)
    {
        if(pos >= 0 && pos <= 8) 
            return (this.grid[pos] == null);
        else 
            return false;
    }
    
    public void recordMove(Letter current, int pos) throws IllegalArgumentException
    {
        if(this.isLegalMove(pos))
            this.grid[pos] = current;
        else 
            throw new IllegalArgumentException("Position not legal.");
    }
    
    public boolean checkWin()
    {
        //rows
        for (int i = 0; i < 9; i += 3) 
            if (grid[i] == grid[i + 1] && grid[i] == grid[i + 2]) 
                return true;
        
        // columns
        for (int i = 0; i < 3; i++) 
            if (grid[i] == grid[i + 3] && grid[i] == grid[i + 6]) 
                return true;
    
        // diagonals
        return grid[2] == grid[4] && grid[2] == grid[6] 
            || grid[0] == grid[4] && grid[0] == grid[8];
    }
    
    public void resetBoard()
    {
        for(Letter letter: grid)
            letter = Letter.E;
    }
}
