public class Ship
{
    //direction variables
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    
    private int row;
    private int col;
    private int length;
    private int direction;
    
    public Ship(int length)
    {
        this.length = length;
        row = UNSET;
        col = UNSET;
        length = UNSET;
        direction = UNSET;
    }
    
    public boolean isLocationSet()
    {
        if(row == UNSET || col == UNSET)
        {
            return false;
        }
        return true;
    }
    
    public boolean isDirectionSet()
    {
        if(direction != UNSET)
        {
            return true;
        }
        return false;
    }
    
    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    public int getRow()
    {
        return row;
    }
    
    public int getCol()
    {
        return col;
    }
    
    public int getLength()
    {
        return length;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    private String directionToString()
    {
        if(direction == UNSET)
        {
            return "unset.";
        }
        else if(direction == HORIZONTAL)
        {
            return "horizontal.";
        }
        return "vertical.";
    }
    
    public String toString()
    {
        return "The ship is at row " + row + " and column " + col + " with a length of " + length + " facing " + directionToString();
    }
}
