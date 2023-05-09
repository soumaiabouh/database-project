/**
 * Class: ConsoleMessage: Unify messages in this message toolkit.
 *        The idea is to keep messaging in the same place for future update.
 *
 * @author Felicia Sun
 * @version 1.0.0.0
 * -- 2023-03-13 --
 *
 */

public class ConsoleMessage {
    /**
     *
     * @param in_string
     */
    private static void message(String in_string) {
        System.out.println(in_string);
    }

    public static void error(String in_string) {
        message("Error: " + in_string);
    }

    public static void warning(String in_string) {
        message("Warning: " + in_string);
    }

    public static void info(String in_string) {
        message(/* "Info:  " + */ in_string);
    }

    public static void debug(String in_string) {
        // message("Debug: " + in_string);
    }

}
