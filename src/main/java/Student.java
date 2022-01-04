import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    ArrayList<Course> courses;

    public Student(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }


    public List<Course> getAllCourses() {
        return courses;


    }
}
