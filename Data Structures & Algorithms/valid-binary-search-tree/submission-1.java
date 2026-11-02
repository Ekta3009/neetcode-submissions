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
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBst(TreeNode root, int min, int max){
        if(root == null)
        return true;

        boolean left = isValidBst(root.left, min, root.val);

        if(!left)   return false;

        boolean right = isValidBst(root.right, root.val, max);

        if(!right)  return false;

        return (root.val < max && root.val > min);
    }
}
