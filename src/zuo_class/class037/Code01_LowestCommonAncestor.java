package zuo_class.class037;

//普通二叉树上寻找两个节点的最近公共祖先
//测试链接 : https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
public class Code01_LowestCommonAncestor {
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 提交如下的方法
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode r = lowestCommonAncestor(root.right, p, q); 
		// 上一行执行完到下一行，此时说明root的右子树已经找完了
		TreeNode l = lowestCommonAncestor(root.left, p, q);
		if(r == null && l == null) return null;
		if(r != null && l != null) return root;
		return l == null ? r : l;
	
	}

}
