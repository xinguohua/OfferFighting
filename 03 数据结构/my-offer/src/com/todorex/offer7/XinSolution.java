package com.todorex.offer7;

import sun.font.TrueTypeFont;

public class XinSolution {

    /**
     * 这是一个递归问题
     * 一次流程：
     * 前序遍历确定根节点
     * 中序遍历确定两侧的长度
     *
     * 左子树得到新的前序序列
     * 左子树得到新的中序序列
     *
     * 右子树得到新的前序序列
     * 右子树得到新的中序序列
     *
     *建立关系
     *
     * 再分别buildTree
     *
     * 终止条件是什么 序列的个数是一个 建树的过程
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public  static  TreeNode buildTree(int[] preorder, int[] inorder) {
        if ((preorder.length==0) || (inorder.length==0)){
            return null;
        }
        int prerootindex=0;
        //前序遍历确定根节点
        int root=preorder[prerootindex];
        //建立根节点
        TreeNode treeNode = new TreeNode(root);

        //终止条件
        if (preorder.length>1){


            //中序遍历寻找根节点位置
            int inrootindex=0;
            for (int i = 0; i <inorder.length ; i++) {
                if (inorder[i]==root){
                    inrootindex=i;
                    break;
                }
            }
            //中序遍历确定两侧的长度(左右子树)
            int leftlength=inrootindex;
            int rightlength=inorder.length-1-leftlength;


            int[] newleftpreorder=new int[leftlength];
            int[] newrightpreorder=new int[rightlength];
            int size=0,size1=0;
            for (int i=1; i <preorder.length ; i++) {
                if (i<=leftlength){
                    //左子树得到新的前序序列 prerootindex+1
                     newleftpreorder[size++]=preorder[i];}
                else {
                    //右子树得到新的前序序列 prerootindex+1
                    newrightpreorder[size1++]=preorder[i];
                }
            }
            //左子树得到新的中序序列
            int[] newleftinorder=new int[leftlength];
            int[] newrightinorder=new int[rightlength];
            int size2=0;
            for (int i = 0; i <inorder.length ; i++) {
                if (i<leftlength){
                newleftinorder[i]=inorder[i];
                }else if (i>leftlength){

                    newrightinorder[size2++]=inorder[i];
                }

            }


            TreeNode left = buildTree(newleftpreorder, newleftinorder);
            TreeNode right = buildTree(newrightpreorder, newrightinorder);

            treeNode.left=left;
            treeNode.right=right;
        }else{
            return treeNode;
        }
        return treeNode;

    }

    public static void main(String[] args) {
        int[] a = new int[]{3,9,20,15,7};
        int[] b = new int[]{9,3,15,20,7};
        System.out.println(buildTree(a, b));
    }
}
