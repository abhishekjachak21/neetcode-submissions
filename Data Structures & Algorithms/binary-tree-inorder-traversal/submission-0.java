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
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        solve(root, ans);

        return ans;
    }

    public void solve(TreeNode root, List<Integer> ans) {

        // Base case
        if (root == null) {
            return;
        }

        // 1. Left
        solve(root.left, ans);

        // 2. Root
        ans.add(root.val);

        // 3. Right
        solve(root.right, ans);
    }
}