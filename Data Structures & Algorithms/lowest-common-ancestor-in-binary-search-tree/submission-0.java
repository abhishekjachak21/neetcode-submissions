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

    TreeNode ans = null;

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ans = null;
        findLCA(root, p, q);
        return ans;
    }

    int findLCA(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return 0;
        }

        int left = findLCA(node.left, p, q);

        int right = findLCA(node.right, p, q);

        int self = 0;

        if (node == p || node == q) {
            self = 1;
        }

        int total = left + self + right;

        if (total == 2 && ans == null) {
            ans = node;
        }

        return total;
    }

    
}