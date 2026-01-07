# Soccer Tournament Management System

A comprehensive system for managing a soccer tournament using a relational SQL database and a Java console application. This project was developed as part of a programming course (COMP421) to demonstrate proficiency in database design, SQL, and Java application development with JDBC integration.

**Collaborators**: Soumaia Bouhouia and Felicia Sun

## Project Overview

This system enables users to manage all aspects of a soccer tournament, including teams, players, coaches, matches, and tournament results. The application provides an intuitive console interface for querying match information, managing player statistics, and tracking scoring across participating countries.

### Key Features
- **Database Management**: Relational database schema for storing tournament data including accounts, teams, players, coaches, matches, and tickets
- **Console Interface**: User-friendly menu-driven application for tournament management
- **Data Queries**: Advanced queries to retrieve match information, player statistics, and country scoring
- **JDBC Integration**: Direct SQL database connectivity for real-time data operations

## Folder Structure

```
soccer-tournament/
├── src/
│   ├── Soccer.java          # Main application class with tournament management logic
│   └── ConsoleMessage.java  # Utility class for console output and user interaction
├── createtbl.sql            # SQL script to create all database tables
├── droptbl.sql              # SQL script to drop all database tables
├── loaddata.sql             # SQL script to populate database with initial tournament data
├── doc/
│   ├── ER-schema.pdf        # Entity-Relationship diagram of the database design
│   └── Relational-model.pdf # Relational model documentation
└── COMP421-P3.iml          # IntelliJ IDEA project configuration
```

### Database Tables
The system includes the following core tables:
- **Accounts**: User account information (email, name, contact details)
- **Teams**: Team information and metadata
- **Players**: Player details (name, position, date of birth, squad number)
- **Coaches**: Coaching staff information
- **Matches**: Tournament match schedules and details
- **Cards**: Payment card information for ticket purchases
- **Orders**: Order history for tickets
- **Tickets**: Event ticket information and pricing

## Installation & Setup

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher
- **SQL Database**: DB2 or compatible relational database management system
- **JDBC Driver**: Appropriate JDBC driver for your database system

### Step 1: Database Setup

1. **Connect to your database**:
   ```sql
   CONNECT TO cs421;
   ```

2. **Create database tables**:
   ```bash
   db2 -f createtbl.sql
   ```
   This executes the SQL script located in [createtbl.sql](soccer-tournament/createtbl.sql) to create all necessary tables.

3. **Load initial data**:
   ```bash
   db2 -f loaddata.sql
   ```
   This populates the database with sample tournament data from [loaddata.sql](soccer-tournament/loaddata.sql).

### Step 2: Java Application Configuration

1. **Open the project** in your IDE (IntelliJ IDEA recommended):
   - Import the project using `COMP421-P3.iml`

2. **Configure database connection** in `Soccer.java`:
   - Locate the `main()` method
   - Update the following connection parameters:
     - `url`: Your database connection URL (e.g., `jdbc:db2://localhost:50000/cs421`)
     - `userid`: Your database username
     - `password`: Your database password

3. **Ensure JDBC driver is in classpath**:
   - Add the appropriate JDBC driver JAR file to your project's library dependencies

### Step 3: Running the Application

1. **Compile the Java files**:
   ```bash
   javac src/*.java
   ```

2. **Run the Soccer application**:
   ```bash
   java -cp src Soccer
   ```

3. **Interact with the application**:
   The main menu will display the following options:
   - **Option 1**: List match information for a specific country
   - **Option 2**: Insert initial player information for a match
   - **Option 3**: View scoring information for each country
   - **Option 4**: Exit the application

### Step 4: Cleanup (Optional)

To reset the database and remove all tables:
```bash
db2 -f droptbl.sql
```

## Project Documentation

- [ER-schema.pdf](soccer-tournament/doc/ER-schema.pdf): Visual representation of the entity-relationship model
- [Relational-model.pdf](soccer-tournament/doc/Relational-model.pdf): Documentation of the relational schema with table definitions and constraints

## Technologies Used

- **Language**: Java (Console Application)
- **Database**: SQL (DB2)
- **API**: JDBC (Java Database Connectivity)
- **IDE**: IntelliJ IDEA

## Learning Outcomes

This project provided hands-on experience in:
- Relational database design and normalization
- SQL DDL and DML operations
- Java-database integration using JDBC
- Console-based user interface design
- Data validation and error handling
- Team-based software development
