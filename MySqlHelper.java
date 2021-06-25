package com.practice;
import java.sql.*;
public class MySqlHelper {

    static String filePath = "C:\\IntelliJ\\StudentDatabase\\src\\Resources\\StudentDataFile.txt";
    static Connection con;

    public MySqlHelper(){
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/sys", "root", "Akshat@27");
        }
        catch(SQLException e){
            System.out.print("MYSQL helper error : connection can't be acquired");
        }
    }

    public static void insertStudentInDatabase(Student student) throws SQLException {
       /* Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/sys", "root", "Akshat@27");*/

        String insertQuery = "INSERT INTO StudentData(Name, Stu_ID, Age, Grade, Father_Name, Mother_Name) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(insertQuery);
        pstmt.setString(1, student.getName());
        pstmt.setString(2, student.getId().trim());
        pstmt.setInt(3, student.getAge());
        pstmt.setInt(4, student.getGrade());
        pstmt.setString(5, student.getFatherName());
        pstmt.setString(6, student.getMotherName());

        pstmt.execute();
        //con.close();
    }
    public static void deleteStudentFromDatabase(Student stu) throws SQLException {

        String deleteQuery = "DELETE FROM StudentData WHERE stu_id like ?";
        PreparedStatement prepStmt = con.prepareStatement(deleteQuery);
        prepStmt.setString(1, "%"+stu.getId()+"%");
        prepStmt.execute();
        //con.close();
    }
    public static void deleteStudentFromDatabase(String stu_id) throws SQLException {

        String deleteQuery = "DELETE FROM StudentData WHERE stu_id like ?";
        PreparedStatement prepStmt = con.prepareStatement(deleteQuery);
        prepStmt.setString(1, "%"+stu_id+"%");
        prepStmt.execute();
        //con.close();
    }
    /*public Student findStudentById(String stuId) throws SQLException {
        String findStudentQuery = "select * from StudentData where stu_id ='?';";
        PreparedStatement preparedStatement = con.prepareStatement(findStudentQuery);
        preparedStatement.setString(1,"%"+stuId+"%");
        preparedStatement.execute();
        return ;*/

    public void performDatabaseOperationWithStudent(Student student, String operation) throws SQLException {
        if (operation.equals("ADD")){
            insertStudentInDatabase(student);
        }
        else if (operation.equals("DELETE")){
            deleteStudentFromDatabase((student));
        }
    }

    public Connection getCon() {
        return con;
    }
}


