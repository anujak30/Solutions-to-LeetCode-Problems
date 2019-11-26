// I have coded the recursive as well as the iterative version of the program along with their complexities
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
    public boolean hasPathSum(TreeNode root, int sum) {
        Boolean result = helper(root, 0, sum);
        return result;
    }
    public boolean helper(TreeNode current, int parentSum, int sum) {
        if(current == null)    return false;
        parentSum += current.val;
        if(current.right == null && current.left == null && parentSum == sum)
            return true;
        boolean res1 = helper(current.left, parentSum, sum);
        boolean res2 = helper(current.right, parentSum, sum);
        if(res1 || res2)    return true;
        else                return false;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Path Sum.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int parentValue = 0;
        while(!stack.isEmpty() || current != null) {
            while(current != null) {
                current.val += parentValue;
                stack.push(current);
                parentValue = current.val;
                current = current.left;
            }
            current = stack.pop();
            parentValue = current.val;
            if(current.left == null && current.right == null && current.val == sum)
                return true;
            current = current.right;
        }
        return false;
    }
}

// Runtime: 2 ms, faster than 8.28% of Java online submissions for Path Sum.
// Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Path Sum.