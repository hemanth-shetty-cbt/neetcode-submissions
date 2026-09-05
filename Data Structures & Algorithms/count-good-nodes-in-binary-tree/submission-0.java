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
    public int goodNodes(TreeNode root) {

        int min = Integer.MIN_VALUE;


        int count = findGoodNode(root, min);
        return count;

    }

    public int findGoodNode(TreeNode root, Integer max ) {
        if (root == null) {
            return 0;
        }


        int count = 0;

        if (root.val >= max ) {
            count = 1;
        }

        int newMan = Math.max(max, root.val);

        count = count + findGoodNode(root.left, newMan);

        count = count + findGoodNode(root.right, newMan);

        return count;


    } 
}
