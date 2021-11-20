package lession9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Hw9 {


    public static void main(String[] args) {

        // data
        Course course0 = new Course("Java4Beginners");
        Course course1 = new Course("Java4Testers");
        Course course2 = new Course("JavaCore");
        Course course3 = new Course("JavaLevel2");
        Course course4 = new Course("JavaLevel3");
        Course course5 = new Course("JavaGodMode");

        List<Student> students = Arrays.asList(
                new Student("Johnson", Arrays.asList(course1, course2, course3, course4, course5)),
                new Student("Jackson", Arrays.asList(course0, course1, course2, course3, course4)),
                new Student("Billson", Arrays.asList(course1, course2, course3)),
                new Student("Fredson", Arrays.asList(course1, course2)),
                new Student("Tompson", Arrays.asList(course1)),
                new Student("Duckson", Arrays.asList(course1, course2, course3, course4)));

        // 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        System.out.println("All unique courses: " + uniqueCourses(students));

        // 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
        System.out.println("Most curious students are: " + curiousStudents(students));

        // 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
        System.out.println("Course " + course3 + " is attended by students: " + studentsByCourse(students, course3));

    }

    private static List<Course> uniqueCourses(List<Student> students) {
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Student> curiousStudents(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingInt(s -> s.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Student> studentsByCourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

}

/**
 * Имеется следующая структура:
 *
 *    interface Student {
 *         String getName();
 *         List<Course> getAllCourses();
 *     }
 *     interface Course {}
 *
 * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
 * 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
 * 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
 */