package pckgdatabase;

import pckgmodel.Student;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDBUtils {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection connection= DatabaseConnector.databaseConnector();

    public boolean createStudent(Student student)  {
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

    public void fetchData(){
        try {
            String query = "SELECT * FROM Student";
            preparedStatement= connection.prepareStatement(query);

           resultSet= preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("NAME : " + resultSet.getString("namel"));
                System.out.println("ADDRESS : " + resultSet.getString("address"));
                System.out.println("Semester : " + resultSet.getInt("sem"));
                System.out.println("Roll  : " + resultSet.getInt("roll"));

            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
    public void fetchById(int id){
        try {
            if(connection!=null) {
            String query = "SELECT * FROM Student Where id=?";
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID : " + resultSet.getInt("id"));
                System.out.println("NAME : " + resultSet.getString("namel"));
                System.out.println("ADDRESS : " + resultSet.getString("address"));
                System.out.println("Semester : " + resultSet.getInt("sem"));
                System.out.println("Roll  : " + resultSet.getInt("roll"));

            }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
