package com.todorex.dataStructure.section3.section322;
//数组实现线性表
//Java实现顺序列表的接口
public interface ListInterface {

        /**
         * 新增对象
         * @param o
         */
        public void add(Object o);

        /**
         * 新增对象到指定位置
         * @param index
         * @param o
         */
        public void add(int index, Object o);

        /**
         * 清楚全部数据
         */
        public void clear();

        /**
         * 判断是否包含对象
         * @param o
         * @return
         */
        public boolean contains(Object o);

        /**
         * 获取指定索引上的数据对象
         * @param index
         * @return
         */
        public Object get(int index);

        /**
         * 获取某对象的索引
         * @param o
         * @return
         */
        public int indexOf(Object o);

        /**
         * 判断列表是不是空的
         * @return
         */
        public boolean isEmpty();

        /**
         * 移除某索引
         * @param o
         * @return
         */
        public boolean remove(Object o);

        /**
         * 移除指定索引的位置
         * @param index
         * @return
         */
        public Boolean remove(int index);

        /**
         * 获取当前集合的长度信息
         * @return
         */
        public int size();

        /**
         * 更新指定位置的数据
         * @param index
         * @param o
         */
        public void set(int index,Object o);



}
