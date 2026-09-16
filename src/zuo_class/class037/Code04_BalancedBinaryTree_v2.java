package zuo_class.class037;

import zuo_class.class037.Code04_BalancedBinaryTree.TreeNode;

public class Code04_BalancedBinaryTree_v2 {
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static boolean balance;
	
	public static boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		balance = true;
		high(root);
		return balance;
	}
	
	/* 使用 return balance 而不是 return isBalanced(root.left) && isBalanced(root.right) && balance;
	 * 这里和 v1 不一样的是：
	 * v1 的high方法只是单纯计数没有判断是否平衡
	 * v2 的high方法在计数的时候就对每一层都判断是否平衡
	 * 所以 isBalanced 方法的返回值存在区别
	 * 
	 */
	public static int high(TreeNode root) {
		if (root == null) return 0;
		int lh = high(root.left);
		int rh = high(root.right);
		
		if (Math.abs(lh - rh) > 1) {
			balance = false;
			
		}
		return Math.max(lh, rh) + 1;
	}

}
