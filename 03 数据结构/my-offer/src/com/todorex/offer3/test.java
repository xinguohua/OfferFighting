package com.todorex.offer3;

import static com.todorex.offer3.Duplicate2.findDuplicate;

public class test {

        public static void main(String[] args) {
        int[] intArray = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int[] duplication = new int[1];
        System.out.println(findDuplicate(intArray, duplication));
        System.out.println(duplication[0]);
    }
}
