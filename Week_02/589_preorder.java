/*589. N叉树的前序遍历
给定一个 N 叉树，返回其节点值的前序遍历。*/

/*这题没什么好说的，就必须熟练掌握的算法实现。*/
         
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> list=new ArrayList();
    public List<Integer> preorder(Node root) {
        if(root != null) {
            list.add(root.val);
            for(Node node: root.children) {
                preorder(node);
            }
            return list;
        }
        else {
            return list;
        }
    }
}
