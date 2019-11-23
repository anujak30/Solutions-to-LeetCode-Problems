/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();    
        if(root == null)    return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subAnswer = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                subAnswer.add(current.val);
                if(current.left != null)    queue.add(current.left);
                if(current.right != null)   queue.add(current.right);                
            }
            result.add(subAnswer);
        }
        return result;
    }
}

// Runtime: 1 ms, faster than 90.00% of Java online submissions for Binary Tree Level Order Traversal.
// Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.