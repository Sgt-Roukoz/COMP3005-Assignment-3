package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseInteraction db = new DatabaseInteraction();

        db.getAllStudents();
        db.closeConnection();
    }
}