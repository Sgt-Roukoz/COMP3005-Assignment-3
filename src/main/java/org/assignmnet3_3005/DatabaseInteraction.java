/**
 * Database Interaction class represents a class with basic database interaction code with pre-specified database
 *
 * @author Marwan Zeid
 * @version 2024-03-18
 */
package org.assignmnet3_3005;

import java.sql.*;

public class DatabaseInteraction {
    private Connection databaseConnection;

    /**
     * Constructor for database interaction
     */
    public DatabaseInteraction()
    {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Students";
            String user = "postgres";
            String password = "z3i0";
            databaseConnection = DriverManager.getConnection(url, user, password);
            if (databaseConnection != null) System.out.println("Connected Successfully");
            else System.out.println("Connection Failed");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints all tuples from the students table in database
     */
    public void getAllStudents()
    {
        try{
            Statement statement = databaseConnection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();
            while(resultSet.next())
            {
                System.out.print(resultSet.getInt("student_id") + "\t");
                System.out.print(resultSet.getString("first_name") + "\t");
                System.out.print(resultSet.getString("last_name") + "   \t");
                System.out.print(resultSet.getString("email") + "\t");
                System.out.print(resultSet.getString("enrollment_date") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a student tuple to the students table in database
     * @param first_name first name of student
     * @param last_name last name of student
     * @param email email address of student
     * @param enrollment_date enrollment date of student
     */
    public void addStudent (String first_name, String last_name, String email, String enrollment_date)
    {
        try
        {
            String insert = String.format("('%s', '%s', '%s', '%s');", first_name, last_name, email, enrollment_date);
            Statement statement = databaseConnection.createStatement();
            statement.execute("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES" + "\t" + insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates the email of a specific student
     * @param student_id student to be updated
     * @param new_email new email to insert
     */
    public void updateStudentEmail(int student_id, String new_email)
    {
        try
        {
            String query = String.format(
                    "UPDATE students\t" +
                    "SET email = '%s'\t" +
                    "WHERE student_id = %d", new_email, student_id);

            Statement statement = databaseConnection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a student tuple from list
     * @param student_id Student to be deleted
     */
    public void deleteStudent(int student_id)
    {
        try
        {
            String query = String.format(
                            "DELETE FROM students\t" +
                            "WHERE student_id = %d", student_id);

            Statement statement = databaseConnection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Closes the connection with database
     */
    public void closeConnection()
    {
        try {
            databaseConnection.close();
            System.out.println("Closed Connection Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
