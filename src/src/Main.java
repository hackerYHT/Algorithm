/*
 * @Descripttion: 
 * @version: 
 * @Author: yht
 * @Date: 2022-04-21 04:13:12
 * @LastEditors: yht
 * @LastEditTime: 2022-05-16 21:54:46
 */
package src;

public class Main{
    public static void main(String[] args) {
        // 创建一棵二分搜索树
        BST<Integer> bstTree = new BST<>();

        // 首先对二分搜索树是否为空进行判断
        System.out.println("当前二分搜索树是否为空：" + bstTree.isEmpty());
        // 查看当前二分搜索树中的元素个数
        System.out.println("二分搜索树中的元素个数为：" + bstTree.size());

        // 向二分搜索树中插入根节点
        bstTree.add(33);
        bstTree.add(28);
        bstTree.add(40);
        bstTree.add(19);
        bstTree.add(31);
        bstTree.add(35);
        bstTree.add(45);

        // 判断当前二分搜索树是否为空
        System.out.println("当前二分搜索树是否为空：" + bstTree.isEmpty());
        // 查看当前二分搜索树中的元素个数
        System.out.println("二分搜索树中的元素个数为：" + bstTree.size());

        System.out.println("------------------- 接下来查看二分搜索树中包含的元素 -------------------");

        System.out.println("二分搜索树中是否包含元素33：" + bstTree.contains(33));
        System.out.println("二分搜索树中是否包含元素28：" + bstTree.contains(28));
        System.out.println("二分搜索树中是否包含元素40：" + bstTree.contains(40));
        System.out.println("二分搜索树中是否包含元素19：" + bstTree.contains(19));
        System.out.println("二分搜索树中是否包含元素31：" + bstTree.contains(31));
        System.out.println("二分搜索树中是否包含元素35：" + bstTree.contains(35));
        System.out.println("二分搜索树中是否包含元素45：" + bstTree.contains(45));
        System.out.println("二分搜索树中是否包含元素100：" + bstTree.contains(100));

    }
}