package zuo_class.class037;

//验证搜索二叉树
//测试链接 : https://leetcode.cn/problems/validate-binary-search-tree/
public class Code05_ValidateBinarySearchTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static int MAXN = 10001;

	public static TreeNode[] stack = new TreeNode[MAXN];

	public static int r; 
	
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
        r = 0;
        TreeNode pre = null;
        while (r != 0 || root != null) {
        	if (root != null) {
        		stack[r++] = root;
        		root = root.left;
        	} else {
        		root = stack[--r];
        		if (pre != null && pre.val >= root.val) {
        			return false;
        		}
        		pre = root;
        		root = root.right;
        	}
        }
        return true;
    }
	
	public static long min, max;
	
	public boolean isValidBST2(TreeNode root) {
		if (root == null) {
			min = Long.MAX_VALUE;
			max = Long.MIN_VALUE;
			return true;
		}
		boolean l = isValidBST2(root.left);
		long lmin = min;
		long lmax = max;
		boolean r = isValidBST2(root.right);
		long rmin = min;
		long rmax = max;
		min = Math.min(Math.min(lmin, rmin), root.val);
		max = Math.max(Math.max(lmax, rmax), root.val);
		return l && r && root.val < rmin && root.val > lmax;
		
	}
}
/**while：
 * - 情况一：
 * 		head != null 需要继续向左深入
 * 			- head != null 栈为空 -> 刚开始
 * - 情况二：
 * 		head == null 但栈不为空 需要回溯 -> 到叶子节点
 * - 情况三：
 * 		head != null 但栈已经空
 * 		场景为：当前节点不为空，栈已空，但整个树尚未遍历完。这通常发生在转向右子树，而右子树又非空时
 * 
 * 
 * */
