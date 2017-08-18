package pckgdatabase;

import pckgmodel.Student;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDBUtils {
    PreparedStatement preparedStatement;


    public boolean createStudent(Student student)  {
        Connection connection= DatabaseConnector.databaseConnector();
        if(connection!=null) {
            String query = "INSERT INTO Student (Namel, Address,sem,roll) VALUES (?,?,?,?)";
            try {

                preparedStatement= connection.prepareStatement(query);
                preparedStatement.setString(1,student.getName());
                preparedStatement.setString(2,student.getAddress());
                preparedStatement.setInt(3,student.getSem());
                preparedStatement.setInt(4,student.getRoll());

                preparedStatement.execute();
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return false;
    }


}
