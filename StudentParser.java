package com.practice;
public class StudentParser {

    public Student getStudentFromText(String line) {

        String[] array = line.split(",");
        Student stu;
        stu = new Student(array[0], array[1].trim(),
                Integer.parseInt(array[2].trim()),
                Integer.parseInt(array[3].trim()),
                array[4].trim(),
                array[5]);
        return stu;
    }

    //operation return method
    //Set or map
    public Object[] splitTask(String line){
        Object[] studentObjects = new Object[2];
        studentObjects[0] = line.substring(0,line.indexOf(","));
        studentObjects[1] = getStudentFromText(line.substring(line.indexOf(",")+1).trim());
        return studentObjects;
    }
}