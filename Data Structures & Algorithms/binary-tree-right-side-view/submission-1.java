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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> pq = new LinkedList<>();

        pq.offer(root);

        while(!pq.isEmpty()) {
            
            int size = pq.size();

            for (int i=0; i<size; i++) {

                TreeNode top = pq.poll();

                if (i == size-1) {
                    result.add(top.val);
                }

                if(top.left != null)
                    pq.offer(top.left);
                
                if(top.right != null)
                    pq.offer(top.right);
            }
        
        }

        return result;
        
    }
}
