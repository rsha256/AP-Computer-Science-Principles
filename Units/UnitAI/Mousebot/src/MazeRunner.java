import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class MazeRunner {

    public static void main(String args[]) {
        BufferedReader in;
        Scanner fileScanner;
        try
        {
            in = new BufferedReader( new FileReader("m1.txt") );
            fileScanner = new Scanner( in );
            while ( fileScanner.hasNext() )
            {
                String n = fileScanner.next();
                char[] cArray = n.toCharArray();
            }
            in.close();
        }
        catch ( Exception e )
        {
            System.out.println( "Exception thrown!" );
            e.printStackTrace();
        }

        char[][] m = {
                { '*', ' ', '*', '*', '*', '*', '*', '*', '*' },
                { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
                { '*', ' ', '*', '*', '*', '*', '*', ' ', '*' },
                { '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', ' ', '*', '.', '*', '*', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

        // this one is impossible
        char[][] m2 = {
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' },
                { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
                { '*', ' ', '*', '*', '*', '*', '*', ' ', '*' },
                { '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', ' ', '*', '.', '*', '*', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

        // has 2 exits
        char[][] m3 = {
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' },
                { ' ', ' ', ' ', ' ', ' ', ' ', '.', ' ', '*' },
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' },
                { '*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', ' ', ' ', ' ', '*', '*', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
                { '*', '*', '*', ' ', '*', ' ', '*', ' ', '*' },
                { '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
                { '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

        Maze maze = new Maze(m3, 4, 3);
        if (maze.findExit())
            System.out.println("There is an exit at ("
                    + maze.getIExit() + ", "
                    + maze.getJExit() + ")");
        else
            System.out.println("No exit was found");

        System.out.println();
        System.out.println();
        maze.display();
        System.out.println("Steps:" + maze.getSteps());

    }



}