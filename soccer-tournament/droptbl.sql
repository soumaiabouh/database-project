-- Include your drop table DDL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the drop table ddls for the tables with foreign key references
--    ONLY AFTER the parent tables has already been dropped (reverse of the creation order).

-- This is only an example of how you add drop table ddls to this file.
--   You may remove it.
DROP TABLE ACCOUNTS;
DROP TABLE ASSOCIATED;
DROP TABLE BELONGTO;
DROP TABLE BOOKS;
DROP TABLE CARDS;
DROP TABLE COACHES;
DROP TABLE GOALS;
DROP TABLE HOST;
DROP TABLE MATCHES;
DROP TABLE NEXTTO;
DROP TABLE ORDERS;
DROP TABLE OVERSEE;
DROP TABLE PARTICIPATE;
DROP TABLE PAYMENTS;
DROP TABLE PLAYERS;
DROP TABLE PLAYFOR;
DROP TABLE REFEREES;
DROP TABLE RESERVE;
DROP TABLE SEATS;
DROP TABLE STADIUMS;
DROP TABLE TEAMS;
DROP TABLE TEAM1;
DROP TABLE TEAM2;
DROP TABLE TICKETS;