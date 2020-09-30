package com.todorex.offer7;
import java.util.*;
public class leetcodeSolution {

    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        //HashMap key是中序遍历的值 value是数组索引
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        //开始递归 初始 先序遍历根节点的索引=0，中序遍历的左边界索引=0， 中序遍历有边界索引 长度-1
        return recursive(0,0,inorder.length-1);
    }

    /**
     * @param pre_root_idx  先序遍历根节点的索引
     * @param in_left_idx  中序遍历的左边界索引
     * @param in_right_idx 中序遍历的有边界索引
     */
    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        //递归终止条件
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //pre_root_idx是在先序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);

        // 有了先序根据点的值,在中序的HashMap,获取当前根在中序的索引
        int in_root_idx = map.get(preorder[pre_root_idx]);


        //建立关系 递归中实质上进行的内容
        //开启接下来的递归

        //建立左子树
        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左子树：左边边界就是left，左子树：右边边界是中间区分的in_root_idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, in_root_idx - 1);

        //建立右子树
        //右子树的根节点就是 pre_root_idx + (in_root_idx-1 - in_left_idx +1)  + 1, 左子树：左边边界就是in_root_idx，左子树：右边边界in_right_idx
        root.right = recursive(pre_root_idx + (in_root_idx-1 - in_left_idx +1)  + 1, in_root_idx + 1, in_right_idx);
        return root;
    }
}
