import java.util.Scanner;

/**
 *
 * To identify a website: query all text on the business card for the following format:
   “https://______.___ “ or “http://______.___ “
        each underscore ("______") represents alphanumeric text
        there should be at least 1 period in the website at some point to signify the website's domain
 *
 * To identify an email address: query all text on the business card for the following format:
 “ _______@_______.___ “
 	each underscore ("______") represents alphanumeric text
 	no spaces or line breaks are allowed for this query
	There should be an '@' symbol and a '.' at some point if the String is a email
 *
 * To identify a phone number: query all text on the business card for the following format:
   “__________“
        each underscore ("_") represents one number
        no spaces or line breaks are allowed for this query
        The length has to be 10 digits of numbers - no other characters
 *
 * To identify a fax number: query all text on the business card for the following format:
   “__________“
        each underscore ("_") represents one number
        no spaces or line breaks are allowed for this query
        The length has to be at least 10 digits of numbers - no other characters
 *
 * To identify a State: query all text on the business card for the following format:
   “__“
        each underscore ("__") represents one letter (no other characters)
        no spaces or line breaks are allowed for this query
 *
 * To identify a Postal Code: query all text on the business card for the following format:
   “_____“
        each underscore ("_") represents one number (no other characters) for a total of 5 numbers
        no spaces or line breaks are allowed for this query
 *
 * To identify a Postal Code: query all text on the business card for the following format:
   “_____“
        each underscore ("_") represents one number (no other characters) for a total of 5 numbers
        no spaces or line breaks are allowed for this query
 *
 * To identify a Name: query all text on the business card for the following format:
   “_____“
        each underscore ("_") represents a letter
        no spaces or line breaks are allowed for this query
 *
 */

public class DigitizingBusinessCards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input String:");
        String attribute = input.nextLine();

        System.out.println(findType(attribute));
    }

    private static String findType(String att) {
        if ((att.startsWith("http://")) || (att.startsWith("https://")) || (att.indexOf('.') >= 0)) {
            return "Website";
        }
        if ((att.indexOf('@') >= 0) && (att.indexOf('.') >= 0)) {
            return "Email";
        }
        if ((att.length() == 10) && (onlyContainsNumbers(att))) {
            return "Phone Number";
        }
        if ((att.length() >= 10) && (onlyContainsNumbers(att))) {
            return "Fax Number";
        }
        if ((!onlyContainsNumbers(att)) && (att.length() == 2)) {
            return "State";
        }
        if ((onlyContainsNumbers(att)) && (att.length() == 5)) {
            return "Postal Code";
        }
        if (!onlyContainsNumbers(att)) {
            return "Name";
        }
        return "Couldn't determine";
    }

    private static boolean onlyContainsNumbers(String text) {
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
