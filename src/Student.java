public class Student {

    private String studentName;
    private int studentId;
    private int year;
    private String gender;

    public Student(String name, int year, String gender){
        this.studentName = name;
        this.year = year;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String toString(){
        return "Student Name: " + studentName + " Year studying: " + year + " Gender: " + gender;
    }
}
