package leetcode.medium;

import entity.ListNode;

/**
 * <p>
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author zhangyu
 */
public class RemoveNTHNodeFromEndList {

    static ListNode head = new ListNode(1, null);
    static int n = 1;

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd());
    }

    /**
     * 两次循环，第一次循环先计算出链表的长度len，第二次循环遍历到 len - n + 1 时，下一个节点就是要删除的节点
     */
    public static ListNode removeNthFromEnd() {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        ListNode dummy = new ListNode(-1, head);
        node = dummy;
        // 先遍历 len-n+1 次，那么下一个节点就是要删除的节点
        for (int i = 1; i < len-n+1; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
        
    }
    
}
