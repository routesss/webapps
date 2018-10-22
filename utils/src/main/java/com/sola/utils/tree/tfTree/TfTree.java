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
     * 删除
     * 无子节点 直接删除
     * 有一个节点 删除节点后 节点的子节点替代节点位置
     * 有两个节点 删除节点后 根据中序排列找到后续元素替换(先右子节点后左节点,到找不到左节点的节点为替换节点,如果该替换节点的右节点有元素替换该节点位置)
     * @param item
     */
    public void delete(int item){
        Node current ;  //当前元素
        Node parent ;   //父节点
        boolean direction = false ; //false左边   true右边(标记当前元素是父节点的左节点还是右节点)
        parent = root ;
        current = root ;
        while (current != null){
            if(current.getData() == item){
                //找到需要的元素
                break ;
            }else if(current.getData() > item){
                //找左边
                direction = false ;
                parent = current ;
                current = current.getLeftChild() ;
            }else if(current.getData() < item){
                //找右边
                direction = true ;
                parent = current ;
                current = current.getRightChild() ;
            }
        }
        if (current != null){

            //删除元素无左右节点
            if(current.getLeftChild() == null && current.getRightChild() == null){
                if(current.getData() == root.getData()){
                    root = null ;
                }else if(direction){
                    parent.setRightChild(null);
                }else{
                    parent.setLeftChild(null);
                }
            }else if(current.getLeftChild() != null && current.getRightChild() == null){
                //删除元素有左节点 无右节点
                if(current.getData() == root.getData()){
                    root = root.getLeftChild() ;
                }else if(direction){
                    parent.setRightChild(current.getLeftChild());
                }else{
                    parent.setLeftChild(current.getLeftChild());
                }
            }else if(current.getLeftChild() == null && current.getRightChild() != null){
                //删除元素有右节点 无左节点
                if(current.getData() == root.getData()){
                    root = root.getRightChild() ;
                }else if(direction){
                    parent.setRightChild(current.getRightChild());
                }else{
                    parent.setLeftChild(current.getRightChild());
                }
            }else{
                //删除节点 左右子节点都有
                //查找替换节点
                Node replacement = current.getRightChild() ;    //替换节点初始化
                Node replacementParent = current ;              //替换节点父节点
                while (true){
                    if(replacement.getLeftChild() != null){
                        replacementParent = replacement ;
                        replacement = replacement.getLeftChild() ;
                    }else{
                        break ;
                    }
                }
                //替换节点的父节点处理(处理替换节点不是删除节点的右节点的情况    <替换节点是删除节点的右节点的情况不用处理，应为如果是这种情况，替换节点的父节点replacementParent就是删除节点，该节点是要被删除的所以不用处理>)   <查找替换节点的方法找的的替换节点只可能会有右节点，不存在替换节点有左节点的情况>
                //1.替换节点是否是删除节点的右节点
                //2.替换节点的右节点是否有元素
                /**
                 * 这里可以写成 优化的版本不容易理解
                 * if(current.getRightChild().getData() != replacement.getData()){
                 *    replacementParent.setLeftChild(replacement.getRightChild());
                 *    replacement.setRightChild(current.getRightChild());
                 * }
                 */
                //->
                if(replacement.getRightChild() != null){
                    if(current.getRightChild().getData() != replacement.getData()){
                        replacementParent.setLeftChild(replacement.getRightChild());
                    }
                }else{
                    if(current.getRightChild().getData() != replacement.getData()){
                        replacementParent.setLeftChild(null);
                    }
                }
                //替换节点的子节点处理
                if(current.getRightChild().getData() != replacement.getData()){
                    replacement.setRightChild(current.getRightChild());
                }
                //<-
                replacement.setLeftChild(current.getLeftChild());
                //替换节点代替删除节点
                if(current.getData() == root.getData()){
                    //如果删除节点是root节点 替换节点变为root
                    root = replacement ;
                }else{
                    if(direction){
                        parent.setRightChild(replacement);
                    }else{
                        parent.setLeftChild(replacement);
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
    private void paintTree(Node item, int level){
        if(item.getRightChild() != null){
            paintTree(item.getRightChild(), level+1);
        }else{
            paintSpace(level+1);
            System.out.println("n");
        }
        paintSpace(level) ;
        System.out.println(item.getData());
        if (item.getLeftChild() != null){
            paintTree(item.getLeftChild(), level+1);
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


    @Override
    public String toString() {
        return "{" +
                "\"root\":" + root +
                '}';
    }
}
