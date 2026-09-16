package zuo_class.class034;

// 排序链表
// 要求时间复杂度O(n*logn)，额外空间复杂度O(1)，还要求稳定性
// 数组排序做不到，链表排序可以
// 测试链接 : https://leetcode.cn/problems/sort-list/
public class Code06_SortList {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode sortList(ListNode head) {
        // 计算数组长度
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // l1...r1 每组的左部分
        // l2...r2 每组的右部分
        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < n; step <<= 1) {
            // 第一组很特殊，因为要决定整个链表的头，所以单独处理
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);
            head = start;
            lastTeamEnd = end;

            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                if (l2 == null){ // 一组只有有序的左部分
                    lastTeamEnd.next = l1;
                    break;
                }
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }

        }
        return head;
    }

    public static ListNode start;
    public static ListNode end;

    // l1...r1 -> null : 有序的左部分
    // l2...r2 -> null : 有序的右部分
    public static void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        ListNode teamHead;
        if (l1.val < l2.val) {
            teamHead = l1;
            start = l1;
            l1 = l1.next;
        } else {
            teamHead = l2;
            start = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                teamHead.next = l1;
                teamHead = l1;
                l1 = l1.next;
            } else {
                teamHead.next = l2;
                teamHead = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            teamHead.next = l1;
            end = r1;
        } else {
            teamHead.next = l2;
            end = r2;
        }
    }

    // 包括s在内，往下数k个节点返回(--k)
    // 如果不够，返回最后一个数到的非空节点
    public static ListNode findEnd(ListNode s, int k){
        while(s.next != null && --k != 0){
            s = s.next;
        }
        return s;
    }
}
