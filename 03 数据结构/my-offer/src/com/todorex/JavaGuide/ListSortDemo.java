package com.todorex.JavaGuide;

import java.util.*;

public class ListSortDemo {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setId(10001);
        s1.setName("cat");
        s1.setScore(99.5f);

        Student s2 = new Student();
        s2.setId(10008);
        s2.setName("bba");
        s2.setScore(100.0f);

        Student s3 = new Student();
        s3.setId(10011);
        s3.setName("bac");
        s3.setScore(89.5f);

        List<Student> list= new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println("排序之前-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }

        Collections.sort(list, new StudentComparator());	//排序

        System.out.println("排序之后-----------------------");
        for(Student stu:list){
            System.out.println("id="+stu.getId()+" name="+stu.getName()+" score="+stu.getScore());
        }
    }

}
