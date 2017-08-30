package pckgmain;

import pckgdatabase.DatabaseConnector;
import pckgdatabase.StudentDBUtils;
import pckgmodel.Student;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentDBUtils studentDBUtils=new StudentDBUtils();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Your Choice ");
        System.out.println("1 : Insert \n2: Update \n3:fetch\n4:fetch By Id ");
        int choice;
        choice=scanner.nextInt();
        switch (choice){
            case 1:

                Student student=new Student();

                student.setName("RAm");
                student.setAddress("Pokhara");
                student.setRoll(24);
                student.setSem(4);

                if(studentDBUtils.createStudent(student)){
                    System.out.println("Student Created");
                }
                break;
            case 2:
                break;
            case 3:
                studentDBUtils.fetchData();
                break;
            case 4:
                int id;
                System.out.println("Enter ID : ");
                id=scanner.nextInt();
                studentDBUtils.fetchById(id);
                break;
            default:
                break;
        }

    }
}
