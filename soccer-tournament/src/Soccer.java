/**
 * Class: Soccer - Java application for managing a simulated soccer tournament database. 
 *                 All tables must first be created and populated before running the application. 
 *                 The url, userid and password must also be initialized in main. 
 *
 * @author Felicia Sun and Soumaia Bouhouia
 * @version 1.0.0.0
 * -- 2023-03-13 --
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;

import static java.lang.System.currentTimeMillis;

public class Soccer {
    static boolean done = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Date addDaysToDate(Date date, int days) {
        return Date.valueOf(date.toLocalDate().plusDays(days));
    }

    public static void mainMenu(Statement statement) throws IOException, SQLException {
        while (!done) {
            ConsoleMessage.info("Soccer Main Menu\n" +
                    "   1. List information of matches of a country\n" +
                    "   2. Insert initial player information for a match\n" +
                    "   3. Scoring information for each country\n" +
                    "   4. Exit application\n" +
                    "Please Enter Your Option:");
            String option = br.readLine();
            Soccer soccer = new Soccer();
            soccer.handleCase(Integer.parseInt(option), statement);
        }
    }

    /**
     * Helper function for mainMenu. Handles each case by calling the appropriate functions.
     *
     * @param option the option (1-4) chosen by the user.
     * @param statement used for the sql queries.
     * @throws IOException
     * @throws SQLException
     */
    public void handleCase(int option, Statement statement) throws IOException, SQLException {
        ConsoleMessage.debug("User chose: " + option);
        // 1. List information of matches of a country
        if (option == 1) {
            ConsoleMessage.debug("switch case 1");
            listMatchInformation(statement);
        }
        // 2. Insert initial player information for a match
        else if (option == 2) {
            ConsoleMessage.debug("switch case 2");
            insertPlayerInformation(statement);
        }
        // 3. For you to design
        else if (option == 3) {
            ConsoleMessage.debug("switch case 3");
            scoringInformation(statement);
        }
        // 4. Exit application
        // TODO: properly close the database connection and quit.
        else if (option == 4) {
            ConsoleMessage.debug("switch case 4");
            done = true;
        }
    }

    /**
     * Option 1: Takes user input of a country and lists the match information of that country.
     * Afterwards, user can either choose [A] to stay in the loop or [P] to leave the loop and return to the Main Menu.
     *
     * @param statement used to read the SQL
     * @throws IOException
     * @throws SQLException
     */
    public void listMatchInformation(Statement statement) throws IOException, SQLException {

        while (true) {
            // When the user selects this option, the program should ask the user to enter a country name
            ConsoleMessage.info("List information of matches of a country \n" +
                    "Please Enter A Country:");
            String in_country = br.readLine();
            //ConsoleMessage.debug("User chose " + in_country);

            String query = "SELECT teams1, teams2, DATE, ROUND,\n" +
                    "       CASE WHEN LENGTH = '00:00:00' THEN NULL ELSE GoalsTeam1 END AS GoalsTeam1,\n" +
                    "       CASE WHEN LENGTH = '00:00:00' THEN NULL ELSE GoalsTeam2 END AS GoalsTeam2,\n" +
                    "       TSOLD\n" +
                    "FROM (SELECT teams1, teams2, DATE, ROUND, GoalsTeam1, GoalsTeam2, TSOLD, LENGTH\n" +
                    "      FROM (\n" +
                    "               SELECT team1goals.COUNTRY as teams1, team2goals.COUNTRY as teams2, team1goals.GoalsTeam1, team2goals.GoalsTeam2, team1goals.MID\n" +
                    "               FROM (\n" +
                    "                        SELECT TEAM1.COUNTRY, TEAM1.mid, COUNT(G.COUNTRY) as GoalsTeam1\n" +
                    "                        FROM TEAM1\n" +
                    "                                 LEFT JOIN GOALS G on TEAM1.mid = G.mid AND TEAM1.COUNTRY = G.COUNTRY\n" +
                    "                        group by TEAM1.COUNTRY, TEAM1.mid\n" +
                    "                    ) as team1goals\n" +
                    "                        LEFT JOIN (SELECT TEAM2.COUNTRY, TEAM2.mid, COUNT(G.COUNTRY) as GoalsTeam2\n" +
                    "                                   FROM TEAM2 LEFT JOIN GOALS G on TEAM2.mid = G.mid AND TEAM2.COUNTRY = G.COUNTRY\n" +
                    "                                   group by TEAM2.COUNTRY, TEAM2.mid\n" +
                    "               ) as team2goals ON team1goals.MID = team2goals.MID ) as tablegoals\n" +
                    "               LEFT JOIN MATCHES ON MATCHES.MID = tablegoals.MID\n" +
                    "         ) ;";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("----------------------------------------------------------------------------------------------------");
            String a = "TEAMS1"; String b = "TEAMS2"; String c = "DATE"; String d = "ROUND"; String e = "GOALS-TEAM1"; String f = "GOALS-TEAM2"; String g = "TSOLD";
            System.out.format("%-15s %-15s %-10s %5s %15s %15s %15s %n", a , b, c, d, e, f, g);
            System.out.println("----------------------------------------------------------------------------------------------------");
            //ConsoleMessage.info("teams1" + " teams2" + " date" + " round" + " GoalsTeam1" + " GoalsTeam2");
            while (rs.next()) {
                String teams1 = rs.getString("teams1");
                String teams2 = rs.getString("teams2");
                Date date = rs.getDate("date");
                int round = rs.getInt("round");
                String goals1 = rs.getString("GoalsTeam1");
                if (rs.wasNull()) {
                    goals1 = "NULL";
                }
                String goals2 = rs.getString("GoalsTeam2");
                if (rs.wasNull()) {
                    goals2 = "NULL";
                }
                int tsold = rs.getInt("tsold");
                if ((teams1.equals(in_country)) || (teams2.equals(in_country))) {
                    System.out.format("%-15s %-15s %-10s %5d %15s %15s %15s %n", teams1, teams2, date, round, goals1, goals2, tsold);
                    //ConsoleMessage.info(teams1 + " " + teams2 + " " + date + " " + round + " " + goals1 + " " + goals2);
                }
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
            rs.close();

            ConsoleMessage.info("Enter [A] to find matches of another country, [P] to go to the previous menu: ");
            String option1 = br.readLine();
            if (option1.equals("P") || option1.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            } else if (option1.equals("A") || option1.equals("a")) {
                ConsoleMessage.debug("User chose A. Wishes to find matches of another country.");
            } else {
                ConsoleMessage.debug("Incorrect input. Will act as though user chose A.");
            }
        }
        mainMenu(statement);
    }

    public void insertPlayerInformation(Statement statement) throws SQLException, IOException {
        while (true) {
            ConsoleMessage.info("Welcome to the menu for inserting the initial player information!");
            ConsoleMessage.info("Here, you may add players to matches happening in the next 3 days.");

            // 1: Get matches in next 3 days
            getMatchesThreeDaysFromNow(statement);

            //TODO: display unregistered players.
            //TODO: Split code for this function into different functions.
            //TODO: let user choose which player to insert.

            // 2:the system should request the user to input the match identifier and for which country the insert should be made.
            // Once the user has entered match identifier and country, the system will print all the players of that country
            // that are already registered to play in this match. This list could be empty. Furthermore, it should list all
            // players of the team that have not yet been selected.

            // Get mid and country from user. Those are the mid and country for which the insert should be made.

            ConsoleMessage.info("\nPlease enter the mid for which the insert should be made or [P] to go to the previous menu.");
            String input = br.readLine();
            if (input.equals("P") || input.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            }
            int in_mid = Integer.parseInt(input);
            ConsoleMessage.debug("User chose " + in_mid);

            ConsoleMessage.info("Please enter the country for which the insert should be made or [P] to go to the previous menu.");
            String in_country = br.readLine();
            if (in_country.equals("P") || in_country.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            }
            ConsoleMessage.debug("User chose " + in_country);

            // Print all players that are already registered to play in this match.
            int player_count = getRegisteredPlayers(statement, in_mid, in_country);

            // Print all players not registered for this match
            getNonRegisteredPlayers(statement, in_country);

            // 3: Insert player

            // ask for player snumber
            ConsoleMessage.info("Enter the number of the player you want to insert or [P] to go to the previous menu.");
            String player_number_input = br.readLine();
            if (player_number_input.equals("P") || player_number_input.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            }
            int player_number = Integer.parseInt(player_number_input);
            ConsoleMessage.debug("User chose " + player_number);

            // ask for position to give to that player
            ConsoleMessage.info("Enter the position of the player you want to insert or [P] to go to the previous menu.");
            String player_position = br.readLine();
            if (player_position.equals("P") || player_position.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            }
            ConsoleMessage.debug("User chose " + player_position);


            insertPlayer(statement, player_number, in_mid, player_position, in_country, player_count);
            // print those again before returning to main menu
            getRegisteredPlayers(statement, in_mid, in_country);
            getNonRegisteredPlayers(statement, in_country);
            break;
        }



        // TODO: The program should also ensure that always only 11 players of a team are selected for a match, i.e., the
        // user should not be able to insert more than 11 players of the same country for a match.
    }

    /**
     * Helper function for option 1. This is the 1st function to be called.
     * @param statement
     * @throws SQLException
     */
    public void getMatchesThreeDaysFromNow(Statement statement) throws SQLException {
        Date current_date = Date.valueOf(LocalDate.now());
        Date last_date =  addDaysToDate(current_date, 3);
        java.sql.Time current_time = new java.sql.Time(currentTimeMillis());

        //ConsoleMessage.info("");
        ConsoleMessage.info("\nCurrent date and time is " + current_date + " and " + current_time + ".");
        ConsoleMessage.info("In three days it will be " + last_date + " and " + current_time + ".");
        //ConsoleMessage.info("");
        ConsoleMessage.info("\nListing all matches in the next 72 hours:");
        String query1 = "SELECT allteams.MID, teams1, teams2, DATE, TIME, ROUND\n" +
                "FROM (SELECT TEAM1.MID, TEAM1.COUNTRY as teams1, T.COUNTRY as teams2\n" +
                "      FROM TEAM1 JOIN TEAM2 T on TEAM1.MID = T.MID) as allteams\n" +
                "         LEFT JOIN MATCHES ON MATCHES.MID = allteams.MID;";

        ResultSet rs1 = statement.executeQuery(query1);
        String a = "MID"; String b = "TEAMS1"; String c = "TEAMS2"; String d = "DATE"; String e = "START-TIME"; String f = "ROUND";
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.format("%-10s %-15s %-15s %-15s %-15s %-15s %n", a , b, c, d, e, f);
        System.out.println("--------------------------------------------------------------------------------------");
        //ConsoleMessage.info("mid" + " team1" + " team2" + " date" + " start-time" + " round");
        while (rs1.next()) {
            int mid = rs1.getInt("mid");
            String teams1 = rs1.getString("teams1");
            String teams2 = rs1.getString("teams2");
            Date date = rs1.getDate("date");
            Time time = rs1.getTime("time");
            int round = rs1.getInt("round");
            // either that row's date is before last_date, or it's equal to last_date but the time is earlier.
            if ((last_date.compareTo(date) > 0) || (last_date.compareTo(date) > 0 && current_time.compareTo(time) >= 0)) {
                System.out.format("%-10s %-15s %-15s %-15s %-15s %-15s %n", mid, teams1, teams2, date, time, round);
                //ConsoleMessage.info(mid + " " + teams1 + " " + teams2 + " " + date + " " + time + " " + round);
            } /* else {
                ConsoleMessage.debug("false " + mid + " " + teams1 + " " + teams2 + " " + date + " " + time + " " + round);
            } */
        }
        System.out.println("--------------------------------------------------------------------------------------");
        rs1.close();
    }

    /**
     * Helper function for option 2. This is the 2nd function to be called.
     * @param statement
     * @param in_mid
     * @param in_country
     * @return number of players registered in this match
     * @throws SQLException
     */
    public int getRegisteredPlayers(Statement statement, int in_mid, String in_country) throws SQLException {
        String query2 = "SELECT mid, country, name, snumber, position, etime, ltime, ynumber, redcard\n" +
                "FROM (SELECT PLAYERS.PID, MID, NAME, SNUMBER, PLAYERS.POSITION, ETIME, LTIME, YNUMBER, REDCARD\n" +
                "      FROM PLAYERS\n" +
                "      RIGHT JOIN PARTICIPATE ON PLAYERS.PID = PARTICIPATE.PID) as playerinfo\n" +
                "LEFT JOIN PLAYFOR ON PLAYFOR.PID = playerinfo.PID;"; // players already registered
        ResultSet rs2 = statement.executeQuery(query2);

        ConsoleMessage.info("The following players from " + in_country + " are already entered for match " + in_mid + ":");
        String a = "NAME"; String b = "SHIRT-NUMBER"; String c = "POSITION"; String d = "ENTER-TIME"; String e = "LEAVE-TIME"; String f = "YELLOW-CARDS"; String g = "RED-CARDS";
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-15s %-20s %-15s %-15s %-15s %-15s %n", a, b, c, d, e, f, g);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        //ConsoleMessage.info("name" + " snumber" + " position" + " enter-time" + " leave-time" + " yellow" + " red");

        int player_count_for_this_match = 0;
        while (rs2.next()) {
            int mid = rs2.getInt("mid"); // used to find desired match
            String country = rs2.getString("country"); // used to find desired country
            String name = rs2.getString("name");
            int snumber = rs2.getInt("snumber");
            String position = rs2.getString("position");
            Time etime = rs2.getTime("etime");
            Time ltime = rs2.getTime("ltime");
            int ynumber = rs2.getInt("ynumber");
            int redcard = (rs2.getBoolean("redcard"))? 1 : 0; // if true, we have 1 red card, otherwise there are 0 red cards.

            if ((in_mid == mid) && (in_country.equals(country))) {
                String time_entered = "from " + etime;
                String time_left = "to " + ltime;
                String yellowc = "yellow: " + ynumber;
                String redc = "red: " + redcard;

                System.out.format("%-20s %-15s %-20s %-15s %-15s %-15s %-15s %n", name, snumber, position, time_entered, time_left, yellowc, redc);
                // ConsoleMessage.info(name + " " + snumber + " " + position + " from " + etime + " to " + ltime + " yellow: " + ynumber + " red: " + redcard);
                player_count_for_this_match++;
            }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        rs2.close();
        ConsoleMessage.info("There are " + player_count_for_this_match + " players registered for this team in this match.");
        return player_count_for_this_match;
    }

    /**
     * Helper function for option 3. This is the 3rd function to be called.
     * Outputs players of the specified country who aren't registered in the specified match.
     * @param statement
     * @param in_country
     * @throws SQLException
     */
    public void getNonRegisteredPlayers(Statement statement, String in_country) throws SQLException {
        String query2 = "SELECT country, NAME, SNUMBER, playerinfo.POSITION\n" +
                "FROM (\n" +
                "    SELECT PLAYERS.PID, NAME, SNUMBER, PLAYERS.POSITION\n" +
                "    FROM PLAYERS\n" +
                "    LEFT JOIN PARTICIPATE ON PLAYERS.PID = PARTICIPATE.PID\n" +
                "    WHERE MID IS NULL) as playerinfo\n" +
                "LEFT JOIN PLAYFOR ON PLAYFOR.PID = playerinfo.PID;"; // players not yet registered
        ResultSet rs2 = statement.executeQuery(query2);

        //ConsoleMessage.info("");
        ConsoleMessage.info("\nPossible players from " + in_country + " not yet selected: ");
        String a = "NAME"; String b = "SHIRT-NUMBER"; String c = "POSITION";
        System.out.println("-----------------------------------------------------");
        System.out.format("%-20s %-15s %-20s %n", a, b, c);
        System.out.println("-----------------------------------------------------");
        //ConsoleMessage.info("name" + " snumber" + " position");

        while (rs2.next()) {
            String country = rs2.getString("country"); // used to find desired country
            String name = rs2.getString("name"); //
            int snumber = rs2.getInt("snumber");
            String position = rs2.getString("position");

            if (in_country.equals(country)) {
                System.out.format("%-20s %-15s %-20s %n", name, snumber, position);
                //ConsoleMessage.info(name + " " + snumber + " " + position);
            }
        }
        System.out.println("-----------------------------------------------------");
        rs2.close();
    }

    public void insertPlayer(Statement statement, int snumber, int mid, String position, String country, int player_count) throws SQLException {

        int player_limit = 11;
        if (player_count >= player_limit) {
            ConsoleMessage.warning("The player limit of " + player_limit + " in a team has been reached." +
                    "This player will not be inserted." );
            return;
        }
        // 1. using snumber input, query players in this team in this country (when find player with correct snumber then get pid)
        String query1 = "select Players.pid pid, snumber from Players, PlayFor " +
                "where Players.pid = PlayFor.pid and PlayFor.country = '" + country + "';";
        ConsoleMessage.debug(query1);
        ResultSet rs1 = statement.executeQuery(query1);
        ConsoleMessage.debug("pid" + " snumber");
        int pid = -1;
        while (rs1.next()) {
            int temp_pid = rs1.getInt("pid");
            int temp_snumber = rs1.getInt("snumber");
            if (temp_snumber == snumber) {
                ConsoleMessage.debug("Found:" + temp_pid + " " + snumber);
                pid = temp_pid;
                break;
            }
        }
        rs1.close();

        // 2. Find match start time
        String query2 = "select time from Matches where mid = '" + mid + "';";
        ConsoleMessage.debug(query2);
        ResultSet rs2 = statement.executeQuery(query2);
        ConsoleMessage.debug("pid" + " snumber");
        Time start_time = null;
        while (rs2.next()) {
            start_time = rs2.getTime("time");
            break;
        }
        rs2.close();

        // 2. use that pid to insert. String "INSERT into Players values(pid + "," + mid ...etc)"
        String query3 = "insert into Participate values (" + pid + ", " + mid + ", '"
                + start_time + "', '00:00:00', '" + position + "', 0, false);\n" ;
        ConsoleMessage.debug(query3);
        //pid=query using snumber, mid=mid, etime=query using mid, ltime=0:00:00, position=position, ycard=0, redcard=false
        statement.executeUpdate(query3);

        ConsoleMessage.info("Update completed.");
    }

    public void scoringInformation(Statement statement) throws SQLException, IOException {
        String country;
        while(true) {
            // Display leaderboard of countries and their respective goals, sorted by descending order of goals scored per team.
            getGoalsAllTeams(statement);
            // Get user's desired specific country.
            country = chooseCountry();
            // Display user's specific country's players and their respective goals, sorted by descending order of goals.
            getGoalsSpecificTeam(statement, country);
            // Get user's desired specific player (shirt number).
            int player = choosePlayer();
            // Display user's chosen player and goals.
            getGoalsSpecificPlayer(statement, player, country);

            ConsoleMessage.info("Enter [A] to find scoring information of another country or player, " +
                    "[P] to go to the previous menu: ");
            String option = br.readLine();
            if (option.equals("P") || option.equals("p")) {
                ConsoleMessage.debug("User chose P. Wishes to go back to main menu. Exiting loop.");
                break;
            } else if (option.equals("A") || option.equals("a")) {
                ConsoleMessage.debug("User chose A. Wishes to find matches of another country.");
            } else {
                ConsoleMessage.debug("Incorrect input. Will act as though user chose P.");
                break;
            }
        }
    }

    public void getGoalsAllTeams (Statement statement) throws SQLException {
        String query = "SELECT COUNTRY, COUNT(OCCURRENCE) as totalgoals\n" +
                "FROM (\n" +
                "         SELECT COUNTRY, OCCURRENCE, ROUND\n" +
                "         FROM GOALS\n" +
                "                  LEFT JOIN MATCHES M on M.MID = GOALS.MID\n" +
                "         ) as countries\n" +
                "group by COUNTRY\n" +
                "ORDER BY totalgoals DESC\n" +
                ";";
        ResultSet rs = statement.executeQuery(query);

        ConsoleMessage.info("\nLeaderboard of countries ranked by total goals: ");

        String a = "COUNTRY"; String b = "TOTAL-GOALS";
        System.out.println("------------------------------------");
        System.out.format("%-20s %-15s %n", a, b);
        System.out.println("------------------------------------");

        while (rs.next()) {
            String variable1 = rs.getString("country");
            int variable2 = rs.getInt("totalgoals");
            System.out.format("%-20s %-15s %n", variable1, variable2);

        }
        System.out.println("------------------------------------");
        rs.close();
    }

    public String chooseCountry() throws IOException {
        ConsoleMessage.info("Please Enter a Country to See More Information on the Goals Scored:");
        String in_country = br.readLine();
        ConsoleMessage.debug("User chose " + in_country);
        return in_country;
    }

    public void getGoalsSpecificTeam (Statement statement, String country) throws SQLException {
        String query = "SELECT scoringplayers.NAME, scoringplayers.SNUMBER, scoringplayers.COUNTRY, scoringplayers.totalGoals, participatingplayers.participated\n" +
                "FROM (\n" +
                "         SELECT p.NAME, p.PID, p.SNUMBER, g.COUNTRY,\n" +
                "                COUNT(p.NAME) as totalGoals,\n" +
                "                SUM(CASE WHEN g.penalty = 1 THEN 1 ELSE 0 END) AS penalties\n" +
                "         FROM PLAYERS p RIGHT JOIN GOALS g on p.PID = g.PID\n" +
                "         WHERE g.COUNTRY = '" + country + "'\n" +
                "         GROUP BY p.Name, g.COUNTRY, p.SNUMBER, p.PID\n" +
                "         ORDER BY totalGoals DESC\n" +
                "         ) scoringplayers\n" +
                "LEFT JOIN (\n" +
                "    SELECT NAME, SNUMBER, P.PID, COUNT(MID) as participated\n" +
                "    FROM PARTICIPATE\n" +
                "             LEFT JOIN PLAYERS P on P.PID = PARTICIPATE.PID\n" +
                "    group by NAME, SNUMBER, P.PID\n" +
                "    ) participatingplayers ON scoringplayers.PID = participatingplayers.PID\n" +
                ";";
        ResultSet rs = statement.executeQuery(query);

        ConsoleMessage.info("\nLeaderboard of players of team " + country + " ranked by total goals: ");
        String a = "NAME"; String b = "SHIRT-NUMBER"; String c = "COUNTRY"; String d = "TOTAL-GOALS"; String e = "PARTICIPATED-IN";
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-15s %-20s %-20s %-15s %n", a, b, c, d, e);
        System.out.println("------------------------------------------------------------------------------------------------------");

        while (rs.next()) {
            String variable1 = rs.getString("name");
            int variable2 = rs.getInt("snumber");
            String variable3 = rs.getString("country");
            int variable4 = rs.getInt("totalgoals");
            int variable5 = rs.getInt("participated");

            System.out.format("%-20s %-15s %-20s %-20s %-15s %n", variable1, variable2, variable3, variable4, variable5);
        }
        System.out.println("------------------------------------------------------------------------------------------------------");
        rs.close();
    }

    public int choosePlayer() throws IOException {
        ConsoleMessage.info("Please Enter A Shirt Number:");
        int snumber = Integer.parseInt(br.readLine());
        ConsoleMessage.debug("User chose " + snumber);
        return snumber;
    }

    public void getGoalsSpecificPlayer(Statement statement, int snumber, String country) throws SQLException {
        System.out.println(country);
        String query = "SELECT temp.NAME, temp.SNUMBER, temp.DATE, temp.MID, temp.TIME, temp.MINUTE, temp.PENALTY, PARTICIPATE.POSITION\n" +
                "FROM (\n" +
                "    SELECT PLAYERS.NAME, PLAYERS.PID, PLAYERS.SNUMBER, goalinfo.DATE, goalinfo.mid, goalinfo.TIME, goalinfo.MINUTE, goalinfo.PENALTY\n" +
                "    FROM (\n" +
                "        SELECT G.MID, g.PID, g.COUNTRY, DATE, TIME, MINUTE, g.PENALTY\n" +
                "        FROM GOALS G\n" +
                "            LEFT JOIN MATCHES M on M.MID = G.MID ) as goalinfo\n" +
                "    LEFT JOIN PLAYERS ON PLAYERS.PID = goalinfo.PID\n" +
                "    WHERE PLAYERS.SNUMBER = '" + snumber + "' AND COUNTRY = '" + country + "'\n" +
                "    ) as temp\n" +
                "LEFT JOIN PARTICIPATE ON temp.PID = PARTICIPATE.PID AND temp.MID = PARTICIPATE.MID\n" +
                "    ;";
        ResultSet rs = statement.executeQuery(query);

        ConsoleMessage.info("\nChosen player's goals: ");
        String a = "NAME"; String b = "SHIRT-NUMBER"; String c = "DATE"; String d = "MATCH ID";
        String e = "MATCH-START-TIME" ; String f = "MINUTE"; String g = "PENALTY"; String h = "POSITION";
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-15s %-20s %-20s %-20s %-20s %-20s %-20s %n", a, b, c, d, e, f, g, h);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        while (rs.next()) {
            String variable1 = rs.getString("name");
            int variable2 = rs.getInt("snumber");
            Date variable3 = rs.getDate("date");
            int variable4 = rs.getInt("mid");
            Time variable5 = rs.getTime("time");
            int variable6 = rs.getInt("minute");
            boolean variable7 = rs.getBoolean("penalty");
            String variable8 = rs.getString("position");

            System.out.format("%-20s %-15s %-20s %-20s %-20s %-20s %-20s %-20s %n", variable1, variable2, variable3, variable4, variable5, variable6, variable7, variable8);

        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        rs.close();
    }

    public static void main(String[] args) throws IOException, SQLException {

        // Register the driver.  You must register the driver before you can use it.
        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch (Exception cnfe) {
            System.out.println("Class not found");
        }

        String url; //for security purposes, the actual url was removed 
        String userid; //for security purposes, the actual userid was removed 
        String password; //for security purposes, the actual password was removed 
        Connection connection = DriverManager.getConnection(url, userid, password);
        Statement statement = connection.createStatement();

        mainMenu(statement);

        connection.close();

    }

}
