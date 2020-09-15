package com.todorex.dataStructure.section3.section322;

public class SelfList implements ListInterface {

    // 增长因子
    private final float GROWTH_FACTOR = 0.75f;

    // 初始默认长度
    private final int DEFAULT_SIZE = 16;

    // 保存数据的容器 数组
    private Object[] objects;

    // 当前位置索引
    private int currentIndex = 0;

    // 线性表的空间长度，注意和currentIndex区分
    // 例如，这里我们申请了8个对象的空间，那么listSize = 8
    // 但是只存放3个对象，那么currentIndex = 3
    private int listSize;

    //初始化---初始化数组长度-----------------
    // 无参构造器,使用默认长度
    public SelfList() {
        this.objects = new Object[DEFAULT_SIZE];
    }
    // 携带长度，这里需要做限定,数据不能太小
    public SelfList(int listSize) {
        this.listSize = listSize < 2 ? 4 : listSize;
        this.objects = new Object[listSize];
    }

    @Override
    //两种add-----------------------------------一种末尾添加，一种索引后添加
    public void add(Object o) {
        // 判断当前位置是不是到达拓展空间的临界值，不是的话直接在末尾添加元素
        if (currentIndex < listSize * GROWTH_FACTOR) {
            objects[currentIndex++] = o;
        } else {
            // 是的话，拓展空间大小，注意这里需要判断一下当前listSize是不是等于0
            // 如果等于0的话，那么将一直无法拓展空间
            listSize = (listSize == 0) ? 1 : listSize * 2;
            System.out.println("拓展了数据长度...." + listSize);
            // 创建新的数组
            Object[] temp = new Object[listSize];
            // 转移数据
            for (int i = 0; i < objects.length; i++) {
                temp[i] = objects[i];
            }
            // 重新指向新的数组集合
            objects = temp;
            // 添加新元素，并将当前索引+1
            objects[currentIndex++] = o;
        }
    }
    @Override
    public void add(int index, Object o) {

        // 数据校验

        if (index > currentIndex) {
            throw new IllegalArgumentException("插入的位置不能大于当前最大索引");
        }
        if (index < 0) {
            throw new IllegalArgumentException("插入的位置不能为负数!");
        }
        // 判断当前空间是否充足，不充足的话拓展空间为原来的2倍
        if (currentIndex > listSize * GROWTH_FACTOR) {
            listSize = listSize * 2;
            Object[] temp = new Object[listSize];
            for (int i = 0; i < currentIndex; i++) {
                temp[i] = objects[i];
            }
            objects = temp;
        }
        // 将数据向后移动
        for (int i = currentIndex + 1; i > index; i--) {
            objects[i] = objects[i - 1];
        }
        // 在指定位置更新值
        set(index, o);
        currentIndex++;
    }

    @Override
    public void clear() {
        // 创建新的数组，将objects指向空的数组
        Object[] temp = new Object[0];
        objects = temp;
        // 相关数据归零
        currentIndex = 0;
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        // 循环遍历，这里判断相等，根据自己实际的需求实现
        for (int i = 0; i < currentIndex; i++) {
            // 这里仅仅使用equal做比较，应该是用比较地址的方法，下面同理
            if (objects[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    //
    @Override
    public Object get(int index) {
        // 如果参数不对，那么直接返回null，表示获取不到
        if (index > currentIndex || index < 0) {
            return null;
        }
        return objects[index];
    }

    @Override
    //寻找指定元素，找到立即返回索引----------------
    public int indexOf(Object o) {
        // 循环遍历,发现立即返回索引
        for (int i = 0; i < currentIndex; i++) {
            if (objects[i].equals(o)) {
                return i;
            }
        }
        // 没有找到返回-1 ，说明不存在
        return -1;
    }

    @Override
    public boolean isEmpty() {
        // 这个很简单了，不解释了，下面的isNotEmpty同理
        if (currentIndex == 0) {
            return true;
        }
        return false;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        // 如果等于-1那么说明不包含，返回false
        int index = indexOf(o);
        // 获取该对象的索引值，为-1说明不存在remove失败
        if (index == -1) {
            return false;
        } else {
            // 存在的话根据索引移除
            remove(index);
            return true;
        }
    }

    @Override
    public Boolean remove(int index) {
        // 判读参数
        if (index > currentIndex || index < 0) {
            throw new IllegalArgumentException();
        }
        // 数据向前移动 一位
        for (int i = index; i < currentIndex - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[--currentIndex] = null;
        return true;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public void set(int index, Object o) {
        if (index > currentIndex || index < 0) {
            throw new IllegalArgumentException();
        }
        objects[index] = o;
    }
}
