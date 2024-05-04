package com.example.demo;

import java.util.*;


// https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true
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
        Queue<Student> queue = new PriorityQueue<>((s1, s2) -> {
            boolean samePoints = s1.getCGPA() == s2.getCGPA();
            String name1 = s1.getName();
            String name2 = s2.getName();
            if (name1.equals(name2) && samePoints) {
                int id1 = s1.getId();
                int id2 = s2.getId();

                return Integer.compare(id1, id2);
            }
            if (samePoints) {
                return name1.compareTo(name2);
            }
            return -(Double.compare(s1.getCGPA(), s2.getCGPA()));
        });

        for (String event : events) {
            if ("SERVED".equals(event) && !queue.isEmpty()) {
                queue.poll();
                continue;
            }
            String[] split = event.split(" ");
            if (split.length != 4 && !"ENTER".equals(split[0])) {
                continue;
            }

            int id = Integer.parseInt(split[3]);
            String name = split[1];
            double cgpa = Double.parseDouble(split[2]);

            queue.offer(new Student(id, name, cgpa));
        }

        List<Student> students = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }
        return students;
    }
}
