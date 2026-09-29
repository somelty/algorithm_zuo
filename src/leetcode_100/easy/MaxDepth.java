package leetcode_100.easy;

import zuo_class.class017.BinaryTreeTraversalRecursion.TreeNode;
import java.util.*;

public class MaxDepth {
	
	// 深度
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lL = maxDepth(root.left);
			int rL = maxDepth(root.right);
			return Math.max(lL, rL) + 1;
		}
	}
	
	// 广度
	public static int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int ans = 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while(!queue.isEmpty()) {
				int size = queue.size();
				while(size > 0) {
					TreeNode node = queue.poll();
					if(node.left != null) queue.offer(node.left);
					if(node.right != null) queue.offer(node.right);
					size--;
				}
				ans++;
				
			}
			return ans;
		}
	}

}
