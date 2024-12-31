//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createTable();

        Student student1 = new Student("Sandali", 13, "Female");
        Student student2 = new Student("Devindie", 13, "Female");
        Student student3 = new Student("Sanjula", 13, "Male");
        Student student4 = new Student("Kisali", 13, "Female");
        Student student5 = new Student("Kasun", 11, "Male");

        studentDAO.createStudent(student1);
        studentDAO.createStudent(student2);
        studentDAO.createStudent(student3);
        studentDAO.createStudent(student4);

        studentDAO.deleteStudent(5);

        Student updatedStudent1 = new Student("Sandali", 12, "Female");
        int indexOfStudentToUpdate = 1;
        studentDAO.updateStudent(indexOfStudentToUpdate, updatedStudent1);

        int idForQuerying = 3;
        studentDAO.queryStudent(3);
        Student queriedStudent = studentDAO.queryStudent(3);
        if(queriedStudent != null){
            System.out.println(queriedStudent.toString());
        }else{
            System.out.println("Student for the id " + idForQuerying + " does not exist.");
        }

    }
}