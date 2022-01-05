package com.example.stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        DBClient cl = ctx.getBean(DBClient.class);

        List<Student> students=  cl.fetchAll();
        process(students);

    }


    public static void process(List<Student> students) {
        students.stream()
                .filter(student -> student.getClazz() == 2) // filter for class 1
                .map(student -> student.getName()) // map list for name from student object
                .forEach((name) -> System.out.println(name)); // print each name

//        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(student -> student.getClazz()));
//        System.out.println(map);

        Map<Integer, List<Student>> map = new HashMap<>();

        for (Student student: students) {
            if (map.containsKey(student.getClazz())) {
                map.get(student.getClazz()).add(student);
            } else {
                List<Student> l = new ArrayList<>();
                l.add(student);
                map.put(student.getClazz(), l);
            }
        }


    }

}
