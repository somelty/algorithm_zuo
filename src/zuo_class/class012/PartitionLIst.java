package zuo_class.class012;

import zuo_class.class011.MergeTwoLists;

public class PartitionLIst {
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode ans = partition(head, 4);
        ans.printList();
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void printList() {
            ListNode cur = this;
            while (cur != null) {
                System.out.print(cur.val + "->");
                cur = cur.next;
            }
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val <= x) {
                if (leftHead == null) {
                    leftHead = head;
                } else {
                    leftTail.next = head;
                }
                leftTail = head;
            } else {
                if (rightHead == null) {
                    rightHead = head;
                } else {
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }
        if (leftTail == null) {
            return rightHead;
        }

        leftTail.next = rightHead;
        return leftHead;

    }
}
