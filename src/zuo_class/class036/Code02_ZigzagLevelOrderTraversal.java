package zuo_class.class036;

import java.util.ArrayList;
import java.util.List;

// 二叉树的锯齿形层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
public class Code02_ZigzagLevelOrderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int MAXN = 2001;
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l, r;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean reverse = false;
        if (root == null) return ans;
        l = r = 0;
        queue[r++] = root;
        int size = 0;
        while(l < r){
            size = r - l;
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = reverse? r - 1: l, j = reverse? -1: 1, k = 0; k < size; i += j, k++) {
                level.add(queue[i].val);
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                if (cur.left != null) queue[r++] = cur.left;
                if (cur.right != null) queue[r++] = cur.right;
            }
            ans.add(level);
            reverse = !reverse;
        }
        return ans;
    }
}
