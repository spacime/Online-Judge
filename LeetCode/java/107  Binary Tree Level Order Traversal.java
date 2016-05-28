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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }
    
    private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if(root == null) return;
        if(result.size() <= level) {
            result.add(0, new ArrayList<>());
        }
        
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
        
        result.get(result.size() - level - 1).add(root.val);
    }
}