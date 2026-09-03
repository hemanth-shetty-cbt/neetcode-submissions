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
    public boolean isBalanced(TreeNode root) {

        return isBalancedHeight(root) != -1;
        
    }

    public int isBalancedHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMax = isBalancedHeight(root.left);
        if (leftMax == -1) {
            return -1;
        }

        int rightMax = isBalancedHeight(root.right);
        if (rightMax == -1) {
            return -1;
        }

        if (Math.abs(leftMax - rightMax) > 1) {
            return -1;
        }

        return 1 + Math.max(leftMax, rightMax);

    }
}
