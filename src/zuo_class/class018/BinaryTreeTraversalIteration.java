package zuo_class.class018;

import java.util.Stack;

// 非递归版 二叉树打印
public class BinaryTreeTraversalIteration {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 先序 中左右
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    // 中序 左中右
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) { // 刚开始head不为空但是栈为空、判读节点是否为空
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    // 后序
    public static void postOrderTwoStacks(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!collect.isEmpty()) {
                System.out.print(collect.pop().val + " "); // shift + enter 跳过后面的切换下一行
            }
            System.out.println();
        }
    }

    // 后序
    // 使用 head 指针记录
    public static void postOrderOneStack(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            // 如果始终没有打印过节点，h就一直是头节点
            // 一旦打印过节点，h就变成打印节点
            // 之后h的含义 :
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek(); //这里只记录，
                if (cur.left != null && head != cur.left && head != cur.right ) {
                    // 由左树且未处理过
                    stack.push(cur.left);
                } else if (cur.right != null && head != cur.right) {
                    // 有右树且右树没有处理过
                    stack.push(cur.right);
                } else {
                    // 左右都没树 或者 都处理过了
                    System.out.print(cur.val + " ");
                    head = stack.pop(); // 这个弹出的节点就是当前的节点 cur
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println("先序遍历非递归版");
        preOrder(head);
        System.out.println("中序遍历非递归版");
        inOrder(head);
        System.out.println("后序遍历非递归版 - 2个栈实现");
        postOrderTwoStacks(head);
        System.out.println("后序遍历非递归版 - 1个栈实现");
        postOrderOneStack(head);
    }
}
