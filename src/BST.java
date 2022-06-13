/*
 * @Descripttion:二叉搜索树 
 * @version: 
 * @Author: yht
 * @Date: 2022-05-16 15:36:36
 * @LastEditors: yht
 * @LastEditTime: 2022-05-18 21:53:45
 */
package src;

public class BST<E extends Comparable<E>> {
    //声明二叉搜索树的节点类
    private class Node{
        //存放节点值的变量
        public E e;
        //指向左子树和右子树的变量
        public Node left, right;
        public Node (E e){
            this.e = e;
            //左子树和右子树初始化为空
            left = null;
            right = null;
        }
    }
    //二分搜索树的根节点
    private Node root;
    //当前二分搜索树存储的元素的个数
    private int size;

    public BST(){
        //初始化时二分搜索树的根节点为空
        root = null;
        size = 0;
    }

    //获取当前二分搜索树存储元素的方法
    public int size(){
        return size;
    }
    //判断当前二分搜索树是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //向二分搜索树中添加新的元素e
    public void add(E e){
        root = add(root, e);
    }
    //向以node为根的二分搜索树中插入元素e
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }
    public boolean contains(E e) {
        return contains(root, e);
    }
    private boolean contains(Node node, E e) {
        if(node == null) return false;
        if(e.compareTo(node.e) < 0) return contains(node.left, e);
        else if(e.compareTo(node.e) > 0) return contains(node.right, e);
        else return true;
    }
}
