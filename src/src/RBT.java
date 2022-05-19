package src;
//参考博客：
//https://blog.csdn.net/qq_42977003/article/details/121862496
import java.util.*;

public class RBT<K extends Comparable<K>, V> {
    class Node<K extends Comparable<K>, V>{
        K key;
        V val;
        Node parent;
        Node left;
        Node right;
        boolean color;

        Node(){}

        public Node(K key, V val, Node parent, Node left, Node right, boolean color){
            this.key = key; 
            this.val = val;
            this.left = left;
            this.right = right;
            this.color = color;
        }
        public K getKey(){
            return key;
        }
        public V getVal(){
            return val;
        }
        public Node getParent(){
            return parent;
        }
        public Node getLeft(){
            return left;
        }
        public Node right(){
            return right;
        }
        public boolean isColor(){
            return color;
        }
        public void setKey(K key){
            this.key = key;
        }
        public void setParent(Node parent){
            this.parent = parent;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public void setColor(boolean color){
            this.color = color;
        }
    }



    Node root;
    int len;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    RBT(){
        root = null;
        this.len = 0;
    }
    public int size(){
        return this.len;
    }
    public boolean isRed(Node node){
        return node == null ? false : node.color == RED;
    }
    public boolean isBlack(Node node){
        return node == null ? false : node.color == BLACK;
    }
    public Node parent(Node node){
        return node == null ? null : node.parent;
    }
    public void rotateL(Node k){
        Node h = k.right;
        k.right = h.left;
        if(h.left.parent != null) 
            h.left.parent = k;
        h.parent = k.parent;
        if(k.parent == null){
            root = h;
        }else{
            if(k.parent.left == k)
                k.parent.left = h;
            else k.parent.right = h;
        }
        h.left = k;
        k.parent = h;
    }
    public void rotateR(Node k){
        Node h = k.left;
        k.left = h.right;
        if(h.right != null)
            h.right.parent = k;
        h.parent = k.parent;
        if(k.parent == null){
            root = h;
        }else{
            if(k.parent.left == k)
                k.parent.left = h;
            else k.parent.right = h;
        }
        h.right = k;
        k.parent = h;
    }
    public void put(K key, V val){
        Node parent = null;
        Node curr = root;
        while(curr != null){
            parent = curr;
            int cmp = key.compareTo((K)curr.key);
            if(cmp > 0) curr = curr.right;
            else if(cmp < 0) curr = curr.left;
            else {
                curr.val = val;
                return;
            }
        }
        Node newNode = new Node(key, val, parent, null, null, RED);
        if(parent != null){
            int cmp = key.compareTo((K)parent.key);
            if(cmp > 0){
                parent.right = newNode;
                this.len++;
                balance(newNode);
                return;
            }else{
                parent.left = newNode;
                this.len++;
                balance(newNode);
                return;
            }
        }else{
            root = newNode;
            this.len++;
            return;
        }
    }
    private void balance(Node node){
        root.color = BLACK;
        Node parent = parent(node);
        Node grandpa = parent(parent);
        //父节点红色
        if(parent != null && isRed(parent)){
            Node uncle = null;
            //父节点为爷爷的左子节点
            if(parent == grandpa.left){
                uncle = grandpa.right;
                //父节点和叔叔节点为红色
                if(uncle != null && isRed(uncle)){
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandpa.color = RED;
                    balance(grandpa);
                    return;
                }
                //叔叔节点为空或者黑色
                if(uncle != null || isBlack(uncle)){
                    //插入的节点为父节点的左子树LL
                    if(node == parent.left){
                        parent.color = BLACK;
                        grandpa.color = RED;
                        rotateR(grandpa);
                        return;
                    }
                    //插入的节点为父节点的右子树LR
                    if(node == parent.right){
                        rotateL(parent);
                        balance(parent);
                        return;
                    }
                }else{
                    //父节点为爷爷节点的右子树
                    uncle = grandpa.left;
                    //叔叔节点和父节点为红色
                    if(uncle != null && isRed(uncle)){
                        parent.color = BLACK;
                        uncle.color = BLACK;
                        grandpa.color = RED;
                        balance(grandpa);
                        return;
                    }
                    //叔叔节点为空或者黑色
                    if(uncle == null ||isBlack(uncle)){
                        //插入的节点为父节点的右子树
                        if(node == parent.right){
                            parent.color = BLACK;
                            grandpa.color = RED;
                            rotateL(grandpa);
                            return;
                        }
                        //插入的节点为父节点的左子树
                        if(node == parent.left){
                            rotateR(parent);
                            balance(grandpa);
                            return;
                        }
                    }
                }
            }
        }
    }
    /**
     * @name:get 
     * @test: test font
     * @msg: 红黑树查找元素
     * @return {*}
     */
    public K get(K key){
        return (K) get(root, key).key;
    }
    public Node get(Node node, K key){
        if(node == null) return null;
        int cmp = key.compareTo((K)node.key);
        if(cmp > 0) return get(node.right, key);
        else if (cmp < 0) return get(node.left, key);
        else return node;
    }
    /**
     * @name:middlebl 
     * @test: test font
     * @msg: 红黑树的中序遍历(迭代法)
     * @return {*}
     */
    public ArrayList<K> middlebl(){
        if(root == null) return null;
        ArrayList<K> keys = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        Node temp = root;
        while(temp != null || stack.isEmpty()){
            while(temp != null){
                stack.addFirst(temp);
                temp = temp.left;
            }
            temp = stack.removeFirst();
            keys.add((K)temp.key);
            temp = temp.right;
        }
        return keys;        
    }
    /**
     * @name:height 
     * @test: test font
     * @msg: 返回树的高度
     * @return {*}
     */
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null) return 0;
        int maxl = 0, maxr = 0, max = 0;
        maxl = height(node.left);
        maxr = height(node.right);
        max = Math.max(maxl, maxr)+1;
        return max;
    }
}
