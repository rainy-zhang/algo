package entity;

import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangyu
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
