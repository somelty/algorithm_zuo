package zuo_class.class017;

public class BinaryTreeTraversalRecursion {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 递归序
    public static void f(TreeNode head) {
        if (head == null) return;
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    // 先序打印所有节点，递归版
    public static void preOrder(TreeNode head) {// 这里只需打印不需要返回
        if (head == null) return;
        System.out.println((head.val) + " ");
        preOrder(head.left);
        preOrder(head.right);
    }
    // 中序答应所有节点，递归版
    public static void inOrder(TreeNode head) {
        if (head == null) return;
        inOrder(head.left);
        System.out.println((head.val) + " ");
        inOrder(head.right);
    }
    // 后序答应所有节点，递归版
    public static void postOrder(TreeNode head) {
        if (head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        System.out.println((head.val) + " ");
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        preOrder(head);
        System.out.println();
        System.out.println("先序遍历递归版");

        inOrder(head);
        System.out.println();
        System.out.println("中序遍历递归版");

        postOrder(head);
        System.out.println();
        System.out.println("后序遍历递归版");
    }
}
