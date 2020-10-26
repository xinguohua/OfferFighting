package com.todorex.week210;
import java.util.*;
import java.util.HashMap;

public class Solution5536 {
    public int maximalNetworkRank(int n, int[][] roads) {

        //�ڽӱ����ʽ
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] road: roads){
            put(map,road[0],road[1]);
            put(map,road[1],road[0]);
        }

        Set<Integer> keySet = map.keySet();
        int max = 0;
        //��������i j
        for (int i:keySet){
            for (int j:keySet){
                if (i!=j){
                    int ans = map.get(i).size()+map.get(j).size();
                    //��������ڵ���������Ҫ��һ
                    if (map.get(i).contains(j))
                        ans--;
                    if (ans>max)
                        max = ans;
                }
            }
        }
        return max;
    }

    private void put( HashMap<Integer, HashSet<Integer>> map, int i,int j){
        if (map.get(i)==null){
            HashSet<Integer> set = new HashSet<>();
            set.add(j);
            map.put(i,set);
        }
        else
            map.get(i).add(j);
    }




}
