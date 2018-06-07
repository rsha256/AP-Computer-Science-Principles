package com.rahul.chatbot.chatbot.feature;

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

        statement = statement.toLowerCase().trim();

        if (statement.contains("no") || statement.contains("tf")) {
            response = "Why so negative?";
        } else if (statement.contains("rahul")) {
            response = "Yes, Rahul is the creator of all.";
        } else if (statement.contains("feeling")) {
            response = "I am feeling fine. How about you?";
        } else if (statement.contains("hello")
                || statement.contains("hi")
                || statement.contains("theo")
                || statement.contains("theodore")) {
            response = "I, Theodore, \ncontrol the observable Universe \nand all Domains thereof.";
        } else if (statement.contains("kushagr") || statement.contains("kush")) {
            response = "Kushagr should have added the keywords himself \nso that he would get something cool said about him. \nBut he didn't!";
        } else if (statement.contains("weather") || statement.contains("time")) {
            response = "The sun isn't very hot because it is still first hour.";
        } else if (statement.contains("mother")
                || statement.contains("father")
                || statement.contains("sister")
                || statement.contains("brother")
                || statement.contains("family")
                || statement.contains("relative")) {
            response = "Tell me more about your family.";
        } else if (statement.contains("dog") || statement.contains("cat") || statement.contains("pet")) {
            response = "Tell me more about your pets.";
        } else if (statement.contains("miller")) {
            response = "He sounds like a good teacher.";
        } else if (statement.contains("why")) {
            response = "Don't ask too many questions.";
        } else if (statement.trim().length() == 0) {
            response = "Say something, please.";
        } else if (statement.contains("I")) {
            response = "It is great to see that you're healthy and well!";
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
            response = "I know what you mean.";
        }
        return response;
    }
}