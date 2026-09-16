package zuo_class.class010;

import zuo_class.class009.ListReverse;

public class addTwoNumbers {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode head1 = new ListNode(7);
        ListNode node11 = new ListNode(2);
        ListNode node22 = new ListNode(5);
        ListNode node33 = new ListNode(6);
        head1.next = node11;
        node11.next = node22;
        node22.next = node33;
        node33.next = null;

        ListNode res = mergeTwoLists(head,head1);
        res.printList();
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void printList() {
            // 打印所有节点
            ListNode cur = this;
            while (cur != null) {
                System.out.println(cur.val + " ");
                cur = cur.next;
            }
        }
    }

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        int carry = 0, val = 0, sum = 0;
        ListNode ans = null;
        ListNode cur = null;
        for (;
             h1 != null || h2 != null;
             h1 = h1 == null? null: h1.next, h2 = h2 == null? null: h2.next
        ){
            sum = (h1 == null? 0: h1.val) + (h2 == null? 0: h2.val) + carry;
            val = sum % 10;
            carry = sum / 10;

            if (ans == null){
                ans = new ListNode(val);
                cur = ans;
            }else {
                // 这句代码出现了逻辑问题。
                //原因是 `ans.next` 也就是头节点之后的节点，每一次操作相只是在不断覆盖头节点之后的第二个节点，导致整体的链表长度只有 2。
                //两种解决方法：
                //1. 头节点也跟着移动，移动到下一个，下一次再在头节点下面去追加。最后再反转这个链表，返回头节点。但操作麻烦。
                //2. 第二种方法（推荐）：再维护一个尾节点 `cur`。
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        if (carry > 0){
            ans.next = new ListNode(carry);
        }

        return ans;

    }


}
