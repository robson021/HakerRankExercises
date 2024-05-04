package com.example.demo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Student {
    private final int id;

    private final String name;

    private final double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(cgpa, student.cgpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cgpa);
    }
}

class Priorities {

    List<Student> getStudents(List<String> events) {
        List<Student> students = new LinkedList<>();

        for (String event : events) {
            if ("SERVED".equals(event) && !students.isEmpty()) {
                Student s = findHighestGcpa(students);
                students.remove(s);
                continue;
            }
            String[] split = event.split(" ");
            if (split.length != 4 && !"ENTER".equals(split[0])) {
                continue;
            }

            int id = Integer.parseInt(split[3]);
            String name = split[1];
            double cgpa = Double.parseDouble(split[2]);

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, Comparator.comparingDouble(Student::getCGPA).reversed());
        return students;
    }

    private Student findHighestGcpa(List<Student> students) {
        Student s = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            Student toCheck = students.get(i);
            if (toCheck.getCGPA() > s.getCGPA()) {
                s = toCheck;
            }
        }
        return s;
    }
}

/*class Priorities2 {

    List<Student> getStudents(List<String> events) {
        List<Student> students = new LinkedList<>();

        for (String event : events) {
            if ("SERVED".equals(event) && !students.isEmpty()) {
                Student s = findHighestGcpa(students);
                students.remove(s);
                continue;
            }
            String[] split = event.split(" ");
            if (split.length != 4 && !"ENTER".equals(split[0])) {
                continue;
            }

            int id = Integer.parseInt(split[3]);
            String name = split[1];
            double cgpa = Double.parseDouble(split[2]);

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, Comparator.comparingDouble(Student::getCGPA).reversed());
        return students;
    }

    private Student findHighestGcpa(List<Student> students) {
        Student s = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            Student toCheck = students.get(i);
            if (toCheck.getCGPA() > s.getCGPA()) {
                s = toCheck;
            }
        }
        return s;
    }
}*/
