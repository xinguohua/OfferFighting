package com.todorex.dataStructure.section3.section322;

public class TestSelfList {
    public static void main(String[] args) {
        // 创建集合
        SelfList selfList = new SelfList(4);
        //循环遍历新增数据
        for (int i = 0; i < 24; i++) {
            selfList.add(String.valueOf(i));
        }

        //根据索引和数据移除数据
        selfList.remove(2);
        selfList.remove("4");

        System.out.println("是否包含 13 = " + selfList.contains("13"));
        System.out.println(selfList.get(12)+" 的位置是 = " + selfList.indexOf(selfList.get(12)));
        System.out.println("当前数据长度: = " +selfList.size());

        //更新指定位置数据
        selfList.set(12,"12121212");
        System.out.println("当前12的数据是："+selfList.get(12));
        System.out.println("当前第120位数据: = " +selfList.get(120));

        //清空数据
        selfList.clear();
        System.out.println("当前数据是否为空:"+selfList.isEmpty());
        System.out.println("当前数据长度: = " +selfList.size());

        //更新数据
        selfList.add("1");
        selfList.add("2");
        System.out.println("当前数据长度: = " +selfList.size());
    }
}
