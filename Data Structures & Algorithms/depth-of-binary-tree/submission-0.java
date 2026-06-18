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
    int maxLength = 0;
    public int maxDepth(TreeNode root) {

        if(root == null)    return maxLength;

        findMaxLength(root, 0);
        return maxLength;
    }

    public void findMaxLength(TreeNode root, int localLength){
        if(root == null){
            maxLength = Math.max(localLength, maxLength);
            return;
        }

        findMaxLength(root.left, localLength + 1);
        findMaxLength(root.right, localLength + 1);
    }
}
