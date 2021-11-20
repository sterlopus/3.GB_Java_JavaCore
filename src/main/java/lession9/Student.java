package lession9;

import java.util.List;

public class Student {

    String name;
    List<Course> allCourses;

    public Student(String name, List<Course> allCourses) {
        this.name = name;
        this.allCourses = allCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public void setCourses(List<Course> courses) {
        this.allCourses = courses;
    }

    @Override
    public String toString() {
        return name;
    }
}