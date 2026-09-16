package zuo_class.class036;

// 二叉树的最大特殊宽度，java版
// 测试链接 : https://leetcode.cn/problems/maximum-width-of-binary-tree/
public class Code03_WidthOfBinaryTree1 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int MAXN = 3001;
    public static int l, r;
    public static TreeNode[] queue = new TreeNode[MAXN];
    public static long[] id = new long[MAXN];
    public static int widthOfBinaryTree(TreeNode root) {
    	int ans = 0;
    	if(root == null) return ans;
    	l = r = 0;
    	queue[r] = root;
    	id[r] = 1;
    	r++;
    	int size = 0;
    	int diff = 0;
    	while (l < r) {
    		size = r - l;
    		diff = (int)((int)id[r - 1] - id[l] + 1); 
    		ans = Math.max(ans, diff);
    		for(int i = 0; i < size; i++) {
    			TreeNode cur = queue[l];
    			long curID = id[l];
    			l ++;
    			if(cur.left != null) {
    				queue[r] = cur.left;
    				id[r] = curID * 2;
    				r ++;
    			}
    			if (cur.right != null) {
    				queue[r] = cur.right;
    				id[r] = curID * 2 + 1;
    				r ++;
    			}	
    			
    		}
    			
    	}
    	return ans;
    }
    
}
