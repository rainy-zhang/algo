package leetcode.easy;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 145. 二叉树的后序遍历
 * 
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 后序遍历：左、右、根
 * 
 * </p>
 *
 * @author zhangyu
 */
public class BinaryTreePostorderTraversal {

    static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

    public static void main(String[] args) {
        System.out.println(postorderTraversal());
        System.out.println(postorderTraversal2());
    }

    /**
     * 递归
     */
    private static List<Integer> postorderTraversal() {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    
    private static void postorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
    }

    /**
     * 迭代
     */
    private static List<Integer> postorderTraversal2() {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            
            root = deque.pop();
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                deque.push(root);
                root = root.right;
            }
            
        }
        return list;
    }
    
}
