package com.todorex.offer5;

public class LeetcodeSolutionB {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char character : chars) {
            if(character==' '){
                sb.append("%20");
            }else{
                sb.append(character);
            }
         }
         return sb.toString();
    }

}
