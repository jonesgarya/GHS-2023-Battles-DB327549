public class Battleship extends ConsoleProgram
{
    public int playerHits = 0;
    public int botHits = 0;
    
    //creates a computer for the player to go against
    Player bot = new Player();
        
    //creates a player for the user to play as
    Player test = new Player();
    
    public void run()
    {
        // Start here! This class should interact with the user
        // to play the game of Battleship
        
        // You only need to allow for the user to set up each player's
        // ships and for each player to make a guess on the other player's grid
        // Don't worry about finishing the whole game yet.
        
        // You will probably need to make additions to the Player class to
        // allow for this setting up and guessing
        
        // Asks the player where they want their ships to be
        test.askShips();
        
        // Creates a random board for the bot to use
        bot.createBot();
        
        System.out.println("\033[2J");
        
        game();
    }
    
    public void game()
    {
        while(playerHits != 17 || botHits != 17)
        {
            if(playerHits == 17)
            {
                System.out.println("Players wins!");
                break;
            }
            else if(botHits == 17)
            {
                System.out.println("Bot wins!");
                break;
            }
            bot.printBoard();
            String playerRowGuess = readLine("Enter a row guess(A-J): ");
            int playerColGuess = readInt("Enter a column guess(1-10): ");
            
            //converts the string entered for the
            //row int a character.
            char playerRowChar = playerRowGuess.charAt(0);
            
            //Converts the row character into a row 
            //number using the keyboard ascii characters
            int rowToInt = ((int)playerRowChar)-64;
            
            if(bot.playerGuessResult(rowToInt, playerColGuess) == true)
            {
                System.out.println("It's a hit!");
                playerHits++;
                bot.printBoard();
            }
            else
            {
                System.out.println("It's a miss");
                bot.printBoard();
            }
        }
    }
}
