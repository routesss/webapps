package com.sola.utils.tree;

import java.io.Serializable;

public class Node implements Serializable {

    private static final long serialVersionUID = 1L;
    private int data ; //节点数据
    private Node leftChild ; //左子节点
    private Node rightChild ; //右子节点

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" +'"'+ data +'"'+
                ", \"leftChild\":" + leftChild +
                ", \"rightChild\":" + rightChild +
                '}';
    }
}
