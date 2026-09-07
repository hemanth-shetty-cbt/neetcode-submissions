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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i=0;i<inorder.length;i++) {

            mp.put(inorder[i], i);
        }

        TreeNode result = buildTreeFromArray(inorder,0,inorder.length-1,preorder,0,
        preorder.length-1,mp);
        
        return result;
        
    }

    public TreeNode buildTreeFromArray(int[] inorder, int inordermin, int inordermax,
    int[] preorder, int preordermin, int preordermax, Map<Integer, Integer> mp) {

        if (inordermin > inordermax || preordermin > preordermax) {
            return null;
        }

        TreeNode rootnode = new TreeNode(preorder[preordermin]);

        int index = mp.get(rootnode.val);
        int count = index - inordermin;

        rootnode.left = buildTreeFromArray(inorder, inordermin, index -1, preorder, preordermin + 1, 
        preordermin + count, mp);

        rootnode.right = buildTreeFromArray(inorder, index + 1, inordermax, preorder,preordermin+
        count + 1, preordermax, mp);

        return rootnode;
    }







}
