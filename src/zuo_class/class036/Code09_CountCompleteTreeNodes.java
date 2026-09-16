package zuo_class.class036;

//求完全二叉树的节点个数
//测试链接 : https://leetcode.cn/problems/count-complete-tree-nodes/
public class Code09_CountCompleteTreeNodes {
	
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
	}

	// 提交如下的方法
	public static int countNodes(TreeNode head) {
		if (head == null) return 0;
		return g(head, 1, getDepthL(head, 1));
	}
	
/*	public static int getDepthL(TreeNode root, int level) {
		while (root.left != null) {         
			root = root.left;             
			level ++;
		}
		return level;
	}
	这个方法错误，会报空指针异常，因为在 g 函数里调用 getDepthL 时传入 head.right，但是 head 的 right
	节点可能为空，需要从当前传入的节点开始判断是否为空
*/
	public static int getDepthL(TreeNode cur, int level) {
		while (cur != null) {
			level ++;
			cur = cur.left;
		}
		return level - 1;
	}
	
	public static int g(TreeNode head, int level, int h) {
		// 出口 叶子节点
		if (head.left == null) return 1; // 或者 level == h 作为条件也可以
		if (getDepthL(head.right, level + 1) == h) {
			return (1 << (h - level)) + g(head.right, level + 1, h);
		} else {
			return (1 << (h - level - 1)) + g(head.left, level + 1, h); 
		}
		
	}
	
	
	
}
