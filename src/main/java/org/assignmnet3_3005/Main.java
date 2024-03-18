package org.assignmnet3_3005;

public class Main {
    public static void main(String[] args) {
        DatabaseInteraction db = new DatabaseInteraction();

        db.getAllStudents();
        db.closeConnection();
    }
}