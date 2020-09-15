package com.todorex.dataStructure.section3.section323;

public class MyLink {
    Node head = null; // 头节点

    /**
     * 链表中的节点，data代表节点的值，next是指向下一个节点的引用
     */
    class Node {
        Node next = null;// 节点的引用，指向下一个节点
        int data;// 节点的对象，即内容
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * @return 返回节点长度
     */
    public int length() {
        int length = 0;
        //移动指针，其实是对象
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next; //对象的层层调用
        }
        return length;
    }


    /**
     * 按序号查找
     */
     public int findKth(int k){
        Node tmp=head;
        //顺序找从头i=0开始往下索引
        int i=0;
        while (tmp!=null&& i<k ){
            tmp=tmp.next;
            i++;
        }
        if (i==k&&tmp!=null)
            return tmp.data;
         else
            return -1;

     }

    /**
     * 按值查找
     */
    public int find(int number){
        Node tmp=head;
        //顺序找从头i=0开始往下索引
        int i=0;
        while (tmp!=null ){
            if (tmp.data==number)
                return i;
            tmp=tmp.next;
            i++;
        }
        return -1;

    }


    /**
     *
     * @param d  插入的数字
     * @param k  插入的索引
     * @return
     */
    public Node insertByIndex(int d,int k){
        Node newNode = new Node(d);// 实例化一个节点
        //新节点插入在表头
        if (k==0){
            newNode.next=head;
            head=newNode;
            //返回新表头
            return head;
        }else{
            //找到k-1的节点插入
            Node temp=head;
            int cnt=0;
            for (;cnt <k-1 ; cnt++) {
                if (temp!=null){
                    temp=temp.next;
                }else{
                    break;
                }
            }

            //temp指向k-1 正常情况下最后一个 提前跳出
            if (temp==null || cnt!=k-1){
                System.out.println("插入位置有问题");
                return null;
            }else{
                newNode.next=temp.next;
                temp.next=newNode;
                return head;
            }

        }
    }
    /**
     * 向链表中插入数据
     * @param d
     */
    public void addNode(int d) {
        Node newNode = new Node(d);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     *
     * @param index:删除第index个节点
     * @return
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
    }

    /**
     * 在不知道头指针的情况下删除指定节点
     *
     * @param n
     * @return
     */
    public boolean deleteNode11(Node n) {
        if (n == null || n.next == null)
            return false;
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("删除成功！");
        return true;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }



    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);

        System.out.println("linkLength:" + list.length());
        System.out.println("索引为5的数是"+list.findKth(5));
        System.out.println("值为55的数索引是"+list.find(55));
        System.out.println("在索引中插入数 并遍历");
        Node insert = list.insertByIndex(10, 0);
        for (int i = 0; i <list.length() ; i++) {
            Node temp=insert;
            while (insert!=null){
                System.out.println(insert.data);
                insert=insert.next;
            }
        }
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();
    }
}
