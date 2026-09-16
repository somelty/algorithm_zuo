package zuo_class.class036;

import java.util.*;

// 二叉树的层序遍历
// 测试链接 : https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class Code01_LevelOrderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static List<List<Integer>> levelOrder1 (TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        HashMap<TreeNode, Integer> levels = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 使用现成queue
        queue.add(root);
        levels.put(root, 0);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int level = levels.get(cur);
            if (ans.size() == level) {
                ans.add(new ArrayList<>());
            }
            ans.get(level).add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
                levels.put(cur.left, level + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                levels.put(cur.right, level + 1);
            }
        }
        return ans;
    }

    // 自己模拟队列
    public static int MAXN = 2001;
    // 用数组模拟队列，数组里面装的是树节点
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static int l = 0, r = 0;
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        queue[r++] = root;
        while (l < r) {
            int size = r - l;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue[l++];
                list.add(cur.val);
                if (cur.left != null) {
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    queue[r++] = cur.right;
                }
            }
            ans.add(list);
        }
        return ans;
    }

}

