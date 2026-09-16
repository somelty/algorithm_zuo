package zuo_class.class034;

// 判断链表是否是回文结构
// 测试链接 : https://leetcode.cn/problems/palindrome-linked-list/
public class Code04_PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        // 快慢指针找中点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 现在中点就是 slow
        ListNode pre = slow;
        // 反转中点后的节点 (考察单链表反转)
        // head -> ... -> slow <- ... <- pre  cur此时跳到 null，链表最后一个节点为 pre（卡玛里讲的）
        ListNode cur = slow.next;
        pre.next = null; // 把 slow 的 next 置为空（这里漏了）
        ListNode temp = null;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // 比较前后部分
        ListNode left = head;
        ListNode right = pre;
        // 类似于双指针
        while (left != null){    // 这里的条件判断注意
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        // 调整原来的链表
        cur = pre;
        ListNode prev = null;
        temp = null;

        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return true;
    }
}
