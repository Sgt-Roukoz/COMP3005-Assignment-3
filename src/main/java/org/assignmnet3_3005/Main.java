package org.assignmnet3_3005;

public class Main {
    public static void main(String[] args) {
        DatabaseInteraction db = new DatabaseInteraction();

        //db.addStudent("Marwan", "Zeid", "marwan.zeid@cmail.carleton.ca", "2021-09-02");
        //db.updateStudentEmail(3, "jimbean@example.ca");
        //db.deleteStudent(3);
        db.getAllStudents();
        db.closeConnection();
    }
}