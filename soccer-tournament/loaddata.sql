-- Include your INSERT SQL statements in this file.
-- Make sure to terminate each statement with a semicolon (;)

-- LEAVE this statement on. It is required to connect to your database.
CONNECT TO cs421;

-- Remember to put the INSERT statements for the tables with foreign key references
--    ONLY AFTER the parent tables!

INSERT INTO Accounts VALUES ('annablue@outlook.com', 'Anna Blue', '1900-05-23', 'annabluesecretpwd!!!',
                             '123 rue Fleury, Montréal, Québec', '514-000-0000', 'French', 'Mrs.', 'Canada', 'Australia');
INSERT INTO Accounts VALUES ('abc244?!%$#^@gmail.com', 'Joel A. Blue', '2000-01-01', 'j03b1u3pwd',
                             '221B Baker St., London', '514-398-4455', 'English', 'Mr.', 'United Kingdom', 'United Kingdom');
INSERT INTO Accounts VALUES ('jred@outlook.com', 'Joey Red', '2010-05-23', 'jred123pwd',
                             '4 Privet Drive, Little Whinging, Surrey', '1-90-14-38-45', 'Arabic', 'Dr.', 'United Kingdom', 'India');
INSERT INTO Accounts VALUES ('chloerose123@outlook.com', 'Chloe Rose', '1999-09-09', 'chloepwd!!!',
                             '124 Conch Street, Bikini Bottom, Pacific Ocean', '123-123-1234', 'Arabic', 'Dr.', 'New Zealand', 'New Zealand');
INSERT INTO Accounts VALUES ('matmatgreengreen@outlook.com', 'Mat Green', '1900-05-23', 'matgreenusernamepwd',
                             'Trottier Building', '333-333-3333', 'English', 'Mr.', 'Canada', 'New Zealand');

-- Cards:
INSERT INTO Cards VALUES (1111111111111111, '2023-07-01', 'Anna Blue', 1234);
INSERT INTO Cards VALUES (1112111121113111, '2024-08-01', 'Joel Blue', 324);
INSERT INTO Cards VALUES (3331223455321242, '2023-12-01', 'Joe Red', 298);
INSERT INTO Cards VALUES (4552716182299112, '2025-01-01', 'Chloe Rose', 982);
INSERT INTO Cards VALUES (8198919298119288, '2023-04-01', 'Mat Green', 2910);

-- Orders:
INSERT INTO Orders VALUES (00000001, 55.50); 
INSERT INTO Orders VALUES (00000002, 10.00); 
INSERT INTO Orders VALUES (00000003, 115.99);
INSERT INTO Orders VALUES (00000004, 15.99); 
INSERT INTO Orders VALUES (00000005, 55.99); 

-- Tickets:
INSERT INTO Tickets VALUES (00000001, 20.00, 'Child', 'A');
INSERT INTO Tickets VALUES (00000002, 35.50, 'Adult', 'B');
INSERT INTO Tickets VALUES (00000003, 10.00, 'Child', 'C');
INSERT INTO Tickets VALUES (00000004, 50.00, 'Adult', 'A');
INSERT INTO Tickets VALUES (00000005, 15.99, 'Child', 'C');
INSERT INTO Tickets VALUES (00000006, 50.00, 'Adult', 'A');
INSERT INTO Tickets VALUES (00000007, 15.99, 'Child', 'D');
INSERT INTO Tickets VALUES (00000008, 55.99, 'Adult', 'A');
INSERT INTO Tickets VALUES (00000009, 35.99, 'Child', 'A');

-- Players:
INSERT INTO Players VALUES (1001, 'Erin Nayler', 1, '1992-04-17', 'Goalkeeper');
INSERT INTO Players VALUES (1002, 'Olivia Chance', 11, '1993-10-05', 'Forward');
INSERT INTO Players VALUES (1003, 'Betsy Hassett', 12, '1990-08-04', 'Midfielder');
INSERT INTO Players VALUES (1004, 'Anna Green', 21, '1990-08-20', 'Defender');
insert into Players values (1101, 'Sam Kerr', 20, '1993-09-10', 'Forward');
insert into Players values (1102, 'Caitlin Foord', 9, '1994-11-11', 'Forward');
insert into Players values (1103, 'Lydia Williams', 1, '1988-06-13', 'Goalkeeper');
insert into Players values (1104, 'Aivi Luik', 3, '1985-03-18', 'Defender'); 
INSERT INTO Players VALUES (1204, 'Jennifer Hermoso', 10, '1990-05-09', 'Forward'); 
INSERT INTO Players VALUES (1205, 'Alba Redondo', 11, '1996-08-27', 'Forward');
INSERT INTO Players VALUES (1206, 'Elene Lete', 23, '2002-05-07', 'Goalkeeper');
INSERT INTO Players VALUES (1207, 'Berta Pujadas', 12, '2000-04-09', 'Defender');
INSERT INTO Players VALUES (1301, 'Elena Black', 14, '2000-05-09', 'Defender');
--Philippines
INSERT INTO Players VALUES (1401, 'Jessica Johnson', 9, '1998-07-12', 'Forward');
INSERT INTO Players VALUES (1402, 'Danna Lee', 3, '1996-03-27', 'Midfielder');
INSERT INTO Players VALUES (1403, 'Michelle Nguyen', 22, '2001-09-04', 'Defender');
--Switzerland
INSERT INTO Players VALUES (1501, 'Julie Kim', 11, '1995-11-29', 'Midfielder');
INSERT INTO Players VALUES (1502, 'Cat Jones', 20, '1999-05-21', 'Defender');
INSERT INTO Players VALUES (1503, 'Anna Davis', 7, '1997-12-08', 'Forward');
--Norway
INSERT INTO Players VALUES (1601, 'Emily Brown', 3, '1996-03-27', 'Midfielder');
INSERT INTO Players VALUES (1602, 'Ava Smith', 22, '2001-09-04', 'Defender');
INSERT INTO Players VALUES (1603, 'Mia Davis', 11, '1995-11-29', 'Midfielder');
--Ireland
INSERT INTO Players VALUES (1701, 'Olivia Taylor', 20, '1999-05-21', 'Defender');
INSERT INTO Players VALUES (1702, 'Emma Lee', 7, '1997-12-08', 'Forward');

-- Coaches:
INSERT INTO Coaches VALUES (1, 'Jared Smith', '1975-03-12', 'Head Coach');
INSERT INTO Coaches VALUES (2, 'Samantha Johnson', '1982-07-22', 'Assistant Coach');
INSERT INTO Coaches VALUES (3, 'Michael Davis', '1969-11-04', 'Defensive Coordinator');
INSERT INTO Coaches VALUES (4, 'Amanda Lee', '1990-05-18', 'Offensive Coordinator');
INSERT INTO Coaches VALUES (5, 'Tommy Nguyen', '1985-09-02', 'Special Teams Coordinator');

-- Teams:
INSERT INTO Teams VALUES ('New Zealand', 'New Zealand National Team', 'A', 'https://www.example.com/new-zealand');
INSERT INTO Teams VALUES ('Norway', 'Norway National Team', 'A', 'https://www.example.com/norway');

INSERT INTO Teams VALUES ('Australia', 'Australia National Team', 'B', 'https://www.example.com/australia');
INSERT INTO Teams VALUES ('Ireland', 'Ireland National Team', 'B', 'https://www.example.com/ireland');

INSERT INTO Teams VALUES ('Philippines', 'Philippines National Team', 'A', 'https://www.example.com/philippines');
INSERT INTO Teams VALUES ('Switzerland', 'Switzerland National Team', 'A', 'https://www.example.com/switzerland');

INSERT INTO Teams VALUES ('Nigeria', 'Nigerian National Team', 'B', 'https://www.example.com/nigeria');
INSERT INTO Teams VALUES ('Canada', 'Canada National Team', 'B', 'https://www.example.com/canada');

INSERT INTO Teams VALUES ('Spain', 'Spain National Team', 'C', 'https://www.example.com/spain');
INSERT INTO Teams VALUES ('Costa Rica', 'Costa Rica National Team', 'C', 'https://www.example.com/costa-rica');

-- Matches: Only match 1, 2 and 3 happened
INSERT INTO Matches VALUES (1, '2023-03-15', '19:00:00', '01:45:00', 1, 15500);
INSERT INTO Matches VALUES (2, '2023-03-15', '20:00:00', '01:40:00', 1, 25000);
INSERT INTO Matches VALUES (3, '2023-03-16', '17:00:00', '01:30:00', 1, 12000);
INSERT INTO Matches VALUES (4, '2023-03-16', '12:30:00', '00:00:00', 1, 17213);
INSERT INTO Matches VALUES (5, '2023-03-17', '19:30:00', '00:00:00', 1, 15020);
INSERT INTO Matches VALUES (6, '2023-03-17', '10:30:00', '00:00:00', 2, 18020);
INSERT INTO Matches VALUES (7, '2023-03-18', '11:30:00', '00:00:00', 2, 20000);

--INSERT INTO Matches VALUES (4, '2023-03-16', '12:30:00', '01:55:00', 1, 17213);
--INSERT INTO Matches VALUES (5, '2023-03-17', '19:30:00', '01:43:00', 1, 15020);
--INSERT INTO Matches VALUES (6, '2023-03-17', '10:30:00', '01:25:00', 2, 18020);


-- Referees:
INSERT INTO Referees VALUES (1, 'John Smith', 'New Zealand', 'Head Referee', 10);
INSERT INTO Referees VALUES (2, 'Maria Garcia', 'Argentine', 'Assistant Referee', 6);
INSERT INTO Referees VALUES (3, 'Hans Mueller', 'Germany', 'Head Referee', 8);
INSERT INTO Referees VALUES (4, 'Juliana Santos', 'Brazil', 'Assistant Referee', 5);
INSERT INTO Referees VALUES (5, 'François Dubois', 'France', 'Head Referee', 12);


-- Stadiums:
INSERT INTO Stadiums VALUES ('Eden Park', 20000, 'Auckland, New Zealand');
INSERT INTO Stadiums VALUES ('Dunedin Stadium', 15000, 'Dunedin, New Zealand');
INSERT INTO Stadiums VALUES ('Melbourne Rectangular Stadium', 18000, 'Melbourne, Australia');
INSERT INTO Stadiums VALUES ('Wellington Regional Stadium', 21044, 'Wellington, New Zealand');
INSERT INTO Stadiums VALUES ('Stadium Australia', 25800, 'Sydney, Australia');

-- Goals: Only matches 1 and 2 occurred
insert into Goals values (1, 1, 34, false, false, 1004, 'New Zealand');
insert into Goals values (1, 2, 42, true, false, 1004, 'New Zealand');
insert into Goals values (1, 3, 50, true, false, 1004, 'New Zealand');
insert into Goals values (1, 4, 65, false, false, 1601, 'Norway');
insert into Goals values (1, 5, 68, false, false, 1601, 'Norway');

insert into Goals values (2, 1, 20, false, false, 1101, 'Australia');
insert into Goals values (2, 2, 41, false, false, 1702, 'Ireland');
insert into Goals values (2, 3, 55, false, false, 1702, 'Ireland');
insert into Goals values (2, 4, 121, false, true, 1101, 'Australia');

insert into Goals values (3, 1, 34, false, false, 1401, 'Philippines');
insert into Goals values (3, 2, 63, false, false, 1402, 'Philippines');
insert into Goals values (3, 3, 80, true, false, 1501, 'Switzerland');
--insert into Goals values (5, 1, 10, false, false, 1205, 'Spain');
--insert into Goals values (5, 2, 12, false, false, 1204, 'Spain');
--insert into Goals values (5, 3, 98, true, false, 1204, 'Spain');
--insert into Goals values (5, 4, 99, false, false, 1301, 'Costa Rica');

-- Seats:
insert into Seats values (4, 'Eden Park', 'General', 1, 3, 5, 7);
insert into Seats values (14, 'Dunedin Stadium', 'General', 24, 35, 46, 57);
insert into Seats values (70, 'Dunedin Stadium', 'VIP', 86, 75, 64, 42);
insert into Seats values (1400, 'Stadium Australia', 'General', 0001, 0002, 0003, 0004);
insert into Seats values (901, 'Stadium Australia', 'VIP', 0005, 0006, 0007, 0008);

--Reserve:
INSERT INTO Reserve VALUES (1, 4, 'Eden Park');
INSERT INTO Reserve VALUES (2, 14, 'Dunedin Stadium');
INSERT INTO Reserve VALUES (3, 70, 'Dunedin Stadium');
INSERT INTO Reserve VALUES (4, 1400, 'Stadium Australia');
INSERT INTO Reserve VALUES (5, 901, 'Stadium Australia');

--Payments:
INSERT INTO PAYMENTS VALUES ('annablue@outlook.com', 1111111111111111, 1);
INSERT INTO PAYMENTS VALUES ('abc244?!%$#^@gmail.com', 1112111121113111, 2);
INSERT INTO PAYMENTS VALUES ('jred@outlook.com', 3331223455321242, 3);
INSERT INTO PAYMENTS VALUES ('chloerose123@outlook.com', 4552716182299112, 4);
INSERT INTO PAYMENTS VALUES ('matmatgreengreen@outlook.com', 8198919298119288, 5);


--Books:
INSERT INTO BOOKS VALUES (1, 00000001);
INSERT INTO BOOKS VALUES (2, 00000001);
INSERT INTO BOOKS VALUES (3, 00000002);
INSERT INTO BOOKS VALUES (4, 00000003);
INSERT INTO BOOKS VALUES (5, 00000003);
INSERT INTO BOOKS VALUES (6, 00000003);
INSERT INTO BOOKS VALUES (7, 00000003);
INSERT INTO BOOKS VALUES (8, 00000004);
INSERT INTO BOOKS VALUES (9, 00000005);

--NextTo:
INSERT INTO NEXTTO VALUES (1, 2);
INSERT INTO NEXTTO VALUES (4, 5);
INSERT INTO NEXTTO VALUES (5, 6);
INSERT INTO NEXTTO VALUES (6, 7);
INSERT INTO NEXTTO VALUES (8, 9);

--Team1
INSERT INTO TEAM1 VALUES (1, 'New Zealand');
INSERT INTO TEAM1 VALUES (2, 'Australia');
INSERT INTO TEAM1 VALUES (3, 'Philippines');
INSERT INTO TEAM1 VALUES (4, 'Nigeria');
INSERT INTO TEAM1 VALUES (5, 'Spain');
INSERT INTO TEAM1 VALUES (6, 'New Zealand');
INSERT INTO TEAM1 VALUES (7, 'Australia');

--Team2
INSERT INTO TEAM2 VALUES (1, 'Norway');
INSERT INTO TEAM2 VALUES (2, 'Ireland');
INSERT INTO TEAM2 VALUES (3, 'Switzerland');
INSERT INTO TEAM2 VALUES (4, 'Canada');
INSERT INTO TEAM2 VALUES (5, 'Costa Rica');
INSERT INTO TEAM2 VALUES (6, 'Costa Rica');
INSERT INTO TEAM2 VALUES (7, 'Nigeria');

-- Oversee:
insert into Oversee values (1, 1);
insert into Oversee values (2, 1);
insert into Oversee values (2, 1);
insert into Oversee values (3, 2);
insert into Oversee values (4, 2);
insert into Oversee values (4, 5);
insert into Oversee values (4, 3);
insert into Oversee values (5, 4);
insert into Oversee values (4, 6);
insert into Oversee values (4, 7);

-- Host:
insert into Host values (1, 'Eden Park');
insert into Host values (2, 'Eden Park');
insert into Host values (3, 'Dunedin Stadium');
insert into Host values (4, 'Dunedin Stadium');
insert into Host values (5, 'Stadium Australia');
insert into Host values (6, 'Stadium Australia');
insert into Host values (7, 'Eden Park');

-- PlayFor:
insert into PlayFor values (1001, 'New Zealand');
insert into PlayFor values (1002, 'New Zealand');
insert into PlayFor values (1003, 'New Zealand');
insert into PlayFor values (1004, 'New Zealand');
insert into PlayFor values (1101, 'Australia');
insert into PlayFor values (1102, 'Australia');
insert into PlayFor values (1103, 'Australia');
insert into PlayFor values (1104, 'Australia');
insert into PlayFor values (1204, 'Spain');
insert into PlayFor values (1205, 'Spain');
insert into PlayFor values (1206, 'Spain');
insert into PlayFor values (1207, 'Spain');
insert into PlayFor values(1301, 'Costa Rica');
insert into PlayFor values(1401, 'Philippines');
insert into PlayFor values(1402, 'Philippines');
insert into PlayFor values(1403, 'Philippines');
insert into PlayFor values(1501, 'Switzerland');
insert into PlayFor values(1502, 'Switzerland');
insert into PlayFor values(1503, 'Switzerland');
insert into PlayFor values(1601, 'Norway');
insert into PlayFor values(1602, 'Norway');
insert into PlayFor values(1603, 'Norway');
insert into PlayFor values(1701, 'Ireland');
insert into PlayFor values(1702, 'Ireland');

-- BelongTo :
insert into BelongTo values (1, 'New Zealand');
insert into BelongTo values (2, 'Norway');
insert into BelongTo values (3, 'Australia');
insert into BelongTo values (4, 'Ireland');
insert into BelongTo values (5, 'Philippines');

-- Associated:
insert into Associated values (00000001, 1);
insert into Associated values (00000002, 1);
insert into Associated values (00000003, 1);
insert into Associated values (00000004, 1);
insert into Associated values (00000005, 2);
insert into Associated values (00000006, 3);
insert into Associated values (00000007, 4);
insert into Associated values (00000008, 5);

-- Participate: Only match 1 and 2 occurred
insert into Participate values (1001, 1, '19:00:00', '19:45:00', 'Goalkeeper', 1, false);
insert into Participate values (1002, 1, '19:00:00', '20:05:00', 'Forward', 1, false);
insert into Participate values (1004, 1, '19:00:00', '20:05:00', 'Forward', 0, false);
insert into Participate values (1601, 1, '19:00:00', '20:25:00', 'Midfielder', 0, false);

insert into Participate values (1101, 2, '20:00:00', '21:00:00', 'Forward', 0, false);
insert into Participate values (1702, 2, '20:00:00', '21:00:01', 'Forward', 0, false);

insert into Participate values (1401, 3, '17:00:00', '18:00:00', 'Forward', 0, false);
insert into Participate values (1402, 3, '17:00:00', '18:10:00', 'Forward', 0, false);
insert into Participate values (1501, 3, '17:00:00', '17:44:12', 'Forward', 0, false);

insert into Participate values (1301, 5, '00:00:00', '00:00:00', 'Midfielder', 0, false);
insert into Participate values (1001, 6, '00:00:00', '00:00:00', 'Goalkeeper', 0, false);
insert into Participate values (1301, 6, '00:00:00', '00:00:00', 'Defender', 0, false);


--insert into Participate values (1301, 5, '19:30:00', '20:13:00', 'Midfielder', 1, false);
--insert into Participate values (1001, 6, '19:30:00', '20:13:00', 'Goalkeeper', 1, false);
--insert into Participate values (1301, 6, '10:30:00', '11:13:00', 'Defender', 1, false);
