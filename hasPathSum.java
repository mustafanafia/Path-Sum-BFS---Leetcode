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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sum = new Stack<>();

        path.push(root);
        sum.push(root.val);

        while(!path.isEmpty()){

            TreeNode temp_path = path.pop();
            int temp_sum = sum.pop();

            if(temp_path.left == null && temp_path.right == null && temp_sum == targetSum){
                return true;
            }

            if(temp_path.left != null){
                path.push(temp_path.left);
                sum.push(temp_sum + temp_path.left.val);
            }

            if(temp_path.right != null){
                path.push(temp_path.right);
                sum.push(temp_sum + temp_path.right.val);
            }

        }
        return false;


    }
}