package com.host.algorithm.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiaoy on 2020/1/10
 */
public class StreamTest {
    public static void main(String[] args) {


        Student s1 = new Student(1L, "小张", 15, "湖北");
        Student s2 = new Student(2L, "小李", 19, "浙江");
        Student s3 = new Student(1L, "小张", 15, "湖北");
        Student s4 = new Student(4L, "小王", 14, "北京");
        Student s5 = new Student(5L, "小赵", 12, "北京");

        List<Student> students = new ArrayList<>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);


//        List<Student> ss = testFilter(students);
//        ss.forEach(System.out::println);
       //  testMap(students);

//        List<Student> ss = testDistinct(students);
//        ss.forEach(System.out::println);
        testSort(students);

        testMatch(students);

    }

    private static void testMatch(List<Student> students) {
        boolean b = students.stream().anyMatch(s -> "湖北".equals(s.getAddress()));
        if (b){
            System.out.println("这里面有湖北的人");
        }
        boolean b1 = students.stream().allMatch(s -> s.getAge() > 10);
        if (b1){
            System.out.println("年龄都大于10");
        }
        boolean b2 = students.stream().noneMatch(s -> s.getName().equals("肖肖"));
        if (b2){
            System.out.println("没有叫肖肖的同学");
        }


    }

    private static void testSort(List<Student> students) {
        List<Student> news = students.stream().sorted((s1,s2) -> Long.compare(s1.getAge(),s2.getAge()))
                .sorted((s1,s2) -> Long.compare(s1.getId(),s2.getId())).collect(Collectors.toList());
        news.forEach(System.out::println);
    }

    private static List<Student> testDistinct(List<Student> students) {
        return students.stream().distinct().collect(Collectors.toList());
    }

    /**
     * 把需要的信息封装成map
     * @param students
     * @return
     */
    private static void testMap(List<Student> students) {
        List<String> address = students.stream().map(s->"住址"+s.getAddress()).collect(Collectors.toList());
        address.forEach(a->System.out.println(a));
    }

    /**
     * 返回过滤地址是浙江的学生
     * @param students
     * @return
     */
    private static List<Student> testFilter(List<Student> students) {
        return students.stream().filter(s->"浙江".equals(s.getAddress())).collect(Collectors.toList());
    }

}
