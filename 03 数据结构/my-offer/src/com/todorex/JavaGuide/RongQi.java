package com.todorex.JavaGuide;

import java.util.ArrayList;
import java.util.List;

public class RongQi {

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");

        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("============");
        objects.add(1,"xx");
        for (Object object : objects) {
            System.out.println(object);
        }

    }
}
