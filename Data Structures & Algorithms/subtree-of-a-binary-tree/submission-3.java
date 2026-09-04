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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        //first compare the  elements of root and subRoot taking root as the root
        //ran out of the tree 

        if(root ==  null) {
            return false;
        }
   
        if(isSubTreePossible(root, subRoot)) {
            return true;
        }
           
        

        //taking the root element as start it did not work so taking the left or right element as the root

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public Boolean isSubTreePossible(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSubTreePossible(root.left, subRoot.left) && isSubTreePossible(root.right, subRoot.right);

    }
}
