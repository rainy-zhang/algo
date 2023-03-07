package leetcode.easy;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author zhangyu
 */
public class ListCycle {

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        first.next = second;
        second.next = third;
        third.next = null;

        hasCycle(first);
        hasCycle2(first);
    }

    /**
     * 快慢指针，快指针每次移动两次，慢指针每次移动一次，如果有环的话，快指针一定会追上慢指针
     */
    private static void hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        boolean flag = true;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                flag = false;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(flag);
    }


    /**
     * 遍历链表，通过list保存遍历过的节点，并判断每个节点是否出现在list中，如果出现了则说明有环
     */
    private static void hasCycle2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur.val)) {
                flag = true;
                break;
            }
            list.add(cur.val);
            cur = cur.next;
        }
        System.out.println(flag);
    }

}
