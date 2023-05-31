public class Player extends ConsoleProgram
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    public int playerDirection;
    public Grid playerGrid = new Grid();
    
    // These are the lengths of all of the ships.
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    
    // Write your Player class here
    
    public void chooseShipLocation(Ship s, int row, int col, int direction)
    {
        s.setLocation(row, col);
        s.setDirection(direction);
        
        playerGrid.addShip(s);
        playerGrid.printShips();
    }
    
    public void askShips()
    {
        playerGrid.printShips();
        
        for(int i = 0; i < SHIP_LENGTHS.length; i++)
        {
            String askRow = readLine("Place the ship of " + SHIP_LENGTHS[i] + " on a row (A-J).");
            int askCol = readInt("Now place the ship of " + SHIP_LENGTHS[i] + " on a col (1-10).");
            String askDir = readLine("Horizontal or vertical?");
            
            String playerDir = askDir.toLowerCase();
            
            String playerRow = askRow.toUpperCase();
            
            char playerRowChar = playerRow.charAt(0);
            
            int rowToInt = ((int)playerRowChar)-64;
            
            if(playerDir.equals("horizontal"))
            {
                playerDirection = HORIZONTAL;
            }
            else if(playerDir.equals("vertical"))
            {
                playerDirection = VERTICAL;
            }
            
            chooseShipLocation(new Ship(SHIP_LENGTHS[i]), rowToInt, askCol, playerDirection);
        }
    }
}
