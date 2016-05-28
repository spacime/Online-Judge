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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, postorder.length - 1, inorder, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] postorder, int postStart, int[] inorder, int orderStart, int orderEnd) {
        if(postStart < 0 || orderStart < orderEnd) return null;

        TreeNode root = new TreeNode(postorder[postStart]);

        int index = orderStart;
        while(inorder[index] != postorder[postStart]) {
            index--;
        }

        root.right = buildTree(postorder, postStart - 1, inorder, orderStart, index + 1);
        root.left = buildTree(postorder, postStart - (orderStart - index + 1), inorder, index - 1, orderEnd);

        return root;
    }
}
