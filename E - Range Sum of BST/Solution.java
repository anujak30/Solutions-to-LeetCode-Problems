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
    public int rangeSumBST(TreeNode root, int L, int R) {
        // Recrusive Approach:
        return helper(root, L, R);
    }
    
    public int helper(TreeNode node, int L, int R) {
        if(node == null)
            return 0;
        if(node.val < L)
            return helper(node.right, L, R);
        else if(node.val > R)
            return helper(node.left, L, R);
        else
            return helper(node.left, L, R) + node.val + helper(node.right, L, R);
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
// Memory Usage: 54.5 MB, less than 5.23% of Java online submissions for Range Sum of BST.

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        // Recrusive Approach:
        // return helper(root, L, R);
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null) {
                if (node.val >= L && node.val <= R)
                    ans += node.val;
                if (node.val > L)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}

// Runtime: 4 ms, faster than 13.04% of Java online submissions for Range Sum of BST.
// Memory Usage: 55.3 MB, less than 5.23% of Java online submissions for Range Sum of BST.

// // DFS approach:
        // Stack<TreeNode> stack = new Stack<TreeNode>();
        // TreeNode current = root;
        // int finalSum = 0;
        // while(!stack.isEmpty() || current != null) {
        //     while(current != null) {
        //         stack.push(current);
        //         current = current.left;
        //     }
        //     current = stack.pop();
        //     if(current.val > R)
        //         break;
        //     if(current.val >= L && current.val <= R)
        //         finalSum += current.val;
        //     current = current.right != null? current.right : null;                        
        // }
        // return finalSum;
// // BFS approach:
        // Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // queue.add(root);
        // int finalSum = 0;
        // while(!queue.isEmpty()) {
        //     int size = queue.size();
        //     for(int i = 0; i < size; i++) {
        //         TreeNode current = queue.remove();
        //         if(current.val >= L && current.val <= R)
        //             finalSum += current.val;
        //         if(current.left != null)    queue.add(current.left);
        //         if(current.right != null)   queue.add(current.right);
        //     }
        // }
        // return finalSum;