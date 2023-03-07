package leetcode.easy;

import entity.ListNode;

/**
 * <p>
 * 83. 删除排序链表中的重复元素
 * <p>
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @author zhangyu
 */
public class RemoveDuplicatesSortedList {

    static ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));

    public static void main(String[] args) {
        System.out.println(deleteDuplicates());
    }

    private static ListNode deleteDuplicates() {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
