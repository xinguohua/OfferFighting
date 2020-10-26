package com.todorex.dataStructure.section4.section434;


/**
 * 二叉树的顶级接口
 * @param <T>
 */
public interface Tree<T> {

    /**
     * 判空
     * @return
     */
    boolean isEmpty();


    /**
     * 先根次序遍历
     */
    String preOrder();

    /**
     * 中根次序遍历
     */
    String inOrder();

    /**
     * 后根次序遍历
     */
    String postOrder();

    /**
     * 层次遍历
     */
    String levelOrder();

}
