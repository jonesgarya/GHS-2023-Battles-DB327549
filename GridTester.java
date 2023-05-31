public class GridTester extends ConsoleProgram
{
    public void run()
    {
        // Your test code here.
        Grid grid1 = new Grid();
        grid1.printStatus();
        System.out.println();
        
        grid1.markMiss(0,0);
        grid1.markMiss(1,1);
        grid1.markMiss(2,2);
        grid1.markMiss(7,7);
        grid1.markMiss(8,8);
        grid1.markMiss(9,9);
        grid1.markHit(1,6);
        grid1.markHit(2,6);
        
        grid1.printStatus();
        System.out.println();
        
        Grid grid2 = new Grid();
        grid2.setShip(5,1,true);
        grid2.setShip(5,2,true);
        grid2.setShip(5,3,true);
        grid2.printShips();

    }
}
