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
    TreeNode first = null, second = null, prev= null;
    Stack<TreeNode> s = new Stack<>();
    public void recoverTree(TreeNode root) {
        recover(root);
        int temp=second.val;
        second.val = first.val;
        first.val = temp;
    }
    private void recover(TreeNode root) {
        while ( root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root=root.left;
            }
            root = s.pop();
            if (prev != null && prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev= root;
            if (root != null) {
                root = root.right;
            }

        }
    }
}
