package leetcode.easy;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 94. 二叉树的中序遍历
 * 
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 中序遍历： 左、根、右
 * 
 * </p>
 * leetcode: https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * 
 * @author zhangyu
 */
public class BinaryTreeInorderTraversal {
    
    static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    
    public static void main(String[] args) {
        System.out.println(inorderTraversal());
        System.out.println(inorderTraversal2());
    }
    
    /**
     * 递归遍历法
     */
    private static List<Integer> inorderTraversal() {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    
    private static void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        
        // 先遍历所有左节点
        inorder(node.left, list);
        // 输出根节点
        list.add(node.val);
        // 再遍历所有右节点
        inorder(node.right, list);
    }

    /**
     * 借助栈迭代
     */
    private static List<Integer> inorderTraversal2() {
        List<Integer> list = new ArrayList<>();
        TreeNode node = root;
        Deque<TreeNode> deque = new LinkedList<>();
        
        while (node != null || !deque.isEmpty()) {
            
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            
            node = deque.pop();
            list.add(node.val);
            node = node.right;
        }
        
        return list;
    }
    
}
