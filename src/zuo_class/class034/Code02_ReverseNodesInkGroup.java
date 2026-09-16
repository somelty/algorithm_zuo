package zuo_class.class034;

// 每k个节点一组翻转链表
// 测试链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class Code02_ReverseNodesInkGroup {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 反转主逻辑
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode s = head;
        ListNode e = teamEnd(head, k);
        if (e == null) return head;
        head = e;
        reverse(s, e);
        ListNode lastTeamEnd = s;

        while (lastTeamEnd.next != null) {
            s = lastTeamEnd.next;
            e = teamEnd(s, k);
            if (e == null) return head;
            reverse(s, e);
            lastTeamEnd.next = e;
            lastTeamEnd = s;
        }
        return head;
    }


    // 反转链表
    public static void reverse(ListNode s, ListNode e) {
        ListNode pre = null, cur = s;
        ListNode temp = null;
        e = e.next;
        while(cur != e){ // 原本是 cur != null
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        s.next = e; // 容易漏，反转后的 s 需要链接到下一组的 s，也就是这一组最后节点 e 的 next 指向的节点
    }

    // 寻找当前组的第 K 个节点，从 start 开始，跳 k-1 下
    // 没找到会返回 null
    public static ListNode teamEnd(ListNode s, int k) {
        while (--k != 0 && s != null) {
            // 如果上面条件判断写 s.next != null 则最后会放回最后一个节点 s，就无法验证是否满足一组共有 k 个
            // 因为我们想当一组不满足 k 个时返回 null
            // 但是用 s.next 判断最后一定无论满不满足k都会返回这一组最后一个节点 s 而不会返回 null
            s = s.next;
        }
        return s;
    }

}
