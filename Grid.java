public class Grid
{
    // Write your Grid class here
    private Location[][] grid;

    // Constants for number of rows and columns.    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    public String alpha[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    
    public Grid()
    {
        grid = new Location[NUM_ROWS][NUM_COLS];
        for(int x = 0; x < NUM_ROWS; x++)
        {
            for(int y = 0; y < NUM_COLS; y++)
            {
                grid[x][y] = new Location();
            }
        }
    }
    
    public void markHit(int row, int col)
    {
        grid[row][col].markHit();
    }
    
    public void markMiss(int row, int col)
    {
        grid[row][col].markMiss();
    }
    
    public void setStatus(int row, int col, int status)
    {
        grid[row][col].setStatus(status);
    }
    
    public int getStatus(int row, int col)
    {
        return grid[row][col].getStatus();
    }
    
    public boolean alreadyGuessed(int row, int col)
    {
        return grid[row][col].isUnguessed();
    }
    
    public void setShip(int row, int col, boolean val)
    {
        grid[col][row].setShip(val);
    }
    
    public boolean hasShip(int row, int col)
    {
        return grid[col][row].hasShip();
    }
    
    public Location get(int row, int col)
    {
        return grid[col][row];
    }
    
    public int numRows()
    {
        return NUM_ROWS;
    }
    
    public int numCols()
    {
        return NUM_COLS;
    }
    
    public void printStatus()
    {
        System.out.print(" ");
        
        for(int i = 0; i < NUM_COLS; i++)
        {
            System.out.print((i+1) + " ");
        }
        
        System.out.println("");
        
        for(int y = 0; y < NUM_ROWS; y++)
        {
            System.out.print(alpha[y] + " ");
            
            for(int x = 0; x < NUM_COLS; x++)
            {
                if(grid[x][y].checkHit())
                {
                    System.out.print("X ");
                }
                else if(grid[x][y].checkMiss())
                {
                    System.out.print("O ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
    
    public void printShips()
    {
        for(int i = 0; i < NUM_COLS; i++)
        {
            System.out.print((i+1) + " ");
        }
        
        System.out.println("");
        
        for(int y = 0; y < NUM_ROWS; y++)
        {
            System.out.print(alpha[y] + " ");
            
            for(int x = 0; x < NUM_COLS; x++)
            {
                if(grid[x][y].hasShip())
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
}
