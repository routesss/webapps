package com.sola.utils.tree.tfTree;

import com.sola.utils.tree.Node;

public class TfTree {

    private Node root ;

    public Node find(int item){

        return null ;
    }


    /**
     * 添加元素
     * @param item 元素值
     */
    public void insert(int item){
        Node node = new Node(item);
        Node current = root ; //当前元素

        //root节点为null 放在root元素位置
        if(root == null){
            root = node ;
        }else{
            while (current != null){
                if(current.getData() > item){
                    //比当前元素小 检查左边
                    if(current.getLeftChild() == null){
                        //左节点为null 将node放在这里
                        current.setLeftChild(node);
                        break ;
                    }else{
                        //左节点不为null 将当前元素current设置为左节点，检查左节点值的大小
                        current = current.getLeftChild() ;
                    }

                }else if(current.getData() < item){
                    //比当前元素大 检查右边
                    if(current.getRightChild() == null){
                        current.setRightChild(node);
                        break ;
                    }else{
                        current = current.getRightChild() ;
                    }

                }
            }
        }

    }

    /**
     * 中序遍历 显示顺序(左 中 右)  右边无节点时返回
     */
    public void infixOrder(){
        infixOrder(root);
    }
    private void infixOrder(Node data){
        if(data.getLeftChild() != null){
            infixOrder(data.getLeftChild());
        }
        System.out.print(data.getData());
        System.out.print(" ");
        if(data.getRightChild() != null){
            infixOrder(data.getRightChild());
        }
    }



    @Override
    public String toString() {
        return "{" +
                "\"root\":" + root +
                '}';
    }
}
