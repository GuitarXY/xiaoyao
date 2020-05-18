package com.host.jdk18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * created by xiaoyao01  on 2020/5/11.
 **/
public class LambadTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1","2","1");
//        List<String> collect = list.stream().distinct().filter(s -> s.equals("1")).collect(toList());
//        System.out.println(collect);
        Teacher t1 = new Teacher("小雅","南昌");
        Teacher t2 = new Teacher("小白","南昌");
        Teacher t3 = new Teacher("小黑","北京");
        Teacher t4 = new Teacher("小黑","上海");
        List<Submit> submits = Arrays.asList(
                new Submit(t1,2011,300),
                new Submit(t1,2012,600),
                new Submit(t2,2011,400),
                new Submit(t2,2012,500),
                new Submit(t3,2013,500),
                new Submit(t4,2014,500)
        );
        List<Submit> collect = submits.stream().filter(submit -> submit.getYear() == 2011)
                .sorted(Comparator.comparing(submit -> submit.getSubmitPrice())).collect(toList());
        System.out.println(collect);

        List<String> collect1 = submits.stream().map(submit -> submit.getTeacher().getWorkCity()).distinct().collect(toList());
        System.out.println(collect1);

        List<Submit> citys = submits.stream().filter(submit -> submit.getTeacher().getWorkCity().equals("南昌")).collect(toList());
        List<Teacher> citys1 = submits.stream().map(submit -> submit.getTeacher()).filter(teacher -> teacher.getWorkCity().equals("南昌")).collect(toList());
        System.out.println(citys);
        System.out.println(citys1);


        Stream<String> sorted = submits.stream().map(submit -> submit.getTeacher().getName()).distinct().sorted(Comparator.comparing(s -> s.equals("小白")));
        System.out.println(sorted.collect(Collectors.joining()));
        submits.stream().map(Submit::getTeacher).filter(teacher -> teacher.getWorkCity().equals("南昌")).distinct();

    }
}
class Teacher{
    String name;
    String workCity;

    public Teacher() {
    }

    public Teacher(String name, String workCity) {
        this.name = name;
        this.workCity = workCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", workCity='" + workCity + '\'' +
                '}';
    }
}
class Submit{
    Teacher teacher;
    int year;
    int submitPrice;

    public Submit() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSubmitPrice() {
        return submitPrice;
    }

    public void setSubmitPrice(int submitPrice) {
        this.submitPrice = submitPrice;
    }

    public Submit(Teacher teacher, int year, int submitPrice) {
        this.teacher = teacher;
        this.year = year;
        this.submitPrice = submitPrice;
    }

    @Override
    public String toString() {
        return "Submit{" +
                "teacher=" + teacher +
                ", year=" + year +
                ", submitPrice=" + submitPrice +
                '}';
    }
}