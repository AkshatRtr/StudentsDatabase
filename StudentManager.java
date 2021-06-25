package com.practice;
import java.io.*;
import java.sql.SQLException;

public class StudentManager {
    static StudentParser studentParser = new StudentParser();
    static MySqlHelper mySqlHelper = new MySqlHelper();
    public static void main(String [] args) throws Exception{
        File file = new File("src/Resources/StudentDataFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        System.out.println("Logging in");
        String st;
        long startTime = System.currentTimeMillis();

            while ((st = br.readLine()) != null) {
                SingleLineHandler handler = new SingleLineHandler(st);
                handler.start();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken : "+(endTime-startTime));

    }

    static class SingleLineHandler extends Thread{
        String line;

        public SingleLineHandler(String line){
            this.line = line;
        }

        //6 op  -> 17 ms => 6000 ops -> 1700 ms -> 1 sec.
        @Override
        public void run() {
            try{
                Object[] taskAndStudent = studentParser.splitTask(line);
                String operation = String.valueOf(taskAndStudent[0]); //what if we didn't have an actual string here.
                Student student = (Student) taskAndStudent[1];
                //Student newStudent = (Student) taskAndStudent[0];
                mySqlHelper.performDatabaseOperationWithStudent(student, operation);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
