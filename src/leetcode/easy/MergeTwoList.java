package leetcode.easy;

import entity.ListNode;

/**
 * <p>
 * 21. 合并两个有序链表
 * </p>
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * leetcode: https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author zhangyu
 */
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        System.out.println(mergeTwoList(list1, list2));

        ListNode list3 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list4 = new ListNode(1, new ListNode(3,null));
        System.out.println(mergeTwoList2(list3, list4));

    }

    /**
     * 递归
     * (1,1):代表第一次进入递归函数，并且从第一个口进入，并且记录进入前链表的状态
     * merge(1,1): 1->4->5->null, 1->2->3->6->null
     *     merge(2,2): 4->5->null, 1->2->3->6->null
     *     	merge(3,2): 4->5->null, 2->3->6->null
     *     		merge(4,2): 4->5->null, 3->6->null
     *     			merge(5,1): 4->5->null, 6->null
     *     				merge(6,1): 5->null, 6->null
     *     					merge(7): null, 6->null
     *     					return l2
     *     				l1.next --- 5->6->null, return l1
     *     			l1.next --- 4->5->6->null, return l1
     *     		l2.next --- 3->4->5->6->null, return l2
     *     	l2.next --- 2->3->4->5->6->null, return l2
     *     l2.next --- 1->2->3->4->5->6->null, return l2
     * l1.next --- 1->1->2->3->4->5->6->null, return l1
     */
    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        }

    }

    /**
     * 遍历：每次取出list1和list2中比较小的那个节点追加到新节点中
     */
    private static ListNode mergeTwoList2(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(-1);
        ListNode pre = listNode;
        
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        if (list1 != null) {
            pre.next = list1;
        } else if (list2 != null) {
            pre.next = list2;
        }
        
        listNode = listNode.next;   // 移除新建的头节点
        return listNode;
    }

}
