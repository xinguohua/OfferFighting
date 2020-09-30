package com.todorex.JavaGuide;
import java.util.*;
import java.util.function.Predicate;

public class Person implements Comparable{
    private String name;
    private Integer order;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order
     *            the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }




    @Override
    public int compareTo(Object o) {
        Person arg0 = (Person) o;
        return this.getOrder().compareTo(arg0.getOrder());      //这里定义你排序的规则。
    }


    public static void main(String[] args) {
        //初始化数据
        List<Person> listA = new ArrayList<>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        p1.setName("name1");
        p1.setOrder(1);
        p2.setName("name2");
        p2.setOrder(2);
        p3.setName("name3");
        p3.setOrder(3);

        listA.add(p2);
        listA.add(p1);
        listA.add(p3);

        //排序
        Collections.sort(listA);

        //打印排序后的Person
        for (Person p : listA) {
            System.out.println(p.getName());
        }
    }
}
