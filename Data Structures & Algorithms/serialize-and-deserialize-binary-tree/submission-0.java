/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public void dfsSer(TreeNode root, StringBuilder data){
        if(root == null){
            data.append("N,");
            return;
        }
        data.append(Integer.toString(root.val)).append(",");
        dfsSer(root.left, data);
        dfsSer(root.right, data);
        return;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        dfsSer(root, data);
        System.out.println(data);
        return data.toString();
    }

    public TreeNode dfsDes(int[] ind, String[] trav){
        if(trav[ind[0]].equals("N")) {
            ind[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(trav[ind[0]]));
        ind[0]++;
        node.left = dfsDes(ind, trav);
        node.right = dfsDes(ind, trav);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] trav = data.split(",");
        TreeNode root = dfsDes(new int[]{0} , trav);
        return root;
    }
}
