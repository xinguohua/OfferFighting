package com.todorex.dataStructure.section4.section46;

import java.util.Arrays;

/**
 * Created by zejian on 2017/9/12.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 * 最大堆实现
 */
public class MaxHeap<T extends Comparable<T>> {

    //存储元素的数组
    private T[] queue;
    private int size = 0;

    public MaxHeap(int maxLength){
        queue = (T[]) new Comparable[maxLength+1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }



    //最大堆的插入============================实质是上滤的过程
    /**
     * 添加元素
     * @param key
     */
    public void insert(T key){
        if (key == null) {
            throw new NullPointerException("key is not be null !");
        }

        if (size >= queue.length) {
            grow();//扩容
        }
        //为满足完全二叉树的性质
        queue[++size] = key;
        //为满足堆的性质，上浮元素
        siftUp(size);
    }

    /**
     * 上浮操作
     */
    private void siftUp(int k){
        //上浮时,K位置的元素与父元素比较
        //只要小且不到根节点就一直进行
        while(k > 1 && less(k/2,k) ){
            exch(k/2,k);
            k = k/2;
        }
    }



    //最大堆删除最大元素 实质上是下滤的过程=====================
    /**
     * 删除最大元素
     * @return
     */
    public T deleteMax(){
        if(size == 0){
            return null;
        }
        T key = queue[1];
        exch(1,size);
        queue[size] = null;
        size--;
        siftDown(1);
        return key;
    }

    /**
     * 下沉操作
     */
    private void siftDown(int k){
        while (2*k <= size){
            int j = 2*k ;//左子节点 保证必须有左子节点（针对最右边的叶子节点）


            //父节点与最大的子节点进行交换
            //判断左子节点是否比右子节点小
            if(j + 1 < size && less(j,j+1)){
                j++;//说明右子节点比左子节点大,使用右子节点与父节点交换
            }

            //如果父节点大于子节点,那么就不用交换了
            if(!less(k,j)){
                break;
            }

            //否则执行元素交换
            exch(k,j);

            k = j;
        }
    }




    /**
     * 比较i位置的元素是否比j位置的元素小
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i , int j){
        return queue[i].compareTo(queue[j]) < 0;
    }

    /**
     * 交换两个位置的值
     * @param i
     * @param j
     */
    private void exch(int i , int j){
        T temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    private void grow() {
        int oldCapacity = queue.length;
        // 如果小于64,那么就拓展1倍,否则拓展1/2倍
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        // overflow-conscious code
        queue = Arrays.copyOf(queue, newCapacity);
    }


    /**
     * 比较i位置的元素是否比j位置的元素小
     * @param i
     * @param j
     * @return
     */
    private boolean less(T[] array,int i , int j){
        return array[i].compareTo(array[j]) < 0;
    }

    /**
     * 交换两个位置的值
     * @param i
     * @param j
     */
    private void exch(T[] array,int i , int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        MaxHeap<String> MaxHeap = new MaxHeap<>(10);
        MaxHeap.insert("z");
        MaxHeap.insert("a");
        MaxHeap.insert("q");
        MaxHeap.insert("b");
        MaxHeap.insert("x");
        MaxHeap.insert("c");
        MaxHeap.insert("d");
        MaxHeap.insert("y");
        MaxHeap.insert("n");

        StringBuilder sb = new StringBuilder();
        while(!MaxHeap.isEmpty()){
            sb.append(MaxHeap.deleteMax()+",");
        }
        String min = sb.toString();

        System.out.println(min.substring(0,min.length()-1));


//        String[] a = {null,"c","a","o","w","z","k"};
//        System.out.println("排序前:"+ Arrays.toString(a));
//        MaxHeap.heapSort(a);
//        System.out.println("排序后:"+ Arrays.toString(a));
    }
}
