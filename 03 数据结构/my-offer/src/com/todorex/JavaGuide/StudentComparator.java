package com.todorex.JavaGuide;

import java.util.Comparator;

public class StudentComparator implements Comparator{


    /**
     * return a negative integer, zero, or a positive integer as the first argument is less than,
     * 			equal to, or greater than the second.
     */
    @Override
    public int compare(Object o1, Object o2) {
        Student s1=(Student)o1;
        Student s2=(Student)o2;
        if(s1.getScore()>s2.getScore()){	//greater
            return -1;
        }else if(s1.getScore()==s2.getScore()){	//equals
            if(s1.getId()>s2.getId()){
                return 1;
            }else if(s1.getId()==s2.getId()){
                return 0;
            }else{
                return -1;
            }
        }else{	//less
            return 1;
        }
    }
}
