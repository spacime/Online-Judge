/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int[] order, int orderStart, int orderEnd) {
        if(preStart >= preorder.length || orderStart > orderEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int index = orderStart;
        while(order[index] != preorder[preStart]) {
            index++;
        }

        root.left = buildTree(preorder, preStart + 1, order, orderStart, index - 1);
        root.right = buildTree(preorder, preStart + index - orderStart + 1, order, index + 1, orderEnd);

        return root;
    }
}
