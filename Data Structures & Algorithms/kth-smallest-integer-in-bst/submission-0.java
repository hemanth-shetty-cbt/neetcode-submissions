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

    private int result = 0, count = 0;

    public int kthSmallest(TreeNode root, int k) {

        findTheSmallestElement(root, k);
        return result;
    }

    public boolean findTheSmallestElement(TreeNode root, int k ) {

        if (root == null) {

            return false;
        }

        //this condition is if the result is found findTheSmallestElement will be true
        //by this we are stopping the recursion
        if (findTheSmallestElement(root.left, k)) {
            return true;
        }

        count++;

        if (count == k) {
            result = root.val;
            return true;
        }

        return findTheSmallestElement(root.right,k);

    }
}
