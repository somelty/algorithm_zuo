package zuo_class.class036;

//求二叉树的最大、最小深度
//测试链接 : https://leetcode.cn/problems/maximum-depth-of-binary-tree/
public class Code04_DepthOfBinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int ldepth = Integer.MAX_VALUE;
		int rdepth = Integer.MAX_VALUE;
		if (root.left != null) {
			ldepth = minDepth(root.left);
		}
		if (root.right != null) {
			rdepth = minDepth(root.right);
		}
		return Math.min(ldepth, rdepth) + 1;
	}
	
	public static int maxDepth(TreeNode root) {
		return root == null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
