public class Player extends ConsoleProgram
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public int playerDirection;
    public Grid playerGrid = new Grid();
    public int index;
    public int botIndex;
    
    private int botRowValue;
    private int botColValue;
    private int botDirValue;
    
    public Grid botGrid = new Grid();
    
    // These are the lengths of all of the ships.
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    
    // Write your Player class here
    
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        
        //checks if the ship selected collides with an
        //already existing ship
        if(checkShips(s, playerGrid) == false)
        {
            System.out.println("Invalid placement.");
            index--;
        }
        else
        //adds the ship to the grid and board
        {
            playerGrid.addShip(s);
            playerGrid.printShips();
        }
    }
    
    public void chooseBotLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        
        //checks if the ship selected collides with an
        //already existing ship
        if(checkShips(s, botGrid) == false)
        {
            botIndex--;
        }
        else
        //adds the ship to the grid and board
        {
            botGrid.addShip(s);
            botGrid.printShips();
        }    
    }
    
    public void askShips()
    {
        index = 0;
        playerGrid.printShips();
        
        while(index != SHIP_LENGTHS.length)
        {
            //Starts asking the user for location information
            String askRow = readLine("Place the ship of " + SHIP_LENGTHS[index] + " on a row (A-J).");
            int askCol = readInt("Now place the ship of " + SHIP_LENGTHS[index] + " on a col (1-10).");
            String askDir = readLine("(H)orizontal (L-R) or (v)ertical? (T-B) ");
            
            String playerDir = askDir.toLowerCase();
            
            String playerRow = askRow.toUpperCase();
            
            //converts the string entered for the row
            //int a character.
            char playerRowChar = playerRow.charAt(0);
            
            //Converts the row character into a row 
            //number using the keyboard ascii characters
            int rowToInt = ((int)playerRowChar)-64;
            
            //Converts the string used for direction into an integer
            // which means either VERTICAL or HORIZONTAL.
            if(playerDir.equals("horizontal") || playerDir.equals("h"))
            {
                playerDirection = HORIZONTAL;
            }
            else if(playerDir.equals("vertical") || playerDir.equals("v"))
            {
                playerDirection = VERTICAL;
            }
            //Using the user input info, the program
            //creates a new ship for the grid and 
            //creates the ship using the constructor
            chooseShipLocation(new Ship(SHIP_LENGTHS[index]), rowToInt, askCol, playerDirection);
            index++;
        }
    }
    
    public void createBot()
    {
        botIndex = 0;
        String initialize = readLine("Hit enter to create an opponent.");
        
        if(initialize.equals(""))
        {
            while(botIndex != SHIP_LENGTHS.length)
            {
                botRowValue = Randomizer.nextInt(1, 10);
                botColValue = Randomizer.nextInt(1, 10);
                botDirValue = Randomizer.nextInt(HORIZONTAL, VERTICAL);
               
                chooseBotLocation(new Ship(SHIP_LENGTHS[botIndex]), botRowValue, botColValue, botDirValue);
                botIndex++;
            }
        }
    }
    
    public void printBoard()
    {
        botGrid.printStatus();
    }
    
    public boolean playerGuessResult(int row, int col)
    {
        if(botGrid.hasShip(row-20, col-10) == true)
        {
            botGrid.markHit(row, col);
            return true;
        }
        botGrid.markMiss(row, col);
        return false;
    }
    
    //lines from here are ship checkers
    public boolean checkShips(Ship s, Grid g)
    {
        //Uses the addShip() method from Grid.java to scan for
        //signs of the ship using the hasShip() method.
        
        //returns false if there is a ship in the direction of the
        //ship being placed 
        
        //returns true if there is not a ship in the direction of the
        // ship being placed.
        if(s.getDirection() == VERTICAL)
        {
            //Checks for ships in the direction of the ship being
            //placed in a vertical direction
            for(int y = s.getRow(); y < (s.getLength() + s.getRow()); y++)
            {
                if(g.hasShip(y-1, s.getCol()-1) == true || (y-1) + s.getLength()-1 >= g.numRows()+1)
                {
                    return false;
                }
            }
        }
        else
        {
            //Checks for already existing ships placed if
            //the ship being placed is facing horizontally.
            for(int x = s.getCol(); x < (s.getLength() + s.getCol()); x++)
            {
                if(g.hasShip(s.getRow()-1, x-1) == true || (x-1) + s.getLength()-1 >= g.numRows()+1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
