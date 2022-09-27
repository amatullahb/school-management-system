# School Management System (SMS)

This application allows students whose credentials are stored in the sms database (sms.student), to register for courses located in the sms.course table, view their courses, and view all courses. The application only accepts valid student credentials.

##### Technologies used:
* Java 17
* MariaDB
* Heidi SQL
* Hibernate 6.1.2
* Maven

##### Steps to successfully run this application:
1. Run `CreateTables.java` (`com.brown.sms.controller`) in your IDE.
2. Run the attached SQL scripts (`insertIntoStudent.sql` and `insertIntoCourse.sql`) in your Heidi SQL.
3. Run `SMSRunner.java` (`jpa.mainrunner`).
    1. Enter 1 to log in as a student, 2 to quit the program.
    2. Enter a valid email and password when prompted (valid log in information comes from the SQL sms.student table).
    3. Proceed to 1. Register or 2. Logout.