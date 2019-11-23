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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if(root == null)    return answer;
        queue.add(root);
        int round = 1;
        while(!queue.isEmpty()) { 
            int size = queue.size();
            List<Integer> subAnswer = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if(round % 2 == 1)  subAnswer.add(current.val);
                else                subAnswer.add(0, current.val);
                if(current.left != null)    queue.add(current.left);
                if(current.right != null)   queue.add(current.right);
            }
            round++;
            answer.add(subAnswer);
        }
        return answer;
    }
}

// Runtime: 1 ms, faster than 94.15% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 36.1 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.