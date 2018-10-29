package com.sola.utils.treeAVL;

import java.io.Serializable;

public class TreeAVL<E extends Comparable> implements Serializable {
    private static final long serialVersionUID = 1L;
    private NodeAVL<E> root ;

    //添加节点
    public void insert(E item){

        root = insert(item, root) ;
    }
    //先创建查找二叉树 再优化为avl树(第一步:先写计算树的高度部分 第二部:判断是否均衡 第三部:判断不均衡的地方属于什么情况<一共四种 左左 左右 右右 右左>)
    private NodeAVL<E> insert(E item, NodeAVL<E> current){
        if (current == null){
            //当前新建节点默认高度为0
            return new NodeAVL<E>(item) ;
        }
        //新加元素和当前节点值比较大小
        int flag = current.getData().compareTo(item);
        if(flag == 1){
            //当前节点大与添加节点 判断左边
            current.setLeft(insert(item, current.getLeft())) ;
            //判断均衡
            if(getHeight(current.getLeft()) - getHeight(current.getRight()) == 2){
                //左不均衡
                if(current.getLeft().getLeft() != null){
                    //左左 右旋转
                    current = rightRotate(current);
                }else{
                    //左右
                    current = rightAndLeftRotate(current) ;
                }
            }
        }else if(flag == -1){
            //当前节点小于添加节点 判断右边
            current.setRight(insert(item, current.getRight()));
            if(getHeight(current.getRight()) - getHeight(current.getLeft()) == 2){
                //右不均衡
                if(current.getRight().getRight() != null){
                    //右右 左旋转
                    current = leftRotate(current) ;
                }else{
                    //右左
                    current = leftAndRightRotate(current) ;
                }
            }
        }else{
            //节点已存在
        }

        current.setHeight(Math.max(getHeight(current.getRight()), getHeight(current.getLeft())) + 1);// 左右节点高度比较大的数值 加一
        return current ;
    }

    /**
     * 节点高度计算方式 为节点的左节点高度和右节点高度较大的一个 加一(节点为null时返回 -1 加一后为0)
     * @param item 计算高度的节点
     * @return
     */
    public int getHeight(NodeAVL<E> item){
        return item == null ? -1 : item.getHeight() ;
    }

    /**
     * 右旋 -> 左左
     * @param item 要旋转的节点
     * @return 旋转后的父节点
     */
    private NodeAVL<E> rightRotate(NodeAVL<E> item){
        NodeAVL<E> currentRoot = item.getLeft(); //旋转节点的左节点变为父节点
        item.setLeft(currentRoot.getRight()); //父节点原本的右节点转到旋转节点的左节点
        currentRoot.setRight(item); //旋转节点移动到父节点的右节点
        item.setHeight(Math.max(getHeight(item.getLeft()), getHeight(item.getRight())) + 1);//旋转节点重新计算高度
        currentRoot.setHeight(Math.max(getHeight(currentRoot.getRight()), getHeight(currentRoot.getLeft())) +1);//旋转后的父节点重新计算高度
        return currentRoot ;//返回父节点
    }

    /**
     * 左旋 -> 右右
     * @param item 要旋转的节点
     * @return 旋转后的父节点
     */
    private NodeAVL<E> leftRotate(NodeAVL<E> item){
        NodeAVL<E> currentRoot = item.getRight();
        item.setRight(currentRoot.getLeft());
        currentRoot.setLeft(item);
        item.setHeight(Math.max(getHeight(item.getLeft()), getHeight(item.getRight())) + 1);//旋转节点重新计算高度
        currentRoot.setHeight(Math.max(getHeight(currentRoot.getRight()), getHeight(currentRoot.getLeft())) +1);//旋转后的父节点重新计算高度
        return currentRoot ;//返回父节点
    }

    /**
     * 先左旋后右旋  -> 左右不均衡情况
     * @return
     */
    private NodeAVL<E> rightAndLeftRotate(NodeAVL<E> item){
        item.setLeft(leftRotate(item.getLeft()));
        return rightRotate(item) ;
    }

    /**
     * 先右旋后左旋 -> 右左情况
     * @param item
     * @return
     */
    private NodeAVL<E> leftAndRightRotate(NodeAVL<E> item){
        item.setRight(rightRotate(item.getRight()));
        return leftRotate(item) ;
    }







    //下方都是显示数据相关
    /**
     * 打印树
     */
    public void paintTree(){
        int level = 0 ;
        if(root != null){
            paintTree(root, level);
        }
    }
    //item 打印节点 level 当前层数
    private void paintTree(NodeAVL<E> item, int level){
        if(item.getRight() != null){
            paintTree(item.getRight(), level+1);
        }else{
            paintSpace(level+1);
            System.out.println("n");
        }
        paintSpace(level) ;
        System.out.println(item.getData() + " " + item.getHeight());
        if (item.getLeft() != null){
            paintTree(item.getLeft(), level+1);
        }else{
            paintSpace(level+1);
            System.out.println("n");
        }
    }
    //打印空格
    private void paintSpace(int level){
        for(int i = 0; i < level; i++){
            System.out.print("     ");
        }
    }

    /**
     * 中序显示 左 中 右
     */
    public void infixOrder(){
        infixOrder(root);
    }
    private void infixOrder(NodeAVL<E> item){
        if(item.getLeft() != null){
            infixOrder(item.getLeft());
        }
        System.out.print(item.getData());
        System.out.print(" ");
        if(item.getRight() != null){
            infixOrder(item.getRight());
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"root\":" + root +
                '}';
    }

}
