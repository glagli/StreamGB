import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course("Матан");
        Course course2 = new Course("Физика");
        Course course3 = new Course("Химия");
        Course course4 = new Course("ФизХим");
        Course course5 = new Course("Линейная алгебра");
        Course course6 = new Course("Дифферницальные уравнения");


        ArrayList<Course> coursesA = new ArrayList<>();
        coursesA.add(course1);
        coursesA.add(course2);


        ArrayList<Course> coursesB = new ArrayList<>();
        coursesB.add(course4);
        coursesB.add(course5);
        coursesB.add(course2);

        ArrayList<Course> coursesC = new ArrayList<>();
        coursesC.add(course1);
        coursesC.add(course2);
        coursesC.add(course6);
        coursesC.add(course3);

        Student student1 = new Student("Vasya", coursesA);
        Student student2 = new Student("Sony", coursesC);
        Student student3 = new Student("Yana", coursesC);
        Student student4 = new Student("Vlad", coursesA);
        Student student5 = new Student("Slava", coursesB);
        Student student6 = new Student("Evgen", coursesB);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);


        System.out.println("Список уникальных курсов: " + distinctCourse(students));
        System.out.println("Самые любознательные: " + (top3(students)));
        System.out.println(findStudentByCourse(students, course5));

    }

    public static List<Course> distinctCourse(ArrayList<Student> students) {
        List<Course> result = students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());

        return result;

    }

    public static String top3(ArrayList<Student> students) {
        String result = students.stream()
                .sorted((s1, s2) -> (int) (s1.getAllCourses().size() - s2.getAllCourses().size()))
                .map(Student::getName)
                .limit(3)
                .collect(Collectors.joining(", "));
        return result;
    }

    public static String findStudentByCourse(ArrayList<Student> students, Course course) {
        String result = students.stream()
                .filter(student -> student.courses.toString().contains(course.name))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        return "Курс " + course.name + " посещают: "+result;
    }
}
