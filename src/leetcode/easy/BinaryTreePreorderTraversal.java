package leetcode.easy;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 前序遍历：根、左、右
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/binary-tree-preorder-traversal
 *
 * @author zhangyu
 */
public class BinaryTreePreorderTraversal {

    static TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));

    public static void main(String[] args) {
        System.out.println(preorderTraversal());
        System.out.println(preorderTraversal2());
    }

    /**
     * 递归
     */
    private static List<Integer> preorderTraversal() {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private static void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    /**
     * 借助栈遍历
     */
    private static List<Integer> preorderTraversal2() {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                deque.push(root);
                root = root.left;
            }

            root = deque.pop();
            root = root.right;
        }
        return list;
    }

}
