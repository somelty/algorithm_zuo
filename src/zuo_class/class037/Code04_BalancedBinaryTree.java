package zuo_class.class037;

//验证平衡二叉树
//测试链接 : https://leetcode.cn/problems/balanced-binary-tree/
public class Code04_BalancedBinaryTree {
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static boolean balance;
	
	
	// 判断 root 节点是否平衡
	// 注意：平衡二叉树要求所有节点都是平衡的，只有 root 平衡不可以
	public boolean isBalanced(TreeNode root) {
        balance = true;
        if (root == null) {
        	return true;
        }
        int hl = high(root.left);
        int hr = high(root.right);
        if (Math.abs(hl - hr) > 1) {
        	balance = false;
        }
        
        /*
        return balance;
         * 这里只是对 root 的左右子树高度进行判断，但是没有分别对左右子树内部是否平衡做判断
         * 忽略了 root 平衡，但是左右子树不平衡的情况，所以这版代码只通过了一部风测试用例
        */
        //          左递归                 右是否平衡              root 是否平衡 
        return isBalanced(root.left) && isBalanced(root.right) && balance;
    }
	
	
	public static int high(TreeNode cur) {
		// 终止
		if(cur == null) {
			return 0;
		}
		return Math.max(high(cur.left), high(cur.right)) + 1;
	}

}
