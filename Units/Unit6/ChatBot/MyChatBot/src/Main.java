import java.util.Scanner;

/**
 * A simple class to run the Bot class.
 * @author Rahul Shah
 * @version April 2012
 */
public class Main
{

    /**
     * Create a Bot, give it user input, and print its replies.
     */
    public static void main(String[] args)
    {
        Bot theo = new Bot();

        System.out.println (theo.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();

        while (!statement.equals("Bye"))
        {
            System.out.println (theo.getResponse(statement));
            statement = in.nextLine();
        }
    }

}