package com.todorex.week211;

import java.util.*;

public class Solution5545 {
    public int bestTeamScore(int[] scores, int[] ages) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> ageset=new ArrayList<>();

        //把年龄存在hashmap中
        for (int i = 0; i <ages.length ; i++) {
            if (!hm.containsKey(ages[i])){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(scores[i]);
                hm.put(ages[i],list);
                ageset.add(ages[i]);
            }else {
                ArrayList<Integer> list = hm.get(ages[i]);
                list.add(scores[i]);
                hm.put(ages[i],list);
        }
    }
        Arrays.sort(ages);

        int maxscore=0;
        for (int i = 0; i < ages.length; i++) {
            int agestart=ages[i];
            //从哪个年龄开始
            int score=computeScore(agestart,hm,i,ageset);
            if (score>maxscore)
                maxscore=score;
        }



        return maxscore;
    }

    public int computeScore(int agestart,HashMap<Integer, ArrayList<Integer>> hm,int index,ArrayList<Integer> ageset) {
        //算出来你这个年龄的得分
        ArrayList<Integer> sore_first_List = hm.get(agestart);
        int score=0;
        int score_pre_age=0;
        for (Integer score_age : sore_first_List) {
                score=score+score_age;
            if (score_age>score_pre_age)
                score_pre_age=score_age;
        }
        for (int i =index+1; i < ageset.size(); i++) {
            ArrayList<Integer> soreList = hm.get(agestart);
            for (Integer score_age : soreList) {
                if (score_age>score_pre_age)
                    score=score+score_age;
            }
        }

        return score;
    }
    }
