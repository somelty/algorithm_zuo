package zuo_class.class036;

public class Code06_LevelorderSerializeAndDeserialize {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}
	// 二叉树按层序列化和反序列化
	// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
	// 层序列化 就是在之前层序遍历上加入了转为字符串的过程
	
	public class Codec {
		public static int MAXN = 10001;

		public static TreeNode[] queue = new TreeNode[MAXN];

		public static int l, r;
		
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			if(root == null) return sb.append("").toString();
			l = r = 0;
			queue[r++] = root;
			sb.append(root.val + ",");
			while(l < r) {
				TreeNode cur = queue[l++];
				if (cur.left != null) {
					queue[r++] = cur.left;
					sb.append(cur.left.val + ",");
				} else {
					sb.append("#,");
				}
				if (cur.right != null) {
					queue[r++] = cur.right;
					sb.append(cur.right.val + ",");
				} else {
					sb.append("#,");
				}
				
			}
			return sb.toString();
		}
		
		public TreeNode deserialize(String data) {
			if (data.equals("")) return null;
			String[] nodes = data.split(",");
			int idx = 0;
			TreeNode root = generate(nodes[idx++]);
			l = r = 0;
			queue[r++] = root;
			while(r > l) {
				TreeNode node = queue[l++];
				node.left = generate(nodes[idx++]);
				node.right = generate(nodes[idx++]);
				if (node.left != null) queue[r++] = node.left;
				if (node.right != null) queue[r++] = node.right;
			
			}
			return root;
		}

		private TreeNode generate(String node) {
			// TODO Auto-generated method stub
			return node.equals("#") ? null: new TreeNode(Integer.valueOf(node));
		}
	}

}
