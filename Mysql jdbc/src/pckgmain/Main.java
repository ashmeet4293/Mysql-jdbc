package pckgmain;

import pckgdatabase.DatabaseConnector;
import pckgdatabase.StudentDBUtils;
import pckgmodel.Student;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        StudentDBUtils studentDBUtils=new StudentDBUtils();
        Student student=new Student();

        student.setName("RAm");
        student.setAddress("Pokhara");
        student.setRoll(24);
        student.setSem(4);

        if(studentDBUtils.createStudent(student)){
            System.out.println("Student Created");
        }


    }
}
