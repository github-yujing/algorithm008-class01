**学习总结**

>       本周学习了哈希表、映射、集合、树、二叉树、二叉搜索树、图的实现和特性，对于数据结构的知识我以前是都没学过的，有些名词有听说过也不知道是什么，现在听了覃超老师的课后，也能懂一点点，知道了个大概，没有Java内部实现的数据结构，后面需要熟悉它们实现所需要编写的代码，能够做到条件反射式地写出代码，就能算完全掌握该数据结构了，已有内部实现的数据结构则需要熟练掌握它在Java中的interface。在学习过程中遇到BFS和DFS不知道是什么，老师也没有过多讲解，就只能通过搜索引擎查找定义，这对于我这种完全是新手的人来说有利有弊吧，利就是能够快速掌握更多的知识，习惯于自己解决不会问题，弊就是让本就不多的学习时间更少了。

      
**学习笔记**
	

 1. 哈希表Hash table
 

> 也叫散列表，是根据关键码值（Key value）而直接进行访问的数据结构 它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。
> 这个映射函数叫做散列函数（Hash Function），存放记录的数组叫作哈希表。
> 拉链式解决冲突法：对应位置存储的数据不再是一个元素，而是一个链表。

 
 2. 映射Map
 Key-value对，key不重复。接口如下：
-new HashMap()/new TreeMap()
-map.put(key,value)
-map.get(key)
-map.has(key)
-map.size()
-map.clear()

 3. 集合Set
 不重复元素的集合，接口如下：
-new HashSet()/new TreeSet()
-set.add(value)
-set.delete(value)
-set.hash(value)

 4. 树Tree

> 首先有个根节点，根节点下有左子树和右子树，节点又分为儿子节点和父亲节点，具体怎么区分需要根据节点的位置来定。

 5. 二叉树Binary Tree

> 儿子节点节点只有两个的树。 树和图最关键的差别就是看有没有环，如果节点只连接到儿子节点，永远不会走回去，则为树。

Linked List是特殊化的Tree，Tree是特殊化的Graph。
二叉树遍历 Pre-order/ In-order/ Post-order
1．	前序（Pre-order）:根-左-右
2．	中序（In-order）:左-根-右
3．	后序（Post-order）:左-右-根
java代码实现：

    public class Node {  
        private int data;  
        private Node leftNode;  
        private Node rightNode;  
        public Node(int data, Node leftNode, Node rightNode){  
            this.data = data;  
            this.leftNode = leftNode;  
            this.rightNode = rightNode;  
        ｝
    }
    
    public void printNode(Node node) {  
        System.out.print(node.getData());  
    } 
    
    public void theFirstTraversal(Node root) {  //先序遍历  
        printNode(root);  
        if (root.getLeftNode() != null) {  //使用递归进行遍历左孩子  
            theFirstTraversal(root.getLeftNode());  
        }  
        if (root.getRightNode() != null) {  //递归遍历右孩子  
            theFirstTraversal(root.getRightNode());  
        }  
    }
    
    public void theInOrderTraversal(Node root) {  //中序遍历  
        if (root.getLeftNode() != null) {  
            theInOrderTraversal(root.getLeftNode());  
        }  
        printNode(root);  
        if (root.getRightNode() != null) {  
            theInOrderTraversal(root.getRightNode());  
        }  
    }
    
    public void thePostOrderTraversal(Node root) {  //后序遍历  
        if (root.getLeftNode() != null) {  
            thePostOrderTraversal(root.getLeftNode());  
        }  
        if(root.getRightNode() != null) {  
            thePostOrderTraversal(root.getRightNode());  
        }  
        printNode(root);  
    }  



 6. 二叉搜索树Binary Search Tree
二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一颗空树或者具有下列性质的二叉树：
 a.	左子树上所有节点的指均小于它的根节点的值；
 b.	右子树上所有节点的值均大于它的根节点的值；
 c.	以此类推：左、右子树也分别为二叉查找树。
 d.	中序遍历：升序排列


 7. 图Graph
图的属性有：Graph（V, E）

>  V - vertex：点 	a.度 - 入度和出度 （进入的路和出去的路） 	b.点与点之间：连通与否

> 
> E – edge：边 	a.有向和无向（单行线） 	b.权重（边长)
> 
> 图的表示：邻接矩阵（矩阵存储）和邻接表（链表存储）。
> 
> 图的分类：无向无权图、有向无权图、无向有权图、有向有权图。







