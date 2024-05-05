package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class PrioritiesTest {

    @Test
    public void test() {
        List<String> events = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );
        List<Student> students = new Priorities().getStudents(events);


        List<String> result = students
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        assertThat(result).containsExactly("Dan", "Ashley", "Shafaet", "Maria");
    }

}
