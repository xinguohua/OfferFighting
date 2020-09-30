package com.todorex.dataStructure.section4.section434;

import java.util.LinkedList;

/**
 * 二叉树的实现
 * @param <T>
 */

/**
 * 两大部分
 * 创建二叉树
 * 遍历二叉树
 *
 * @param <T>
 */
public class BinaryTree<T extends Comparable> implements Tree<T> {
    //根结点
    protected BinaryNode<T> root;

    //===============================二叉树的创建==========================
    //创建空二叉树
    public BinaryTree(){
        root =null;
    }

    /**
     * 以层序遍历构造二叉树
     * @param levelOrderArray
     */
    public BinaryTree(T[] levelOrderArray)
    {
        //队列依次存放层序遍历的结果，存放节点的队列
        LinkedList<BinaryNode<T>> Queue=new LinkedList<>();

        //层次遍历数组 第一个数“0” 则为根节点空
        //层次遍历数组 不为空继续遍历创建树
        if (levelOrderArray[0] !="0"){
            this.root=new BinaryNode<>(levelOrderArray[0],null,null);
            Queue.add(this.root);
            int i=0;

            //终止循环的条件是队列中无元素
            while (!Queue.isEmpty()){
                //从队列中取出一节点
                BinaryNode<T> First = Queue.remove();

                //创建First节点的左孩子并放入队列
                if (levelOrderArray[++i]=="0"){
                    First.left=null;
                }else{
                    First.left=new BinaryNode<>(levelOrderArray[i],null,null);
                    Queue.add(First.left);
                }

                //创建First节点的右孩子并放入队列
                if (levelOrderArray[++i]=="0"){
                    First.right=null;
                }else{
                    First.right=new BinaryNode<>(levelOrderArray[i],null,null);
                    Queue.add(First.right);
                }
            }

        }else{
            this.root=null;
        }
    }



    /*
     * 根据先根和中根遍历算法构造二叉树
     * @param preList 先根遍历次序数组
     * @param inList 中根遍历次序数组
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * return root 最终返回的根结点
     * ==============================
     */
    public  BinaryNode<T>  createBinarySearchTreeByPreIn(T[] preList , T[] inList,int preStart ,int preEnd ,int inStart ,int inEnd){
        //preList[preStart]必须根结点数据,创建根结点root
        BinaryNode<T> p=new BinaryNode<>(preList[preStart]);
        //如果没有其他元素,就说明结点已构建完成
        if (preStart == preEnd && inStart == inEnd) {
            return p;
        }


        //处理中序序列
        //寻找中跟次序根节点对应下标
        //找出中根次序的根结点下标root
        int root=0;
        for (root = inStart; root < inEnd; root++) {
            //如果中根次序中的元素值与先根次序的根结点相当,则该下标index即为inList中的根结点下标
            if (preList[preStart].compareTo(inList[root])==0){
                break;
            }
        }
        //获取左子树的长度
        int leftLength=root-inStart;
        //获取右子树的长度
        int rightLength=inEnd-root;


        //递归构建左子树
        if(leftLength>0){
            //左子树的先根序列：preList[1] , ... , preList[i]
            //左子树的中根序列：inList[0] , ... , inList[i-1]
            p.left=createBinarySearchTreeByPreIn(preList,inList,preStart+1,preStart+leftLength,inStart,root-1);
        }

        //构建右子树
        if (rightLength>0){
            //右子树的先根序列：preList[i+1] , ... , preList[n-1]
            //右子树的中根序列：inList[i+1] , ... , inList[n-1]
            p.right=createBinarySearchTreeByPreIn(preList,inList,preStart+leftLength+1,preEnd,root+1,inEnd);
        }

        return p;
    }


    /**
     *Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
     * 后根/中根遍历构建二叉树
     * @param postList 后根遍历序列
     * @param inList 中根遍历序列
     * @param postStart
     * @param postEnd
     * @param inStart
     * @param inEnd
     * @return 根结点
     */
    public BinaryNode<T> createBinarySearchTreeByPostIn(T[] postList,T[] inList,int postStart,int postEnd,int inStart,int inEnd){

        //构建根结点
        BinaryNode<T> p=new BinaryNode<>(postList[postEnd]);

        if(postStart==postEnd && inStart==inEnd){
            return p;
        }

        //查找中根序列的根结点下标root
        int root=0;

        for (root=inStart;root<inEnd;root++){
            //查找到
            if (postList[postEnd].compareTo(inList[root])==0){
                break;
            }
        }

        //左子树的长度
        int leftLenght=root-inStart;
        //右子树的长度
        int rightLenght=inEnd-root;

        //递归构建左子树
        if(leftLenght>0){
            //postStart+leftLenght-1:后根左子树的结束下标
            p.left=createBinarySearchTreeByPostIn(postList,inList,postStart,postStart+leftLenght-1,inStart,root-1);
        }

        //递归构建右子树
        if(rightLenght>0){
            p.right=createBinarySearchTreeByPostIn(postList,inList,postStart+leftLenght,postEnd-1,root+1,inEnd);
        }

        return p;
    }





    @Override
    public boolean isEmpty() {
        return false;
    }


    //============================二叉树的遍历==============================
    //二叉树先序遍历递归实现
    @Override
    public String preOrder() {
        String OutputSequence=preOrder(root);
        if(OutputSequence.length()>0){
            //去掉尾部","号
            OutputSequence=OutputSequence.substring(0,OutputSequence.length()-1);
        }

        return OutputSequence;
    }

    public String preOrder(BinaryNode<T> subtree) {
        StringBuffer OutputSequence=new StringBuffer();
        if (subtree!=null) {//递归结束条件
            //先访问根结点
            OutputSequence.append(subtree.data+",");
            //遍历左子树
            OutputSequence.append(preOrder(subtree.left));
            //遍历右子树
            OutputSequence.append(preOrder(subtree.right));
        }
        return OutputSequence.toString();
    }


    //二叉树先序遍历非递归实现
    public String preOrderTraverse(){
        StringBuffer OutputSequence=new StringBuffer();
        //构建用于存放结点的栈
        LinkedList<BinaryNode<T>> stack=new LinkedList<>();

        BinaryNode<T> p=this.root;

        while (p!=null||!stack.isEmpty()){

            if (p!=null){
                //访问该结点
                OutputSequence.append(p.data+",");

                //将已访问过的结点入栈
                stack.push(p);

                //继续访问其左孩子，直到p为null
                p=p.left;

            }else { //若p=null 栈不为空,则说明已沿左子树访问完一条路径, 从栈中弹出栈顶结点,并访问其右孩子
                p=stack.pop();//获取已访问过的结点记录
                p=p.right;
            }

        }
        //去掉最后一个逗号
        if(OutputSequence.length()>0){
            return OutputSequence.toString().substring(0,OutputSequence.length()-1);
        }else {
            return OutputSequence.toString();
        }
    }



    //二叉树中序遍历递归实现
    @Override
    public String inOrder() {
        String OutputSequence=inOrder(root);
        if(OutputSequence.length()>0){
            //去掉尾部","号
            OutputSequence=OutputSequence.substring(0,OutputSequence.length()-1);
        }
        return OutputSequence;
    }

    /**
     * 中根遍历
     * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
     * @return
     */
    public String inOrder(BinaryNode<T> subtree) {
        StringBuffer OutputSequence=new StringBuffer();
        if (subtree!=null) {//递归结束条件
            //先遍历左子树
            OutputSequence.append(inOrder(subtree.left));
            //再遍历根结点
            OutputSequence.append(subtree.data+",");
            //最后遍历右子树
            OutputSequence.append(inOrder(subtree.right));
        }
        return OutputSequence.toString();
    }

    //二叉树中序遍历的非递归 递归实现
    public String inOrderTraverse(){
        StringBuffer sb=new StringBuffer();
        //构建用于存放结点的栈
        LinkedList<BinaryNode<T>> stack=new LinkedList<>();

        BinaryNode<T> p=this.root;

        while (p!=null||!stack.isEmpty()){
            while (p!=null){//把左孩子都入栈,至到左孩子为null
                stack.push(p);
                p=p.left;
            }
            //如果栈不为空,因为前面左孩子已全部入栈
            if(!stack.isEmpty()){
                p=stack.pop();
                //访问p结点
                sb.append(p.data+",");
                //访问p结点的右孩子
                p=p.right;
            }
        }

        if(sb.length()>0){
            return sb.toString().substring(0,sb.length()-1);
        }else {
            return sb.toString();
        }
    }

    //后根遍历非递归实现
    @Override
    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }

        return sb;
    }

    /**
     * 后根遍历
     * @param subtree
     * @return
     */
    public String postOrder(BinaryNode<T> subtree) {
        StringBuffer sb=new StringBuffer();
        if (subtree!=null) {//递归结束条件
            //先遍历左子树
            sb.append(postOrder(subtree.left));

            //再遍历右子树
            sb.append(postOrder(subtree.right));

            //最后遍历根结点
            sb.append(subtree.data+",");
        }
        return sb.toString();
    }

    /**
     * 非递归后根遍历
     * @return
     */
    public String postOrderTraverse(){
        StringBuffer sb=new StringBuffer();
        //构建用于存放结点的栈
        LinkedList<BinaryNode<T>> stack=new LinkedList<>();

        BinaryNode<T> currentNode =this.root;
        BinaryNode<T> prev=this.root;

        while (currentNode!=null||!stack.isEmpty()){
            //把左子树加入栈中,直到叶子结点为止
            while (currentNode!=null){
                stack.push(currentNode);
                currentNode=currentNode.left;
            }

            //开始访问当前结点父结点的右孩子
            if(!stack.isEmpty()){
                //获取右孩子，先不弹出
                BinaryNode<T> temp=stack.peek().right;
                //先判断是否有右孩子或者右孩子是否已被访问过
                if(temp==null||temp==prev){//没有右孩子||右孩子已被访问过
                    //如果没有右孩子或者右孩子已被访问,则弹出父结点并访问
                    currentNode=stack.pop();
                    //访问
                    sb.append(currentNode.data+",");
                    //记录已访问过的结点
                    prev=currentNode;
                    //置空当前结点
                    currentNode=null;
                }else {
                    //有右孩子,则开始遍历右子树
                    currentNode=temp;
                }
            }

        }

        //去掉最后一个逗号
        if(sb.length()>0){
            return sb.toString().substring(0,sb.length()-1);
        }else {
            return sb.toString();
        }
    }

    /**
     * 层次遍历
     * @return
     */
    @Override
    public String levelOrder() {
        /**
         * 存放需要遍历的结点,左结点一定优先右节点遍历
         */
        LinkedList<BinaryNode<T>> queue=new LinkedList<>();
        StringBuffer sb=new StringBuffer();
        BinaryNode<T> p=this.root;

        while (p!=null){
            //记录经过的结点
            sb.append(p.data);

            //先按层次遍历结点,左结点一定在右结点之前访问
            if(p.left!=null){
                //孩子结点入队
                queue.add(p.left);
            }

            if (p.right!=null){
                queue.add(p.right);
            }
            //访问下一个结点
            p=queue.poll();
        }
        return sb.toString();
    }




    public static void main(String args[])
    {

        String[] levelorderArray = {"A","B","C","D","F","G","I","0","0","E","0","0","H","0","0","0","0","0","0"};
        //String[] levelorderArray = {"0","A","B","C","D","F","G","I","0","0","E","0","0","H","0","0","0","0","0","0"};
        BinaryTree<String> cbtree = new BinaryTree<>(levelorderArray);
        System.out.println("先根遍历:"+cbtree.preOrder());
        System.out.println("非递归先根遍历:"+cbtree.preOrderTraverse());
        System.out.println("中根遍历:"+cbtree.inOrder());
        System.out.println("非递归中根遍历:"+cbtree.inOrderTraverse());
        System.out.println("后根遍历:"+cbtree.postOrder());
        System.out.println("非递归后根遍历:"+cbtree.postOrderTraverse());


    }

}
