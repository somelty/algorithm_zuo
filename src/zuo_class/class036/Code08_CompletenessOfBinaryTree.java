package zuo_class.class036;

//验证完全二叉树
//测试链接 : https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
/**
 * 左子树无但有右子树
 * 左子树有右子树无，后面节点仍然有子树
 */
public class Code08_CompletenessOfBinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}
	
	public static int l, r;
	public static int MAXN = 101;
	public static TreeNode[] queue = new TreeNode[MAXN];
	
	public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        l = r = 0;
        queue[r++] = root;
        TreeNode cur;
        boolean flag = false;
        while(l < r) {
        	cur = queue[l++];
        	if (cur.left == null && cur.right != null) return false;
        	if (flag && (cur.left != null || cur.right != null)) return false;
        	if ((cur.left != null && cur.right == null) || (cur.left == null && cur.right == null)) flag = true;
        	if (cur.left != null) {
        		queue[r++] = cur.left;
        	}
        	if (cur.right != null) {
        		queue[r++] = cur.right;
        	}
        	
        }
        return true;
        
    }
	
}
