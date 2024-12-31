import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void createTable(){
        String dropTableQuery = "DROP TABLE IF EXISTS students";
        String createTable = "CREATE TABLE students ("+ "id INT AUTO_INCREMENT PRIMARY KEY," + "name VARCHAR(255) NOT NULL," + "year INT NOT NULL," +"gender VARCHAR(10) NOT NULL);";

        try(Connection conn = DBConnection.connect();
            Statement statement = conn.createStatement()) {
            statement.executeUpdate(dropTableQuery);
            statement.executeUpdate(createTable);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void createStudent(Student student){
        String createStatement = "INSERT INTO students (name, year, gender) VALUES (?,?,?) ";

        try(Connection conn = DBConnection.connect();
            PreparedStatement statement = conn.prepareStatement(createStatement)){
            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getGender());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteStudent(int Id){
        String deleteStatement = "DELETE FROM students WHERE id = ?";
        try(Connection conn = DBConnection.connect();
        PreparedStatement statement = conn.prepareStatement(deleteStatement)){
            statement.setInt(1, Id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void updateStudent(int id, Student student){
        String updateStatement = "UPDATE students SET name = ?, year = ?, gender = ? WHERE id = ?";;
        try(Connection conn = DBConnection.connect();
        PreparedStatement statement = conn.prepareStatement(updateStatement)){
            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getYear());
            statement.setString(3, student.getGender());
            statement.setInt(4, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Student queryStudent(int id) {
        String getStudent = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement statement = conn.prepareStatement(getStudent)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String gender = rs.getString("gender");
                // Create a new Student object with the retrieved data
                Student student = new Student(name, year, gender);
                student.setStudentId(id);
                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
