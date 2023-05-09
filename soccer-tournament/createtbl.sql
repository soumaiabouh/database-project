CONNECT TO cs421;

create table Accounts
(
    email       VARCHAR(255) NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    dob         DATE         NOT NULL,
    password    VARCHAR(100) NOT NULL,
    address     VARCHAR(100) NOT NULL,
    pnumber     VARCHAR(100) NOT NULL, --phone number
    language    VARCHAR(100) NOT NULL,
    title       VARCHAR(10)  NOT NULL,
    country     VARCHAR(100) NOT NULL,
    nationality VARCHAR(100) DEFAULT
);

CREATE TABLE Cards
(
    cnumber BIGINT NOT NULL PRIMARY KEY,
    expdate DATE NOT NULL,
    name VARCHAR(100) NOT NULL,
    cvv VARCHAR(4) NOT NULL --could be int
);

CREATE TABLE Orders
(
    oid BIGINT NOT NULL PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Tickets
(
    tid BIGINT NOT NULL PRIMARY KEY,
    price DECIMAL(10, 2) NOT NULL,
    type VARCHAR(5) NOT NULL,
    gate VARCHAR(20) NOT NULL
);

create table Players
(
    pid      INTEGER                       NOT NULL PRIMARY KEY,
    name     VARCHAR(100)                  NOT NULL,
    snumber  INTEGER CHECK (snumber <= 23) NOT NULL,
    dob      DATE                          NOT NULL,
    position VARCHAR(20) --18 actually
);

CREATE TABLE Coaches
(
    cid  INTEGER     NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    dob  DATE        NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE Teams
(
    country VARCHAR(100) NOT NULL PRIMARY KEY,
    aname   VARCHAR(50)  NOT NULL,
    group   VARCHAR(1)   NOT NULL, --only 8 groups
    aurl    VARCHAR(100) NOT NULL
);

CREATE TABLE Matches
(
    mid    INTEGER NOT NULL PRIMARY KEY,
    date   DATE    NOT NULL,
    time   TIME    NOT NULL, --time it starts
    length TIME    NOT NULL, --total length
    round  INTEGER NOT NULL,
    tsold  INTEGER NOT NULL
);

CREATE TABLE Referees
(
    rid INTEGER NOT NULL PRIMARY KEY,
    name    VARCHAR(50)  NOT NULL,
    country VARCHAR(100) NOT NULL,
    role    VARCHAR(50)  NOT NULL,
    years   INTEGER      NOT NULL
);

CREATE TABLE Stadiums
(
    stname   VARCHAR(50)  NOT NULL PRIMARY KEY,
    capacity INTEGER      NOT NULL,
    location VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Goals
(
    mid        INTEGER      NOT NULL,
    occurrence INTEGER      NOT NULL,
    minute     INTEGER      NOT NULL,
    penalty    BOOLEAN      NOT NULL,
    penaltyShoutout BOOLEAN not null,
    pid        INTEGER      NOT NULL,
    country VARCHAR(100) NOT NULL,
    FOREIGN KEY (mid) REFERENCES Matches (mid),
    FOREIGN KEY (country) REFERENCES Teams (country),
    FOREIGN KEY (pid) REFERENCES Players (pid),
    PRIMARY KEY (mid, occurrence)
);


CREATE TABLE Seats
(
    sid       INTEGER     NOT NULL,
    stname    VARCHAR(50) NOT NULL,
    category  VARCHAR(50) NOT NULL,
    pavillion INTEGER     NOT NULL,
    block     INTEGER     NOT NULL,
    row       INTEGER     NOT NULL,
    number    INTEGER     NOT NULL,
    FOREIGN KEY (stname) REFERENCES STADIUMS (stname),
    PRIMARY KEY (sid, stname)
);

CREATE TABLE Reserve
(
    tid BIGINT NOT NULL UNIQUE,
    sid INTEGER NOT NULL UNIQUE,
    stname VARCHAR(50) NOT NULL,
    FOREIGN KEY (tid) REFERENCES TICKETS,
    FOREIGN KEY (sid, stname) REFERENCES SEATS
);

CREATE TABLE Payments
(
    email VARCHAR(255) NOT NULL,
    cnumber BIGINT NOT NULL,
    oid BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (email) REFERENCES ACCOUNTS,
    FOREIGN KEY (cnumber) REFERENCES CARDS,
    FOREIGN KEY (oid) REFERENCES ORDERS
);

CREATE TABLE Books
(
    tid BIGINT NOT NULL UNIQUE,
    oid BIGINT NOT NULL,
    FOREIGN KEY (tid) REFERENCES TICKETS,
    FOREIGN KEY (oid) REFERENCES ORDERS
);

CREATE TABLE NextTo
(
    tid1 BIGINT NOT NULL,
    tid2 BIGINT NOT NULL,
    FOREIGN KEY (tid1) REFERENCES TICKETS,
    FOREIGN KEY (tid2) REFERENCES TICKETS
);

CREATE TABLE Team1
(
    mid INTEGER NOT NULL UNIQUE,
    country VARCHAR(100) NOT NULL,
    FOREIGN KEY (mid) REFERENCES MATCHES,
    FOREIGN KEY (country) REFERENCES TEAMS
);

CREATE TABLE Team2
(
    mid INTEGER NOT NULL UNIQUE,
    country VARCHAR(100) NOT NULL,
    FOREIGN KEY (mid) REFERENCES MATCHES,
    FOREIGN KEY (country) REFERENCES TEAMS
);

CREATE TABLE Oversee --Referees oversee Matches
(
    rid INTEGER NOT NULL,
    mid INTEGER NOT NULL,
    FOREIGN KEY (rid) REFERENCES REFEREES (rid),
    FOREIGN KEY (mid) REFERENCES MATCHES (mid)
);

CREATE TABLE Host --Stadiums host Matches
(
    mid    INTEGER     NOT NULL UNIQUE,
    stname VARCHAR(50) NOT NULL,
    FOREIGN KEY (mid) REFERENCES MATCHES (mid),
    FOREIGN KEY (stname) REFERENCES STADIUMS (stname)
);

CREATE TABLE PlayFor --Teams play for countries
(
    pid     INTEGER      NOT NULL UNIQUE,
    country VARCHAR(100) NOT NULL,
    FOREIGN KEY (pid) REFERENCES PLAYERS (pid),
    FOREIGN KEY (country) REFERENCES TEAMS (country)
);
CREATE TABLE BelongTo --
(
    cid     INTEGER      NOT NULL UNIQUE,
    country VARCHAR(100) not null,
    FOREIGN KEY (cid) REFERENCES Coaches (cid),
    FOREIGN KEY (country) REFERENCES Teams (country)
);

CREATE TABLE Associated
(
    tid INTEGER NOT NULL UNIQUE,
    mid INTEGER NOT NULL,
    FOREIGN KEY (tid) REFERENCES Tickets (tid),
    FOREIGN KEY (mid) REFERENCES Matches (mid)
);

CREATE TABLE Participate
(
    pid INTEGER NOT NULL,
    mid INTEGER NOT NULL,
    etime TIME NOT NULL,
    ltime TIME NOT NULL,
    position  VARCHAR(20),
    ynumber INTEGER NOT NULL,
    redcard BOOLEAN NOT NULL,
    FOREIGN KEY (pid) REFERENCES Players (pid),
    FOREIGN KEY (mid) REFERENCES Matches (mid)
);



