package zuo_class.class036;

import java.util.HashMap;

//利用先序与中序遍历序列构造二叉树
//测试链接 : https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Code07_PreorderInorderBuildBinaryTree {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}
	
	public static TreeNode buildTree(int[] pre, int[] in) {
		if (pre == null || in == null || pre.length != in.length) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		int rootIdx = map.get(pre[0]);
		TreeNode ans = g(pre, 0, pre.length, in, 0, in.length, map);
		return ans;
	}

	// 返回 l1 - r1 l2 - r2 对应子树的根，拼接就 return
	private static TreeNode g(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> map) {
		// 递归出口
		if (l1 > r1) return null;
		TreeNode head = new TreeNode(pre[l1]);
		if (l1 == r1) return head;
		int k = map.get(head.val);
		head.left = g(pre, l1 + 1, l1 + k - l2, in, l2, k - 1, map);
		head.right = g(pre, l1 + k - l2 + 1, r1, in, k + 1, r2, map);
		return head;
		
	}
}
