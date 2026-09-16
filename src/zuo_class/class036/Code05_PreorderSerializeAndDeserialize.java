package zuo_class.class036;

//二叉树先序序列化和反序列化
//测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class Code05_PreorderSerializeAndDeserialize {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int v) {
			val = v;
		}
	}
	
	
	public class Codec {

	    // Encodes a tree to a single string.
	    public static String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        f(sb, root);
	        return sb.toString();
	    }
	    
	    public static void f(StringBuilder sb, TreeNode root) {
	    	if (root == null) {
	    		sb.append("#,");
	    	} else {
	    		sb.append(root.val + ",");
	    		f(sb, root.left);
	    		f(sb, root.right);
	    	}
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	        String[] vals = data.split(",");
	        TreeNode ans = g(vals);
	        return ans;
	    }
	    
	    public static int cnt;
	    
	    public static TreeNode g(String[] vals) {
	    	String cur = vals[cnt++];
	    	if (cur.equals("#")) return null;
	    	TreeNode head = new TreeNode(Integer.valueOf(cnt));
	    	head.left = g(vals);
	    	head.right = g(vals);
	    	return head;
	    }
	}
	
}
