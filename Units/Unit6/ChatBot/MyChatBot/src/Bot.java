/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses contains to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Rahul Shah
 * @version May 2018
 */
class Bot
{
    /**
     * Get a default greeting
     * @return a greeting
     */
    String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    String getResponse(String statement)
    {
        String response;

        if (statement.contains("no") || statement.contains("No")) {
            response = "Why so negative?";
        } else if (statement.contains("Rahul") || statement.contains("rahul")) {
            response = "Yes, Rahul is the ruler of the observable Universe and all Domains thereof.";
        } else if (statement.contains("Kushagr") || statement.contains("Kush")) {
            response = "Kushagr should have added the keywords himself so that he would get something cool said about him. But he didn't!";
        } else if (statement.contains("weather") || statement.contains("sun")) {
            response = "The sun is very hot.";
        } else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")
                || statement.contains("family")
                || statement.contains("relative")) {
            response = "Tell me more about your family.";
        } else if (statement.contains("dog") || statement.contains("cat")) {
            response = "Tell me more about your pets.";
        } else if (statement.contains("Mr.")) {
            response = "He sounds like a good teacher.";
        } else if (statement.trim().length() == 0) {
            response = "Say something, please.";
        } else {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Don't worry about it.";
        }
        else if (whichResponse == 5)
        {
            response = "You should give Rahul Shah one dollar.";
        }
        return response;
    }
}