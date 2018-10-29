package com.sola.utils.treeAVL;

import java.io.Serializable;

/**
 * 节点类
 * @param <E>
 */
public class NodeAVL<E extends Comparable> implements Serializable {
    private static final long serialVersionUID = 1L;
    E  data ;           //当前节点对象
    NodeAVL<E> left ;   //左节点
    NodeAVL<E> right ;  //右节点
    int height ;        //节点的高

    public NodeAVL(E data) {
        this.data = data;
        this.left = null ;
        this.right = null ;
        this.height = 0 ;
    }

    public NodeAVL(E data, NodeAVL<E> left, NodeAVL<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeAVL<E> getLeft() {
        return left;
    }

    public void setLeft(NodeAVL<E> left) {
        this.left = left;
    }

    public NodeAVL<E> getRight() {
        return right;
    }

    public void setRight(NodeAVL<E> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" +'"'+ data +'"'+
                ", \"leftChild\":" + left +
                ", \"rightChild\":" + right +
                '}';
    }
}
