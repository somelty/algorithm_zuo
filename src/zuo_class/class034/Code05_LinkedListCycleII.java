package zuo_class.class034;

// 返回链表的第一个入环节点
// 测试链接 : https://leetcode.cn/problems/linked-list-cycle-ii/
public class Code05_LinkedListCycleII {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;

        // 条件判断是当slow不等于fast的时候执行，如果同时从起点出发永远进不了while
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if(fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
